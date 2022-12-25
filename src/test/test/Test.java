package test;

import com.assignment.FootballManagerView;

import javax.swing.UIManager;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new FootballManagerView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}