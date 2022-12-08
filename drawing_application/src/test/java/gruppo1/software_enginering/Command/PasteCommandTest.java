package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;




public class PasteCommandTest {



    @Test
    public void PasteRectangleTest(){

        System.out.println("\n--------  TEST CASE 1  --------\n");
        

        /*I create instance of MyRectangle from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory rectangle = new ShapeFactory("Rectangle[x=150.0, y=84.0, width=256.0, height=109.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) rectangle.getShape(); 
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();

        System.out.println("Shape create : "+myRectangle.getMyRectangle());

        //Draw Command
        DrawCommand draw = new DrawCommand(myRectangle, drawingSurface);
        draw.execute();


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myRectangle.getShape()));
        System.out.println("Control of select shape for Copy Command : "+selection.contains(myRectangle.getShape()));

        // Copy Command for copying the current shape
        CopyCommand copy = new CopyCommand(myRectangle.getShape(), selection, drawingSurface);
        copy.execute();


        //Check selection view after copy command
        assertEquals(false, selection.contains(myRectangle.getShape()));
        System.out.println("Control of select shape After Copy Command : "+selection.contains(myRectangle.getShape()));




        /*Paste Command for pasting the current shape, ContextCommand.getShapeCopy() is statit method for copying the shape such as clone
           with different reference */
        PasteCommand paste = new PasteCommand(ContextCommand.getShapeCopy(), drawingSurface, selection);
        paste.execute();
        


        //Check selection of the clone shape
        assertEquals(true, selection.contains(ContextCommand.getShapeCopy().getShape()));
        System.out.println("Control of select of clone shape after Paste Command : "+selection.contains(ContextCommand.getShapeCopy().getShape())); 
        Shape shapeClone = (Shape) selection.getShape_element();



          
        //Check Selection of the clone shape
        selection.clear(drawingSurface);
        assertEquals(false, selection.contains(myRectangle.getShape()));
        assertEquals(2, drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Paste Command and disable selection : "+drawingSurface.getChildren().size());


        //Check if the shape and its clone have been same parameters
        assertEquals(myRectangle.getMyRectangle().toString(), shapeClone.toString());

        //Check of different refernces -> true for different references
        System.out.println("Check of different shapes becasue they have different references : "+
        !(myRectangle.getMyRectangle().equals(ContextCommand.getShapeCopy().getShape())));

        //Parameters of clonated shape
        System.out.println("rectagleClone clonato : "+shapeClone);



    }




    @Test
    public void PasteEllipseTest(){

        System.out.println("\n--------  TEST CASE 2  --------\n");

        /*I create instance of MyEllipse from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory ellipse = new ShapeFactory("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        MyEllipse myEllipse = (MyEllipse) ellipse.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();

        System.out.println("Shape create : "+myEllipse.getMyEllipse());

        //Draw Command
        DrawCommand draw = new DrawCommand(myEllipse, drawingSurface);
        draw.execute();


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myEllipse.getShape()));
        System.out.println("Control of select shape for Copy Command : "+selection.contains(myEllipse.getShape()));

        // Copy Command for copying the current shape
        CopyCommand copy = new CopyCommand(myEllipse.getShape(), selection, drawingSurface);
        copy.execute();


        //Check selection view after copy command
        assertEquals(false, selection.contains(myEllipse.getShape()));
        System.out.println("Control of select shape After Copy Command : "+selection.contains(myEllipse.getShape()));


        /*Paste Command for pasting the current shape, ContextCommand.getShapeCopy() is statit method for copying the shape such as clone
           with different reference */
        PasteCommand paste = new PasteCommand(ContextCommand.getShapeCopy(), drawingSurface, selection);
        paste.execute();
        


        //Check selection of the clone shape
        assertEquals(true, selection.contains(ContextCommand.getShapeCopy().getShape()));
        System.out.println("Control of select of clone shape after Paste Command : "+selection.contains(ContextCommand.getShapeCopy().getShape())); 
        Shape shapeClone = (Shape) selection.getShape_element();



          
        //Check Deselection of the clone shape
        selection.clear(drawingSurface);
        assertEquals(false, selection.contains(myEllipse.getShape()));
        assertEquals(2, drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Paste Command and disable selection : "+drawingSurface.getChildren().size());


        //Check if the shape and its clone have been same parameters
        assertEquals(myEllipse.getMyEllipse().toString(), shapeClone.toString());

        //Check of different refernces -> true for different references
        System.out.println("Check of different shapes becasue they have different references : "+
        !(myEllipse.getMyEllipse().equals(ContextCommand.getShapeCopy().getShape())));

        //Parameters of clonated shape
        System.out.println("rectagleClone clonato : "+shapeClone);



    }




    @Test
    public void PasteLineTest(){

        System.out.println("\n--------  TEST CASE 3  --------\n");

        /*I create instance of MyRectangle from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory line = new ShapeFactory("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        MyLine myLine = (MyLine) line.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();

        System.out.println("Shape create : "+myLine.getMyLine());

        //Draw Command
        DrawCommand draw = new DrawCommand(myLine, drawingSurface);
        draw.execute();


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myLine.getShape()));
        System.out.println("Control of select shape for Copy Command : "+selection.contains(myLine.getShape()));

        // Copy Command for copying the current shape
        CopyCommand copy = new CopyCommand(myLine.getShape(), selection, drawingSurface);
        copy.execute();


        //Check selection view after copy command
        assertEquals(false, selection.contains(myLine.getShape()));
        System.out.println("Control of select shape After Copy Command : "+selection.contains(myLine.getShape()));


        /*Paste Command for pasting the current shape, ContextCommand.getShapeCopy() is statit method for copying the shape such as clone
           with different reference */
        PasteCommand paste = new PasteCommand(ContextCommand.getShapeCopy(), drawingSurface, selection);
        paste.execute();
        


        //Check selection of the clone shape
        assertEquals(true, selection.contains(ContextCommand.getShapeCopy().getShape()));
        System.out.println("Control of select of clone shape after Paste Command : "+selection.contains(ContextCommand.getShapeCopy().getShape())); 
        Shape shapeClone = (Shape) selection.getShape_element();



          
        //Check Deselection of the clone shape
        selection.clear(drawingSurface);
        assertEquals(false, selection.contains(myLine.getShape()));
        assertEquals(2, drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Paste Command and disable selection : "+drawingSurface.getChildren().size());


        //Check if the shape and its clone have been same parameters
        assertEquals(myLine.getMyLine().toString(), shapeClone.toString());

        //Check of different refernces -> true for different references
        System.out.println("Check of different shapes becasue they have different references : "+
        !(myLine.getMyLine().equals(ContextCommand.getShapeCopy().getShape())));

        //Parameters of clonated shape
        System.out.println("rectagleClone clonato : "+shapeClone);



    }


















}
