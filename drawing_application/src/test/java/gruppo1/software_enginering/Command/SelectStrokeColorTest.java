package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class SelectStrokeColorTest {

    @Test
    void testExecute() {
        Color strokeColor = new Color(0, 0, 0, 0);
        // Color error = new Color(1, 0, 0, 0);
        System.out.println("Color :" +strokeColor);

        System.out.println("\n--------  TEST CASE 1  --------\n");

        Rectangle rectangle = new Rectangle();
        System.out.println("Stroke color of Rectangle : "+rectangle.getStroke());
        SelectStrokeColor selectStrokeColorRectangle = new SelectStrokeColor(rectangle, strokeColor);
        selectStrokeColorRectangle.execute();
        System.out.println("Stroke color of Rectangle after SelectStrokeColor execute: "+rectangle.getStroke());
        assertEquals(strokeColor, rectangle.getStroke());

        System.out.println("\n--------  TEST CASE 2  --------\n");

        Ellipse ellipse = new Ellipse();
        System.out.println("Stroke color of Ellipse : "+ellipse.getStroke());
        SelectStrokeColor selectStrokeColorEllipse = new SelectStrokeColor(ellipse, strokeColor);
        selectStrokeColorEllipse.execute();
        System.out.println("Stroke color of Ellipse after SelectStrokeColor execute: "+ellipse.getStroke());
        assertEquals(strokeColor, ellipse.getStroke());

        System.out.println("\n--------  TEST CASE 3  --------\n");

        Line line = new Line();
        System.out.println("Stroke color of Line : "+line.getStroke());
        SelectStrokeColor selectStrokeColorLine = new SelectStrokeColor(line, strokeColor);
        selectStrokeColorLine.execute();
        System.out.println("Stroke color of Line after SelectStrokeColor execute: "+line.getStroke());
        assertEquals(strokeColor, line.getStroke());

    }
}
