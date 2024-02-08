package op.controller;
import java.util.List;
import java.util.ArrayList;

public class Snapshot {
	private String dateTime;
//	private ArrayList<String> lines;
	
	// Try make this replace the lines list
	private ArrayList<List<String>> data;
	
	public Snapshot(String dateTime, ArrayList<List<String>> data) {
		setDateTime(dateTime);
		setData(new ArrayList<>(data));
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

//	public List<String> getLines() {
//		return lines;
//	}
//
//	public void setLines(ArrayList<String> lines) {
//		this.lines = lines;
//	}
//	
//	public void printLines() {
//		System.out.println(getDateTime());
//		for (int i = 0; i < lines.size(); i++) {
//			System.out.println(lines.get(i));
//		}
//		System.out.println("");
//	}

	public ArrayList<List<String>> getData() {
		return data;
	}

	public void setData(ArrayList<List<String>> data) {
		this.data = data;
	}
}
