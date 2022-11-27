package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.Shape.MyShape;
import javafx.scene.canvas.GraphicsContext;

public class DrawCommand implements Command  {

    private MyShape shape;
    private GraphicsContext drawingSurface;

    public DrawCommand(MyShape shape, GraphicsContext drawingSurface) {
        this.shape = shape;
        this.drawingSurface = drawingSurface;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        this.shape.draw(drawingSurface);
        
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        
    }
    
}
