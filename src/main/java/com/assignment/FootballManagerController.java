package com.assignment;

import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
public class FootballManagerController implements Action{
    public FootballManagerView view;


    public FootballManagerController(FootballManagerView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        switch (cm) {
            case "Add":
                try {
                    this.view.addFootballer();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(this.view, "Cannot add or update footballer!");
                }
                break;
            case "Delete":
                try {
                    this.view.deleteFootballer();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(this.view, "You have not choose any row yet!");
                }
                break;
            case "Update":
                try {
                    this.view.setChooseFootballer();
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(this.view, "You have not choose any row yet!");
                }
                break;
            case "Cancel":
                this.view.deleteForm();
                break;
            case "Search":
                this.view.seachFootballer();
                break;
            case "Cancel Search":
                this.view.reloadData();
                this.view.deleteSearch();
                break;
            case "Open":
                this.view.openFileAction();
                break;
            case "Save":
                this.view.saveFileAction();
                break;
            case "About Me":
                this.view.displayAbout();
                break;
            case "Exit":
                this.view.exitProgram();
                break;
        }
    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }

}
