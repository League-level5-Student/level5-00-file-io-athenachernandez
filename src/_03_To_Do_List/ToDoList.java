package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	JFrame frame;
	JPanel panel;
	JButton addTask;
	JButton viewTasks;
	JButton removeTask;
	JButton saveList;
	JButton loadList;
	List<String> tasks = new ArrayList<String>();
	String message = "";

	ToDoList() {
		frame = new JFrame();
		panel = new JPanel();
		addTask = new JButton();
		viewTasks = new JButton();
		removeTask = new JButton();
		saveList = new JButton();
		loadList = new JButton();

		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		addTask.setText("Add Task");
		viewTasks.setText("View Tasks");
		removeTask.setText("Remove Tasks");
		saveList.setText("Save List");
		loadList.setText("Load List");
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == addTask) {
			String task = JOptionPane.showInputDialog("What's your task?");
			tasks.add(task);
		} else if (buttonClicked == viewTasks) {
			String text = "";
			for (int i = 0; i < tasks.size(); i++) {
				text += tasks.get(i);
				text += "\n";
			}
			JOptionPane.showMessageDialog(null, text);
		} else if (buttonClicked == removeTask) {
			String delete = JOptionPane.showInputDialog("Which task do you want to delete?");
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).equalsIgnoreCase(delete)) {
					tasks.remove(i);
				}
			}
		} else if (buttonClicked == saveList) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/file.txt", true);
				for (String str : tasks) {
					fw.write(str + "\n");
				}

				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (buttonClicked == loadList) {
			String loc = JOptionPane.showInputDialog("Where is the file?");
			readFile(loc);
		}

	}

	public void readFile(String loc) {
		// Read from a file one line at a time
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(loc));

			String line = br.readLine();
			while (line != null) {
				message += line + "\n";
				line = br.readLine();
			}
			
			System.out.println(message);

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] tasksStrArr = message.split("\n");
		
		tasks = new ArrayList<String>(Arrays.asList(tasksStrArr));
	}

	public static void main(String[] args) {
		ToDoList todolist = new ToDoList();
	}
}


//Copyright © 2019 Athena Hernández