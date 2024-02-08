package op.controller;
import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

// A report that displays all fields for the following companies (listed here by ticker
// symbol): ALL, BA, BC, GBEL, KFT, MCD, TR, WAG
public class ListingObserver implements Observer, Display {
	private List<String> symbols;
	
	public ListingObserver(List<String> symbols) {
		setSymbols(symbols);
	}
	
	public void update(Snapshot snapshot) {
		System.out.println(snapshot.getDateTime());
		for (List<String> line: snapshot.getData()) {
			if (symbols.contains(line.get(LineValues.SYMBOL.getValue()))) {
				System.out.println(String.join(", ", line));
			}
		}
		System.out.println("");
	}

	public List<String> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<String> symbols) {
		this.symbols = symbols;
	}
}
