package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;




public class DrawCommandTest {




    @Test
    public void DrawRectangleTest(){



        /*I create instance of MyRectangle from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory rectangle = new ShapeFactory("Rectangle[x=150.0, y=84.0, width=256.0, height=109.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) rectangle.getShape(); 
        Pane drawingSurface = new Pane();


        // Draw Command for drawing the current shape
        DrawCommand draw = new DrawCommand(myRectangle, drawingSurface);
        draw.execute();  
      
        
        //Check shape number on drawingSurface with print of check
        assertEquals( 1, drawingSurface.getChildren().size());
        System.out.println("Number of shapes on the drawingSurface : "+drawingSurface.getChildren().size());


        /*I take the figure from the drawingSurface, perform a Cast to make the types compatible,
          and do subsequent attribute checks between those of the instantiated shape myRectangle and
          the shape rectangleFromSurface presented on the drawingSurface*/
        Node node = (Node) drawingSurface.getChildren().get(0);
        ShapeFactory shapeFactory = new ShapeFactory((Shape) node);
        MyRectangle rectangleFromSurface =  (MyRectangle) shapeFactory.getShape();


        if( rectangleFromSurface instanceof MyRectangle){


             assertEquals(myRectangle.getPressedPoint_x(), rectangleFromSurface.getMyRectangle().getX());
             assertEquals(myRectangle.getPressedPoint_y(), rectangleFromSurface.getMyRectangle().getY());
             assertEquals(myRectangle.getMyRectangle().getStroke(), rectangleFromSurface.getMyRectangle().getStroke());
             assertEquals(myRectangle.getMyRectangle().getFill(), rectangleFromSurface.getMyRectangle().getFill());
             assertEquals(myRectangle.getMyRectangle().getStrokeWidth(), rectangleFromSurface.getMyRectangle().getStrokeWidth());
             assertEquals(myRectangle.getMyRectangle().getHeight(), rectangleFromSurface.getMyRectangle().getHeight());
             assertEquals(myRectangle.getMyRectangle().getWidth(), rectangleFromSurface.getMyRectangle().getWidth());

        }
        


    }





    @Test
    public void DrawEllipseTest(){

        ShapeFactory ellipse = new ShapeFactory("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        MyEllipse myEllipse = (MyEllipse) ellipse.getShape();
        Pane drawingSurface = new Pane();

        
        // Draw Command for drawing the current shape
        DrawCommand draw = new DrawCommand(myEllipse, drawingSurface);
        draw.execute();


        //Check shape number on drawingSurface with print of check
        assertEquals( 1, drawingSurface.getChildren().size());
        System.out.println("Number of shapes on the drawingSurface : "+drawingSurface.getChildren().size());


        /*I take the figure from the drawingSurface, perform a Cast to make the types compatible,
          and do subsequent attribute checks between those of the instantiated shape myEllipse and
          the shape ellipseFromSurface presented on the drawingSurface*/
        Node node = (Node) drawingSurface.getChildren().get(0);
        ShapeFactory shapeFactory = new ShapeFactory((Shape) node);
        MyEllipse ellipseFromSurface =  (MyEllipse) shapeFactory.getShape();

        if( ellipseFromSurface instanceof MyEllipse){

            System.out.println("è UNA ISTANZA");

            assertEquals(myEllipse.getPressedPoint_x(), ellipseFromSurface.getMyEllipse().getCenterX());
            assertEquals(myEllipse.getPressedPoint_y(), ellipseFromSurface.getMyEllipse().getCenterY());
            assertEquals(myEllipse.getMyEllipse().getRadiusX(), ellipseFromSurface.getMyEllipse().getRadiusX());
            assertEquals(myEllipse.getMyEllipse().getRadiusY(), ellipseFromSurface.getMyEllipse().getRadiusY());
            assertEquals(myEllipse.getMyEllipse().getStroke(), ellipseFromSurface.getMyEllipse().getStroke());
            assertEquals(myEllipse.getMyEllipse().getFill(), ellipseFromSurface.getMyEllipse().getFill());
            assertEquals(myEllipse.getMyEllipse().getStrokeWidth(), ellipseFromSurface.getMyEllipse().getStrokeWidth());


       }

    }




    @Test
    public void DrawLineTest(){

                ShapeFactory line = new ShapeFactory("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
                MyLine myLine = (MyLine) line.getShape();
                Pane drawingSurface = new Pane();

                // Draw Command for drawing the current shape
                DrawCommand draw = new DrawCommand(myLine, drawingSurface);
                draw.execute();


                 //Check shape number on drawingSurface with print of check
                assertEquals( 1, drawingSurface.getChildren().size());
                System.out.println("Number of shapes on the drawingSurface : "+drawingSurface.getChildren().size());


                /*I take the figure from the drawingSurface, perform a Cast to make the types compatible,
                  and do subsequent attribute checks between those of the instantiated shape myLine and
                  the shape lineFromSurface presented on the drawingSurface*/
                Node node = (Node) drawingSurface.getChildren().get(0);
                ShapeFactory shapeFactory = new ShapeFactory((Shape) node);
                MyLine lineFromSurface =  (MyLine) shapeFactory.getShape();

                if( lineFromSurface instanceof MyLine ){

                    assertEquals(myLine.getMyLine().getStartX(), lineFromSurface.getMyLine().getStartX());
                    assertEquals(myLine.getMyLine().getStartY(), lineFromSurface.getMyLine().getStartY());
                    assertEquals(myLine.getMyLine().getEndX(), lineFromSurface.getMyLine().getEndX());
                    assertEquals(myLine.getMyLine().getEndY(), lineFromSurface.getMyLine().getEndY());
                    assertEquals(myLine.getMyLine().getStroke(), lineFromSurface.getMyLine().getStroke());
                    assertEquals(myLine.getMyLine().getStrokeWidth(), lineFromSurface.getMyLine().getStrokeWidth());


                }


    }





























}
