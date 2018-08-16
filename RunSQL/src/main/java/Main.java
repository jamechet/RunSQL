
import java.sql.*;
public class Main {

    public static void main(String[] agrs) throws SQLException {

        // Server authentication
        String dbUrl = "jdbc:mysql://127.0.0.1:13306/testdb";
        String userName = "testuser";
        String password = "password";

        // Java adapter to sql server
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            // Test SQL connection
            myConn = DriverManager.getConnection(dbUrl,userName, password);
            System.out.println("Database connection successful! \n");

            // create SQL statement
            myStmt = myConn.createStatement();

           /* // select data
            // myRs = myStmt.executeQuery("select  * from customers");
           */

           /*  // Insert data
            int rowAffected = myStmt.executeUpdate("insert into customers " + "(first_name, last_name) " + "values " + "('John', 'Smith')");
            myRs = myStmt.executeQuery("select  * from customers");
            */

            /* int rowAffected = myStmt.executeUpdate("update customers " + "set first_name='Alice' " + "where last_name='Smith'");
                myRs = myStmt.executeQuery("select  * from customers");
             */
            int rowAffected = myStmt.executeUpdate("delete  from customers " + "where last_name='Smith' and first_name='Alice'");
            myRs = myStmt.executeQuery("select  * from customers");


            while (myRs.next()){
                System.out.println(myRs.getString("first_name") + ", " + myRs.getString("last_name"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("database fail connection");

        }
        finally {
            if (myRs != null){
                myRs.close();
            }
        }
    }

}
