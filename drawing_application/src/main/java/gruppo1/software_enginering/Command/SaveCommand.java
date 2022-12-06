package gruppo1.software_enginering.Command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class SaveCommand implements Command{

    private File file;
    private Pane Canvas;

    public SaveCommand(File file, Pane canvas) {
        this.file = file;
        this.Canvas = canvas;
    }

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
                fos.close();
                out.close();

            }catch(IOException ex){
                System.out.println("Error");
            }

        }
        
        
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        
    }
    
}
