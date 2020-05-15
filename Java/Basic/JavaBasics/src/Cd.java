public class Cd {
    public String artist;
    public String title;
    public int year;
    public String genre;
    public String fan;
    static int total = -1;

    public Cd(String artist_in, String title_in,  int year_in, String genre_in, String fan_in){
        total += 1;
        artist = artist_in;
        title = title_in;
        year = year_in;
        genre = genre_in;
        fan = fan_in;
    }

    public Cd(String line){
        total += 1;
        line = line.replaceAll("\\s+","");
        String[] values = new String[5];
        values = line.split(",");
        artist = values[0];
        title = values[1];
        year  = Integer.parseInt(values[2]);
        genre = values[3];
        fan = values[4];
    }

    void printCd(){
        System.out.println("Cd:".concat(" " + title).concat(" is a " + genre +  " cd").concat(" created in " + year).concat(" by " + artist).concat(" played mostly by " + fan));
    }

    static void printTotal(){
        System.out.println("There is a total of " + total + " instances of this class");
    }
}