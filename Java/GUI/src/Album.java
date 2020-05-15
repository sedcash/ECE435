import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ArrayBlockingQueue;

public class Album {
    public String genre;
    public String price;
    public String country;
    public String explicitness;
    public String releaseDate;
    public String title;
    public String artist;
    public String image;
    public int trackCount;

    public Album(String genre, String price, String country, String title, String artist, String id,
                 String explicitness, String releaseDate){
        this.genre = genre;
        this.country = country;
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.explicitness = explicitness;
        this.releaseDate = releaseDate;
    }

    public Album(JSONObject object) throws JSONException {
        this.image = object.getString("artworkUrl100");
        try {
            this.price = "$" + object.getDouble("collectionPrice") + " " + object.getString("currency");
        }catch (Exception e){
            this.price = "$0";
        }

        this.genre = object.getString("primaryGenreName");
        this.trackCount = object.getInt("trackCount");
        this.title = object.getString("collectionName");
        this.explicitness = object.getString("collectionExplicitness");
        this.releaseDate = object.getString("releaseDate").substring(0,4);
    }

    public void printAlbum(){
        System.out.println();
        System.out.println(this.title);
        System.out.println(this.price);
        System.out.println(this.genre);
        System.out.println(this.trackCount);
        System.out.println(this.explicitness);
        System.out.println(this.releaseDate);
    }
}
