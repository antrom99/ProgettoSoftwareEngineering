package gruppo1.software_enginering.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import gruppo1.software_enginering.Shape.MyEllipse;
import gruppo1.software_enginering.Shape.MyLine;
import gruppo1.software_enginering.Shape.MyRectangle;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;




public class SaveCommandTest {





    @Test
    public void SaveRectangleTest(){

        File file = new File("/home/antonionocerino/Documenti/GitHub/ProgettoSoftwareEngineering/drawing_application/src/test/java/gruppo1/software_enginering/Command/FileTest/ProvaSave");
        Pane drawingSurface = new Pane();


        /*I create instance of MyRectangle from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory rectangle = new ShapeFactory("Rectangle[x=150.0, y=84.0, width=256.0, height=109.0, fill=null, stroke=0x000000ff, strokeWidth=1.0]");
        MyRectangle myRectangle = (MyRectangle) rectangle.getShape();


        /*I create instance of MyEllipse from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory ellipse = new ShapeFactory("Ellipse[centerX=616.0, centerY=264.5, radiusX=94.0, radiusY=51.5, fill=0x800000ff, stroke=0x000000ff, strokeWidth=1.0]");
        MyEllipse myEllipse = (MyEllipse) ellipse.getShape();



        /*I create instance of MyLine from an instance of ShapeFactory
          by performing a cast to make the types compatible*/
        ShapeFactory line = new ShapeFactory("Line[startX=441.0, startY=117.0, endX=396.0, endY=302.0, stroke=0x000000ff, strokeWidth=1.0]");
        MyLine myLine = (MyLine) line.getShape();

        

        // Draw Commands for each shape to drawing
        DrawCommand drawMyRectangle = new DrawCommand(myRectangle, drawingSurface);
        drawMyRectangle.execute();

        DrawCommand drawMyEllipse = new DrawCommand(myEllipse, drawingSurface);
        drawMyEllipse.execute();

        DrawCommand drawMyLine = new DrawCommand(myLine, drawingSurface);
        drawMyLine.execute();


        // Save Command for saving the draw from the drawingSurface
        SaveCommand save = new SaveCommand(file, drawingSurface);
        save.execute();

        
        //Check the toString() of Shapes on the drawingSurface with the content of file line for line
        try (Scanner scanner = new Scanner(file)) {

            int i=0;

            while(scanner.hasNext()){

                String textFile = scanner.nextLine();

                assertEquals(textFile, drawingSurface.getChildren().get(i).toString());
                System.out.println("Current String from Save File : "+textFile+"\n"+"Check with toString() of SHAPE on drawingSurface : "+drawingSurface.getChildren().get(i).toString());
                i++;
            }


        } catch (FileNotFoundException e) {

            System.out.println("File not found !!");
        }





    }

















}


