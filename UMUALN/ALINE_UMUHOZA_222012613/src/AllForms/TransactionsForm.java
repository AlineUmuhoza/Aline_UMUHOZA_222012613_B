package AllForms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllEntities.Transactions;
public class TransactionsForm implements ActionListener{

	JFrame frame;
	JLabel TransactionID_lb=new JLabel("TransactionID");
	JLabel AccountID_lb=new JLabel("AccountID");
	JLabel TransactionType_lb=new JLabel("TransactionType");
	JLabel Amount_lb=new JLabel("Amount");
	JLabel TransactionDate_lb=new JLabel("TransactionDate");
	
	JTextField TransactionID_txf=new JTextField();
	JTextField AccountID_txf=new JTextField();
	JTextField TransactionType_txf=new JTextField();
	JTextField Amount_txf=new JTextField();
	JTextField TransactionDate_txf=new JTextField();
	
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
	public TransactionsForm() {
		createForm();
		actionEvent();
		setLocationandSize();
		addComponentToFrame();
		setFontforall();
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
		frame.setTitle("TRANSACTIONS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		TransactionID_lb.setBounds(10, 10, 150, 30);
		AccountID_lb.setBounds(10, 50, 150, 30);
		TransactionType_lb.setBounds(10, 90, 180, 30);
		Amount_lb.setBounds(10, 130, 150, 30);
		TransactionDate_lb.setBounds(10, 170, 180, 30);
		
		
		TransactionID_txf.setBounds(200, 10, 170, 30);
		AccountID_txf.setBounds(200, 50, 170, 30);
		TransactionType_txf.setBounds(200, 90, 170, 30);
		Amount_txf.setBounds(200, 130, 170, 30);
		TransactionDate_txf.setBounds(200, 170, 170, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(10,270, 100, 60);
		Read_btn.setBounds(120,270, 100, 60);
		update_tbtn.setBounds(230,270, 100, 60);
		delete_btn.setBounds(340,270, 100, 60);
		
		table.setBounds(500, 10, 600, 300);
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		TransactionID_lb.setFont(font);
		AccountID_lb.setFont(font);
		TransactionType_lb.setFont(font);
		Amount_lb.setFont(font);
		TransactionDate_lb.setFont(font);
		

		TransactionID_txf.setFont(font);
		AccountID_txf.setFont(font);
		TransactionType_txf.setFont(font);
		Amount_txf.setFont(font);
		TransactionDate_txf.setFont(font);
		
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(TransactionID_lb);
		frame.add(AccountID_lb);
		frame.add(TransactionType_lb);
		frame.add(Amount_lb);
		frame.add(TransactionDate_lb);
		
		
		frame.add(TransactionID_txf);
		frame.add(AccountID_txf);
		frame.add(TransactionType_txf);
		frame.add(Amount_txf);
		frame.add(TransactionDate_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
		
	}

@Override
public void actionPerformed(ActionEvent e) {
	
	Transactions trn=new Transactions();
	if(e.getSource()==insert_btn) {
		trn.setAccountID(AccountID_txf.getText());
		trn.setTransactionType(TransactionType_txf.getText());
		trn.setAmount(Amount_txf.getText());
		trn.setTransactionDate(TransactionDate_txf.getText());
		/*emf.setTelephone(tel_txf.getText());
		emf.setEmail(eml_txf.getText());*/
		trn.insertData();
		
	}else if (e.getSource() == Read_btn) {
		model.setColumnCount(0);
		model.setRowCount(1);
		model.addColumn("TransactionID");
        model.addColumn("AccountID");
        model.addColumn("TransactionType");
        model.addColumn("Amount");
        model.addColumn("TransactionDate");
        //model.addColumn("Telephone");
        //model.addColumn("Email");
       
        ResultSet resultSet =Transactions.viewData();
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
    	int id=Integer.parseInt(TransactionID_txf.getText());
    	trn.setAccountID(AccountID_txf.getText());
    	trn.setTransactionType(TransactionType_txf.getText());
    	trn.setAmount(Amount_txf.getText());
    	trn.setTransactionDate(TransactionDate_txf.getText());
		//emf.setTelephone(tel_txf.getText());
		//emf.setEmail(eml_txf.getText());
		
    	trn.update(id);
    }
  else {
		int id=Integer.parseInt(TransactionID_txf.getText());
		trn.delete(id);}

  }		
	public static void main(String[] args) {
		TransactionsForm tsf=new TransactionsForm();
		System.out.println(tsf);
	
		
	}

}



