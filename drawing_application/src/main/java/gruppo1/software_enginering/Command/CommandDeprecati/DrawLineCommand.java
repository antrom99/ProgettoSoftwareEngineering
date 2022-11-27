package gruppo1.software_enginering.Command.CommandDeprecati;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Shape.MyLine;
import javafx.scene.canvas.GraphicsContext;

public class DrawLineCommand implements Command{

    

    private MyLine line;
    private GraphicsContext drawingSurface;


    public DrawLineCommand(MyLine line, GraphicsContext drawingSurface) {
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
