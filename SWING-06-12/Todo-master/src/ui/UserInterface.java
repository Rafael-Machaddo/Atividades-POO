package ui;

import controller.AddListener;
import controller.DoneListener;
import controller.RemoveListener;
import model.TodoList;
import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable
{
    private JFrame frame;
    private TodoList todo = new TodoList();
    public UserInterface(){ }

  
    @Override
    public void run()
    {
        frame = new JFrame("KIP");
        Components(frame.getContentPane());
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void Components(Container container)
    {
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        JTextField field = new JTextField(40);
        JButton addButton = new JButton("add");
        JButton removeButton = new JButton("remove");
        JButton doneButton = new JButton("toggle");
        TodoPane todoPane = new TodoPane(todo);

        //event listeners
        AddListener addListener = new AddListener(todo,field);
        addButton.addActionListener(addListener);

        RemoveListener removeListener = new RemoveListener(todo, todoPane);
        removeButton.addActionListener(removeListener);

        DoneListener doneListener = new DoneListener(todo, todoPane);
        doneButton.addActionListener(doneListener);


        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);



        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(field)
                                .addComponent(addButton)
                                .addComponent(removeButton)
                                .addComponent(doneButton))
                        .addComponent(todoPane)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(field,30, 30, 30)
                                .addComponent(addButton)
                                .addComponent(removeButton)
                                .addComponent(doneButton))
                        .addComponent(todoPane)
        );
    }
}
