package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class SelectFillColorTest {
    @Test
    void testExecute() {
        Color fillColor = new Color(0, 0, 0, 0);
        // Color error = new Color(1, 0, 0, 0);
        System.out.println("Color :" +fillColor);


        System.out.println("\n--------  TEST CASE 1  --------\n");

        Rectangle rectangle = new Rectangle();
        System.out.println("Fill color of Rectangle : "+rectangle.getFill());

        SelectFillColor selectFillColorRectangle = new SelectFillColor(rectangle, fillColor);       
        selectFillColorRectangle.execute();
        System.out.println("Fill color of Rectangle after SelectFillColor execute: "+rectangle.getFill());
        assertEquals(fillColor, rectangle.getFill());

        System.out.println();
        System.out.println("\n--------  TEST CASE 2  --------\n");

        Ellipse ellipse = new Ellipse();
        System.out.println("Fill color of Ellipse : "+ellipse.getFill());
        SelectFillColor selectFillColorEllipse = new SelectFillColor(ellipse, fillColor);
        selectFillColorEllipse.execute();
        System.out.println("Fill color of Ellipse after SelectFillColor execute: "+ellipse.getFill());
        assertEquals(fillColor, ellipse.getFill());
        
        System.out.println();
        System.out.println("\n--------  TEST CASE 3  --------\n");

        Line line = new Line();
        System.out.println("Fill color of Line : "+line.getFill());
        SelectFillColor selectFillColorLine = new SelectFillColor(line, fillColor);
        selectFillColorLine.execute();
        System.out.println("Fill color of Line after SelectFillColor execute: "+line.getFill());
        assertEquals(fillColor, line.getFill());
         
    }
}
