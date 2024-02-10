package op.controller;
import java.util.List;
import java.util.ArrayList;

public class Snapshot {
	private String dateTime;
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

	public ArrayList<List<String>> getData() {
		return data;
	}

	public void setData(ArrayList<List<String>> data) {
		this.data = data;
	}
}
