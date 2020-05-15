import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Itunes {

    static Map<String,Album> getAlbums(String name) throws IOException, JSONException {
        JSONArray results = searchArtist(name);
        if (results.length() == 0) {
            return Collections.emptyMap();
        }

        int id = getArtistId(results);
        URL myUrl = new URL("https://itunes.apple.com/lookup?id=" + id + "&entity=album");
        JSONObject object = submitURL(myUrl);
        results = object.getJSONArray("results");
        Map<String, Album> albums = new HashMap<>();
        for(int i = 1; i < results.length(); i++){
            JSONObject temp = results.getJSONObject(i);
             if(temp.has("collectionName")){
                 String title = temp.getString("collectionName");
                 if(!title.contains("- S")){
                     Album album = new Album(temp);
                     albums.put(title, album);
                 }
             }
        }

        return albums;
    }

    static JSONArray searchArtist(String name) throws IOException, JSONException {
        name = name.toLowerCase().replaceAll(" ", "+");
        URL myUrl = new URL("http://itunes.apple.com/search?term=" + name);
        JSONObject object = submitURL(myUrl);
        JSONArray results =  object.getJSONArray("results");
        return results;
    }

    static int getArtistId(JSONArray array) throws JSONException {
        JSONObject object = array.getJSONObject(0);
        int artistId = 0;
        try{
            artistId = object.getInt("artistId");
        }
        catch (JSONException e){
            System.out.print("No id found");
        }
        return artistId;
    }

    static JSONObject submitURL(URL url) throws IOException, JSONException {
        URLConnection myUrlConnection = url.openConnection();
        java.io.InputStream myInputStream = myUrlConnection.getInputStream();
        InputStreamReader myInputStreamReader = new InputStreamReader(myInputStream);
        BufferedReader in = new BufferedReader(myInputStreamReader);
        String line,str;
        str="";
        while((line=in.readLine())!=null)
        {
            str+=line;
        }
        return new JSONObject(str);
    }
}
