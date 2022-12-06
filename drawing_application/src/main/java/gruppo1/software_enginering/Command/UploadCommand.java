package gruppo1.software_enginering.Command;


import java.io.File;

import java.io.IOException;

import java.util.Scanner;

import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;




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
                    ShapeFactory shapeFactory = new ShapeFactory(line);
                    MyShape shape = shapeFactory.getShape();
                    Command command = new DrawCommand(shape, drawingSurface);
                    command.execute();
                    
                   
                }

               scanner.close();              
                
                
                



                
            
             



                
                
               

                
                

                
               
              

            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }   
        
    }

    @Override
    public void undo() {
        
        
    }


   

}
