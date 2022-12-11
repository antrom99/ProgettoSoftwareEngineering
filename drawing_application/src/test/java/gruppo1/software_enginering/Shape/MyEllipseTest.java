package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class MyEllipseTest {





    

    /**
     * This test checks the function: draw
     * Controls whether the element passed to the "draw" is added 
     * to the Drawing Surface element of type Pane
     */
    @Test
    void testDraw() {

        System.out.println("\n--------  TEST DRAW   --------\n");


        Pane drawingSurface = new Pane();
        MyEllipse myEllipse = new MyEllipse("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
      


        //The create shape
        System.out.println("MyEllipse created : "+myEllipse.getShape());
        

       //Add shape to the drawingSurface
        myEllipse.draw(drawingSurface);

        //Check Nodes Number of Pane
        System.out.println("Number of Nodes on the drawingSurface : "+drawingSurface.getChildren().size());
        boolean isDraw = drawingSurface.getChildren().contains(myEllipse.getShape());
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyEllipse?: "+drawingSurface.getChildren().contains(myEllipse.getShape()));

    }

    @Test
    void testSetRadiusX() {

        System.out.println("\n--------  TEST SetRadiusX   --------\n");


       
        MyEllipse myEllipse = new MyEllipse("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyEllipse created : "+myEllipse.getShape());

        //Set of RadiusX
        double radius = 30;
        System.out.println("New RadiusX: " +radius);
        myEllipse.setRadiusX(radius);


        //Check of Parameters CenterX e RadiusX
        assertEquals(323, myEllipse.getMyEllipse().getCenterX());
        assertEquals(293, myEllipse.getMyEllipse().getRadiusX());
        System.out.println("Ellipse after set radiusX +30 : "+myEllipse.getShape());


       
        //Set of RadiusX negative
        radius = -10;
        System.out.println("New RadiusX: " +radius);
        myEllipse.setRadiusX(radius);


        //Check of Parameters CenterX e RadiusX
        assertEquals(308, myEllipse.getMyEllipse().getCenterX());
        assertEquals(308, myEllipse.getMyEllipse().getRadiusX());
        System.out.println("Ellipse after set radiusX -10 : "+myEllipse.getShape());


       
        //Set Of RadiusX High Level
        radius = 1000;
        System.out.println("New RadiusX: " +radius);
        myEllipse.setRadiusX(radius);

        //Check of Parameters CenterX e RadiusX
        assertEquals(694,5, myEllipse.getMyEllipse().getCenterX());
        assertEquals(78.5, myEllipse.getMyEllipse().getRadiusX());
        System.out.println("Ellipse after set radiusX +1000 : "+myEllipse.getShape());



    }

    @Test
    void testSetRadiusY() {

        System.out.println("\n--------  TEST SetRadiusY   --------\n");


        MyEllipse myEllipse = new MyEllipse("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyEllipse created : "+myEllipse.getShape());


        //Set RadiusY
        double radius = 30;
        System.out.println("New RadiusY: " +radius);
        myEllipse.setRadiusY(radius);


        //Check of Parameters CenterY e RadiusY
        assertEquals(147.25, myEllipse.getMyEllipse().getCenterY());
        assertEquals(117.25, myEllipse.getMyEllipse().getRadiusY());
        System.out.println("MyEllipse after set radiusY +30 : "+myEllipse.getShape());


        //Set RadiusY negative
        radius = -10;
        System.out.println("New RadiusY: " +radius);
        myEllipse.setRadiusY(radius);


        //Check of Parameters CenterY e RadiusY
        assertEquals(132.25, myEllipse.getMyEllipse().getCenterY());
        assertEquals(132.25, myEllipse.getMyEllipse().getRadiusY());
        System.out.println("MyEllipse after set radiusY -10 : "+myEllipse.getShape());

      
        //Set RadiusY high level
        radius = 1000;
        System.out.println("New RadiusY: " +radius);
        myEllipse.setRadiusY(radius);


        //Check of Parameters CenterY e RadiusY
        assertEquals(487.25, myEllipse.getMyEllipse().getCenterY());
        assertEquals(222.75, myEllipse.getMyEllipse().getRadiusY());
        System.out.println("MyEllipse after set radiusY +1000 : "+myEllipse.getShape());


    }


    @Test
    void testUpdateAttribute() {

        System.out.println("\n--------  TEST UpdateAttribute   --------\n");

        MyEllipse myEllipse = new MyEllipse("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyEllipse created : "+myEllipse.getShape());


        //Update of Drag Point X e Y
        double x = 5.0, y = 7.0;
        System.out.println("Drag Point x : "+x + "  Drag Point y :" +y);
        myEllipse.updateAttribute(x, y);


        //Check of Parameters CenterX ,CenterY, RadiusX , RadiusY
        assertEquals(310.5, myEllipse.getMyEllipse().getCenterX());
        assertEquals(135.75, myEllipse.getMyEllipse().getCenterY());
        assertEquals(305.5, myEllipse.getMyEllipse().getRadiusX());
        assertEquals(128.75, myEllipse.getMyEllipse().getRadiusY());

       
        System.out.println("MyEllipse modified : "+myEllipse.getShape());


    }

    @Test
    void testView() {

        System.out.println("\n--------  TEST View   --------\n");

       //Create a myEllipse
       MyEllipse myEllipse = new MyEllipse("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");

       

       //Create a rectangle view for shape
       Rectangle rectangle = myEllipse.view();
       System.out.println("MyEllipse created : "+myEllipse.getShape());

       //Check for the view
       assertEquals(myEllipse.getMyEllipse().getCenterX()-myEllipse.getMyEllipse().getRadiusX()-3,rectangle.getX());
       assertEquals(myEllipse.getMyEllipse().getCenterY()-myEllipse.getMyEllipse().getRadiusY()-3,rectangle.getY());
       assertEquals(myEllipse.getMyEllipse().getRadiusX()*2+6,rectangle.getWidth());
       assertEquals(myEllipse.getMyEllipse().getRadiusY()*2+6,rectangle.getHeight());
       System.out.println("Correct view Rectangle for the Shape : "+rectangle);
    }

    @Test
    void testCloneShape(){

        System.out.println("\n--------  TEST CloneShape   --------\n");

        //Create a myEllipse
        MyEllipse myEllipse = new MyEllipse("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        System.out.println("MyEllipse created : "+myEllipse.getShape());


        //Create a clone of shape myEllipse
        MyEllipse clone =  (MyEllipse) myEllipse.cloneShape();


        if(clone instanceof MyEllipse){ 

            assertEquals(myEllipse.getMyEllipse().getCenterX(),clone.getMyEllipse().getCenterX());
            assertEquals(myEllipse.getMyEllipse().getCenterY(),clone.getMyEllipse().getCenterY());
            assertEquals(myEllipse.getMyEllipse().getRadiusX(),clone.getMyEllipse().getRadiusX());
            assertEquals(myEllipse.getMyEllipse().getRadiusY(),clone.getMyEllipse().getRadiusY());
            assertEquals(myEllipse.getMyEllipse().getStroke(),clone.getMyEllipse().getStroke());
            assertEquals(myEllipse.getMyEllipse().getFill(),clone.getMyEllipse().getFill());
            assertEquals(myEllipse.getMyEllipse().getStrokeWidth(),clone.getMyEllipse().getStrokeWidth());

            System.out.println("Clone is  Correct : "+clone.getShape());

        }else{

            System.out.println("Clone is not Correct !");

        }


       

    }


    @Test
    public void TestlineIsEllipse(){

        System.out.println("\n--------  TEST wrongs lines  --------\n");


        String correct1 = "Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]";
        String correct2 = "Ellipse[centerX=284.5, centerY=162.5, radiusX=146.5, radiusY=133.5, fill=0xffffffff, stroke=0x000000ff, strokeWidth=3.0]";
        String wrong1 = "Ellipse[centerX=616.0, =264.5, radiusX=T94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0";
        String wrong2 = "my name is MARIO ROSSI";
        String wrong3 ="Ellise[centerX=616.0, =264.5, radiusX=T94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0";
        MyEllipse myEllipse =new MyEllipse(new Ellipse());



        //TEST CHE CORRECT FORMAT OF LINES
       assertEquals(true,myEllipse.lineIsEllipse(correct1));
       System.out.println("String 1 is in the Correct Format ?  "+myEllipse.lineIsEllipse(correct1));
       assertEquals(true,myEllipse.lineIsEllipse(correct2));
       System.out.println("String 2 is in the Correct Format ?  "+myEllipse.lineIsEllipse(correct2));


       //TEST THE WRONG FORMAT OF LINES
       assertEquals(false, myEllipse.lineIsEllipse(wrong1));
       System.out.println("String 3 is in the Correct Format ?  "+myEllipse.lineIsEllipse(wrong1));
       assertEquals(false, myEllipse.lineIsEllipse(wrong2));
       System.out.println("String 4 is in the Correct Format ?  "+myEllipse.lineIsEllipse(wrong2));
       assertEquals(false,myEllipse.lineIsEllipse(wrong3));
       System.out.println("String 5 is in the Correct Format ?  "+myEllipse.lineIsEllipse(wrong3));
      





        









    }
}
