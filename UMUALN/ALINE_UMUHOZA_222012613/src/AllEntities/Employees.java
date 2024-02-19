package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Employees {

	private int EmployeeID;
	private String FirstName;
	private String LastName;
	private String Position;
	private String BranchID;
	private String Telephone;
	private String Email;
	
public Employees(int EmployeeID,String FirstName,String LastName,String Position,String BranchID,String Telephone,String Email){                                        
super();
this.EmployeeID = EmployeeID;
this.FirstName = FirstName;
this.LastName = LastName;
this.Position = Position;
this.BranchID = BranchID;
this.Telephone = Telephone;
this.Email = Email;	
}

public Employees() {
	//  constructor 
}

public int getEmployeeID() {
	return EmployeeID;
}

public void setEmployeeID(int employeeID) {
	EmployeeID = employeeID;
}

public String getFirstName() {
	return FirstName;
}

public void setFirstName(String firstName) {
	FirstName = firstName;
}

public String getLastName() {
	return LastName;
}

public void setLastName(String lastName) {
	LastName = lastName;
}

public String getPosition() {
	return Position;
}

public void setPosition(String position) {
	Position = position;
}

public String getBranchID() {
	return BranchID;
}

public void setBranchID(String branchID) {
	BranchID = branchID;
}

public String getTelephone() {
	return Telephone;
}

public void setTelephone(String telephone) {
	Telephone = telephone;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to insert data
    String sql = "INSERT INTO Employees ( FirstName, LastName,Position, BranchID, Telephone, Email) VALUES (?,?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.FirstName);
       preparedStatement.setString(2, this.LastName);
       preparedStatement.setString(3, this.Position);
       preparedStatement.setString(4, this.BranchID);
       preparedStatement.setString(5, this.Telephone);
       preparedStatement.setString(6, this.Email);
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

	        String sql = "SELECT * FROM Employees";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputEmployeeID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to update data
    String sql = "UPDATE Employees SET  FirstName=?, LastName=?, Position=?, BranchID=?, Telephone=?, Email=?  WHERE EmployeeID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getFirstName());
          stm.setString(2, this.getLastName());
          stm.setString(3, this.getPosition());
          stm.setString(4, this.getBranchID());
          stm.setString(5, this.getTelephone());
          stm.setString(6, this.getEmail());
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(7, inputEmployeeID);
       
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
public void delete(int inputEmployeeID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/aline_umuhoza_bs";
    String user = "222012613";
    String password = "222012613";

    // SQL query to delete data
    String sql = "DELETE FROM Employees WHERE  EmployeeID =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputEmployeeID); // Assuming there is a column named 'id' for the WHERE clause

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



