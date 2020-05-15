public class General {

    //Get the angle between two objects
    static double getAngle(double x1, double y1, double x2, double y2){
        double dx = x2 - x1;
        double dy = y1 - y2;
        double angle = Math.atan2(dy,dx);
        return angle;
    }


    //Gets a random int value between
    static double getRandomValueInRange(double maxValue, double minValue){
        return minValue + (Math.random() * (maxValue - minValue));
    }
}
