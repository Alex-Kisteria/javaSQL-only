import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "UPDATE users SET name=?, email=? WHERE id=?")) {

            String name = "Alex Kisteria";
            String email = "alex@cit.edu";

            int idToUpdate = 2;
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setInt(3,idToUpdate);

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("Data updated successfullly!");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
