public class RoundedRectangle extends Rectangle {
    public int ry;
    public int rx;

    public RoundedRectangle(int x, int y, int w, int l, int r){
        super(x, y, w, l);
        this.rx = r;
        this.ry = r;
    }
}
