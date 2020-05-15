public class Main {

    public static void main(String[] args) {
	// write your code here
//        Circle c = new Circle(10,20,30);
//        c.print("C");
//
//        Circle c1 = new Circle();
//        Circle c2 = new Circle(0.5, 0 , 1.0);
//
//        //shallow copy
//        c1.copy(c2);
//
//        boolean b = c1.intersets(c2);
//
//        if(b = true){
//            System.out.println("They intersect");
//        }else{
//            System.out.println("They do not intersect");
//        }

        Circle[] circles = new Circle[10];
        for(int i = 0; i < circles.length; i++){
            circles[i] = new Circle(Math.random(), Math.random(), Math.random());
            circles[i].print("I am Circle " + i);
        }
    }
}
