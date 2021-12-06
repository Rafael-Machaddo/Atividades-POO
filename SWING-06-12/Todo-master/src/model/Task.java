package model;

public class Task {
	private int id;
	private String label;
	private boolean isDone;

	public Task(int id, String label, boolean isDone) { this.label = label; this.id = id; this.isDone = isDone; }
	public Task(String label) { this.label = label; this.isDone = false; }

	// Getters
	public String getLabel() { return this.label; }
	public boolean getIsDone() { return this.isDone; }
	public int getId() { return this.id; }

	// Setters
	public void setLabel(String label) { this.label = label; }
	public void setDone(boolean isDone) { this.isDone = isDone; }

}
