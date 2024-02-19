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

import AllEntities.Payments;

public class PaymentsForm implements ActionListener{

	JFrame frame;
	JLabel Pid_lb=new JLabel("PaymentID");
	JLabel Lid_lb=new JLabel("LoanID");
	JLabel Amnt_lb=new JLabel("Amount");
	JLabel Paydt_lb=new JLabel("PaymentDate");

	JTextField Pid_txf=new JTextField();
	JTextField Lid_txf=new JTextField();
	JTextField Amnt_txf=new JTextField();
	JTextField Paydt_txf=new JTextField();

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
	public PaymentsForm() {
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
		frame.setTitle("PAYMENTS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		Pid_lb.setBounds(10, 10, 130, 30);
		Lid_lb.setBounds(10, 50, 100, 30);
		Amnt_lb.setBounds(10, 100, 100, 30);
		Paydt_lb.setBounds(10, 150, 150, 30);
		
		Pid_txf.setBounds(200, 10, 190, 30);
		Lid_txf.setBounds(200, 50, 190, 30);
		Amnt_txf.setBounds(200, 100, 190, 30);
		Paydt_txf.setBounds(200, 150, 190, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(10,240, 100, 60);
		Read_btn.setBounds(120,240, 100, 60);
		update_tbtn.setBounds(230,240, 100, 60);
		delete_btn.setBounds(340,240, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		Pid_lb.setFont(font);
		Lid_lb.setFont(font);
		Amnt_lb.setFont(font);
		Paydt_lb.setFont(font);
		
		Pid_txf.setFont(font);
		Lid_txf.setFont(font);
		Amnt_txf.setFont(font);
		Paydt_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(Pid_lb);
		frame.add(Lid_lb);
		frame.add(Amnt_lb);
		frame.add(Paydt_lb);
		
		frame.add(Pid_txf);
		frame.add(Lid_txf);
		frame.add(Amnt_txf);
		frame.add(Paydt_txf);

		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Payments pym=new Payments();
		if(e.getSource()==insert_btn) {
				if(e.getSource()==insert_btn) {
					pym.setLoanID(Lid_txf.getText());
					pym.setAmount(Amnt_txf.getText());
					pym.setPaymentDate(Paydt_txf.getText());
					/*csf.setContactNmbr(ContactNmbr_txf.getText());
					csf.setEmail(Email_txf.getText());
					csf.setGender(gender_txf.getText());*/
					pym.insertData();
					
				}
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(0);
			model.addColumn("PaymentID");
            model.addColumn("LoanID");
            model.addColumn("Amount");
            model.addColumn("PaymentDate");
            
            ResultSet resultSet =Payments.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
			    else if (e.getSource()==update_tbtn) {
					int id=Integer.parseInt(Pid_txf.getText());
					pym.setLoanID(Lid_txf.getText());
					pym.setAmount(Amnt_txf.getText());
					pym.setPaymentDate(Paydt_txf.getText());
					/*csf.setContactNmbr(ContactNmbr_txf.getText());
					csf.setEmail(Email_txf.getText());
					csf.setGender(gender_txf.getText());*/
					
					pym.update(id);
			    }
			  else {
					int id=Integer.parseInt(Pid_txf.getText());
					pym.delete(id);}

			  }
			    public static void main(String[] args) {
					PaymentsForm pyf=new PaymentsForm ();
					System.out.println(pyf);
				
					
				}

			}



