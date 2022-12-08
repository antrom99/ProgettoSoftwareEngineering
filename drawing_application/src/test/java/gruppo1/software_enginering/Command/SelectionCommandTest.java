package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;


public class SelectionCommandTest {


    @Test
    public void SelectionRectangleTest(){


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

        //Check Nodes number
        assertEquals(1, drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Draw Command : "+drawingSurface.getChildren().size());


        //Command Selection in the case the shape have already view selected
        selection.add(myRectangle.getMyRectangle());
        selection.addView(drawingSurface);
        SelectionCommand selectionCommand = new SelectionCommand(selection, drawingSurface.getChildren().get(0), drawingSurface);
        selectionCommand.execute();

        //Check for verify of Command , in this case the shape is deselected
        assertEquals(null, selection.getView_element());
        System.out.println("Shape view selected must be false after Selection Command : "+selection.contains(myRectangle.getShape()));


        //Command Selection in the case the shape haven't again view selected
        SelectionCommand selectionCommand2 = new SelectionCommand(selection, drawingSurface.getChildren().get(0), drawingSurface);
        selectionCommand2.execute();

        
        //Check for verify the view selected after a Selection Command
        assertEquals(true, selection.contains(myRectangle.getShape()));
        System.out.println("Shape view selected must be trur after Selection Command : "+selection.contains(myRectangle.getShape()));




    }




    @Test
    public void SelectionEllipseTest(){


        System.out.println("\n--------  TEST CASE 2  --------\n");

        /*I create instance of MyEllipse from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory ellipse = new ShapeFactory("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        MyEllipse myEllipse = (MyEllipse) ellipse.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();;


        System.out.println("Shape create : "+myEllipse.getMyEllipse());

        //Draw Command
        DrawCommand draw = new DrawCommand(myEllipse, drawingSurface);
        draw.execute();

        //Check Nodes number
        assertEquals(1, drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Draw Command : "+drawingSurface.getChildren().size());


        //Command Selection in the case the shape have already view selected
        selection.add(myEllipse.getMyEllipse());
        selection.addView(drawingSurface);
        SelectionCommand selectionCommand = new SelectionCommand(selection, drawingSurface.getChildren().get(0), drawingSurface);
        selectionCommand.execute();

        //Check for verify of Command , in this case the shape is deselected
        assertEquals(null, selection.getView_element());
        System.out.println("Shape view selected must be false after Selection Command : "+selection.contains(myEllipse.getShape()));


        //Command Selection in the case the shape haven't again view selected
        SelectionCommand selectionCommand2 = new SelectionCommand(selection, drawingSurface.getChildren().get(0), drawingSurface);
        selectionCommand2.execute();

        
        //Check for verify the view selected after a Selection Command
        assertEquals(true, selection.contains(myEllipse.getShape()));
        System.out.println("Shape view selected must be trur after Selection Command : "+selection.contains(myEllipse.getShape()));




    }




    @Test
    public void SelectionLineTest(){


        System.out.println("\n--------  TEST CASE 3  --------\n");

        /*I create instance of MyLine from an instance of ShapeFactory
        by performing a cast to make the types compatible*/
        ShapeFactory line = new ShapeFactory("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        MyLine myLine = (MyLine) line.getShape();
        SelectionModel selection = new SelectionModel();
        Pane drawingSurface = new Pane();


        System.out.println("Shape create : "+myLine.getMyLine());

        //Draw Command
        DrawCommand draw = new DrawCommand(myLine, drawingSurface);
        draw.execute();

        //Check Nodes number
        assertEquals(1, drawingSurface.getChildren().size());
        System.out.println("Nodes number of Pane after the Draw Command : "+drawingSurface.getChildren().size());


        //Command Selection in the case the shape have already view selected
        selection.add(myLine.getMyLine());
        selection.addView(drawingSurface);
        SelectionCommand selectionCommand = new SelectionCommand(selection, drawingSurface.getChildren().get(0), drawingSurface);
        selectionCommand.execute();

        //Check for verify of Command , in this case the shape is deselected
        assertEquals(null, selection.getView_element());
        System.out.println("Shape view selected must be false after Selection Command : "+selection.contains(myLine.getShape()));


        //Command Selection in the case the shape haven't again view selected
        SelectionCommand selectionCommand2 = new SelectionCommand(selection, drawingSurface.getChildren().get(0), drawingSurface);
        selectionCommand2.execute();

        
        //Check for verify the view selected after a Selection Command
        assertEquals(true, selection.contains(myLine.getShape()));
        System.out.println("Shape view selected must be trur after Selection Command : "+selection.contains(myLine.getShape()));




    }

}
