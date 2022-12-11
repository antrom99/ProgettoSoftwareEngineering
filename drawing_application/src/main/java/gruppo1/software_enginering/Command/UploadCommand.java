package gruppo1.software_enginering.Command;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import gruppo1.software_enginering.MyAlertModel;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;






public class UploadCommand implements Command {

    private  Pane drawingSurface;
    private File file;
    

    public UploadCommand( Pane drawingSurface,File file) {
        this.drawingSurface = drawingSurface;
        this.file = file;
        
    }



    @Override
    public void execute() {


        ArrayList<String> listString = new ArrayList<>();
        int i= 0;


        if (file != null) {

            drawingSurface.getChildren().clear();
            try {

                Scanner scanner = new Scanner(file);
                String line;


                while(scanner.hasNextLine()){
                    line = scanner.nextLine();
                    i=i+1;
                    if(checkLine(line)){
                        listString.add(line);   
                    }else{

                        MyAlertModel myAlertModel = new MyAlertModel("File Upload Error", "Error","Formatting error in the FILE.", AlertType.WARNING);

                        break ;
                    }
                        
                }


                

               if(listString.size() == i){
                    for(String line1 : listString){
                       ShapeFactory ShapeFactory = new ShapeFactory(line1);
                       MyShape shape = ShapeFactory.getShape();
                       Command command = new DrawCommand(shape, drawingSurface);
                       command.execute();
                   }
                   
                   MyAlertModel myAlertModel = new MyAlertModel("file loaded correctly", "Information", "the selected file was uploaded correctly", AlertType.INFORMATION);

                }

               
                


               scanner.close();              
            

            } catch (IOException ex) {
                 System.out.println("Error file is null");
            }
        } else{

          MyAlertModel myAlertModel = new MyAlertModel("Error File during Upload", "Error", "File is NULL.", AlertType.WARNING);

        }  
        
    }

    @Override
    public void undo() {
        
        
    }

    public boolean checkLine(String lineCurrent){


        String [] split=lineCurrent.split(",");
        String check;
        
       

        //LINE

        if(split.length == 6){//siamo in LINE



          if(split[0].startsWith("Line[startX=")){
            check = split[0].replace("Line[startX=", "");

            try {
              Double.parseDouble(check);
            } catch (NumberFormatException e) {
              System.out.println("ECCEZIONE DOUBLE GESITA");
              return false;
            }

          }else{
            return false;
          }

          if(split[1].startsWith(" startY=")){
            check = split[1].replace(" startY=", "");

            try {

              Double.parseDouble(check);
              
            } catch (NumberFormatException e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[1]");
              return false;
            }

          }else{
            return false;
          }

          if(split[2].startsWith(" endX=")){
            check = split[2].replace(" endX=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[2]");
              return false;
            }

          }else{
            return false;
          }

          if(split[3].startsWith(" endY=")){
            check = split[3].replace(" endY=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[3]");
              return false;
            }

          }else{
            return false;

          }

          if(split[4].startsWith(" stroke=")){
            check = split[4].replace(" stroke=", "");

            try {
              Paint.valueOf(check);  
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[4]");
              return false;
            }

          }else{
            return false;
          }

          if(split[5].startsWith(" strokeWidth=") && split[5].endsWith("]")){
            split[5] = split[5].replace(" strokeWidth=", "");
            check = split[5].replace("]", "");


            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("return false --> split[5]");
              return false;
            }

          }else{
            return false;
          }


          //tutti i check sono andati a buon fine

          return true;




        }


        //RECTANGLE

        if(split.length == 7 && split[0].startsWith("Rectangle")){

          if(split[0].startsWith("Rectangle[x=")){
            check = split[0].replace("Rectangle[x=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[0] RECTANGLE");
              return false;
            }

          }else{
            return false;
          }

          if(split[1].startsWith(" y=")){
            check = split[1].replace(" y=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[1] RECTANGLE");
              return false;
            }

          }else{
            return false;
          }


          if(split[2].startsWith(" width=")){
            check = split[2].replace(" width=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[2] RECTANGLE");
              return false;
            }

          }else{
            return false;
          }


          if(split[3].startsWith(" height=")){
            check = split[3].replace(" height=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[3] RECTANGLE");
              return false;
            }

          }else{
            return false;
          }



          if(split[4].startsWith(" fill=")){
            check = split[4].replace(" fill=", "");

            try {
              if(!check.contains("null"))  
                 Paint.valueOf(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[4] RECTANGLE");
              return false;
            }

          }else{
            return false;
          }


          if(split[5].startsWith(" stroke=")){
            check = split[5].replace(" stroke=", "");

            try {
              Paint.valueOf(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[5] RECTANGLE");
              return false;
            }

          }else{
            return false;
          }



          if(split[6].startsWith(" strokeWidth=") && split[6].endsWith("]")){
            split[6] = split[6].replace(" strokeWidth=", "");
            check = split[6].replace("]", "");
            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[6] RECTANGLE");
              return false;
            }

          }else{
            return false;
          }


          //check superati

          return true;

        }





        //ELLIPSE

        if(split.length == 7 && split[0].startsWith("Ellipse")){

          if(split[0].startsWith("Ellipse[centerX=")){
            check = split[0].replace("Ellipse[centerX=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[0] ELLIPSE");
              return false;
            }

          }else{
            return false;
          }

          if(split[1].startsWith(" centerY=")){
            check = split[1].replace(" centerY=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[1] ELLIPSE");
              return false;
            }

          }else{
            return false;
          }


          if(split[2].startsWith(" radiusX=")){
            check = split[2].replace(" radiusX=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[2] ELLIPSE");
              return false;
            }

          }else{
            return false;
          }


          if(split[3].startsWith(" radiusY=")){
            check = split[3].replace(" radiusY=", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[3] ELLIPSE");
              return false;
            }

          }else{
            return false;
          }



          if(split[4].startsWith(" fill=")){
            check = split[4].replace(" fill=", "");

            try {
              if(!(split[4].contains("null")))
                 Paint.valueOf(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[4] ELLIPSE");
              return false;
            }

          }else{
            return false;
          }


          if(split[5].startsWith(" stroke=")){
            check = split[5].replace(" stroke=", "");

            try {
              Paint.valueOf(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[5] ELLIPSE");
              return false;
            }

          }else{
            return false;
          }



          if(split[6].startsWith(" strokeWidth=") && split[6].endsWith("]")){
            split[6] = split[6].replace(" strokeWidth=", "");
            check = split[6].replace("]", "");

            try {
              Double.parseDouble(check);
            } catch (Exception e) {
              System.out.println("ECCEZIONE DOUBLE GESITA split[6] ELLIPSe");
              return false;
            }

          }else{
            return false;
          }


          //check superati

          return true;


          

        }

         








        //ALTRI CASI
        return false;
    }



   

}
