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

import AllEntities.Employees;

public class EmployeesForm implements ActionListener{

	JFrame frame;
	JLabel Eid_lb=new JLabel("EmployeeID");
	JLabel fname_lb=new JLabel("FirstName");
	JLabel lname_lb=new JLabel("LastName");
	JLabel pos_lb=new JLabel("Position");
	JLabel Bid_lb=new JLabel("BranchID");
	JLabel tel_lb=new JLabel("Telephone");
	JLabel eml_lb=new JLabel("Email");

	JTextField Eid_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField pos_txf=new JTextField();
	JTextField Bid_txf=new JTextField();
	JTextField tel_txf=new JTextField();
	JTextField eml_txf=new JTextField();

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
	public EmployeesForm() {
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
		frame.setTitle("EMPLOYEES FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		Eid_lb.setBounds(10, 10, 130, 30);
		fname_lb.setBounds(10, 50, 150, 30);
		lname_lb.setBounds(10, 90, 150, 30);
		pos_lb.setBounds(10, 130, 100, 30);
		Bid_lb.setBounds(10, 170, 100, 30);
		tel_lb.setBounds(10, 210, 170, 30);
		eml_lb.setBounds(10, 250, 100, 30);
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		Eid_txf.setBounds(200, 10, 170, 30);
		fname_txf.setBounds(200, 50, 170, 30);
		lname_txf.setBounds(200, 90, 170, 30);
		pos_txf.setBounds(200, 130, 170, 30);
		Bid_txf.setBounds(200, 170, 170, 30);
		tel_txf.setBounds(200, 210, 170, 30);
		eml_txf.setBounds(200, 250, 170, 30);
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,300, 100, 60);
		Read_btn.setBounds(120,300, 100, 60);
		update_tbtn.setBounds(230,300, 100, 60);
		delete_btn.setBounds(340,300, 100, 60);
		table.setBounds(450, 10, 750, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		Eid_lb.setFont(font);
		fname_lb.setFont(font);
		lname_lb.setFont(font);
		pos_lb.setFont(font);
		Bid_lb.setFont(font);
		tel_lb.setFont(font);
		eml_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		Eid_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		pos_txf.setFont(font);
		Bid_txf.setFont(font);
		tel_txf.setFont(font);
		eml_txf.setFont(font);
	
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(Eid_lb);
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(pos_lb);
		frame.add(Bid_lb);
		frame.add(tel_lb);
		frame.add(eml_lb);
		
		frame.add(Eid_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(pos_txf);
		frame.add(Bid_txf);
		frame.add(tel_txf);
		frame.add(eml_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Employees emf=new Employees();
		if(e.getSource()==insert_btn) {
			emf.setFirstName(fname_txf.getText());
			emf.setLastName(lname_txf.getText());
			emf.setPosition(pos_txf.getText());
			emf.setBranchID(Bid_txf.getText());
			emf.setTelephone(tel_txf.getText());
			emf.setEmail(eml_txf.getText());
			emf.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("EmployeeID");
            model.addColumn("FirstName");
            model.addColumn("LastName");
            model.addColumn("Position");
            model.addColumn("BranchID");
            model.addColumn("Telephone");
            model.addColumn("Email");
           
            ResultSet resultSet =Employees.viewData();
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
	    	int id=Integer.parseInt(Eid_txf.getText());
	    	emf.setFirstName(fname_txf.getText());
			emf.setLastName(lname_txf.getText());
			emf.setPosition(pos_txf.getText());
			emf.setBranchID(Bid_txf.getText());
			emf.setTelephone(tel_txf.getText());
			emf.setEmail(eml_txf.getText());
			
			emf.update(id);
	    }
	  else {
			int id=Integer.parseInt(Eid_txf.getText());
			emf.delete(id);}

	  }		
		public static void main(String[] args) {
			EmployeesForm ef=new EmployeesForm();
			System.out.println(ef);
		
			
		}

	}

