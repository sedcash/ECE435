import java.util.ArrayList;

public class Fill {
    public int r;
    public int g;
    public int b;
    public double opacity;


    public Fill(double r, double g, double b, double opacity) {
        this.r = (int) r;
        this.g = (int) g;
        this.b = (int) b;
        this.opacity = opacity;
    }

    public Fill(){
        this.r = (int) General.getRandomValueInRange(255, 5);
        this.g = (int) General.getRandomValueInRange(255, 5);
        this.b = (int) General.getRandomValueInRange(255, 5);
        this.opacity = General.getRandomValueInRange(.8, .1);
    }

    public String returnFill() {
        String result = "fill = 'rgb(" + r + "," + g + "," + b + ")'";
        return result;
    }

    public String returnOpacity() {
        String result = "opacity = '" + opacity + "'";
        return result;
    }
}

