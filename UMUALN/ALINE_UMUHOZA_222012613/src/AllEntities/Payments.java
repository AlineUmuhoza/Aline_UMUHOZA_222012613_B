package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payments {
	
	private int PaymentID;
	private String LoanID;
	private String Amount;
	private String PaymentDate;
	
	public Payments(int PaymentID,String LoanID,String Amount, String PaymentDate) {
		
		this.PaymentID = PaymentID;
		this.LoanID = LoanID;
		this.Amount = Amount;
		this.PaymentDate = PaymentDate;
	
	}

	public Payments() {
		// TODO Auto-generated constructor stub
	}

	public int getPaymentID() {
		return PaymentID;
	}

	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}

	public String getLoanID() {
		return LoanID;
	}

	public void setLoanID(String loanID) {
		LoanID = loanID;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}


public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to insert data
    String sql = "INSERT INTO Payments (LoanID, Amount, PaymentDate) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       
       preparedStatement.setString(1, this.LoanID);
       preparedStatement.setString(2, this.Amount);
       preparedStatement.setString(3, this.PaymentDate);
       /*preparedStatement.setString(4, this.ContactNmbr);
       preparedStatement.setString(5, this.Email);
       preparedStatement.setString(6, this.gender);*/
       
          
        
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

	        String sql = "SELECT * FROM Payments";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputPaymentID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to update data
    String sql = "UPDATE Payments SET  LoanID=?, Amount=?, PaymentDate=? WHERE PaymentID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getLoanID());
          stm.setString(2, this.getAmount());
          stm.setString(3, this.getPaymentDate());
          /*stm.setString(4, this.getContactNmbr());
          stm.setString(5, this.getEmail());
          stm.setString(6, this.getGender());*/
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputPaymentID);
       
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
public void delete(int inputPaymentID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to delete data
    String sql = "DELETE FROM Payments WHERE  PaymentID =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputPaymentID); // Assuming there is a column named 'id' for the WHERE clause

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
	

