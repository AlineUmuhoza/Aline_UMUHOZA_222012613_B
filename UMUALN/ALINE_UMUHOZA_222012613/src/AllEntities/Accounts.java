package AllEntities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Accounts {
	
	 private int AccountID;
	   private String  CustomerID;
	   private String AccountType;
	   private String  Balance;
	   private String OpenDate;
		
	   public Accounts() {
		   //contructor
	   }
	   
	   public Accounts (int AccountID,  String CustomerID, String AccountType, String  Balance, String OpenDate) {
	   super();
	   this.AccountID = AccountID;
	   this.CustomerID = CustomerID;
	   this.AccountType = AccountType;
	   this.Balance = Balance;
	   this.OpenDate = OpenDate;	
	}


	public int getAccountID() {
		return AccountID;
	}


	public void setAccountID(int accountID) {
		AccountID = accountID;
	}


	public String getCustomerID() {
		return CustomerID;
	}


	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}


	public String getAccountType() {
		return AccountType;
	}


	public void  setAccountType (String accountType) {
		AccountType = accountType;
	}


	public String getBalance() {
		return Balance;
	}


	public void setBalance(String balance) {
		Balance = balance;
	}


	public String getOpenDate() {
		return OpenDate;
	}


	public void setOpenDate(String openDate) {
		OpenDate = openDate;
	}
	   

	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/aline_umuhoza_bs";
	    String user = "222012613";
	    String password = "222012613";

	    // SQL query to insert data
	    String sql = "INSERT INTO Accounts (CustomerID, AccountType ,Balance, OpenDate) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	      // preparedStatement.setString(1, this.CustomerID);
	       preparedStatement.setString(1, this.CustomerID);                                 
	       preparedStatement.setString(2, this. AccountType);
	       preparedStatement.setString(3, this.Balance);
	       preparedStatement.setString(4, this.OpenDate);
	       //preparedStatement.setString(5, this.Email);
	       //preparedStatement.setString(6, this.gender);
	       
	          
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
			public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/aline_umuhoza_bs";
		        String user = "222012613";
		        String password = "222012613";

		        String sql = "SELECT * FROM Accounts";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputAccountID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
	    String user = "222012613";
	    String password = "222012613";

	    // SQL query to update data
	    String sql = "UPDATE Accounts SET  CustomerID=?, AccountType=?, Balance=?, OpenDate=?  WHERE AccountID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getCustomerID());
	          stm.setString(2, this.getAccountType());
	          stm.setString(3, this.getBalance());
	          stm.setString(4, this.getOpenDate());
	          //stm.setString(5, this.getEmail());
	         // stm.setString(6, this.getGender());
	          
	          
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputAccountID);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputAccountID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
	    String user = "222012613";
	    String password = "222012613";

	    // SQL query to delete data
	    String sql = "DELETE FROM Accounts WHERE  AccountID =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputAccountID); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}
	}

	

