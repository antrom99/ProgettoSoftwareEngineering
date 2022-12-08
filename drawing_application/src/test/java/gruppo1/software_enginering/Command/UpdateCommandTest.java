package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class UpdateCommandTest {
    @Test
    void testExecuteForRectangle() {

        System.out.println("\n--------  TEST CASE 1  --------\n");

        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);

        System.out.println("MyRectangle created : "+actual.getShape());

        UpdateCommand up = new UpdateCommand(actual, 5.0, 3.0);
        System.out.println("Drag Point x : "+5.0 + "  Drag Point y :" + 3.0);
        up.execute();
        assertEquals(5, actual.getMyRectangle().getWidth()); 
        assertEquals(3, actual.getMyRectangle().getHeight());
        System.out.println("Update Width and Height of MyRectangle: ");
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("Expected :[Width : "+5.0 + "  Height :" + 3.0+"]");

        System.out.println();

        UpdateCommand upNegative = new UpdateCommand(actual, -10.0, -3.0);
        System.out.println("Drag Point x : "+-10.0 + "  Drag Point y :" +-3.0);
        upNegative.execute();
        assertEquals(0.0, actual.getMyRectangle().getWidth());
        assertEquals(0.0, actual.getMyRectangle().getHeight());
        System.out.println("Update Width and Height of MyRectangle: ");
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("Expected :[Width : "+0.0 + "  Height :" + 0.0+"]");

        System.out.println();

        UpdateCommand upUpper = new UpdateCommand(actual, 1000.0, 3000.0);
        System.out.println("Drag Point x : "+-1000.0 + "  Drag Point y :" +-3000.0);
        upUpper.execute();
        assertEquals(773.0, actual.getMyRectangle().getWidth());
        assertEquals(670.0, actual.getMyRectangle().getHeight());
        System.out.println("Update Width and Height of MyRectangle: ");
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("Expected :[Width : "+773.0 + "  Height :" + 670.0+"]");

    }


    @Test
    void testExecuteForEllipse() {

        System.out.println("\n--------  TEST CASE 2  --------\n");

        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);

        System.out.println("MyEllipse created : "+actual.getShape());

        UpdateCommand up = new UpdateCommand(actual, 5.0, 3.0);
        System.out.println("Drag Point x : "+5.0 + "  Drag Point y :" + 3.0);
        up.execute();
        assertEquals(5.0/2, actual.getMyEllipse().getRadiusX());
        assertEquals(3.0/2, actual.getMyEllipse().getRadiusY());
        System.out.println("Update Radius X and Radius Y of MyEllipse: ");
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("Expected :[Radius X : "+2.5 + "  Radius Y :" + 1.5+"]");

        System.out.println();
         
        UpdateCommand upNegative = new UpdateCommand(actual, -10.0, -3.0);
        System.out.println("Drag Point x : "+-10.0 + "  Drag Point y :" + -3.0);
        upNegative.execute();
        assertEquals(0.0, actual.getMyEllipse().getRadiusX());
        assertEquals(0.0, actual.getMyEllipse().getRadiusY());
        System.out.println("Update Radius X and Radius Y of MyEllipse: ");
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("Expected :[Radius X : "+0.0 + "  Radius Y :" + 0.0+"]");

        System.out.println();

        UpdateCommand upUpper = new UpdateCommand(actual, 1000.0, 3000.0);
        System.out.println("Drag Point x : "+1000.0 + "  Drag Point y :" + 3000.0);
        upUpper.execute();
        assertEquals(773.0/2, actual.getMyEllipse().getRadiusX());
        assertEquals(670.0/2, actual.getMyEllipse().getRadiusY());
        System.out.println("Update Radius X and Radius Y of MyEllipse: ");
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("Expected :[Radius X : "+386.5 + "  Radius Y :" + 335.0+"]");

         
    }

    
   
        @Test
        void testExecuteForLine() {
    
            System.out.println("\n--------  TEST CASE 3  --------\n");
    
            Line line = new Line();
            MyLine actual = new MyLine(line);
    
            System.out.println("MyLine created : "+actual.getShape());
    
            UpdateCommand up = new UpdateCommand(actual, 5.0, 3.0);
            System.out.println("Drag Point x : "+5.0 + "  Drag Point y :" + 3.0);
            up.execute();
            assertEquals(5.0, actual.getMyLine().getEndX());
            assertEquals(3.0, actual.getMyLine().getEndY());
            System.out.println("Update End X and End Y of MyLine: ");
            System.out.println("MyLine modified : "+actual.getShape());
            System.out.println("Expected :[End X : "+5.0 + "  End Y :" + 3.0+"]");
    
            System.out.println();
    
            UpdateCommand upNegative = new UpdateCommand(actual, -10.0, -3.0);
            System.out.println("Drag Point x : "+-10.0 + "  Drag Point y :" + -3.0);
            upNegative.execute();
            assertEquals(0.0, actual.getMyLine().getEndX());
            assertEquals(0.0, actual.getMyLine().getEndY());
            System.out.println("Update End X and End Y of MyLine: ");
            System.out.println("MyLine modified : "+actual.getShape());
            System.out.println("Expected :[End X : "+0.0 + "  End Y :" + 0.0+"]");
    
            System.out.println();
             
    
            UpdateCommand upUpper = new UpdateCommand(actual, 1000.0, 3000.0);
            System.out.println("Drag Point x : "+1000.0 + "  Drag Point y :" + 3000.0);
            upUpper.execute();
            assertEquals(773.0, actual.getMyLine().getEndX());
            assertEquals(670.0, actual.getMyLine().getEndY());
            System.out.println("Update End X and End Y of MyLine: ");
            System.out.println("MyLine modified : "+actual.getShape());
            System.out.println("Expected :[End X : "+773.0 + "  End Y :" + 670.0+"]");
    
             
        }

    }