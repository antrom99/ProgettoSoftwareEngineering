package gruppo1.software_enginering.Command;


import java.io.File;

import java.io.IOException;

import java.util.Scanner;

import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;






public class UploadCommand implements Command {

    private  Pane drawingSurface;
    private File file;
    

    public UploadCommand( Pane drawingSurface,File file) {
        this.drawingSurface = drawingSurface;
        this.file = file;
        
    }


    /*private static final java.nio.file.Path SAVE_FILE_LOCATION = Paths.get(System.getProperty("user.home"),
    "shapes.xml");*/



    @Override
    public void execute() {
        
        
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
