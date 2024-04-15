import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class insertData {

    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO users (name, email) VALUES (?, ?)")){

            String name = "Jas Arells";
            String email = "number6@gmail.com";

            statement.setString(1,name);
            statement.setString(2,email);

            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Data inserted successfullly!");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
