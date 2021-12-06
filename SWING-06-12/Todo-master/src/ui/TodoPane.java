package ui;

import model.TodoList;
import javax.swing.*;
import java.awt.*;

public class TodoPane extends JPanel
{
    private TodoList todo;
    public JTabbedPane tabbedPane;
    public TodoPane(TodoList todo)
    {
        super (new GridLayout(1,1));
        this.todo = todo;

        tabbedPane = new JTabbedPane();
        JScrollPane notDonePane = new JScrollPane(this.todo.notDoneList);
        JScrollPane donePane = new JScrollPane(this.todo.doneList);

        tabbedPane.addTab("Tasks", notDonePane);
        tabbedPane.addTab("Completed", donePane);

        add(tabbedPane);
    }
}
