package gruppo1.software_enginering.Command.CommandDeprecati;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Shape.MyLine;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class DrawLineCommand implements Command{

    

    private MyLine line;
    private /*GraphicsContext drawingSurface*/ Pane drawingSurface;


    public DrawLineCommand(MyLine line, /*GraphicsContext drawingSurface*/ Pane drawingSurface) {
        this.line = line;
        this.drawingSurface = drawingSurface;
    }
    

    @Override
    public void execute() {
        
        line.draw(drawingSurface);
    }

    @Override
    public void undo() {
        
        
    }
    
}
