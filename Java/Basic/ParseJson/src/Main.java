import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;


public class Main {

    public static void main(String[] args) throws JSONException, IOException {
	// write your code here
//        String json = "{" +
//                "\"one\": 100.0, " +
//                "\"two\": [10,20,30], " +
//                "\"three\": {\"red\": 255, \"blue\": 26}" +
//                "}";
//
//        JSONObject myobject = new JSONObject(json);
//        System.out.println(myobject.toString());
//
//        Double d = myobject.getDouble("one");
//        JSONArray myArray = myobject.getJSONArray("two");
//        ArrayList<Integer> myList = new ArrayList<Integer>();
//        int n = myArray.length();
//
//        for(int i = 0; i < n; i++){
//            myList.add(myArray.getInt(i));
//        }
//
//        System.out.println(myList);
         String result = searchTopic("person");
         System.out.println(result);

    }

    public static String searchTopic(String topic) throws IOException, JSONException {
        String results = null;
        URL myUrl = new URL("https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + topic);
        JSONObject object = submitURL(myUrl);
        JSONObject query = object.getJSONObject("query");
        JSONObject pages = query.getJSONObject("pages");
        String id = String.valueOf(pages.getInt("pageid"));
        results = pages.getString(id);
        return results;
    }


    public static JSONObject submitURL(URL url) throws IOException, JSONException {
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

    Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText, encoding)).userAgent("Mozilla/5.0").get();

    //Get the first link about Wikipedia
    String wikipediaURL = google.getElementsByTag("cite").get(0).text();

    //Use Wikipedia API to get JSON File
    String wikipediaApiJSON = "https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
            + URLEncoder.encode(wikipediaURL.substring(wikipediaURL.lastIndexOf("/") + 1, wikipediaURL.length()), encoding);

//Let's see what it found
				System.out.println(wikipediaURL);
                        System.out.println(wikipediaApiJSON);

                        //"extract":" the summary of the article
                        HttpURLConnection httpcon = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
                        httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
                        BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

                        //Read line by line
                        String responseSB = in.lines().collect(Collectors.joining());
                        in.close();

                        //Print the result for us to see
                        //System.out.println(responseSB);
                        String result = responseSB.split("extract\":\"")[1];
                        //System.out.println(result);

                        //Tell only the 150 first characters of the result
                        String textToTell = result.length() > 250 ? result.substring(0, 250) : result;
                        System.out.println(textToTell + "...");


