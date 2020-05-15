public class Stroke {
    public int width;
    public int r;
    public int g;
    public int b;
    public double opacity;

    public Stroke(double w, double r, double g, double b, double o){
        this.width = (int) w;
        this.g = (int) g;
        this.r = (int) r;
        this.b = (int) b;
        this.opacity = o;
    }

    public Stroke(){
        this.r = (int) General.getRandomValueInRange(255, 5);
        this.g = (int) General.getRandomValueInRange(255, 5);
        this.b = (int) General.getRandomValueInRange(255, 5);
        this.width = (int) General.getRandomValueInRange(3, 1);
        this.opacity = General.getRandomValueInRange(.8, .1);
    }

    public String returnStroke(){
        String result = "stroke = 'rgb(" + r + "," + g + "," + b + ")' stroke-width = '" + width + "' ";
        return  result;
    }
}
