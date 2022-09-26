package com.example.f22comp1011s1w1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBUtility {
    //the user name and password are what ever you have defined on your local
    //MySQL server
    private static String user = "student";
    private static String password = "student";

    // jdbc:mysql  - this piece tells Java which SQL driver to load
    // 127.0.0.1:3306 - this tells Java that the MySQL server is at IP 127.0.0.1, port 3306
    // F22- that is the database name (do not confuse that with a table name)
    private static String connectUrl = "jdbc:mysql://127.0.0.1:3306/F22";

    /**
     * This method will return a list of Artist objects
     */
    public static ArrayList<Artist> getArtistsFromDB()
    {
        ArrayList<Artist> artists = new ArrayList();

        //query the DB to get a list of Artists
        String sql = "SELECT * FROM artists";

        //the try() is called "try with resources"
        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                )
        {
            //loop over the objects returned and create an Artist object
            while (resultSet.next())
            {
                int artistID = resultSet.getInt("artistID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();

                Artist newArtist = new Artist(artistID, firstName,lastName,birthday);
                artists.add(newArtist);
            }
        }
        catch (Exception e)
        {e.printStackTrace();}

        return artists;
    }
}
