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

        Rectangle rectangle = new Rectangle();
        SelectStrokeColor selectStrokeColorRectangle = new SelectStrokeColor(rectangle, strokeColor);
        selectStrokeColorRectangle.execute();
        assertEquals(strokeColor, rectangle.getStroke());

        Ellipse ellipse = new Ellipse();
        SelectStrokeColor selectStrokeColorEllipse = new SelectStrokeColor(ellipse, strokeColor);
        selectStrokeColorEllipse.execute();
        assertEquals(strokeColor, ellipse.getStroke());

        Line line = new Line();
        SelectStrokeColor selectStrokeColorLine = new SelectStrokeColor(line, strokeColor);
        selectStrokeColorLine.execute();
        assertEquals(strokeColor, line.getStroke());

    }
}
