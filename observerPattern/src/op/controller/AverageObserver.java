package op.controller;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

// A report that displays the average of all local stock prices of each snapshot, along
// with the time the snapshot was taken
public class AverageObserver implements Observer, Display {
	public AverageObserver() {
		
	}
	
	public void update(Snapshot snapshot) {
		float average = 0;
		for (List<String> line: snapshot.getData()) {
			average += Float.parseFloat(line.get(LineValues.CURRENTPRICE.getValue()));
		}
		average = average / snapshot.getData().size();
		
		String output = snapshot.getDateTime() + ", Average price: " + average;
		display(output);
	}
	
	public void display(String output) {
		try {
			// True value in FileWriter allows for appending
			FileWriter writer = new FileWriter("Average.dat", true);
			writer.append(output + "\n");
			writer.close();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
