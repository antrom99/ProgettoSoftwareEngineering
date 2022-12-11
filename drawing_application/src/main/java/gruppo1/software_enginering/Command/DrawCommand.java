package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.Shape.MyShape;
//import javafx.scene.Node;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class DrawCommand implements Command  {

    private MyShape shape;
    private Pane drawingSurface;

    public DrawCommand(MyShape shape, Pane drawingSurface) {
        this.shape = shape;
        this.drawingSurface = drawingSurface;
    }

    @Override
    public void execute() {
        
        
        this.shape.draw(this.drawingSurface);
       
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
