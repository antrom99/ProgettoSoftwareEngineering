package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ReDrawCommandTest {


    @Test
    void testExecuteEllipse() {

        System.out.println("\n--------  TEST ReDraw Ellipse   --------\n");

        Pane drawingSurface = new Pane();
        Ellipse ellipse = new Ellipse(7.0, 81.2,6.6, 5.0);
        MyEllipse actual = new MyEllipse(ellipse);
        System.out.println("MyEllipse created : "+actual.getShape());

        System.out.println("--call function Draw: --");
        actual.draw(drawingSurface);
        boolean isDraw = drawingSurface.getChildren().contains(ellipse);
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyEllipse?: "+drawingSurface.getChildren().contains(ellipse));

        SelectionModel selectionModel = new SelectionModel();
        selectionModel.setShape_element(ellipse);

        ReDrawCommand reDrawCommand = new ReDrawCommand(selectionModel, drawingSurface);

        System.out.println("Redraw command");
        reDrawCommand.execute();

        boolean isReDraw = drawingSurface.getChildren().contains(ellipse);
        assertEquals(false, isReDraw);
        System.out.println("The drawingSurface contains MyEllipse?: "+isReDraw);

        System.out.println();
        System.out.println("Check if the drawingSurface contains a Clone of MyEllipse");

        Ellipse actualClone = (Ellipse) selectionModel.getShape_element();
        MyEllipse myActualClone = new MyEllipse(actualClone);

        boolean isClone = drawingSurface.getChildren().contains(actualClone);
        assertEquals(true, isClone);
        System.out.println("The drawingSurface contains MyEllipseClone?: "+isClone);

        assertEquals(actual.getMyEllipse().getCenterX(), myActualClone.getMyEllipse().getCenterX());
        assertEquals(actual.getMyEllipse().getCenterY(), myActualClone.getMyEllipse().getCenterY());
        assertEquals(actual.getMyEllipse().getRadiusX(), myActualClone.getMyEllipse().getRadiusX());
        assertEquals(actual.getMyEllipse().getRadiusY(), myActualClone.getMyEllipse().getRadiusY());

        System.out.println("MyEllipse cloned by ReDraw Command : "+myActualClone.getShape());
    }

    @Test
    void testExecuteRectangle() {

        System.out.println("\n--------  TEST ReDraw Rectangle   --------\n");

        Pane drawingSurface = new Pane();
        Rectangle rectangle = new Rectangle(7.0, 81.2,6.6, 5.0);
        MyRectangle actual = new MyRectangle(rectangle);
        System.out.println("MyRectangle created : "+actual.getShape());

        System.out.println("--call function Draw: --");
        actual.draw(drawingSurface);
        boolean isDraw = drawingSurface.getChildren().contains(rectangle);
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyRectangle?: "+drawingSurface.getChildren().contains(rectangle));

        SelectionModel selectionModel = new SelectionModel();
        selectionModel.setShape_element(rectangle);

        ReDrawCommand reDrawCommand = new ReDrawCommand(selectionModel, drawingSurface);

        System.out.println("Redraw command");
        reDrawCommand.execute();

        boolean isReDraw = drawingSurface.getChildren().contains(rectangle);
        assertEquals(false, isReDraw);
        System.out.println("The drawingSurface contains MyRectangle?: "+isReDraw);

        System.out.println();
        System.out.println("Check if the drawingSurface contains a Clone of MyRectangle");

        Rectangle actualClone = (Rectangle) selectionModel.getShape_element();
        MyRectangle myActualClone = new MyRectangle(actualClone);

        boolean isClone = drawingSurface.getChildren().contains(actualClone);
        assertEquals(true, isClone);
        System.out.println("The drawingSurface contains MyRectangleClone?: "+isClone);

        assertEquals(actual.getMyRectangle().getX(), myActualClone.getMyRectangle().getX());
        assertEquals(actual.getMyRectangle().getY(), myActualClone.getMyRectangle().getY());
        assertEquals(actual.getMyRectangle().getWidth(), myActualClone.getMyRectangle().getWidth());
        assertEquals(actual.getMyRectangle().getHeight(), myActualClone.getMyRectangle().getHeight());

        System.out.println("MyRectangle cloned by ReDraw Command : "+myActualClone.getShape());
    }

    @Test
    void testExecuteLine() {

        System.out.println("\n--------  TEST ReDraw Line   --------\n");

        Pane drawingSurface = new Pane();
        Line line = new Line(7.0, 81.2,6.6, 5.0);
        MyLine actual = new MyLine(line);
        System.out.println("MyLine created : "+actual.getShape());

        System.out.println("--call function Draw: --");
        actual.draw(drawingSurface);
        boolean isDraw = drawingSurface.getChildren().contains(line);
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyLine?: "+drawingSurface.getChildren().contains(line));

        SelectionModel selectionModel = new SelectionModel();
        selectionModel.setShape_element(line);

        ReDrawCommand reDrawCommand = new ReDrawCommand(selectionModel, drawingSurface);

        System.out.println("Redraw command");
        reDrawCommand.execute();

        boolean isReDraw = drawingSurface.getChildren().contains(line);
        assertEquals(false, isReDraw);
        System.out.println("The drawingSurface contains MyLine?: "+isReDraw);

        System.out.println();
        System.out.println("Check if the drawingSurface contains a Clone of MyLine");

        Line actualClone = (Line) selectionModel.getShape_element();
        MyLine myActualClone = new MyLine(actualClone);

        boolean isClone = drawingSurface.getChildren().contains(actualClone);
        assertEquals(true, isClone);
        System.out.println("The drawingSurface contains MyLineClone?: "+isClone);

        assertEquals(actual.getMyLine().getStartX(), myActualClone.getMyLine().getStartX());
        assertEquals(actual.getMyLine().getStartY(), myActualClone.getMyLine().getStartY());
        assertEquals(actual.getMyLine().getEndX(), myActualClone.getMyLine().getEndX());
        assertEquals(actual.getMyLine().getEndY(), myActualClone.getMyLine().getEndY());

        System.out.println("MyLine cloned by ReDraw Command : "+myActualClone.getShape());
    }
}
