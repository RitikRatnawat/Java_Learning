import model.Artist;
import model.DataSource;
import model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class MusicMain
{
    public static void main(String[] args)
    {
        DataSource source = new DataSource();

        if(!source.open())
        {
            System.out.println("Couldn't Open the Data Source");
            return;
        }

//        List<Artist> artists = source.queryArtist(DataSource.ORDER_BY_DESC);
//
//        if(artists == null)
//        {
//            System.out.println("No Artists");
//            return;
//        }
//
//        for(Artist artist : artists)
//        {
//            System.out.println(artist.getId()+"    "+artist.getName());
//        }

//        List<String> albums = source.queryAlbumsForArtists("Pink Floyd", DataSource.ORDER_BY_ASC);
//
//        if(albums == null)
//        {
//            System.out.println("No Albums");
//            return;
//        }
//
//        for(String album : albums)
//            System.out.println(album);

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Song Name : ");
//        String title = sc.nextLine();
//
//        List<SongArtist> artistsForSong = source.queryArtistForSongs(title);
//
//        if(artistsForSong == null)
//        {
//            System.out.println("No Artists");
//            return;
//        }
//
//        for(SongArtist artist : artistsForSong)
//        {
//            System.out.println(artist.getArtistName()+"    "+artist.getAlbumName()+
//                    "   "+artist.getTrack());
//        }

//        source.getCount("Harry");


        source.close();
    }
}
