package op.controller;

public interface Subject {
	public void addObserver(Observer o);
	public void dropObserver(Observer o);
	public void notifyObservers();
	public void readData(Snapshot s);
}
