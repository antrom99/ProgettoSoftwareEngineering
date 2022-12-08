package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;




public class DeleteCommandTest {




    @Test
    public void DeleteRectangleTest(){

        System.out.println("\n--------  TEST CASE 1  --------\n");


        /*I create instance of MyRectangle from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory rectangle = new ShapeFactory("Rectangle[x=150.0, y=84.0, width=256.0, height=109.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) rectangle.getShape(); 
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();
        
        // Adding myRectangle on the drawingSurface
        drawingSurface.getChildren().add(myRectangle.getShape());
        System.out.println("SHAPE add to the surface : "+drawingSurface.getChildren().get(0));
        
        // Check number of Pane Nodes
        assertEquals(1,drawingSurface.getChildren().size());
        System.out.println("Nodes of the Pane : "+drawingSurface.getChildren().size());


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myRectangle.getShape()));
        System.out.println("Control of select shape : "+selection.contains(myRectangle.getShape()));


        // Delete Command for deleting the currente shape
        DeleteCommand delete = new DeleteCommand(myRectangle.getShape(), drawingSurface, selection);
        delete.execute();


        //Check disable "selection view" after Delete Command , deselection --> getView_element() return false because doesn't have any shapes
        assertEquals(false, selection.contains(myRectangle.getShape()));
        System.out.println("Control of view Selection after Delete Command : "+selection.contains(myRectangle.getShape()));


        // Check of Nodes number is == 0 
        assertEquals(0, drawingSurface.getChildren().size());
        System.out.println("Verify of the Nodes number for the Pane after delete Command : "+drawingSurface.getChildren().size());

    }




    @Test
    public void DeleteEllipseTest(){

        System.out.println("\n--------  TEST CASE 2  --------\n");



        /*I create instance of MyEllipse from an instance of ShapeFactory
            by performing a cast to make the types compatible*/
        ShapeFactory ellipse = new ShapeFactory("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        MyEllipse myEllipse = (MyEllipse) ellipse.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();

        // Adding myRectangle on the drawingSurface
        drawingSurface.getChildren().add(myEllipse.getShape());
        System.out.println("SHAPE add to the surface : "+drawingSurface.getChildren().get(0));;

        // Check number of Pane Nodes
        System.out.println("Nodes of the Pane : "+drawingSurface.getChildren().size());


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myEllipse.getShape()));
        System.out.println("Control of select shape : "+selection.contains(myEllipse.getShape()));


        // Delete Command for deleting the currente shape
        DeleteCommand delete = new DeleteCommand(myEllipse.getShape(), drawingSurface, selection);
        delete.execute();


        //Check disable "selection view" after Delete Command , deselection --> getView_element() return false because doesn't have any shapes
        assertEquals(false, selection.contains(myEllipse.getShape()));
        System.out.println("Control of view Selection after Delete Command : "+selection.contains(myEllipse.getShape()));

      
        // Check of Nodes number is == 0 
        assertEquals(0, drawingSurface.getChildren().size());
        System.out.println("Verify of the Nodes number for the Pane after delete Command : "+drawingSurface.getChildren().size());

    }




    @Test
    public void DeleteLineTest(){

        System.out.println("\n--------  TEST CASE 3  --------\n");


        /*I create instance of MyLine from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory line = new ShapeFactory("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        MyLine myLine = (MyLine) line.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();

        
        // Adding myRectangle on the drawingSurface
        drawingSurface.getChildren().add(myLine.getShape());
        System.out.println("SHAPE add to the surface : "+drawingSurface.getChildren().get(0));;

        // Check number of Pane Nodes
        System.out.println("Nodes of the Pane : "+drawingSurface.getChildren().size());


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myLine.getShape()));
        System.out.println("Control of select shape : "+selection.contains(myLine.getShape()));


        // Delete Command for deleting the currente shape
        DeleteCommand delete = new DeleteCommand(myLine.getShape(), drawingSurface, selection);
        delete.execute();


        //Check disable "selection view" after Delete Command , deselection --> getView_element() return false because doesn't have any shapes
        assertEquals(false, selection.contains(myLine.getShape()));
        System.out.println("Control of view Selection after Delete Command : "+selection.contains(myLine.getShape()));

      
        // Check of Nodes number is == 0 
        assertEquals(0, drawingSurface.getChildren().size());
        System.out.println("Verify of the Nodes number for the Pane after delete Command : "+drawingSurface.getChildren().size());

    }




}
