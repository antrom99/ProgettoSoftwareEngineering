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
import javafx.scene.shape.Shape;






public class UploadCommand implements Command {

    private  Pane drawingSurface;
    private File file;
    

    public UploadCommand( Pane drawingSurface,File file) {
        this.drawingSurface = drawingSurface;
        this.file = file;
        
    }



    @Override
    public void execute() {

      ArrayList<MyShape> listShape = new ArrayList<>();
      boolean exception = false; 

      if(file.getName().endsWith(".txt")==false){

  
          MyAlertModel myAlertModel = new MyAlertModel("File extension not conforming", "Error", "Please upload file '*.txt'", AlertType.WARNING);



      }else  if (file != null) {

            drawingSurface.getChildren().clear();
            try {

                Scanner scanner = new Scanner(file);
                String line;


                while(scanner.hasNextLine()){
                    line = scanner.nextLine();
                    
                    try{
                      ShapeFactory shapeFactory = new ShapeFactory(line);
                      
                      listShape.add(shapeFactory.getShape());
                      

                    }catch(Exception e ){

                      exception = true;
                      MyAlertModel myAlertModel = new MyAlertModel("File Upload Error", "Error", "Formatting error in FILE", AlertType.WARNING);
                      break;
                    }
                  }

                  if(!exception){
                    for( MyShape shape : listShape){
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
}

  
