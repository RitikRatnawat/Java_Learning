import javax.sql.DataSource;
import java.sql.*;

public class Main
{
    public static final String DB_NAME = "testJava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\My Learning\\Java Practice\\Java Masterclass Course Programs\\JavaDatabases\\"+DB_NAME;

    public static final String TABLE_NAME = "contacts";

    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PHONE = "Phone";
    public static final String COLUMN_EMAIL = "Email";

    public static void main(String[] args)
    {
        try
        {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS "+ TABLE_NAME);

            statement.execute("CREATE TABLE IF NOT EXISTS "+ TABLE_NAME+
                    "("+COLUMN_NAME+" TEXT, "+COLUMN_PHONE+" INTEGER, "+COLUMN_EMAIL+" TEXT)");
//            statement.execute("INSERT INTO contacts values('John', 95463874, 'john@email.com')");
//            statement.execute("INSERT INTO contacts values('Steve', 95461584, 'steve@email.com')");
//            statement.execute("INSERT INTO contacts values('Tim', 954654684, 'tim@anywhere.com')");
//            statement.execute("INSERT INTO contacts values('Joe', 95111584, 'joe@root.com')");

//            statement.execute("UPDATE contacts set name='Jane' where Phone=95463874");
//            statement.execute("DELETE FROM contacts where name='Jane'");

//            statement.execute("SELECT * from contacts");
//            ResultSet set = statement.getResultSet();

            ResultSet set = statement.executeQuery("SELECT * FROM contacts");
            while(set.next())
            {
                System.out.println(set.getString(1)+"   "+
                        set.getInt(2)+"    "+set.getString(3));
            }

            set.close();
            statement.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Something went wrong : "+e.getMessage());
        }
    }
}
