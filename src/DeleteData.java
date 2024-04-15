import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        try( Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "DELETE FROM users WHERE id=?")) {

            int idToDelete = 2;
            statement.setInt(2,idToDelete);

            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                System.out.println("Data deleted successfullly!");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}

