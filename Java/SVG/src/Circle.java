public class Circle {
    public double x;
    public double y;
    public double r;

    public Circle(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    //Set member variables to random values if there are no provided parameters
    public Circle(){
        this.x = (int) General.getRandomValueInRange(999, 10);
        this.y = (int) General.getRandomValueInRange(999, 10);
        this.r = (int) General.getRandomValueInRange(10, 1);
    }

    //Returns the area of this circle
    public double getArea(){
        return Math.PI * r * r;
    }

    //Get distance between this circle and another circle
    public double getDistBetweenCircles(Circle c){
        double sum;

        sum = (x - c.x) * (x - c.x) + (y - c.y) * (y - c.y);

        return Math.sqrt(sum);
    }

    //Determines this circle intersects with another circle
    public boolean interescts(Circle other){
        boolean result;

        double dist = getDistBetweenCircles(other);

        if(dist < r + other.r){
            result = true;
        }
        else{
            return false;
        }
        return result;
    }


    //Reposition the circle given another circle and angle
    public void repositionCircle(Circle c, double angle){
        double rOfBothCircles = c.r + r;
        x = c.x + (rOfBothCircles * Math.cos(angle));
        y = c.y - (rOfBothCircles * Math.sin(angle));
    }
}


