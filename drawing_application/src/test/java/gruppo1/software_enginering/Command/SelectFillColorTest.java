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

        Rectangle rectangle = new Rectangle();
        SelectFillColor selectFillColorRectangle = new SelectFillColor(rectangle, fillColor);       
        selectFillColorRectangle.execute();
        assertEquals(fillColor, rectangle.getFill());


        Ellipse ellipse = new Ellipse();
        SelectFillColor selectFillColorEllipse = new SelectFillColor(ellipse, fillColor);
        selectFillColorEllipse.execute();
        assertEquals(fillColor, ellipse.getFill());
        

        Line line = new Line();
        SelectFillColor selectFillColorLine = new SelectFillColor(line, fillColor);
        selectFillColorLine.execute();
        assertEquals(fillColor, line.getFill());
         
    }
}
