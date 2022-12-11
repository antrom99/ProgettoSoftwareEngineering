package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;




public class CopyCommandTest {  

    


    @Test
    public void CopyRectangleTest(){
        
                System.out.println("\n--------  TEST CASE 1  --------\n");



 
                /*I create instance of MyRectangle from an instance of ShapeFactory
                   by performing a cast to make the types compatible*/
                ShapeFactory rectangle = new ShapeFactory("Rectangle[x=150.0, y=84.0, width=256.0, height=109.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
                MyRectangle myRectangle = (MyRectangle) rectangle.getShape(); 
                SelectionModel selection = new SelectionModel();
                Pane drawingSurface = new Pane();

               
                System.out.println("MyRectangle creato : "+myRectangle.getShape());


                // Draw Command for drawing the current shape
                DrawCommand draw = new DrawCommand(myRectangle, drawingSurface);
                draw.execute();
               
                //Check "selection view" of current shape 
                selection.add(drawingSurface.getChildren().get(0));
                assertEquals(true, selection.contains(myRectangle.getShape()));
                System.out.println("Control of view select current shape : "+selection.contains(myRectangle.getShape()));

                // Copy Command for copying the current shape
                CopyCommand copy = new CopyCommand( selection, drawingSurface);
                copy.execute(); 
                
                //Check disable "selection view" after Copy Command , deselection --> getView_element() return false because doesn't have any shapes
                assertEquals(false, selection.contains(myRectangle.getShape()));
                System.out.println("Control of false Selection after Copy Command : "+selection.contains(myRectangle.getShape()));



                



                 /*I take the the cloned shape and do subsequent attribute checks between those of the instantiated shape myRectangle and
                   the shape rectangleClone */
                if ( ContextCommand.getShapeCopy() instanceof MyRectangle ){

                     MyRectangle rectangleClone = (MyRectangle) ContextCommand.getShapeCopy();

                    assertEquals(myRectangle.getPressedPoint_x(), rectangleClone.getPressedPoint_x());
                    assertEquals(myRectangle.getPressedPoint_y(), rectangleClone.getPressedPoint_y());
                    assertEquals(myRectangle.getMyRectangle().getStroke(), rectangleClone.getMyRectangle().getStroke());
                    assertEquals(myRectangle.getMyRectangle().getFill(), rectangleClone.getMyRectangle().getFill());
                    assertEquals(myRectangle.getMyRectangle().getStrokeWidth(), rectangleClone.getMyRectangle().getStrokeWidth());
                    assertEquals(myRectangle.getMyRectangle().getHeight(), rectangleClone.getMyRectangle().getHeight());
                    assertEquals(myRectangle.getMyRectangle().getWidth(), rectangleClone.getMyRectangle().getWidth());

                    System.out.println("rectagleClone clonato : "+rectangleClone.getShape());

                }
                
                

    }




    @Test
    public void CopyEllipseTest(){

                System.out.println("\n--------  TEST CASE 2  --------\n");


                /*I create instance of MyEllipse from an instance of ShapeFactory
                  by performing a cast to make the types compatible*/
                ShapeFactory ellipse = new ShapeFactory("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
                MyEllipse myEllipse = (MyEllipse) ellipse.getShape();
                SelectionModel selection = new SelectionModel();
                Pane drawingSurface = new Pane();
                
                
                System.out.println("Myellipse : "+myEllipse.getShape());


                // Draw Command for drawing the current shape
                DrawCommand draw = new DrawCommand(myEllipse, drawingSurface);
                draw.execute();

                //Check "selection view" of current shape 
                selection.add(drawingSurface.getChildren().get(0));
                assertEquals(true, selection.contains(myEllipse.getShape()));
                System.out.println("Control of view select current shape : "+selection.contains(myEllipse.getShape()));


                // Copy Command for copying the current shape
                CopyCommand copy = new CopyCommand(selection, drawingSurface);
                copy.execute();


                //Check disable "selection view" after Copy Command , deselection --> getView_element() return false because doesn't have any shapes
                assertEquals(false, selection.contains(myEllipse.getShape()));
                System.out.println("Control of false Selection after Copy Command : "+selection.contains(myEllipse.getShape()));



                /*I take the the cloned shape and do subsequent attribute checks between those of the instantiated shape myEllipse and
                  the shape ellipseClone */
                if( ContextCommand.getShapeCopy() instanceof MyEllipse ){

                    MyEllipse ellipseClone = (MyEllipse) ContextCommand.getShapeCopy();

                    assertEquals(myEllipse.getPressedPoint_x(), ellipseClone.getPressedPoint_x());
                    assertEquals(myEllipse.getPressedPoint_y(), ellipseClone.getPressedPoint_y());
                    assertEquals(myEllipse.getMyEllipse().getRadiusX(), ellipseClone.getMyEllipse().getRadiusX());
                    assertEquals(myEllipse.getMyEllipse().getRadiusY(), ellipseClone.getMyEllipse().getRadiusY());
                    assertEquals(myEllipse.getMyEllipse().getStroke(), ellipseClone.getMyEllipse().getStroke());
                    assertEquals(myEllipse.getMyEllipse().getFill(), ellipseClone.getMyEllipse().getFill());
                    assertEquals(myEllipse.getMyEllipse().getStrokeWidth(), ellipseClone.getMyEllipse().getStrokeWidth());

                    System.out.println("ellipseClone clonato : "+ellipseClone.getShape());


                }

                

    }




    @Test
    public void CopyLineTest(){

                System.out.println("\n--------  TEST CASE 3  --------\n");


                /*I create instance of MyLine from an instance of ShapeFactory
                  by performing a cast to make the types compatible*/
                ShapeFactory line = new ShapeFactory("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
                MyLine myLine = (MyLine) line.getShape();
                SelectionModel selection = new SelectionModel();
                Pane drawingSurface = new Pane(); 
                
                
                System.out.println("MyLine : "+myLine.getShape());

                // Draw Command for drawing the current shape
                DrawCommand draw = new DrawCommand(myLine, drawingSurface);
                draw.execute();

                //Check "selection view" of current shape 
                selection.add(drawingSurface.getChildren().get(0));
                assertEquals(true, selection.contains(myLine.getShape()));
                System.out.println("Control of view select current shape : "+selection.contains(myLine.getShape()));

                // Copy Command for copying the current shape
                CopyCommand copy = new CopyCommand(selection, drawingSurface);
                copy.execute();


                //Check disable "selection view" after Copy Command , deselection --> getView_element() return false because doesn't have any shapes
                assertEquals(false, selection.contains(myLine.getShape()));
                System.out.println("Control of false Selection after Copy Command : "+selection.contains(myLine.getShape()));


                /*I take the the cloned shape and do subsequent attribute checks between those of the instantiated shape myLine and
                  the shape lineClone */
                if( ContextCommand.getShapeCopy() instanceof MyLine ){

                    MyLine lineClone = (MyLine) ContextCommand.getShapeCopy();

                    assertEquals(myLine.getMyLine().getStartX(), lineClone.getMyLine().getStartX());
                    assertEquals(myLine.getMyLine().getStartY(), lineClone.getMyLine().getStartY());
                    assertEquals(myLine.getMyLine().getEndX(), lineClone.getMyLine().getEndX());
                    assertEquals(myLine.getMyLine().getEndY(), lineClone.getMyLine().getEndY());
                    assertEquals(myLine.getMyLine().getStroke(), lineClone.getMyLine().getStroke());
                    assertEquals(myLine.getMyLine().getStrokeWidth(), lineClone.getMyLine().getStrokeWidth());

                    System.out.println("LineClone clonato : "+lineClone.getShape());


                }

               

    }




}
