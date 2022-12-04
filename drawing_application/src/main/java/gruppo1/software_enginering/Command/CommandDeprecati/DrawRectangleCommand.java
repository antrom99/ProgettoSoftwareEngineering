package gruppo1.software_enginering.Command.CommandDeprecati;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Shape.MyRectangle;
//import gruppo1.software_enginering.Shape.MyShape;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;


public class DrawRectangleCommand implements Command {

    private MyRectangle rectangle;
    private /*GraphicsContext drawingSurface*/ Pane drawingSurface;
    

    public DrawRectangleCommand(MyRectangle rectangle, /*GraphicsContext drawingSurface*/ Pane drawingSurface) {
        this.rectangle = rectangle;
        this.drawingSurface = drawingSurface;
    }


    @Override
    public void execute() {
        
        rectangle.draw(drawingSurface);
    }


    @Override
    public void undo() {
        
        
    }
        
}


    

