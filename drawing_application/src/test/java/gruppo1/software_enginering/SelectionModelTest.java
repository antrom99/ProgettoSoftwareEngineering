package gruppo1.software_enginering;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SelectionModelTest {

    SelectionModel selectionModel = new SelectionModel();
    Rectangle rectangle = new Rectangle(7.0, 8.0, 9.0, 12.0);

    @Test
    void testAdd() {

        System.out.println("\n--------  TEST  Add   --------\n");

        System.out.println("Selection Model :");
        System.out.println("Selection Model view_element: "+selectionModel.getView_element());
        System.out.println("Selection Model shape_element: "+selectionModel.getShape_element());
        System.out.println("Selection Model rotate: "+selectionModel.getRotate());
        System.out.println("Selection Model rotateCircle: "+selectionModel.getRotateCircle());
        System.out.println("Selection Model resizeCircle: "+selectionModel.getResizeCircle());

        System.out.println();
        System.out.println("Rectangle : "+rectangle);

        System.out.println();
        System.out.println("Call function Add: ");
        selectionModel.add(rectangle);
        

        System.out.println();

        System.out.println("Selection Model :");
        System.out.println("Selection Model view_element: "+selectionModel.getView_element());
        System.out.println("Selection Model shape_element: "+selectionModel.getShape_element());
        System.out.println("Selection Model rotate: "+selectionModel.getRotate());
        System.out.println("Selection Model rotateCircle: "+selectionModel.getRotateCircle());
        System.out.println("Selection Model resizeCircle: "+selectionModel.getResizeCircle());

        assertEquals(Color.BLUE, selectionModel.getRotateCircle().getStroke());
        assertEquals(Color.BLUE, selectionModel.getResizeCircle().getStroke());
        assertEquals(Color.TRANSPARENT, selectionModel.getRotateCircle().getFill());
        assertEquals(Color.TRANSPARENT, selectionModel.getResizeCircle().getFill());
        assertEquals(-1, selectionModel.getShape_element().getViewOrder());
        assertEquals((selectionModel.getView_element().getX()+ selectionModel.getView_element().getWidth())/2, selectionModel.getRotate().getPivotX());
        assertEquals((selectionModel.getView_element().getY()+ selectionModel.getView_element().getHeight())/2, selectionModel.getRotate().getPivotY());

    }

    @Test
    void testAddView() {

        System.out.println("\n--------  TEST  AddView   --------\n");

        Pane drawingSurface = new Pane();
        System.out.println("Call addView function: ");
        selectionModel.addView(drawingSurface);

        System.out.println("Verify if View Rectangle is show");
        boolean isViewShow = drawingSurface.getChildren().contains(selectionModel.getView_element());
        assertEquals(true, isViewShow);
        System.out.println("Is View Rectangle show on the DrawingSurface?: " +isViewShow);

        System.out.println("Verify if Resize Circle is show");
        boolean isResizeCircle = drawingSurface.getChildren().contains(selectionModel.getResizeCircle());
        assertEquals(true, isResizeCircle);
        System.out.println("Is Resize Circle show on the DrawingSurface?: " +isResizeCircle);

        System.out.println("Verify if Rotate Circle is show");
        boolean isRotateCircle = drawingSurface.getChildren().contains(selectionModel.getRotateCircle());
        assertEquals(true, isRotateCircle);
        System.out.println("Is Rotate Circle show on the DrawingSurface?: " +isRotateCircle);

    }

    @Test
    void testClear() {
            //chiama le due Remove
    }

    @Test
    void testContains() {
        System.out.println("\n--------  TEST  Contains   --------\n");

        System.out.println("Generate a Rectangle : " +rectangle);

        System.out.println("Call function Add of SelectionModel and add Rectangle");
        selectionModel.add(rectangle);

        System.out.println("Verify if contains Rectangle");
        boolean contains = selectionModel.contains(rectangle);
        System.out.println("Contains : "+contains);
        assertEquals(true, contains);

    }

    @Test
    void testRemove() {

        System.out.println("\n--------  TEST  remove(Rectangle selected, Pane drawingSurface)   --------\n");

        System.out.println("Generate a Rectangle : " +rectangle);

        Pane drawingSurface = new Pane();
        System.out.println("Add Rectangle to drawingSurface: ");
        drawingSurface.getChildren().add(rectangle);

        System.out.println("Verify if  Rectangle is add");
        boolean isDraw = drawingSurface.getChildren().contains(rectangle);
        assertEquals(true, isDraw);
        System.out.println("Is Rectangle add to drawingSurface: " +isDraw);

        System.out.println();

        System.out.println("Call Remove Function:");
        selectionModel.remove(rectangle, drawingSurface);
        

        System.out.println("Verify if  Rectangle is remove");
        boolean isDelete = !drawingSurface.getChildren().contains(rectangle);
        assertEquals(true, isDelete);
        System.out.println("Is Rectangle remove to drawingSurface: " +isDelete);

        System.out.println("Verify if Resize Circle is show");
        boolean isResizeCircle = drawingSurface.getChildren().contains(selectionModel.getResizeCircle());
        assertEquals(false, isResizeCircle);
        System.out.println("Is Resize Circle show on the DrawingSurface?: " +isResizeCircle);

        System.out.println("Verify if Rotate Circle is show");
        boolean isRotateCircle = drawingSurface.getChildren().contains(selectionModel.getRotateCircle());
        assertEquals(false, isRotateCircle);
        System.out.println("Is Rotate Circle show on the DrawingSurface?: " +isRotateCircle);


    }

    @Test
    void testRemove2() {

        System.out.println("\n--------  TEST  remove(Node node)   --------\n");

        System.out.println("Generate a Rectangle : " +rectangle);

        System.out.println("Call Remove");
        selectionModel.remove(rectangle);

        System.out.println("Verify if Shape_element is set to 'null'");
        System.out.println("shape_element : "+selectionModel.getShape_element());
        assertEquals(null, selectionModel.getShape_element());
    }

}
