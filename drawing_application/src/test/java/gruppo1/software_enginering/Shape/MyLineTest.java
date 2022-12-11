package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class MyLineTest {

    /**
     * This test checks the function: draw
     * Controls whether the element passed to the "draw" is added 
     * to the Drawing Surface element of type Pane
     */

    @Test
    void testDraw(){

        System.out.println("\n--------  TEST DRAW   --------\n");

        Pane drawingSurface = new Pane();


        //Create myLine
        MyLine myLine = new MyLine("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyLine created : "+myLine.getShape());


        System.out.println("--call function Draw: --");
        myLine.draw(drawingSurface);
        System.out.println("Number of Nodes on the drawingSurface : "+drawingSurface.getChildren().size());

        boolean isDraw = drawingSurface.getChildren().contains(myLine.getShape());
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains myLine?: "+drawingSurface.getChildren().contains(myLine.getShape()));

    }

    
    @Test
    void testSetEndY() {

        System.out.println("\n--------  TEST SetEndY   --------\n");

        //Create myLine
        MyLine myLine = new MyLine("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyLine created : "+myLine.getShape());


        //Set EndY
        double y = 30;
        System.out.println("New EndY : " +y);        
        myLine.setEndY(y);
        

        //Check Parameters EndX e EndY
        assertEquals(396, myLine.getMyLine().getEndX());
        assertEquals(30, myLine.getMyLine().getEndY());
        System.out.println("Line after set EndY +30 : "+myLine.getShape());

     
        //Set EndY negative
        y = -10;
        System.out.println("New EndY : " +y);
        myLine.setEndY(y);


        //Check Parameters Endx e EndY
        assertEquals(396, myLine.getMyLine().getEndX());
        assertEquals(0, myLine.getMyLine().getEndY());
        System.out.println("Line after set EndY -10 : "+myLine.getShape());


        //Set EndY high level
        y = 1000;
        System.out.println("New EndY : " +y);
        myLine.setEndY(y);

       
        //Check Parameters Endx e EndY
        assertEquals(396, myLine.getMyLine().getEndX());
        assertEquals(710, myLine.getMyLine().getEndY());
        System.out.println("Line after set EndY +1000 : "+myLine.getShape());



    }

    @Test
    void testSetEndX() {

        System.out.println("\n--------  TEST SetEndX   --------\n");


        //Create myLine
        MyLine myLine = new MyLine("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyLine created : "+myLine.getShape());

        //Set EndX
        double x = 30;
        System.out.println("New EndX : " +x);      
        myLine.setEndX(x);


        //Check of the correct Parameters EndX e EndY
        assertEquals(30, myLine.getMyLine().getEndX());
        assertEquals(302, myLine.getMyLine().getEndY());
        System.out.println("Line after set EndX +30 :"+myLine.getShape());


        //Set EndX negative
        x = -10;
        System.out.println("New EndX : " +x);
        myLine.setEndX(x);


        //Check of the correct Parameters EndX e EndY
        assertEquals(0, myLine.getMyLine().getEndX());
        assertEquals(302, myLine.getMyLine().getEndY());
        System.out.println("Line after set EndX -10 :"+myLine.getShape());


        //Set Endx high level
        x = 1000;
        System.out.println("New EndX : " +x);
        myLine.setEndX(x);


         //Check of the correct Parameters EndX e EndY
         assertEquals(773, myLine.getMyLine().getEndX());
         assertEquals(302, myLine.getMyLine().getEndY());
        System.out.println("Line after set EndX +1000 :"+myLine.getShape());

      

    }


    @Test
    void testUpdateAttribute() {

        System.out.println("\n--------  TEST UpdateAttribute   --------\n");


        //Create myLine
        MyLine myLine = new MyLine("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyLine created : "+myLine.getShape());

        double x = 5.0, y = 7.0;
        System.out.println("Drag Point x : "+x + "  Drag Point y :" +y);
        myLine.updateAttribute(x, y);


        //Check of Parameters endX e endY
        assertEquals(5, myLine.getMyLine().getEndX());
        assertEquals(7, myLine.getMyLine().getEndY());




        

        System.out.println("MyLine modified : "+myLine.getShape());
    
        
    }

    @Test
    void testView() {

        System.out.println("\n--------  TEST View   --------\n");
        
        //Create myLine
        MyLine myLine = new MyLine("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");


         //Create a rectangle view for shape
        Rectangle rectangle = myLine.view();
        System.out.println("MyLine created : "+myLine.getShape());

        
       
        //Check for the View
        assertEquals(Math.min(myLine.getMyLine().getStartX(), myLine.getMyLine().getEndX())-3, rectangle.getX());
        assertEquals(Math.min(myLine.getMyLine().getStartY(), myLine.getMyLine().getEndY())-3, rectangle.getY());
        assertEquals(Math.abs(myLine.getMyLine().getStartX()-myLine.getMyLine().getEndX())+6, rectangle.getWidth());
        assertEquals(Math.abs(myLine.getMyLine().getStartY()-myLine.getMyLine().getEndY())+6, rectangle.getHeight());
        System.out.println("Correct view Rectangle for the Shape : "+rectangle);

    }

    @Test
    void testCloneShape(){


        System.out.println("\n--------  TEST CloneShape   --------\n");

        //Create MyLine
        MyLine myLine = new MyLine("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("myLine created : "+myLine.getShape());


        //Create a clone of shape myLine
        MyLine clone = myLine.cloneShape();

        if(clone instanceof MyLine){    
            
              assertEquals(myLine.getMyLine().getStartX(),clone.getMyLine().getStartX());
              assertEquals(myLine.getMyLine().getStartY(),clone.getMyLine().getStartY());
              assertEquals(myLine.getMyLine().getEndX(),clone.getMyLine().getEndX());
              assertEquals(myLine.getMyLine().getEndY(),clone.getMyLine().getEndY());
              assertEquals(myLine.getMyLine().getStroke(),clone.getMyLine().getStroke());
              assertEquals(myLine.getMyLine().getStrokeWidth(),clone.getMyLine().getStrokeWidth());
          

            System.out.println("Clone is  Correct : "+clone.getShape());



        }else{
            System.out.println("Clone is not Correct !");
        }

      
      

    }




    @Test
    public void TestlineIsRectangle(){

        System.out.println("\n--------  TEST wrongs lines  --------\n");


        String correct1 = "Line[startX=279.0, startY=120.0, endX=274.0, endY=229.0, stroke=0x000000ff, strokeWidth=3.0]";
        String correct2 = "Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]";
        String wrong1 = "[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]";
        String wrong2 = "my name is MARIO ROSSI";
        String wrong3 ="Line[x=49.0, y=258.0, width=165.0, height=56.0,  stroke=0x000000ff, strokeWidth=1.0]";
        MyLine myLine =new MyLine(new Line());



        //TEST CHE CORRECT FORMAT OF LINES
       assertEquals(true,myLine.lineIsLine(correct1));
       System.out.println("String 1 is in the Correct Format ?  "+myLine.lineIsLine(correct1));
       assertEquals(true,myLine.lineIsLine(correct2));
       System.out.println("String 2 is in the Correct Format ?  "+myLine.lineIsLine(correct2));


       //TEST THE WRONG FORMAT OF LINES
       assertEquals(false, myLine.lineIsLine(wrong1));
       System.out.println("String 3 is in the Correct Format ?  "+myLine.lineIsLine(wrong1));
       assertEquals(false, myLine.lineIsLine(wrong2));
       System.out.println("String 4 is in the Correct Format ?  "+myLine.lineIsLine(wrong2));
       assertEquals(false,myLine.lineIsLine(wrong3));
       System.out.println("String 5 is in the Correct Format ?  "+myLine.lineIsLine(wrong3));
      





        









    }
}
