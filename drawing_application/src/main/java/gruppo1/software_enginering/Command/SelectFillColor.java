package gruppo1.software_enginering.Command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class SelectFillColor implements Command {

    private Shape shape;
    private Color fillColor;

    public SelectFillColor(Shape shape, Color fillColor) {
        this.shape = shape;
        this.fillColor = fillColor;
    }

    @Override
    public void execute() {
        

        shape.setFill(fillColor);
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
