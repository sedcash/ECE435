import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SvgMaker {
    public double imageWidth;
    public double imageHeight;
    public String filename;
    public File file = null;

    private PrintWriter printWriter = null;

    public SvgMaker(String filename, int w, int h){
        this.filename = filename;
        this.imageWidth = w;
        this.imageHeight = h;
        this.file =  new File(filename);

        try{
            printWriter = new PrintWriter(file);
        }
        catch (FileNotFoundException e){
            System.out.println("Cant open file");
        }

        printWriter.println("<svg ");
        printWriter.println("\txmlns = 'http://www.w3.org/2000/svg'");
        printWriter.println("\txmlns:xlink = 'http://www.w3.org/1999/xlink'");
        printWriter.println("\tversion = '1.1'");
        printWriter.println("\twidth = '" + w + "' height = '" + h + "'>");
    }

    public void close(){
        printWriter.println("</svg>");
        printWriter.flush();
        printWriter.close();
    }

    public void drawCircle(Circle c, Fill f, Stroke s){
        printWriter.println("<circle cx = '" + c.x + "' cy = '" + c.y + "'");
        printWriter.println("\t" + "r = '" + c.r + "'");
        printWriter.println("\t" + f.returnFill());
        printWriter.println("\t" + s.returnStroke());
        printWriter.println("\t" + f.returnOpacity() + "/>");
        printWriter.println();
    }

    public void drawRectangle(Rectangle r, Fill f, Stroke s){
        printWriter.println("<rect x = '" + r.x + "' y = '" + r.y + "'");
        printWriter.println("\t" + "width = '" + r.width + "'" + " height = '" + r.length + "'");
        printWriter.println("\t" + f.returnFill());
        printWriter.println("\t" + s.returnStroke() + " />");
        printWriter.println();
    }

    public void drawLine(Line l, Fill f, Stroke s){
        printWriter.println("<line x1 = '" + l.x1 + "' y1 = '" + l.y1 + "'");
        printWriter.println("\t" + "x2 = '" + l.x2 + "'" + " y2 = '" + l.y2 + "'");
        printWriter.println("\t" + s.returnStroke() + " />");
        printWriter.println();
    }

    public void drawRoundedRectangle(RoundedRectangle r, Fill f, Stroke s){
        printWriter.println("<rect x = '" + r.x + "' y = '" + r.y + "'");
        printWriter.println("\t" + "rx = '" + r.rx + "'" + " ry = '" + r.ry + "'");
        printWriter.println("\t" + "width = '" + r.width + "'" + " height = '" + r.length + "'");
        printWriter.println("\t" + f.returnFill());
        printWriter.println("\t" + s.returnStroke() + " />");
        printWriter.println();
    }

}



