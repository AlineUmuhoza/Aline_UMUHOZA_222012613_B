package AllEntities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Loan {

	private int LoanID;
	private String CustomerID;
	private String LoanType;
	private String Amount;
	private String InterestRate;
	private  String StartDate;
	
	public Loan(int LoanID,String CustomerID,String LoanType,String Amount,String InterestRate, String StartDate) {
		
		this.LoanID = LoanID;
		this.CustomerID = CustomerID;
		this.LoanType = LoanType;
		this.Amount = Amount;
		this.InterestRate = InterestRate;
		this.StartDate = StartDate;
		
	}

	public Loan() {
		// TODO Auto-generated constructor stub
	}

	public int getLoanID() {
		return LoanID;
	}

	public void setLoanID(int loanID) {
		LoanID = loanID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getLoanType() {
		return LoanType;
	}

	public void setLoanType(String loanType) {
		LoanType = loanType;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(String interestRate) {
		InterestRate = interestRate;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}



public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to insert data
    String sql = "INSERT INTO Loan (CustomerID, LoanType, Amount, InterestRate, StartDate) VALUES (?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.CustomerID);
       preparedStatement.setString(2, this.LoanType);
       preparedStatement.setString(3, this. Amount);
       preparedStatement.setString(4, this.InterestRate);
       preparedStatement.setString(5, this.StartDate);
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

	        String sql = "SELECT * FROM Loan";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputLoanID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to update data
    String sql = "UPDATE Loan SET  CustomerID=?, LoanType=?, Amount=?, InterestRate=?,  StartDate=?    WHERE LoanID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getCustomerID());
          stm.setString(2, this.getLoanType());
          stm.setString(3, this.getAmount());
          stm.setString(4, this.getInterestRate());
          stm.setString(5, this.getStartDate());
          //stm.setString(5, this.getEmail());
         // stm.setString(6, this.getGender());
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(6, inputLoanID);
       
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
public void delete(int inputLoanID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to delete data
    String sql = "DELETE FROM Loan WHERE  LoanID =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputLoanID); // Assuming there is a column named 'id' for the WHERE clause

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

