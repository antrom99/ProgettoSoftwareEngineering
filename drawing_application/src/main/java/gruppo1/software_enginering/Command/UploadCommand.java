package gruppo1.software_enginering.Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

public class UploadCommand implements Command {

    private GraphicsContext drawingSurface;
    private BorderPane borderPane;

    public UploadCommand(GraphicsContext drawingSurface, BorderPane borderPane) {
        this.drawingSurface = drawingSurface;
        this.borderPane = borderPane;
    }

    @Override
    public void execute() {
        
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");
        File file = openFile.showOpenDialog(borderPane.getScene().getWindow());
        if (file != null) {
            try {
                InputStream io = new FileInputStream(file);
                Image img = new Image(io);
               
                drawingSurface.drawImage(img, 0, 0);
            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }   
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
