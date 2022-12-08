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

        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);

        UpdateCommand up = new UpdateCommand(actual, 5.0, 3.0);
        up.execute();
        assertEquals(5, actual.getMyRectangle().getWidth()); 
        assertEquals(3, actual.getMyRectangle().getHeight());

        UpdateCommand upNegative = new UpdateCommand(actual, -10.0, -3.0);
        upNegative.execute();
        assertEquals(0.0, actual.getMyRectangle().getWidth());
        assertEquals(0.0, actual.getMyRectangle().getHeight());

        UpdateCommand upUpper = new UpdateCommand(actual, 1000.0, 3000.0);
        upUpper.execute();
        assertEquals(773.0, actual.getMyRectangle().getWidth());
        assertEquals(670.0, actual.getMyRectangle().getHeight());
         
    }


    @Test
    void testExecuteForEllipse() {

        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);

        UpdateCommand up = new UpdateCommand(actual, 5.0, 3.0);
        up.execute();
        assertEquals(5.0/2, actual.getMyEllipse().getRadiusX());
        assertEquals(3.0/2, actual.getMyEllipse().getRadiusY());
         
        UpdateCommand upNegative = new UpdateCommand(actual, -10.0, -3.0);
        upNegative.execute();
        assertEquals(0.0, actual.getMyEllipse().getRadiusX());
        assertEquals(0.0, actual.getMyEllipse().getRadiusY());
         

        UpdateCommand upUpper = new UpdateCommand(actual, 1000.0, 3000.0);
        upUpper.execute();
        assertEquals(773.0/2, actual.getMyEllipse().getRadiusX());
        assertEquals(670.0/2, actual.getMyEllipse().getRadiusY());
         
    }

    
    @Test
    void testExecuteForLine() {

        Line line = new Line();
        MyLine actual = new MyLine(line);

        UpdateCommand up = new UpdateCommand(actual, 5.0, 3.0);
        up.execute();
        assertEquals(5.0, actual.getMyLine().getEndX());
        assertEquals(3.0, actual.getMyLine().getEndY());

        UpdateCommand upNegative = new UpdateCommand(actual, -10.0, -3.0);
        upNegative.execute();
        assertEquals(0.0, actual.getMyLine().getEndX());
        assertEquals(0.0, actual.getMyLine().getEndY());

         

        UpdateCommand upUpper = new UpdateCommand(actual, 1000.0, 3000.0);
        upUpper.execute();
        assertEquals(773.0, actual.getMyLine().getEndX());
        assertEquals(670.0, actual.getMyLine().getEndY());

         
    }
}
