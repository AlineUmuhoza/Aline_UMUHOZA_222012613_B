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

import AllEntities.Customer;
//import AllEntities.Employees;

import javax.swing.JComboBox;


public class CustomerForm implements ActionListener{
	JFrame frame;
	JLabel Cid_lb=new JLabel("Customer_id");
	JLabel fname_lb=new JLabel("First Name");
	JLabel lname_lb=new JLabel("Last Name");
	JLabel Adress_lb=new JLabel("Adress");
	JLabel ContactNmbr_lb=new JLabel("ContactNumber");
	JLabel Email_lb=new JLabel("Email");
	JLabel gender_lb=new JLabel("Gender");

	JTextField Cid_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField Adress_txf=new JTextField();
	JTextField ContactNmbr_txf=new JTextField();
	JTextField Email_txf=new JTextField();
	JTextField gender_txf=new JTextField();

	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public CustomerForm() {
		createForm();
		actionEvent();
		setFontforall();
		addComponentToFrame();
		setLocationandSize();
	}

	private void actionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		Cid_lb.setBounds(10, 10, 130, 30);
		fname_lb.setBounds(10, 50, 120, 30);
		lname_lb.setBounds(10, 90, 100, 30);
		Adress_lb.setBounds(10, 130, 100, 30);
		ContactNmbr_lb.setBounds(10, 170, 150, 30);
		Email_lb.setBounds(10, 210, 170, 30);
		gender_lb.setBounds(10, 250, 100, 30);
		
		Cid_txf.setBounds(200, 10, 170, 30);
		fname_txf.setBounds(200, 50, 170, 30);
		lname_txf.setBounds(200, 90, 170, 30);
		Adress_txf.setBounds(200, 130, 170, 30);
		ContactNmbr_txf.setBounds(200, 170, 170, 30);
		Email_txf.setBounds(200, 210, 170, 30);
		genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,330, 100, 60);
		Read_btn.setBounds(120,330, 100, 60);
		update_tbtn.setBounds(230,330, 100, 60);
		delete_btn.setBounds(340,330, 100, 60);
		table.setBounds(500, 10, 700, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		Cid_lb.setFont(font);
		fname_lb.setFont(font);
		lname_lb.setFont(font);
		Adress_lb.setFont(font);
		ContactNmbr_lb.setFont(font);
		Email_lb.setFont(font);
		gender_lb.setFont(font);

		Cid_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		Adress_txf.setFont(font);
		ContactNmbr_txf.setFont(font);
		Email_txf.setFont(font);
		genderBox.setFont(font);
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(Cid_lb);
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(Adress_lb);
		frame.add(ContactNmbr_lb);
		frame.add(Email_lb);
		frame.add(gender_lb);
		
		frame.add(Cid_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(Adress_txf);
		frame.add(ContactNmbr_txf);
		frame.add(Email_txf);
		frame.add(genderBox);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}

@Override
public void actionPerformed(ActionEvent e) {
	
	Customer csf=new Customer();
	if(e.getSource()==insert_btn) {
		csf.setCustomerID(Cid_txf.getText());
		csf.setFname(fname_txf.getText());
		csf.setLname(lname_txf.getText());
		csf.setAdress(Adress_txf.getText());
		csf.setContactNmbr(ContactNmbr_txf.getText());
		csf.setEmail(Email_txf.getText());
		String selectedOption = (String) genderBox.getSelectedItem();
		csf.setGender(selectedOption);
		csf.insertData();
		
	}
	
	else if (e.getSource() == Read_btn) {
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Customer_id");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Adress");
        model.addColumn("ContactNumber");
        model.addColumn("Email");
        model.addColumn("Gender");
       
        ResultSet resultSet =Customer.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getString(7)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource()==update_tbtn) {
		int id=Integer.parseInt(Cid_txf.getText());
		csf.setFname(fname_txf.getText());
		csf.setLname(lname_txf.getText());
		csf.setAdress(Adress_txf.getText());
		csf.setContactNmbr(ContactNmbr_txf.getText());
		csf.setEmail(Email_txf.getText());
		csf.setGender(gender_txf.getText());
		csf.setGender((String)genderBox.getSelectedItem());
		csf.update(id);
    }
  else {
		int id=Integer.parseInt(Cid_txf.getText());
		csf.delete(id);}

  }
    public static void main(String[] args) {
		CustomerForm cs=new CustomerForm ();
		System.out.println(cs);
	
		
	}

}



