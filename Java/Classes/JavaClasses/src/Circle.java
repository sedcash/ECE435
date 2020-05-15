public class Circle {
    //member variables
    public double x, y, r;

    //methods
    public Circle(double x_in, double y_in, double r_in){
        x = x_in;
        y = y_in;
        r = r_in;
    }

    public Circle(){
        x = 0;
        y = 0;
        r = 1;
    }

    public double getDist(double x1, double x2, double y1, double y2){
        double sum = (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2);
        return Math.sqrt(sum);
    }

    public  void print(String label){
        System.out.print("\n Circle object: " + label);
        System.out.print("\n x: " + x);
        System.out.print("\n y: " + y);
        System.out.print("\n r: " + r);
    }

    public boolean intersets(Circle other){
        boolean result;
        double dist = getDist(x,y, other.x, other.y);

        if (dist < r + other.r){
            result = true;
        }
        else {
            result = false;
        }

        return result;
    }

    public void copy(Circle other){
        x = other.x;
        y = other.y;
        r = other.r;
    }

}
