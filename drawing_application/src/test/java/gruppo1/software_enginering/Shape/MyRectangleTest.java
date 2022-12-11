package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MyRectangleTest {

    /**
     * This test checks the function: draw
     * Controls whether the element passed to the "draw" is added 
     * to the Drawing Surface element of type Pane
     */
    @Test
    void testDraw(){

        System.out.println("\n--------  TEST DRAW   --------\n");

        Pane drawingSurface = new Pane();
        ShapeFactory shapeFactory = new ShapeFactory( "Rectangle[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) shapeFactory.getShape();

        System.out.println("MyRectangle created : "+myRectangle.getShape());

        System.out.println("--call function Draw: --");
        myRectangle.draw(drawingSurface);
        System.out.println("Number of Nodes on the drawingSurface : "+drawingSurface.getChildren().size());

        boolean isDraw = drawingSurface.getChildren().contains(myRectangle.getShape());
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyRectangle? "+drawingSurface.getChildren().contains(myRectangle.getShape()));

    }

    @Test
    void testSetHeight() {

        System.out.println("\n--------  TEST SetHeight   --------\n");
        

        ShapeFactory shapeFactory = new ShapeFactory( "Rectangle[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) shapeFactory.getShape();
        
        System.out.println("MyRectangle created : "+myRectangle.getShape());

        //SET the Height of shape
        double height = 30;
        System.out.println("New Height: " +height);
        myRectangle.setHeight(height);


        //Check of the correct Parameters Y e Height
        assertEquals(30, myRectangle.getMyRectangle().getY());
        assertEquals(228, myRectangle.getMyRectangle().getHeight());
        System.out.println("Rectangle after set Height +30 : "+myRectangle.getMyRectangle());

        

        //Check with negative  Height
        height = -10;
        System.out.println("New Height: " +height);
        myRectangle.setHeight(height);


        //Check of the correct Parameters Y e Height
        assertEquals(0, myRectangle.getMyRectangle().getY());
        assertEquals(258, myRectangle.getMyRectangle().getHeight());
        System.out.println("Rectangle after set Height -10 : "+myRectangle.getMyRectangle());

        
        //Check with height greater than Pane
        height = 1000;
        System.out.println("New Height: " +height);
        myRectangle.setHeight(height);


        //Check of the correct Parameters Y e Height
        assertEquals(0, myRectangle.getMyRectangle().getY());
        assertEquals(452, myRectangle.getMyRectangle().getHeight());
        System.out.println("Rectangle after set Height +1000 : "+myRectangle.getShape());
        

    }


    @Test
    void testSetWidth() {

        System.out.println("\n--------  TEST SetWidth   --------\n");

        ShapeFactory shapeFactory = new ShapeFactory( "Rectangle[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) shapeFactory.getShape();
        System.out.println("MyRectangle created : "+myRectangle.getShape());

        //Set the WIDTH of shape
        double width = 30;
        System.out.println("New Height: " +width);
        myRectangle.setWidth(width);


        //Check of the correct Parameters X e Width
        assertEquals(30, myRectangle.getMyRectangle().getX());
        assertEquals(19, myRectangle.getMyRectangle().getWidth());
        System.out.println("Rectangle after set Height +30 :"+myRectangle.getShape());

      
        //Check with negative Width
        width = -10;
        System.out.println("New Height: " +width);
        myRectangle.setWidth(width);


        //Check of the correct Parameters X e Width
        assertEquals(0, myRectangle.getMyRectangle().getX());
        assertEquals(49, myRectangle.getMyRectangle().getWidth());
        System.out.println("Rectangle after set Height -10 :"+myRectangle.getShape());


        //Check with height greater than Pane
        width = 1000;
        System.out.println("New Height: " +width);
        myRectangle.setWidth(width);




        //Check the correct Parameters X e Width
        assertEquals(0, myRectangle.getMyRectangle().getX());
        assertEquals(724, myRectangle.getMyRectangle().getWidth());
        System.out.println("Rectangle after set Height +1000 :"+myRectangle.getShape());

        


    }

    @Test
    void testUpdateAttribute() {

        System.out.println("\n--------  TEST UpdateAttribute   --------\n");


        ShapeFactory shapeFactory = new ShapeFactory( "Rectangle[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) shapeFactory.getShape();


        System.out.println("MyRectangle created : "+myRectangle.getShape());

        //Update of Drag Point X e Y
        double x = 5.0, y = 7.0;
        System.out.println("Drag Point x : "+x + "  Drag Point y :" +y);
        myRectangle.updateAttribute(x, y);


        //Check of Parameters X , Y, Width , Height
        assertEquals(5, myRectangle.getMyRectangle().getX());
        assertEquals(7, myRectangle.getMyRectangle().getY());
        assertEquals(44, myRectangle.getMyRectangle().getWidth());
        assertEquals(251, myRectangle.getMyRectangle().getHeight());
        
        System.out.println("MyRectangle modified : "+myRectangle.getShape());

    }

    @Test
    void testView() {

        System.out.println("\n--------  TEST View   --------\n");

       //Create a myRectangle
        ShapeFactory shapeFactory = new ShapeFactory( "Rectangle[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) shapeFactory.getShape();
        

        //Create a rectangle view for shape
        Rectangle rectangle = myRectangle.view();
        System.out.println("MyRectangle created : "+myRectangle.getMyRectangle());

        //Check for the view
        assertEquals(myRectangle.getMyRectangle().getX()-3,rectangle.getX());
        assertEquals(myRectangle.getMyRectangle().getY()-3,rectangle.getY());
        assertEquals(myRectangle.getMyRectangle().getWidth()+6,rectangle.getWidth());
        assertEquals(myRectangle.getMyRectangle().getHeight()+6,rectangle.getHeight());
        System.out.println("Correct view Rectangle for the Shape : "+rectangle);

    }

    @Test
    void testCloneShape(){

        System.out.println("\n--------  TEST CloneShape   --------\n");

        ShapeFactory shapeFactory = new ShapeFactory( "Rectangle[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) shapeFactory.getShape();
        System.out.println("MyRectangle created : "+myRectangle.getShape());
        

        //Create a clone of shape myRectangle
        MyRectangle clone = myRectangle.cloneShape();

        if(clone instanceof MyRectangle){    
            
            
            assertEquals(myRectangle.getMyRectangle().getX(),clone.getMyRectangle().getX());
            assertEquals(myRectangle.getMyRectangle().getY(),clone.getMyRectangle().getY());
            assertEquals(myRectangle.getMyRectangle().getWidth(),clone.getMyRectangle().getWidth());
            assertEquals(myRectangle.getMyRectangle().getHeight(),clone.getMyRectangle().getHeight());
            assertEquals(myRectangle.getMyRectangle().getStroke(),clone.getMyRectangle().getStroke());
            assertEquals(myRectangle.getMyRectangle().getFill(),clone.getMyRectangle().getFill());
            assertEquals(myRectangle.getMyRectangle().getStrokeWidth(),clone.getMyRectangle().getStrokeWidth());

            System.out.println("Clone is  Correct : "+clone.getShape());



        }else{
            System.out.println("Clone is not Correct !");
        }

    

    }




    @Test
    public void TestlineIsRectangle(){

        System.out.println("\n--------  TEST wrongs lines  --------\n");


        String correct1 = "Rectangle[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]";
        String correct2 = "Rectangle[x=227.0, y=140.0, width=117.0, height=54.0, fill=null, stroke=0x000000ff, strokeWidth=3.0]";
        String wrong1 = "Rect[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]";
        String wrong2 = "my name is MARIO ROSSI";
        String wrong3 ="ANTONIO[x=49.0, y=258.0, width=165.0, height=56.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]";
        MyRectangle myRectangle =new MyRectangle(new Rectangle());



        //TEST CHE CORRECT FORMAT OF LINES
       assertEquals(true,myRectangle.lineIsRectangle(correct1));
       System.out.println("String 1 is in the Correct Format ?  "+myRectangle.lineIsRectangle(correct1));
       assertEquals(true,myRectangle.lineIsRectangle(correct2));
       System.out.println("String 2 is in the Correct Format ?  "+myRectangle.lineIsRectangle(correct2));


       //TEST THE WRONG FORMAT OF LINES
       assertEquals(false, myRectangle.lineIsRectangle(wrong1));
       System.out.println("String 3 is in the Correct Format ?  "+myRectangle.lineIsRectangle(wrong1));
       assertEquals(false, myRectangle.lineIsRectangle(wrong2));
       System.out.println("String 4 is in the Correct Format ?  "+myRectangle.lineIsRectangle(wrong2));
       assertEquals(false,myRectangle.lineIsRectangle(wrong3));
       System.out.println("String 5 is in the Correct Format ?  "+myRectangle.lineIsRectangle(wrong3));
      





        









    }








}
