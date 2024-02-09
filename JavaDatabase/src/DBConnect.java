import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection connect = null;
        Statement st = null;
        String sql = "SELECT * FROM student";
        String insertSql = "INSERT INTO student (student_name,student_class) VALUES ('Azad',4)";
        String prSql = "INSERT INTO student (student_name,student_class) VALUES (?,?)";
        String updateStSql = "UPDATE student SET student_name='Mahmut Çetindağ' WHERE student_id=1";
        String updatePrSql = "UPDATE student SET student_name = ? WHERE student_id = ?";
        String deleteStSql = "DELETE FROM student  WHERE student_id = 4";
        String deletePrSql = "DELETE FROM student  WHERE student_id = ?";
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pr = connect.prepareStatement(deletePrSql);
            pr.setInt(1,3);
            pr.executeUpdate();
            /*st = connect.createStatement();
            st.executeUpdate(deleteStSql);*/
            /*PreparedStatement pr = connect.prepareStatement(updatePrSql);
            pr.setString(1,"Ali Çetindağ");
            pr.setInt(2,1);
            pr.executeUpdate();*/
             /*st = connect.createStatement();
            st.executeUpdate(updateStSql);*/
            /*PreparedStatement prSt = connect.prepareStatement(prSql);
            prSt.setString(1,"Ahmet");
            prSt.setInt(2,5);
            prSt.executeUpdate();
            prSt.close();*/
        //    st = connect.createStatement();
       //     st.executeUpdate(insertSql);
            /*ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID : " + resultSet.getInt("student_id"));
                System.out.println("" + resultSet.getString("student_name"));
                System.out.println("" + resultSet.getInt("student_class"));
            }*/
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
