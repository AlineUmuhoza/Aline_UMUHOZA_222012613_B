package AllEntities;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class Transactions {
	private int TransactionID;
	private String AccountID;
	private String TransactionType;
	private String Amount;
	private String TransactionDate;
	
	public Transactions( int TransactionID, String AccountID, String TransactionType, String Amount, String TransactionDate) {
		super();
		this.TransactionID = TransactionID;
		this.AccountID = AccountID;
		this.TransactionType = TransactionType;
		this.Amount = Amount;
		this.TransactionDate = TransactionDate;
	}
// Constructor
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
		AccountID = accountID;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}
	
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to insert data
    String sql = "INSERT INTO Transactions ( AccountID, TransactionType, Amount, TransactionDate ) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       
       preparedStatement.setString(1, this.AccountID);
       preparedStatement.setString(2, this.TransactionType);
       preparedStatement.setString(3, this.Amount);
       preparedStatement.setString(4, this.TransactionDate);
      // preparedStatement.setString(5, this.Email);
      // preparedStatement.setString(6, this.gender);
       
          
        
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

	        String sql = "SELECT * FROM Transactions";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputTransactionID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to update data
    String sql = "UPDATE Transactions SET  AccountID=?, TransactionType=?, Amount=?, TransactionDate=?  WHERE TransactionID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getAccountID());
          stm.setString(2, this.getTransactionType());
          stm.setString(3, this.getAmount());
          stm.setString(4, this.getTransactionDate());
          /*stm.setString(5, this.getEmail());
          stm.setString(6, this.getGender());*/
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(5, inputTransactionID);
       
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
    String sql = "DELETE FROM Transactions WHERE  TransactionID =?";

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

