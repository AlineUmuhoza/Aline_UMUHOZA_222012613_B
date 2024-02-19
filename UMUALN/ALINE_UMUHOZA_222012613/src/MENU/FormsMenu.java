package MENU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import AllForms.AccountsForm;
import AllForms.BranchesForm;
import AllForms.CustomerForm;
import AllForms.EmployeesForm;
import AllForms.LoanForm;
import AllForms.PaymentsForm;
import AllForms.TransactionsForm;

public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Customermenu;
    private JMenu Employeesmenu;
    private JMenu Branchesmenu;
    private JMenu Transactionsmenu;
    private JMenu Loanmenu;
    private JMenu Paymentsmenu;
    private JMenu Accountsmenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem CustomerItem;
    private JMenuItem EmployeesItem;
    private JMenuItem BranchesItem;
    private JMenuItem TransactionsItem;
    private JMenuItem LoanItem;
    private JMenuItem PaymentsItem;
    private JMenuItem AccountsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setBackground(Color.PINK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Customermenu = new JMenu("Customer");
        Employeesmenu = new JMenu("Employees");
        Branchesmenu= new JMenu(" Branches");
        Transactionsmenu = new JMenu("Transactions");
        Loanmenu = new JMenu("Loan ");
        Paymentsmenu = new JMenu("Payments ");
        Accountsmenu = new JMenu("Accounts");
        Logoutmenu = new JMenu("LOGING OUT");
        		

        // Create menu items
        menuBar.add(Customermenu);
        CustomerItem = new JMenuItem("CustomerForm");
        CustomerItem.addActionListener(this);
        
        menuBar.add(Employeesmenu);
        EmployeesItem = new JMenuItem("EmployeesForm");
        EmployeesItem.addActionListener(this);
        
        menuBar.add(Branchesmenu);
        BranchesItem = new JMenuItem("BranchesForm");
        BranchesItem.addActionListener(this);
        
        menuBar.add(Transactionsmenu);
        TransactionsItem = new JMenuItem("TransactionsForm");
        TransactionsItem.addActionListener(this);
        
        menuBar.add(Loanmenu);
        LoanItem = new JMenuItem("LoanForm");
        LoanItem.addActionListener(this);
        
        menuBar.add(Paymentsmenu);
        PaymentsItem = new JMenuItem("PaymentsForm");
        PaymentsItem.addActionListener(this);

        menuBar.add(Accountsmenu);
        AccountsItem = new JMenuItem("AccountsForm");
        AccountsItem.addActionListener(this);


        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Customermenu.add(CustomerItem);
        Employeesmenu.add(EmployeesItem);
        Branchesmenu.add(BranchesItem);
        Transactionsmenu.add(TransactionsItem);
        Loanmenu.add(LoanItem);
        Paymentsmenu.add(PaymentsItem);
        Accountsmenu.add(AccountsItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);
/*
        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

*/

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CustomerItem) {
            new CustomerForm();
        
        } else if (e.getSource() == EmployeesItem) {
            new EmployeesForm();
        
        } else if (e.getSource() == BranchesItem) {
            new BranchesForm();
       
        } else if (e.getSource() == TransactionsItem) {
           new TransactionsForm();
        
        } else if (e.getSource() == LoanItem) {
           new LoanForm();
           
        } else if (e.getSource() == PaymentsItem) {
            new PaymentsForm();
        
        } else if (e.getSource() == AccountsItem) {
            new AccountsForm();
        
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT OF BANKING FINANCIAL MANAGEMENT SYSTEM"));
    }
}






