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

import AllEntities.Loan;

public class LoanForm implements ActionListener{

	JFrame frame;
	JLabel Lid_lb=new JLabel("LoanID");
	JLabel Cid_lb=new JLabel("Customer_id");
	JLabel Lonty_lb=new JLabel("LoanType");
	JLabel Amnt_lb=new JLabel("Amount");
	JLabel Intr_lb=new JLabel("InterestRate");
	JLabel Strdat_lb=new JLabel("StartDate");

	JTextField Lid_txf=new JTextField();
	JTextField Cid_txf=new JTextField();
	JTextField Lonty_txf=new JTextField();
	JTextField Amnt_txf=new JTextField();
	JTextField Intr_txf=new JTextField();
	JTextField Strdat_txf =new JTextField();

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
	public LoanForm() {
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
		frame.setTitle("LOANS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.red);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		Lid_lb.setBounds(10, 10, 130, 30);
		Cid_lb.setBounds(10, 50, 150, 30);
		Lonty_lb.setBounds(10, 90, 150, 30);
		Amnt_lb.setBounds(10, 130, 100, 30);
		Intr_lb.setBounds(10, 170, 150, 30);
		Strdat_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		Lid_txf.setBounds(200, 10, 170, 30);
		Cid_txf.setBounds(200, 50, 170, 30);
		Lonty_txf.setBounds(200, 90, 170, 30);
		Amnt_txf.setBounds(200, 130, 170, 30);
		Intr_txf.setBounds(200, 170, 170, 30);
		Strdat_txf.setBounds(200, 210, 170, 30);
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

		Lid_lb.setFont(font);
		Cid_lb.setFont(font);
		Lonty_lb.setFont(font);
		Amnt_lb.setFont(font);
		Intr_lb.setFont(font);
		Strdat_lb.setFont(font);
		//genderBox.setFont(font);

		Lid_txf.setFont(font);
		Cid_txf.setFont(font);
		Lonty_txf.setFont(font);
		Amnt_txf.setFont(font);
		Intr_txf.setFont(font);
		Strdat_txf.setFont(font);
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
		frame.add(Lid_lb);
		frame.add(Cid_lb);
		frame.add(Lonty_lb);
		frame.add(Amnt_lb);
		frame.add(Intr_lb);
		frame.add(Strdat_lb);
		//frame.add(gender_lb);
		
		frame.add(Lid_txf);
		frame.add(Cid_txf);
		frame.add(Lonty_txf);
		frame.add(Amnt_txf);
		frame.add(Intr_txf);
		frame.add(Strdat_txf);
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
		
		Loan laf=new Loan();
		if(e.getSource()==insert_btn) {
			laf.setCustomerID(Cid_txf.getText());
			laf.setLoanType(Lonty_txf.getText());
			laf.setAmount(Amnt_txf.getText());
			laf.setInterestRate(Intr_txf.getText());
			laf.setStartDate(Strdat_txf.getText());
			//csf.setGender(gender_txf.getText());
			laf.insertData();
			
		}
		else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("LoanID");
            model.addColumn("Customer_id");
            model.addColumn("LoanType");
            model.addColumn("Amount");
            model.addColumn("InterestRate");
            model.addColumn("StartDate");
           
            ResultSet resultSet =Loan.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(Lid_txf.getText());
	    	laf.setCustomerID(Cid_txf.getText());
			laf.setLoanType(Lonty_txf.getText());
			laf.setAmount(Amnt_txf.getText());
			laf.setInterestRate(Intr_txf.getText());
			laf.setStartDate(Strdat_txf.getText());
			//csf.setEmail(Email_txf.getText());
			//csf.setGender(gender_txf.getText());
			
			laf.update(id);
	    }
	  else {
			int id=Integer.parseInt(Lid_txf.getText());
			laf.delete(id);}

	  }		
		public static void main(String[] args) {
			LoanForm lf=new LoanForm ();
			System.out.println(lf);
		
			
		}

	}

