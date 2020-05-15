public class Rectangle {
    public int width;
    public int length;
    public int x;
    public int y;

    public Rectangle(int x, int y, int w, int l){
        this.y = y;
        this.x = x;
        this.width = w;
        this.length = l;
    }

    public double getPerimeter(){
        return 2 * length + 2 * width;
    }

    public double getArea(){
        return length * width;
    }
}
