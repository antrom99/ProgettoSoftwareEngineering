package gruppo1.software_enginering.Command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * <p>
 * This class define the command for change the fill color for the selected shape
 * <p><!-- -->
 */

public class SelectFillColor implements Command {

    private Shape shape;
    private Color fillColor;

    /**
     * 
     * <p>
     * This is the constructor for the select fill color command, so it initializes the shape and the fill color
     * <p><!-- -->
     * @param shape
     * @param fillColor
     */

    public SelectFillColor(Shape shape, Color fillColor) {
        this.shape = shape;
        this.fillColor = fillColor;
    }

    /**
     * <p>
     * This method perform the operation for chaging the fill color of the selected shape
     * <p><!-- -->
     */

    @Override
    public void execute() {
        

        shape.setFill(fillColor);
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
