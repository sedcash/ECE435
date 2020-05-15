public class DashedStroke extends Stroke {
    public int on;
    public int off;

    public DashedStroke(int w, int r, int g, int b, double o, int on, int off){
        super(w, r, g, b, o);
        this.on = on;
        this.off = off;
    }
}
