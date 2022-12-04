package gruppo1.software_enginering.Command;

//import java.beans.XMLDecoder;
import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.nio.file.Paths;
import java.util.Scanner;

//import gruppo1.software_enginering.Shape.MyRectangle;
//import gruppo1.software_enginering.Shape.MyLine;
//import gruppo1.software_enginering.Shape.MyRectangle;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
//import javafx.scene.paint.Color;


import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
//import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class UploadCommand implements Command {

    private /*GraphicsContext drawingSurface*/ Pane drawingSurface;
    private BorderPane borderPane;

    public UploadCommand(/*GraphicsContext drawingSurface*/ Pane drawingSurface, BorderPane borderPane) {
        this.drawingSurface = drawingSurface;
        this.borderPane = borderPane;
    }


    /*private static final java.nio.file.Path SAVE_FILE_LOCATION = Paths.get(System.getProperty("user.home"),
    "shapes.xml");*/



    @Override
    public void execute() {
        
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");
        File file = openFile.showOpenDialog(borderPane.getScene().getWindow());
        if (file != null) {

            drawingSurface.getChildren().clear();;
            try {

                Scanner scanner = new Scanner(file);

                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    correctShape cs = new correctShape(line,drawingSurface);
                    cs.getShape(line);
                    
                   //Point2D p= new Point2D(Double.parseDouble(part[0]),0);
                    //System.out.println("inizio: "+p.getX()+" fine: "+p.getY());/*startY 
                    //System.out.println(part[0]);
                }

               scanner.close();              
                
                
                /*FileInputStream fos = new FileInputStream(file);
                XMLDecoder decoder = new XMLDecoder(fos);


                array.add((Node) decoder.readObject());
                System.out.println(array.size());

                for(Node n : array){

                    System.out.println(n);

                
                }*/



                
            
             



                
                
               

                
                

                
               
              

            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }   
        
    }

    @Override
    public void undo() {
        
        
    }


    public class correctShape{

        String nShape;
        Pane drawingSurface;

        public correctShape(String nShape, Pane drawingSurface){
            this.nShape=nShape;
            this.drawingSurface=drawingSurface;
        }



        public /*MyShape*/void getShape(String nShape){

        String st=nShape.replace("[","");
        st=st.replace("]", "");
        st=st.replace("=", "");
        st=st.replace(" ", "");
        st=st.replace("strokeWidth", "");        
        st=st.replace("stroke", "");



        String[] split;



             


               if(nShape.contains("Line")){
                st=st.replace("Line", " ");
                st=st.replace("startX", " ");
                st=st.replace("endY", " ");
                st=st.replace("endX", " ");
                st=st.replace("startY", " ");

                split=st.split(",");   

                Line l = new Line(Double.parseDouble(split[0]), 
                Double.parseDouble(split[1]),Double.parseDouble(split[2]), Double.parseDouble(split[3]));
                l.setStroke(Paint.valueOf(split[4]));
                l.setStrokeWidth(Double.parseDouble(split[5]));
               
                drawingSurface.getChildren().add(l);
               
               } 



               if(nShape.contains("Rectangle")){
                st=st.replace("Rectangle", " ");
                st=st.replaceFirst("x", "");
                st=st.replace("y", "");
                st=st.replace("width", "");
                st=st.replace("height", "");
                st=st.replace("fill", "");


                split=st.split(",");

                Rectangle r = new Rectangle(Double.parseDouble(split[0]), 
                Double.parseDouble(split[1]),Double.parseDouble(split[2]), Double.parseDouble(split[3]));

                if(split[4].contains("null")){

                    r.setFill(null);

                }else{

                    r.setFill(Paint.valueOf(split[4]));
                }


                r.setStroke(Paint.valueOf(split[5]));
                r.setStrokeWidth(Double.parseDouble(split[6]));
                drawingSurface.getChildren().add(r);

                }




                if(nShape.contains("Ellipse")){
                    st=st.replace("Ellipse", "");
                    st=st.replace("centerX", "");
                    st=st.replace("centerY", "");
                    st=st.replace("radiusX", "");
                    st=st.replace("radiusY", "");
                    st=st.replace("fill", "");
                    st=st.replace("width", "");


                    split=st.split(",");

                    Ellipse e = new Ellipse(Double.parseDouble(split[0]), 
                    Double.parseDouble(split[1]),Double.parseDouble(split[2]), Double.parseDouble(split[3]));


                    if(split[4].contains("null")){

                        e.setFill(null);

                    } else{

                        e.setFill(Paint.valueOf(split[4]));
                    }

                        

                    e.setStroke(Paint.valueOf(split[5]));
                    e.setStrokeWidth(Double.parseDouble(split[6]));
                    drawingSurface.getChildren().add(e);


                }






       }






    }
    



   

}
