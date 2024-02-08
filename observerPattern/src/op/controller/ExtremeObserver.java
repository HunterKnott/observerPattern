package op.controller;
import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

// A report that displays all companies that closed within 1% of either their 52-week
// high or their 52-week low
public class ExtremeObserver implements Observer, Display {
	public ExtremeObserver() {
		
	}
	
	public void update(Snapshot snapshot) {
		System.out.println(snapshot.getDateTime());
		for (List<String> line: snapshot.getData()) {
			float closingPrice = Float.parseFloat(line.get(LineValues.CURRENTPRICE.getValue()));
			float high = Float.parseFloat(line.get(LineValues.YEARLYHIGH.getValue()));
			float low = Float.parseFloat(line.get(LineValues.YEARLYLOW.getValue()));
			float onePercent = closingPrice / 100;
			
			if ((closingPrice >= (high - onePercent) && closingPrice <= (high + onePercent))
					|| (closingPrice >= (low - onePercent) && closingPrice <= (low + onePercent))) {
				System.out.println(line.get(LineValues.SYMBOL.getValue()) + ": "
						+ line.get(LineValues.CURRENTPRICE.getValue()) + " (Closing), "
						+ line.get(LineValues.YEARLYHIGH.getValue()) + " (High), "
						+ line.get(LineValues.YEARLYLOW.getValue()) + " (Low)");
			}
		}
		System.out.println("");
	}
}
