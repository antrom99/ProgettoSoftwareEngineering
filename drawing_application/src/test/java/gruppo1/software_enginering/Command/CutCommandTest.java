package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;

public class CutCommandTest {

    
    @Test 
    public void CutRectangleTest(){

        /*I create instance of MyRectangle from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory rectangle = new ShapeFactory("Rectangle[x=150.0, y=84.0, width=256.0, height=109.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) rectangle.getShape(); 
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();


        // Draw Command for drawing the current shape
        DrawCommand draw = new DrawCommand(myRectangle, drawingSurface);
        draw.execute();
        System.out.println("Shape on the drawingSurface : "+drawingSurface.getChildren().get(0));


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myRectangle.getShape()));
        System.out.println("Control of select shape : "+selection.contains(selection.getShape_element()));
        
        
        // Cut Command for copying the current shape
        CutCommand cut = new CutCommand(myRectangle.getShape(), selection, drawingSurface);
        cut.execute(); 

        //Check to verify whether the shape has been copied
        assertEquals(myRectangle.getShape().toString(), ContextCommand.getShapeCopy().getShape().toString());
        System.out.println("Cloned Shape : "+ContextCommand.getShapeCopy().getShape());

        //Check to verify the delete of the shape
        assertEquals(0,drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Cut Command : "+drawingSurface.getChildren().size());


        //Check disable "selection view" after Copy Command , deselection --> getView_element() return null because doesn't have any shapes
        assertEquals(null, selection.getView_element());
        System.out.println("Control of null/disable Selection after Copy Command : "+selection.getView_element());



    }




    @Test 
    public void CutEllipseTest(){

        /*I create instance of MyEllipse from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory ellipse = new ShapeFactory("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        MyEllipse myEllipse = (MyEllipse) ellipse.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();


        // Draw Command for drawing the current shape
        DrawCommand draw = new DrawCommand(myEllipse, drawingSurface);
        draw.execute();
        System.out.println("Shape on the drawingSurface : "+drawingSurface.getChildren().get(0));


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));
        assertEquals(true, selection.contains(myEllipse.getShape()));
        System.out.println("Control of select shape : "+selection.contains(selection.getShape_element()));
        
        

        // Cut Command for copying the current shape
        CutCommand cut = new CutCommand(myEllipse.getShape(), selection, drawingSurface);
        cut.execute(); 

        //Check to verify whether the shape has been copied
        assertEquals(myEllipse.getShape().toString(), ContextCommand.getShapeCopy().getShape().toString());
        System.out.println("Cloned Shape : "+ContextCommand.getShapeCopy().getShape());

        //Check to verify the delete of the shape
        assertEquals(0,drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Cut Command : "+drawingSurface.getChildren().size());


        //Check disable "selection view" after Copy Command , deselection --> getView_element() return null because doesn't have any shapes
        assertEquals(null, selection.getView_element());
        System.out.println("Control of null/disable Selection after Copy Command : "+selection.getView_element());



    }




    @Test 
    public void CutLineTest(){

        /*I create instance of MyLine from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory line = new ShapeFactory("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        MyLine myLine = (MyLine) line.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();


        // Draw Command for drawing the current shape
        DrawCommand draw = new DrawCommand(myLine, drawingSurface);
        draw.execute();
        System.out.println("Shape on the drawingSurface : "+drawingSurface.getChildren().get(0));


        //Check "selection view" of current shape 
        selection.add(drawingSurface.getChildren().get(0));        
        assertEquals(true, selection.contains(myLine.getShape()));
        System.out.println("Control of select shape : "+selection.contains(selection.getShape_element()));
        
        

        // Cut Command for copying the current shape
        CutCommand cut = new CutCommand(myLine.getShape(), selection, drawingSurface);
        cut.execute(); 

        //Check to verify whether the shape has been copied
        assertEquals(myLine.getShape().toString(), ContextCommand.getShapeCopy().getShape().toString());
        System.out.println("Cloned Shape : "+ContextCommand.getShapeCopy().getShape());

        //Check to verify the delete of the shape
        assertEquals(0,drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Cut Command : "+drawingSurface.getChildren().size());


        //Check disable "selection view" after Copy Command , deselection --> getView_element() return null because doesn't have any shapes
        assertEquals(null, selection.getView_element());
        System.out.println("Control of null/disable Selection after Copy Command : "+selection.getView_element());



    }





















}
