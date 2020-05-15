import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CdList {
    public Cd[] mylist = new Cd[150];
    public String[] artists = new String[150];
    public String[] titles = new String[150];
    public int[] years = new int[150];
    public String[] genres = new String[150];
    public String[] fans = new String[150];

    void parseFile(String filename){
        File file =  new File(filename);

        try (Scanner in = new Scanner(file)) {
            while(in.hasNextLine()){
                String line = in.nextLine();
                if(line.length() == 0){
                    continue;
                }
                Cd temp = new Cd(line);
                mylist[temp.total] = temp;
                artists[temp.total] = temp.artist;
                titles[temp.total] = temp.title;
                years[temp.total] = temp.year;
                genres[temp.total] = temp.genre;
                fans[temp.total] = temp.fan;
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public CdList(String file){
        parseFile(file);
    }

    void printCds(){
        System.out.println("All the cds in the collection: ");
        System.out.println();
        for(int i = 0; i < Cd.total + 1; i++){
            mylist[i].printCd();
        }
    }

    void printArtists(){
        System.out.println("All the artists in the collection: ");
        System.out.println();
        for(int i = 0; i < Cd.total + 1; i++){
            System.out.println(artists[i]);
        }
    }

    void printTitles(){
        System.out.println("All the titles in the collection: ");
        System.out.println();
        for(int i = 0; i < Cd.total + 1; i++){
            System.out.println(titles[i]);
        }
    }

    void printYears(){
        System.out.println("All the years in the collection: ");
        System.out.println();
        for(int i = 0; i < Cd.total + 1; i++){
            System.out.println(years[i]);
        }
    }

    void printGenres(){
        System.out.println("All the genres in the collection: ");
        System.out.println();
        for(int i = 0; i < Cd.total + 1; i++){
            System.out.println(genres[i]);
        }
    }

    void printFans(){
        System.out.println("All the fans in the collection: ");
        System.out.println();
        for(int i = 0; i < Cd.total + 1; i++){
            System.out.println(fans[i]);
        }
    }

}
