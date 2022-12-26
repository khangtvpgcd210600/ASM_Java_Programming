package com.assignment;


import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class FootballManagerView extends JFrame {

    public FootballManagerModel model;
    public JTextField textField_FootballerId_Search;
    public JTable table;
    public JTextField textField_FootballerID;
    public JTextField textField_Name;
    public JTextField textField_DoB;
    public JTextField textField_Price;
    public JComboBox comboBox_Club;
    public JComboBox comboBox_Club_Search;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FootballManagerView frame = new FootballManagerView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    JFrame error = new JFrame();
                    JOptionPane box = new JOptionPane("Cannot open the program");
                    error.add(box);
                    error.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    error.setVisible(true);
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FootballManagerView() {
        this.model = new FootballManagerModel();
        setTitle("Football Manager App");
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrame jFrame = (JFrame) e.getSource();
                int result = JOptionPane.showConfirmDialog(jFrame, "Are you sure ?",
                        "Exit Application", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
            }
        });
        setBounds(250, 25, 725, 700);

        Action action = new FootballManagerController(this);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuFile.setFont(new Font("Helvetica", Font.PLAIN, 20));
        menuBar.add(menuFile);

        JMenuItem menuOpen = new JMenuItem("Open");
        menuOpen.addActionListener(action);
        menuOpen.setFont(new Font("Helvetica", Font.PLAIN, 18));
        menuFile.add(menuOpen);

        JMenuItem menuSave = new JMenuItem("Save");
        menuSave.addActionListener(action);
        menuSave.setFont(new Font("Helvetica", Font.PLAIN, 18));
        menuFile.add(menuSave);

        JSeparator separator = new JSeparator();
        menuFile.add(separator);

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(action);
        menuExit.setFont(new Font("Helvetica", Font.PLAIN, 18));
        menuFile.add(menuExit);

        JMenu menuAbout = new JMenu("About");
        menuAbout.addActionListener(action);
        menuAbout.setFont(new Font("Helvetica", Font.PLAIN, 20));
        menuBar.add(menuAbout);

        JMenuItem menuAboutMe = new JMenuItem("About Me");
        menuAboutMe.addActionListener(action);
        menuAboutMe.setFont(new Font("Helvetica", Font.PLAIN, 18));
        menuAbout.add(menuAboutMe);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBounds(44, 144, -28, -35);
        contentPane.add(verticalBox_1);

        JLabel label_Club_Search = new JLabel("Club");
        label_Club_Search.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_Club_Search.setBounds(10, 10, 90, 54);
        contentPane.add(label_Club_Search);

        comboBox_Club_Search = new JComboBox();
        ArrayList<Club> listClub = Club.getClubList();
        comboBox_Club_Search.addItem("");
        for (Club club : listClub) {
            comboBox_Club_Search.addItem(club.getName());
        }
        comboBox_Club_Search.setBounds(50, 11, 155, 54);
        contentPane.add(comboBox_Club_Search);

        JLabel label_FootballerId_Search = new JLabel("Footballer Id");
        label_FootballerId_Search.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_FootballerId_Search.setBounds(210, 11, 175, 54);
        contentPane.add(label_FootballerId_Search);

        textField_FootballerId_Search = new JTextField();
        textField_FootballerId_Search.setFont(new Font("Helvetica", Font.PLAIN, 19));
        textField_FootballerId_Search.setColumns(10);
        textField_FootballerId_Search.setBounds(330, 12, 123, 54);
        contentPane.add(textField_FootballerId_Search);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(action);
        btnSearch.setFont(new Font("Helvetica", Font.PLAIN, 18));
        btnSearch.setBounds(460, 12, 89, 54);
        contentPane.add(btnSearch);

        JButton btnCancelSearch = new JButton("Cancel Search");
        btnCancelSearch.addActionListener(action);
        btnCancelSearch.setFont(new Font("Helvetica", Font.PLAIN, 18));
        btnCancelSearch.setBounds(550, 11, 150, 54);
        contentPane.add(btnCancelSearch);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 92, 700, 2);
        contentPane.add(separator_1);

        JLabel label_List_Footballer = new JLabel("List of footballers");
        label_List_Footballer.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_List_Footballer.setBounds(10, 97, 251, 54);
        contentPane.add(label_List_Footballer);

        table = new JTable();
        table.setFont(new Font("Helvetica", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "Footballer Id", "Name", "Club", "DoB",
                        "Price"}));
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 144, 700, 214);
        contentPane.add(scrollPane);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 369, 700, 2);
        contentPane.add(separator_2);

        JLabel label_Footballer_Declare = new JLabel("Footballer");
        label_Footballer_Declare.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_Footballer_Declare.setBounds(10, 369, 233, 54);
        contentPane.add(label_Footballer_Declare);

        JLabel label_FootballerId = new JLabel("Id");
        label_FootballerId.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_FootballerId.setBounds(10, 412, 102, 54);
        contentPane.add(label_FootballerId);

        textField_FootballerID = new JTextField();
        textField_FootballerID.setFont(new Font("Helvetica", Font.PLAIN, 19));
        textField_FootballerID.setColumns(10);
        textField_FootballerID.setBounds(127, 425, 166, 29);
        contentPane.add(textField_FootballerID);

        JLabel label_Name = new JLabel("Name");
        label_Name.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_Name.setBounds(324, 412, 102, 54);
        contentPane.add(label_Name);

        textField_Name = new JTextField();
        textField_Name.setFont(new Font("Helvetica", Font.PLAIN, 19));
        textField_Name.setColumns(10);
        textField_Name.setBounds(405, 425, 166, 29);
        contentPane.add(textField_Name);

        JLabel label_DoB = new JLabel("DoB");
        label_DoB.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_DoB.setBounds(10, 455, 155, 54);
        contentPane.add(label_DoB);

        textField_DoB = new JTextField();
        textField_DoB.setFont(new Font("Helvetica", Font.PLAIN, 19));
        textField_DoB.setColumns(10);
        textField_DoB.setBounds(127, 470, 166, 29);
        contentPane.add(textField_DoB);

        JLabel label_Price = new JLabel("Price");
        label_Price.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_Price.setBounds(324, 470, 52, 23);
        contentPane.add(label_Price);

        textField_Price = new JTextField();
        textField_Price.setFont(new Font("Helvetica", Font.PLAIN, 19));
        textField_Price.setColumns(10);
        textField_Price.setBounds(405, 470, 166, 29);
        contentPane.add(textField_Price);

        JLabel label_Club = new JLabel("Club");
        label_Club.setFont(new Font("Helvetica", Font.PLAIN, 19));
        label_Club.setBounds(10, 510, 102, 54);
        contentPane.add(label_Club);

        comboBox_Club = new JComboBox();
        comboBox_Club.addItem("");
        for (Club club : listClub) {
            comboBox_Club.addItem(club.getName());
        }

        comboBox_Club.setBounds(127, 522, 166, 35);
        contentPane.add(comboBox_Club);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(10, 575, 700, 2);
        contentPane.add(separator_3);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(action);
        btnAdd.setFont(new Font("Helvetica", Font.PLAIN, 18));
        btnAdd.setBounds(31, 580, 89, 42);
        contentPane.add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(action);
        btnDelete.setFont(new Font("Helvetica", Font.PLAIN, 18));
        btnDelete.setBounds(151, 580, 89, 42);
        contentPane.add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(action);
        btnUpdate.setFont(new Font("Helvetica", Font.PLAIN, 18));
        btnUpdate.setBounds(264, 580, 135, 42);
        contentPane.add(btnUpdate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(action);
        btnCancel.setFont(new Font("Helvetica", Font.PLAIN, 18));
        btnCancel.setBounds(450, 580, 135, 42);
        contentPane.add(btnCancel);
        this.setVisible(true);
    }

    public Footballer getChooseFootballer() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        int footballerId = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
        String name = model_table.getValueAt(i_row, 1) + "";
        Club club = Club.getClubByName(model_table.getValueAt(i_row, 2) + "");
        String date = model_table.getValueAt(i_row, 3) + "";
        Date doB = null;
        try {
            doB = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error " + e.getMessage());
        }
        int price = Integer.valueOf(model_table.getValueAt(i_row, 4) + "");

        Footballer footballer = new Footballer(footballerId, name, club, doB, price);
        return footballer;
    }

    public void setChooseFootballer() {
        Footballer footballer = getChooseFootballer();

        this.textField_FootballerID.setText(footballer.getFootballerId() + "");
        this.textField_Name.setText(footballer.getName() + "");
        this.comboBox_Club.setSelectedItem(footballer.getCountry().getName());
        String date = footballer.getDoB().getDate() + "/" + (footballer.getDoB().getMonth() + 1) + "/"
                + (footballer.getDoB().getYear() + 1900);
        this.textField_DoB.setText(date + "");
        this.textField_Price.setText(footballer.getPrice() + "");
    }

    public void addFootballer() {
        int footballerId = Integer.valueOf(this.textField_FootballerID.getText());
        String name = this.textField_Name.getText();
        int club_id = this.comboBox_Club.getSelectedIndex() - 1;
        Club club = Club.getClubById(club_id);
        Date doB = new Date(this.textField_DoB.getText());
        int price = Integer.valueOf(this.textField_Price.getText());
        Footballer footballer = new Footballer(footballerId, name, club, doB, price);
        this.addOrUpdateFootballer(footballer);
    }

    public void addFootballer(Footballer footballer){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();

            model_table.addRow(new Object[] { footballer.getFootballerId()+ "",
                    footballer.getName(),
                    footballer.getCountry().getName(),
                    footballer.getDoB().getDate() + "/"
                            + (footballer.getDoB().getMonth() + 1)
                            + "/" + (footballer.getDoB().getYear() + 1900),
                    footballer.getPrice() });


    }

    public void addOrUpdateFootballer(Footballer footballer){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if (!this.model.checkExist(footballer)) {
            this.model.insert(footballer);
            this.addFootballer(footballer);
        } else {
            this.model.update(footballer);
            int rowCount = model_table.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String id = model_table.getValueAt(i, 0) + "";
                if (id.equals(footballer.getFootballerId() + "")) {

                        model_table.setValueAt(footballer.getFootballerId() + "", i, 0);
                        model_table.setValueAt(footballer.getName() + "", i, 1);
                        model_table.setValueAt(footballer.getCountry().getName() + "", i, 2);
                        model_table.setValueAt(footballer.getDoB().getDate() + "/"
                                + (footballer.getDoB().getMonth() + 1) + "/"
                                + (footballer.getDoB().getYear() + 1900) + "", i, 3);
                        model_table.setValueAt(footballer.getPrice() + "", i, 4);
                }
            }
        }
    }

    public void deleteFootballer() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure about that ?");
        if (choice == JOptionPane.YES_OPTION) {
            Footballer footballer = getChooseFootballer();
            this.model.delete(footballer);
            model_table.removeRow(i_row);
        }
    }

    public void deleteForm() {
        textField_FootballerID.setText("");
        textField_Name.setText("");
        textField_DoB.setText("");
        textField_Price.setText("");
        comboBox_Club.setSelectedIndex(-1);
    }

    public void seachFootballer() {
        this.reloadData();
        int club_id = this.comboBox_Club_Search.getSelectedIndex() - 1;
        String footballerIdSearch = this.textField_FootballerId_Search.getText();
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int rowCount = model_table.getRowCount();

        Set<Integer> footballerIdDelete = new TreeSet<Integer>();
        if (club_id >= 0) {
            Club clubSelected = Club.getClubById(club_id);
            for (int i = 0; i < rowCount; i++) {
                String club = model_table.getValueAt(i, 2) + "";
                String id = model_table.getValueAt(i, 0) + "";
                if (!club.equals(clubSelected.getName())) {
                    footballerIdDelete.add(Integer.valueOf(id));
                }
            }
        }
        if (footballerIdSearch.length() > 0) {
            for (int i = 0; i < rowCount; i++) {
                String club = model_table.getValueAt(i, 0) + "";
                if (!club.equals(footballerIdSearch)) {
                    footballerIdDelete.add(Integer.valueOf(club));
                }
            }
        }
        for (Integer idDelete : footballerIdDelete) {

            rowCount = model_table.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String idInTable = model_table.getValueAt(i, 0) + "";
                if (idInTable.equals(idDelete.toString())) {
                    try {
                        model_table.removeRow(i);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Cannot remove row when searching footballers");
                    }
                    break;
                }
            }
        }
    }

    public void reloadData() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int rowCount = model_table.getRowCount();
            if(rowCount == 0)
                break;
            else
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        for (Footballer footballer : this.model.getFootballers()) {
                this.addFootballer(footballer);
            }
    }

    public void deleteSearch() {
        textField_FootballerId_Search.setText("");
        comboBox_Club_Search.setSelectedIndex(-1);
    }

    public void openFile(File file) {
        ArrayList<Footballer> footballers = new ArrayList<Footballer>();
        try {
            this.model.setName(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Footballer footballer = null;
            while((footballer = (Footballer) ois.readObject())!=null) {
                footballers.add(footballer);
            }
            ois.close();
        } catch (Exception e) {
            if(e.getMessage() != null)
                JOptionPane.showMessageDialog(this,"This file cannot be open!");
        }
        this.model.setFootballers(footballers);
    }

    public void openFileAction() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            openFile(file);
            reloadData();
        }
    }

    public void saveFile(String path) {
        try {
            this.model.setName(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Footballer footballer : this.model.getFootballers()) {
                oos.writeObject(footballer);
            }
            oos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot save file!");
        }
    }

    public void saveFileAction() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            saveFile(file.getAbsolutePath());
        }
    }

    public void exitProgram() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Do you really want to exit ?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void displayAbout() {
        JOptionPane.showMessageDialog(this, "Football Manager");
    }
}
