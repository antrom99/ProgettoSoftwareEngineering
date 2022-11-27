package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.geometry.Point2D;

public class MyRectangleTest {
    @Test
    void testGetWgetWidth() {

        double xmin = 100;
        double xmax = 200;
        double ymin = 50;
        double ymax = 500;
        MyRectangle rectangle = new MyRectangle();

        

        for (int i = 0; i<4; i++){
           if (i == 0){
               Point2D pressedPoint2D = new Point2D(xmin, ymin);
               Point2D releasedPoint2D = new Point2D(xmax, ymax);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);
               


           }
           if(i==1){
               Point2D pressedPoint2D = new Point2D(xmin, ymax);
               Point2D releasedPoint2D = new Point2D(xmax, ymin);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           if(i==2){
               Point2D pressedPoint2D = new Point2D(xmax, ymin);
               Point2D releasedPoint2D = new Point2D(xmin, ymax);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           if(i==3){
               Point2D pressedPoint2D = new Point2D(xmax, ymax);
               Point2D releasedPoint2D = new Point2D(xmin, ymin);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           double actual = rectangle.getHeigth();
           double expected = ymax-ymin;

           assertEquals(expected, actual, "---TEST FAILD---\n" );
        }

    }

    @Test
    void testGetWidth() {

        double xmin = 100;
        double xmax = 200;
        double ymin = 50;
        double ymax = 500;
        MyRectangle rectangle = new MyRectangle();

        

        for (int i = 0; i<4; i++){
           if (i == 0){
               Point2D pressedPoint2D = new Point2D(xmin, ymin);
               Point2D releasedPoint2D = new Point2D(xmax, ymax);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);
               


           }
           if(i==1){
               Point2D pressedPoint2D = new Point2D(xmin, ymax);
               Point2D releasedPoint2D = new Point2D(xmax, ymin);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           if(i==2){
               Point2D pressedPoint2D = new Point2D(xmax, ymin);
               Point2D releasedPoint2D = new Point2D(xmin, ymax);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           if(i==3){
               Point2D pressedPoint2D = new Point2D(xmax, ymax);
               Point2D releasedPoint2D = new Point2D(xmin, ymin);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           double actual = rectangle.getWidth();
           double expected = xmax-xmin;

           assertEquals(expected, actual, "---TEST FAILD---\n" );
        }


    }

    @Test
    void testStartPointforDrawing(){
        double xmin = 100;
        double xmax = 200;
        double ymin = 50;
        double ymax = 500;
        MyRectangle rectangle = new MyRectangle();

        

        for (int i = 0; i<4; i++){
           if (i == 0){
               Point2D pressedPoint2D = new Point2D(xmin, ymin);
               Point2D releasedPoint2D = new Point2D(xmax, ymax);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);
               


           }
           if(i==1){
               Point2D pressedPoint2D = new Point2D(xmin, ymax);
               Point2D releasedPoint2D = new Point2D(xmax, ymin);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           if(i==2){
               Point2D pressedPoint2D = new Point2D(xmax, ymin);
               Point2D releasedPoint2D = new Point2D(xmin, ymax);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           if(i==3){
               Point2D pressedPoint2D = new Point2D(xmax, ymax);
               Point2D releasedPoint2D = new Point2D(xmin, ymin);
               rectangle.setPressedPoint2D(pressedPoint2D);
               rectangle.setReleasedPoint2D(releasedPoint2D);

           }
           Point2D actual = rectangle.startPointforDrawing();
           Point2D expected = new Point2D(xmin, ymin);

           assertEquals(expected, actual, "---TEST FAILD---\n" );
        }



    }
}
