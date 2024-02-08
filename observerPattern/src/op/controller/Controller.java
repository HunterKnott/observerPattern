// Hunter Knott, CS 3450, Utah Valley University
package op.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Controller {
	
	// Reads Ticker file (converted to stream) into a list and returns it
	private static List<Snapshot> readTicker(InputStream filePath) {
		List<Snapshot> snapshots = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(filePath))) {
			String dateTime = "";
			String line;
			ArrayList<String> lines = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				if (line.equals("")) {
					
					final int ITEMS_COUNT = 9; // Number of elements from Ticker
					List<List<String>> data = new ArrayList<>();
					for (String ln: lines) {
						
						// Read line values in backwards then reverse list, so that company name is last
						List<String> values = new ArrayList<>();
						List<String> rawValues = Arrays.asList(ln.split("\\s+"));
						Collections.reverse(rawValues);
						int i = 0;
						while (values.size() < ITEMS_COUNT - 1) {
							values.add(rawValues.get(i));
							i++;
						}
						
						// Get each word of the remaining rawValues, which is the name
						List<String> nameList = new ArrayList<>();
						for (int j = i; j < rawValues.size(); j++) {
							nameList.add(rawValues.get(j));
						}
						Collections.reverse(nameList);
						
						//Make each name part into the full name
						String companyName = "";
						for (String part: nameList) {
							companyName = companyName.concat(part + " ");
						}
						values.add(companyName);
						
						Collections.reverse(values);
						data.add(values);
					}
					
					snapshots.add(new Snapshot(dateTime, new ArrayList<>(data)));
					lines.clear();
				} else if (line.contains("Last updated")) {
					dateTime = line.substring(line.indexOf("Last updated") + "Last updated".length() + 1);
				} else {
					lines.add(line);
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
		
		return snapshots;
	}
	
	public void run() {
		// Add observers to subject
		LocalStocks lsSubject = new LocalStocks();
		
		AverageObserver ao = new AverageObserver();
		lsSubject.addObserver(ao);
		
//		ExtremeObserver eo = new ExtremeObserver();
//		lsSubject.addObserver(eo);
		
//		List<String> symbols = Arrays.asList("ALL", "BA", "BC", "GBEL", "KFT", "MCD", "TR", "WAG");
//		ListingObserver lo = new ListingObserver(symbols);
//		lsSubject.addObserver(lo);
		
		// Reading initial data in, maybe change this to perform loop in readData
		InputStream inputStream = Controller.class.getResourceAsStream("Ticker.dat");
		if (inputStream != null) {
			List<Snapshot> snapshots = readTicker(inputStream);
			
			// Pass the snapshots list to the Subject
			for (Snapshot snapshot: snapshots) {
				lsSubject.readData(snapshot);
			}
		}
	}
}
