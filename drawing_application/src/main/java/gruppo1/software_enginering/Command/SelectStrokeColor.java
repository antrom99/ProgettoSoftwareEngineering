package gruppo1.software_enginering.Command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class SelectStrokeColor implements Command {

    private Shape shape;
    private Color strokeColor;

    public SelectStrokeColor(Shape shape, Color strokeColor) {
        this.shape = shape;
        this.strokeColor = strokeColor;
    }

    @Override
    public void execute() {
       

        shape.setStroke(strokeColor);
        
    }

   

    @Override
    public void undo() {
        
        
    }
    
}
