import java.util.ArrayList;

public class Test {
    public SvgMaker svg;
    public ArrayList<Circle> circles;
    public ArrayList<Rectangle> rectangles;
    public String filename = "/Users/sedrickcashawjr/Documents/School/ECE435/Java/SVG/";
    public int width;
    public int height;
    public int numItems;
    public int[][] colors = {{255,0,0}, {255,153,51}, {255,255,51}, {0,204,0},
                {51,153,255}, {127,0,255}, {255,153,204},{255,255,255}};

    public Test(String filename, int width, int height, int length){
        this.filename = filename + filename;
        this.width = width;
        this.height = height;
        this.numItems = length;

        setupSvg();
        setupCircles();
        drawCircles();
        //drawCustomImage();
        svg.close();


    }

    public void setupCircles(){
        circles = new ArrayList<Circle>();
        Circle newCircle = new Circle();
        newCircle.x = 500;
        newCircle.y = 500;
        circles.add(newCircle);

        for (int i = 1; i < numItems; i++) {

            double minDist;
            double dist;
            newCircle = new Circle();

            minDist = 99999.9;
            Circle closestCircle = null;

            //Find the closest circle
            for (Circle c : circles) {
                dist = newCircle.getDistBetweenCircles(c);
                if (dist < minDist) {
                    minDist = dist;
                    closestCircle = c;
                }
            }

            double angle = General.getAngle(closestCircle.x, closestCircle.y, newCircle.x, newCircle.y);
            newCircle.repositionCircle(closestCircle, angle);
            circles.add(newCircle);
        }
    }

    public void setupSvg(){
        svg = new SvgMaker(filename, width, height);
    }

    public void drawCircles(){
        for (int i = 0; i < circles.size(); i++) {
            Circle circle = circles.get(i);
            Fill f1 = new Fill(255,255,0, 0.8);
            Stroke s1 = new Stroke();
            svg.drawCircle(circle, f1, s1);
        }
    }

    public void drawCustomImage(){
        SvgMaker svg = new SvgMaker(filename, width, height);
        Circle firstCircle = new Circle(700, 700, 55);
        Stroke s = new Stroke(1,0,0,0,.8);
        Fill f = new Fill(0,0,0,1);
        svg.drawCircle(firstCircle, f, s);
        int radius = 45;
        int count = 0;
        int position = 0;
        int[] color = new int[3];
        int colorIndex = 0;
        Circle prevCircle = null;
        for(int i = 0; i < numItems; i++){
            if(count > 5){
                count = 0;
                radius -= 5;
                colorIndex ++;
            }
            Circle tempCircle = new Circle(500,500,radius);
            if(i < 6){
                prevCircle = firstCircle;
            }else {
                position = i - 6;
                prevCircle = circles.get(position);
            }

            tempCircle.repositionCircle(prevCircle, i);

            //Change the color
            color = colors[colorIndex];
            int r = color[0];
            int g = color[1];
            int b = color[2];

            f = new Fill(r,g,b,.8);
            circles.add(tempCircle);
            svg.drawCircle(tempCircle, f, s);
            count += 1;
        }
    }
}
