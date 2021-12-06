package controller;

import model.Task;
import model.TodoList;
import ui.TodoPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoneListener implements ActionListener
{
    private TodoList todo;
    private TodoPane pane;
    private Task taskToToggle;
    public DoneListener(TodoList todo, TodoPane pane)
    {
        this.todo = todo;
        this.pane = pane;
    }
    @Override

    public void actionPerformed(ActionEvent actionEvent)
    {
        int paneIndex = pane.tabbedPane.getSelectedIndex();
        if (paneIndex == 0) { taskToToggle = todo.notDone.get(this.todo.notDoneList.getSelectedIndex());
            
        } else { taskToToggle = todo.done.get(this.todo.doneList.getSelectedIndex()); }
   
        this.todo.toggleDone(taskToToggle);
    }
}
