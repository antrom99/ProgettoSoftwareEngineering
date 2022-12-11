package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.Shape.MyShape;
//import javafx.scene.Node;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

/**
 * <p>
 * This class define the command for perfoming the shape drawing operation
 * <p><!-- -->
 */

public class DrawCommand implements Command  {

    private MyShape shape;
    private Pane drawingSurface;

    /**
     * <p>
     * This is the constructor for Draw Command, so it initialize the shape for drawing and the drawing surface
     * <p><!-- -->
     * @param shape
     * @param drawingSurface
     */

    public DrawCommand(MyShape shape, Pane drawingSurface) {
        this.shape = shape;
        this.drawingSurface = drawingSurface;
    }

    /**
     * <p>
     * This method execute the drawing operation  of the shape on the drawing surface 
     * <p><!-- -->
     */

    @Override
    public void execute() {
        
        
        this.shape.draw(this.drawingSurface);
       
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
