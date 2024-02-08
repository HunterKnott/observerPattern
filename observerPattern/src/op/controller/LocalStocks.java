package op.controller;
import java.util.List;
import java.util.ArrayList;

public class LocalStocks implements Subject {
	private List<Observer> observers;
	private List<Snapshot> snapshots;
	
	public LocalStocks() {
		observers = new ArrayList<Observer>();
		snapshots = new ArrayList<Snapshot>();
	}
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void dropObserver(Observer o) {
		observers.remove(o);
	}
	
	@Override
	public void notifyObservers() {
		for (Observer observer: observers) {
			observer.update(snapshots.get(snapshots.size() - 1));
		}
	}
	
	@Override
	public void readData(Snapshot snapshot) {
		snapshots.add(snapshot);
		notifyObservers();
	}
}
