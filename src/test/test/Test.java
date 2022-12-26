package test;

import com.assignment.FootballManagerView;

import javax.swing.*;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new FootballManagerView();
		} catch (Exception e) {
			JFrame error = new JFrame();
			JOptionPane box = new JOptionPane("Cannot open the program");
			error.add(box);
			error.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			error.setVisible(true);
		}
	}
}