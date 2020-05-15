import java.io.BufferedReader;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Main {

//    static int[] setupRandArray(int n, int minVal, int maxVal){
//        int[] result = new int[n];
//
//        for(int i =0; i<n; i++) {
//            result[i] = (int) Math.floor(minVal + (maxVal - minVal) * Math.random());
//        }
//        return result;
//    }
//
//    static void printIntArray(int[] x, String label){
//        System.out.print("\n"+ label + ": ");
//        for(int i=0; i<x.length; i++){
//            System.out.print(x[i] + " ");
//        }
//        System.out.println();
//        System.out.println();
//    }
//
//    static void printStringArray(String[] x,String label){
//        System.out.println("\n"+ label);
//        for(int i=0; i<x.length; i++){
//            System.out.print(x[i] + " ");
//        }
//        System.out.println();
//        System.out.println();
//    }
//
//    static double getAverage(int n, int[] x){
//        double sum = 0;
//        for(int i = 0; i < n; i++){
//            sum += x[i];
//        }
//        return sum / n;
//    }
//
//
//
//    static int getMaximum(int n, int[] x){
//        int max = 0;
//        for(int i = 0; i < n; i++){
//            int temp = x[i];
//            if(temp >= max){
//                max = temp;
//            }
//        }
//
//        return max;
//    }
//
//    static double getStandardDev(int n, int[] x){
//        double sum = 0.0;
//        double std = 0.0;
//        double mean;
//
//        for(double num : x) {
//            sum += num;
//        }
//
//        mean = sum/n;
//
//        for(double num: x) {
//            std += Math.pow(num - mean, 2);
//        }
//
//        return Math.sqrt(std/n);
//    }
//
//    static int getCountInRange(int n, int[]x, int minVal, int maxVal){
//        int count = 0;
//        for(int i = 0;  i < n; i++){
//            int temp = x[i];
//            if(temp > minVal && temp < maxVal){
//                count += 1;
//            }
//        }
//        return count;
//    }
//
//    static int[] getValuesInRange(int n, int[] x, int minVal, int maxVal){
//        int[] results = new int[n];
//
//        for(int i = 0; i < n; i++){
//            int temp = x[i];
//            if(temp > minVal && temp < maxVal){
//                results[i] = temp;
//            }
//        }
//        return results;
//    }
//
//    static int[] getIndexInRange(int n, int[] x, int minVal, int maxVal){
//        int[] results = new int[n];
//
//        for(int i = 0; i < n; i++){
//            int temp = x[i];
//            if(temp > minVal && temp < maxVal){
//                results[i] = i;
//            }
//        }
//        results[n-1] = results.length - 1;
//        return results;
//    }
//
//
//    static String[] sortArrays(String[] x){
//        int len = x.length;
//        String temp;
//
//        for(int i = 0; i < len; i++) {
//            for(int j=1; j < (len-i); j++) {
//                String curr = x[j-1];
//                String next = x[j];
//                int value = curr.compareTo(next);
//                if(value == 1) {
//                    temp = curr;
//                    curr = next;
//                    next = temp;
//                }
//            }
//        }
//        return x;
//    }




public String topic;

public String searchTopic() throws IOException, JSONException {
    URL myUrl = new URL("https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + topic);
    JSONObject object = submitURL(myUrl);
    String results =  object.getString("extract");
    return results;
}

public JSONObject submitURL(URL url) throws IOException, JSONException {
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



    public static void main(String[] args) {

       /*
         String filename = "/Users/sedrickcashawjr/Downloads/435 CSV Data.txt";
        CdList playlist = new CdList(filename);
        playlist.printArtists();
        */

    }

}
