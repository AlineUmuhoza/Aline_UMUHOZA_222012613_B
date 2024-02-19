package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customer {
	private int CustomerID;
	private String fname;
	private String lname;
	private String Adress;
	private String ContactNmbr;
    private String Email;
	private String gender;
	
	public Customer() {
		//constructor
	}

public Customer(int CustomerID,String fname,String lname,String Adress,String ContactNmbr,String Email,String gender) {
	super();
	this.CustomerID =CustomerID;
	this.fname = fname;
	this.lname = lname;
	this.Adress = Adress;
	this.ContactNmbr = ContactNmbr;
    this.Email = Email;
	this.gender= gender;
}


public int getCustomerID() {
	return CustomerID;
}

public void setCustomerID(String CustomerID) {
	CustomerID = CustomerID;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getAdress() {
	return Adress;
}

public void setAdress(String adress) {
	Adress = adress;
}

public String getContactNmbr() {
	return ContactNmbr;
}

public void setContactNmbr(String contactNmbr) {
	ContactNmbr = contactNmbr;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to insert data
    String sql = "INSERT INTO customer (fname, lname, Adress, ContactNmbr, Email, gender ) VALUES (?,?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       
       preparedStatement.setString(1, this.fname);
       preparedStatement.setString(2, this.lname);
       preparedStatement.setString(3, this.Adress);
       preparedStatement.setString(4, this.ContactNmbr);
       preparedStatement.setString(5, this.Email);
       preparedStatement.setString(6, this.gender);
       
          
        
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

	        String sql = "SELECT * FROM Customer";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }}

		
public void update(int inputCustomerID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to update data
    String sql = "UPDATE Customer SET  fname=?, lname=?, Adress=?, ContactNmbr=?, Email=?, gender=?  WHERE CustomerID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getFname());
          stm.setString(2, this.getLname());
          stm.setString(3, this.getAdress());
          stm.setString(4, this.getContactNmbr());
          stm.setString(5, this.getEmail());
          stm.setString(6, this.getGender());
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(7, inputCustomerID);
       
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
public void delete(int inputCustomerID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to delete data
    String sql = "DELETE FROM Customer WHERE  CustomerID =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputCustomerID); // Assuming there is a column named 'id' for the WHERE clause

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
