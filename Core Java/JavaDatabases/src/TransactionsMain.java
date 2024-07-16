import model.DataSource;

public class TransactionsMain
{
    public static void main(String[] args)
    {
        DataSource source = new DataSource();

        if(!source.open())
        {
            System.out.println("Couldn't Open the Data Source");
            return;
        }

        source.insertSong("Touch of Grey", 1, "Grateful Dead", "In The Dark");
        source.close();
    }
}
