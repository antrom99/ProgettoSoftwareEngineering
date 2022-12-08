package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ShapeFactoryTest {
    

    //Verifico se la Get restituisce correttamente un elemento MyShape
    //Il Test viene effettuato sul MyRectangle
    @Test
    void testGetShapeRectangle() {

        System.out.println("\n--------  TEST GetShape Rectangle   --------\n");
       
        Rectangle rectangle = new Rectangle(7.0, 5.0, 6.3, 8.1);
        MyRectangle expect  = new MyRectangle(rectangle);
        System.out.println("MyRectangle 1 created :\t\t\t  "+expect.getShape());
        //Rectangle error = new Rectangle(5.0,4.0,3.0,2.0);
        
        ShapeFactory s1 = new ShapeFactory(rectangle);
                
        MyRectangle actual = (MyRectangle) s1.getShape();
        System.out.println("MyRectangle 2 generate by MyRectangle 1 : "+actual.getShape());
        assertEquals(expect.getMyRectangle(), actual.getMyRectangle());

        /*assertEquals(expect.getMyRectangle().getX(), actual.getMyRectangle().getX());
        assertEquals(expect.getMyRectangle().getY(), actual.getMyRectangle().getY());
        assertEquals(expect.getMyRectangle().getFill(), actual.getMyRectangle().getFill());
        assertEquals(expect.getMyRectangle().getStroke(), actual.getMyRectangle().getStroke());
        assertEquals(expect.getMyRectangle().getStrokeWidth(), actual.getMyRectangle().getStrokeWidth());        
        */
    }

     //Il Test viene effettuato su un MyEllipse
     @Test
     void testGetShapeEllipse() {

        System.out.println("\n--------  TEST GetShape Ellipse   --------\n");
        
         Ellipse ellipse  = new Ellipse(7.0, 5.0, 6.3, 8.1);
         MyEllipse expect = new MyEllipse(ellipse);      
         System.out.println("MyEllipse 1 created : \t\t\t"+expect.getShape());
         //Ellipse error = new Ellipse(5.0,4.0,3.0,2.0);
         
         ShapeFactory s1 = new ShapeFactory(ellipse);
         
         MyEllipse actual = (MyEllipse) s1.getShape();
         System.out.println("MyEllipse 2 generate by MyEllipse 1 :   "+actual.getShape());
         assertEquals(expect.getMyEllipse(), actual.getMyEllipse());
 
         /*assertEquals(expect.getMyEllipse().getCenterX(), actual.getMyEllipse().getCenterX());
         assertEquals(expect.getMyEllipse().getCenterY(), actual.getMyEllipse().getCenterY());
         assertEquals(expect.getMyEllipse().getFill(), actual.getMyEllipse().getFill());
         assertEquals(expect.getMyEllipse().getStroke(), actual.getMyEllipse().getStroke());
         assertEquals(expect.getMyEllipse().getStrokeWidth(), actual.getMyEllipse().getStrokeWidth());
        */
 
     }

      //Il Test viene effettuato su un MyLine
     @Test
     void testGetShapeLine() {

        System.out.println("\n--------  TEST GetShape Line   --------\n");
        
         Line line  = new Line(7.0, 5.0, 6.3, 8.1);
         MyLine expect = new MyLine(line);    
         System.out.println("MyLine 1 created : \t\t"+expect.getShape());  
         //Line error = new Line(5.0,4.0,3.0,2.0);
         
         ShapeFactory s1 = new ShapeFactory(line);
         
         MyLine actual = (MyLine) s1.getShape();
         System.out.println("MyLine 2 generate by MyLine 1 : "+actual.getShape());
         assertEquals(expect.getMyLine(), actual.getMyLine());
        
         /*assertEquals(expect.getMyLine().getStroke(), actual.getMyLine().getStroke());
         assertEquals(expect.getMyLine().getStrokeWidth(), actual.getMyLine().getStrokeWidth());
       
         expect.getMyLine().setStrokeWidth(3);
         assertEquals(expect.getMyLine().getStrokeWidth(), actual.getMyLine().getStrokeWidth());
        */
     }
 

}
