import java.sql.*;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";
    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        // query sorgusu
        String query = "SELECT * FROM employee ORDER BY id ASC";
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = connection.createStatement();
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            //databaseden gelen verileri listeye ekleme
            while (resultSet.next()){
                employeeList.add(match(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //listedeki verileri ekrana yazma
        for (Employee employee : employeeList){
            System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getPosition() + " " + employee.getSalary());
        }
        /*try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = conn.createStatement();

            // Statement ile Insert İşlemi
            String updateQuery = "INSERT INTO employee (name,position,salary) VALUES ('Azad' , 'uzman' , '1000')";
            st.executeUpdate(updateQuery);
            // Statement ile Insert İşlemi
            String updateQuery2 = "INSERT INTO employee (name,position,salary) VALUES ('Ahmet' , 'uzman' , '2000')";
            st.executeUpdate(updateQuery2);
            // Statement ile Insert İşlemi
            String updateQuery3 = "INSERT INTO employee (name,position,salary) VALUES ('Mehmet' , 'müdür yardımcısı' , '3000')";
            st.executeUpdate(updateQuery3);

            // PreparedStatement ile Insert İşlemi
            PreparedStatement pr = conn.prepareStatement("INSERT INTO employee (name,position,salary) VALUES (?,?,?)");
            pr.setString(1, "Ömer");
            pr.setString(2, "müdür yardımcısı");
            pr.setString(3, "4000");
            pr.executeUpdate();

            // PreparedStatement ile Insert İşlemi
            PreparedStatement pr2 = conn.prepareStatement("INSERT INTO employee (name,position,salary) VALUES (?,?,?)");
            pr2.setString(1, "Kenan");
            pr2.setString(2, "müdür");
            pr2.setString(3, "5000");
            pr2.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }*/
    }
    //database verisini entiteye eşleme
    public static Employee match(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setPosition(resultSet.getString("position"));
        employee.setSalary(resultSet.getInt("salary"));
        return employee;
    }
}