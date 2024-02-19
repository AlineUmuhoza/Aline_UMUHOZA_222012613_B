package AllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllEntities.Branches;


public class BranchesForm implements ActionListener {

    JFrame frame;
    JLabel bidLabel = new JLabel("BranchID");
    JLabel branchNameLabel = new JLabel("BranchName");
    JLabel locationLabel = new JLabel("Location");

    JTextField bidTextField = new JTextField();
    JTextField branchNameTextField = new JTextField();
    JTextField locationTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public BranchesForm() {
        createForm();
        actionEvent();
        setFontForAll();
        addComponentToFrame();
        setLocationAndSize();
    }

    private void actionEvent() {
        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("BRANCHES FORM");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.yellow);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        bidLabel.setBounds(10, 10, 130, 30);
        branchNameLabel.setBounds(10, 50, 150, 30);
        locationLabel.setBounds(10, 90, 150, 30);

        bidTextField.setBounds(200, 10, 170, 30);
        branchNameTextField.setBounds(200, 50, 170, 30);
        locationTextField.setBounds(200, 90, 170, 30);

        insertButton.setBounds(10, 190, 100, 60);
        viewButton.setBounds(120, 190, 100, 60);
        updateButton.setBounds(230, 190, 100, 60);
        deleteButton.setBounds(340, 190, 100, 60);
        
        table.setBounds(500, 10, 600, 250);
    }

    private void setFontForAll() {
        Font font = new Font("Georgia", Font.BOLD, 18);

        bidLabel.setFont(font);
        branchNameLabel.setFont(font);
        locationLabel.setFont(font);

        bidTextField.setFont(font);
        branchNameTextField.setFont(font);
        locationTextField.setFont(font);

        Font buttonFont = new Font("Courier New", Font.BOLD, 15);

        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentToFrame() {
        frame.add(bidLabel);
        frame.add(branchNameLabel);
        frame.add(locationLabel);

        frame.add(bidTextField);
        frame.add(branchNameTextField);
        frame.add(locationTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Branches branch = new Branches();
        if (e.getSource() == insertButton) {
            branch.setBranchName(branchNameTextField.getText());
            branch.setLocation(locationTextField.getText());
            branch.insertData();
            
        } else if (e.getSource() == viewButton) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("BranchID");
            model.addColumn("BranchName");
            model.addColumn("Location");
            ResultSet resultSet = Branches.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == updateButton) {
            int id = Integer.parseInt(bidTextField.getText());
            branch.setBranchName(branchNameTextField.getText());
            branch.setLocation(locationTextField.getText());
            branch.update(id);
        } else {
            int id = Integer.parseInt(bidTextField.getText());
            branch.delete(id);
        }
    }

    public static void main(String[] args) {
        BranchesForm branchForm = new BranchesForm();
        System.out.println(branchForm);
    }
}
