package gruppo1.software_enginering.Command.CommandDeprecati;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Shape.MyEllipse;
import javafx.scene.canvas.GraphicsContext;

public class DrawEllipseCommand implements Command {

    private MyEllipse  ellipse;
    private GraphicsContext drawingSurface;
    

    public DrawEllipseCommand(MyEllipse ellipse, GraphicsContext drawingSurface) {
        this.ellipse = ellipse;
        this.drawingSurface = drawingSurface;
    }


    @Override
    public void execute() {
        

        ellipse.draw(drawingSurface);
    }


    @Override
    public void undo() {
        
        
    }
    
}
