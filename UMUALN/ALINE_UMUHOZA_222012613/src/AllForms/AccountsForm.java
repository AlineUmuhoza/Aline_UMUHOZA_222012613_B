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

import AllEntities.Accounts;

public class AccountsForm implements ActionListener{

	JFrame frame;
	JLabel Aid_lb=new JLabel("Account_id");
	JLabel Cid_lb=new JLabel("Customer_id");
	JLabel Accty_lb=new JLabel("AccountType");
	JLabel Bal_lb=new JLabel("Balance");
	JLabel Opdate_lb=new JLabel("OpenDate");

	JTextField Aid_txf=new JTextField();
	JTextField Cid_txf=new JTextField();
	JTextField Accty_txf=new JTextField();
	JTextField Bal_txf=new JTextField();
	JTextField Opdate_txf=new JTextField();

	//String []gender={"Male", "Female"};
	//JComboBox<String> genderBox = new JComboBox<>(gender);

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
	public AccountsForm() {
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
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("ACCOUNTS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.blue);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		Aid_lb.setBounds(10, 10, 130, 30);
		Cid_lb.setBounds(10, 50, 150, 30);
		Accty_lb.setBounds(10, 90, 150, 30);
		Bal_lb.setBounds(10, 130, 100, 30);
		Opdate_lb.setBounds(10, 170, 100, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		Aid_txf.setBounds(200, 10, 170, 30);
		Cid_txf.setBounds(200, 50, 170, 30);
		Accty_txf.setBounds(200, 90, 170, 30);
		Bal_txf.setBounds(200, 130, 170, 30);
		Opdate_txf.setBounds(200, 170, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,280, 100, 60);
		Read_btn.setBounds(120,280, 100, 60);
		update_tbtn.setBounds(230,280, 100, 60);
		delete_btn.setBounds(340,280, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		Aid_lb.setFont(font);
		Cid_lb.setFont(font);
		Accty_lb.setFont(font);
		Bal_lb.setFont(font);
		Opdate_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		Aid_txf.setFont(font);
		Cid_txf.setFont(font);
		Accty_txf.setFont(font);
		Bal_txf.setFont(font);
		Opdate_txf.setFont(font);
		//Email_txf.setFont(font);
		//gender_lb.setFont(font);
		//genderBox.setFont(font);
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(Aid_lb);
		frame.add(Cid_lb);
		frame.add(Accty_lb);
		frame.add(Bal_lb);
		frame.add(Opdate_lb);
		//frame.add(Email_lb);
		//frame.add(gender_lb);
		
		frame.add(Aid_txf);
		frame.add(Cid_txf);
		frame.add(Accty_txf);
		frame.add(Bal_txf);
		frame.add(Opdate_txf);
		//frame.add(Email_txf);
		//frame.add(genderBox);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Accounts acf=new Accounts();
		if(e.getSource()==insert_btn) {
			acf.setCustomerID(Cid_txf.getText());
			acf.setAccountType(Accty_txf.getText());
			acf.setBalance(Bal_txf.getText());
			acf.setOpenDate(Opdate_txf.getText());
			//csf.setEmail(Email_txf.getText());
			//csf.setGender(gender_txf.getText());
			acf.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("Account_id");
            model.addColumn("Customer_id");
            model.addColumn("AccountType");
            model.addColumn("Balance");
            model.addColumn("OpenDate");
           //model.addColumn("Telephone");
            //model.addColumn("Email");
           
            ResultSet resultSet =Accounts.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(Aid_txf.getText());
	    	acf.setCustomerID(Cid_txf.getText());
			acf.setAccountType(Accty_txf.getText());
			acf.setBalance(Bal_txf.getText());
			acf.setOpenDate(Opdate_txf.getText());
			//csf.setContactNmbr(ContactNmbr_txf.getText());
			//csf.setEmail(Email_txf.getText());
			//csf.setGender(gender_txf.getText());
			
			acf.update(id);
	    }
	  else {
			int id=Integer.parseInt(Aid_txf.getText());
			acf.delete(id);}

	  }		
		public static void main(String[] args) {
			AccountsForm cf=new AccountsForm ();
			System.out.println(cf);
		
			
		}

	}



