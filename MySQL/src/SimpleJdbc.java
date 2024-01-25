// Alec Namey

import java.sql.*;
public class SimpleJdbc {
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded");

    // Establish a connection
    // Assuming the database name is 'testdb', user is 'testuser'
    // and password is 'Pa$$word'
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost:3306/Miramar","root","Pa$$word");
    System.out.println("Database connected");

    // Create a statement
    Statement statement = connection.createStatement();
 
    // UPDATE ZIP CODE
    String updateQuery = "UPDATE student SET zipcode = '92126' WHERE lastName = 'Jones';";
    PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
    preparedStatement.executeUpdate();
    
    
    // Execute a statement 
    ResultSet resultSet = statement.executeQuery("select * from student;");
    




      // Iterate through the result and print the student names
    while (resultSet.next())
      System.out.println( "SSN: " + resultSet.getString(1) + "\nFirst Name: " +
        resultSet.getString(2) + "\nMiddle Name: " + resultSet.getString(3) + "\nLast Name: " +
        resultSet.getString(4) + "\nDOB: " + resultSet.getString(5) +  "\nStreet: " +
        resultSet.getString(6) +  "\nPhone: " + resultSet.getString(7) +  "\nZipCode: " + resultSet.getString(8) +  "\nDeptID: " + resultSet.getString(9));

    // Close the connection
    connection.close();
  }
}