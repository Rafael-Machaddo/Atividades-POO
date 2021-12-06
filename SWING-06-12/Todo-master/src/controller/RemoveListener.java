package controller;

import model.Task;
import model.TodoList;
import ui.TodoPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveListener implements ActionListener {
	private TodoList todo;
	private TodoPane pane;

	public RemoveListener(TodoList todo, TodoPane pane) {
		this.todo = todo;
		this.pane = pane;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		int paneIndex = pane.tabbedPane.getSelectedIndex();
		if (paneIndex == 0) {
			int clickedIndex = this.todo.notDoneList.getSelectedIndex();
			Task task = null;

			if (clickedIndex > -1) { task = this.todo.notDone.get(clickedIndex); }

			this.todo.removeTask(this.todo.notDoneList.getSelectedIndex(), this.todo.notDoneModel, this.todo.notDone,
					task);
		} else {
			int clickedIndex = this.todo.doneList.getSelectedIndex();
			Task task = null;

			if (clickedIndex > -1) { task = this.todo.done.get(clickedIndex); }

			this.todo.removeTask(this.todo.doneList.getSelectedIndex(), this.todo.doneModel, this.todo.done, task);
		}
	}
}
