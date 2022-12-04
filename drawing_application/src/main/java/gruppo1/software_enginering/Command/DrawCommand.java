package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.Shape.MyShape;
//import javafx.scene.Node;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class DrawCommand implements Command  {

    private MyShape shape;
    private /*GraphicsContext drawingSurface*/ Pane drawingSurface;

    public DrawCommand(MyShape shape, /*GraphicsContext drawingSurface*/ Pane drawingSurface) {
        this.shape = shape;
        this.drawingSurface = drawingSurface;
    }

    @Override
    public void execute() {
        
        
        this.shape.draw(this.drawingSurface);
       //drawingSurface.getChildren().add((Node) this.shape);
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
