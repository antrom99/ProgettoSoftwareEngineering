package gruppo1.software_enginering.Command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gruppo1.software_enginering.MyAlertModel;
import javafx.scene.Node;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
/**
 * <p>
 * This class define the command for saving the drawing on txt file
 * <p><!-- -->
 */
public class SaveCommand implements Command{

    private File file;
    private Pane Canvas;

    /**
     * <p>
     * This is the constructor of save command, so it initializes the drawing surface and the file 
     * <p><!-- -->
     * @param file
     * @param canvas
     */

    public SaveCommand(File file, Pane canvas) {
        this.file = file;
        this.Canvas = canvas;
    }

    /**
     * <p>
     * This method perform the operation for saving the drawing on a file txt where every shape is rappresented as a string and save the file with .txt extension
     * <p><!-- -->
     */

    @Override
    public void execute() {

        if(file != null){



            try{  

                PrintWriter out = new PrintWriter(new FileWriter(file)); 
                FileOutputStream fos = new FileOutputStream(file);
                for(Node s : Canvas.getChildren()){
                    out.print(s);
                    System.out.println();
                    out.print("\n");
                }
                //file.setReadOnly();
                fos.close();
                out.close();

            }catch(IOException ex){
                MyAlertModel alert = new MyAlertModel("Error File during Save", "Error", "File saving failed, you cannot Replace an existing file. Please try new 'name' for the file", AlertType.WARNING);
            }

        }
        
        
    }

    
}
