package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource
{
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\My Learning\\Java Practice\\" +
            "Java Masterclass Course Programs\\JavaDatabases\\"+DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final int ORDER_BY_NONE = 0;
    public static final int ORDER_BY_ASC = 1;
    public static final int ORDER_BY_DESC = 2;

    public static final String QUERY_ARTIST_FOR_SONGS_START =
            "Select " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + "," +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + "," +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK +  " from " +
                    TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS +
                    " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " +
                    TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " +
                    TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONGS_END =
            "\" ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ASC";

    public static final String QUERY_FOR_COUNT = "SELECT COUNT(*) FROM " + TABLE_SONGS +
            " WHERE " + COLUMN_SONG_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            "(" + COLUMN_ARTIST_NAME + ")" + " VALUES(?)";

    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS +
            "(" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ")" +
            " VALUES(?, ?)";

    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS +
            "(" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " +
            COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    private Connection conn;
    private PreparedStatement statement;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    public boolean open()
    {
        try
        {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.prepareStatement(QUERY_FOR_COUNT);

            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONG);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void close()
    {
        try {
            if (statement != null)
                statement.close();

            if (insertIntoArtists != null)
                insertIntoArtists.close();

            if (insertIntoAlbums != null)
                insertIntoAlbums.close();

            if (insertIntoSongs != null)
                insertIntoSongs.close();

            if(queryArtist != null)
                queryArtist.close();

            if(queryAlbum != null)
                queryAlbum.close();

            if (conn != null)
                conn.close();
        }
        catch(SQLException e)
        {
            System.out.println("Couldn't Close Connection "+e.getMessage());
        }
    }

    public List<Artist> queryArtist(int sortOrder)
    {
        StringBuilder sb = new StringBuilder("Select * from ");
        sb.append(TABLE_ARTISTS);

        if(sortOrder != ORDER_BY_NONE)
        {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME+" ");
            sb.append("COLLATE NOCASE ");
            if(sortOrder == ORDER_BY_DESC)
                sb.append("DESC");
            else
                sb.append("ASC");
        }

        try(Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(sb.toString()))
        {
            List<Artist> artists = new ArrayList<>();
            while(set.next())
            {
                Artist artist = new Artist();
                artist.setId(set.getInt(INDEX_ARTIST_ID));
                artist.setName(set.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;
        }
        catch(SQLException e)
        {
            System.out.println("Something Went Wrong : "+e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtists(String artistName, int sortOrder)
    {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(TABLE_ALBUMS+"."+COLUMN_ALBUM_NAME);
        sb.append(" FROM ");
        sb.append(TABLE_ALBUMS+" INNER JOIN "+TABLE_ARTISTS);
        sb.append(" ON ");
        sb.append(TABLE_ALBUMS+"."+COLUMN_ALBUM_ARTIST+" = "+TABLE_ARTISTS+"."+COLUMN_ARTIST_ID);
        sb.append(" WHERE "+TABLE_ARTISTS+"."+COLUMN_ARTIST_NAME+" = "+"'"+artistName+"'");
        sb.append(" ORDER BY "+TABLE_ALBUMS+"."+COLUMN_ALBUM_NAME+" COLLATE NOCASE ");
        if(sortOrder == ORDER_BY_DESC)
            sb.append("DESC");
        else
            sb.append("ASC");

        System.out.println(sb.toString());

        try(Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(sb.toString()))
        {
            List<String> albums = new ArrayList<>();
            while(set.next())
            {
                String albumName = set.getString(COLUMN_ALBUM_NAME);
                albums.add(albumName);
            }

            return albums;
        }
        catch(SQLException e)
        {
            System.out.println("Something Went Wrong : "+e.getMessage());
            return null;
        }
    }

    public List<SongArtist> queryArtistForSongs(String songTitle)
    {
        String query = QUERY_ARTIST_FOR_SONGS_START + songTitle + QUERY_ARTIST_FOR_SONGS_END;

        try(Statement statement = conn.createStatement();
            ResultSet data = statement.executeQuery(query))
        {
            List<SongArtist> artistsForSong = new ArrayList<>();
            while(data.next())
            {
                SongArtist artist = new SongArtist();
                artist.setArtistName(data.getString(1));
                artist.setAlbumName(data.getString(2));
                artist.setTrack(data.getInt(3));

                artistsForSong.add(artist);
            }

            return artistsForSong;
        }
        catch (SQLException e)
        {
            System.out.println("Something Went Wrong : "+e.getMessage());
            return null;
        }
    }

    public void getCount(String songName)
    {
        try{
            statement.setString(1, songName);
            ResultSet result = statement.executeQuery();
            System.out.println(result.getInt(1));
        }
        catch (SQLException e)
        {
            System.out.println("Something went wrong : "+e.getMessage());
        }
    }

    private int insertArtist(String name) throws SQLException
    {
        queryArtist.setString(1, name);
        ResultSet result = queryArtist.executeQuery();
        if(result.next())
            return result.getInt(1);
        else
        {
            insertIntoArtists.setString(1, name);
            int affected = insertIntoArtists.executeUpdate();

            if(affected != 1)
                throw new SQLException("Unable to insert Artist");

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                throw new SQLException("Unable to Generate Key for Artist");
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException
    {
        queryAlbum.setString(1, name);
        ResultSet result = queryAlbum.executeQuery();
        if(result.next())
            return result.getInt(1);
        else
        {
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affected = insertIntoAlbums.executeUpdate();

            if(affected != 1)
                throw new SQLException("Unable to insert Album");

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                throw new SQLException("Unable to Generate Key for Album");
        }
    }

    public void insertSong(String title, int track, String artist, String album)
    {
        try
        {
            System.out.println("Resetting Autocommit Default Behaviour");
            conn.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            int affected = insertIntoSongs.executeUpdate();

                if(affected == 1)
                    conn.commit();
                else
                    throw new SQLException("Song Insertion failed");
        }
        catch(Exception e)
        {
            System.out.println("Insert Song Exception : " + e.getMessage());
            try {
                System.out.println("Rolling Back");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("Things are really bad " + e2.getMessage());
            }
        }
        finally
        {
            try
            {
                System.out.println("Resetting Autocommit setting to default");
                conn.setAutoCommit(true);
            }
            catch (SQLException e3)
            {
                System.out.println("Couldn't Reset Commit to default " + e3.getMessage());
            }
        }
    }
}
