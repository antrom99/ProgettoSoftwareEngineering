package gruppo1.software_enginering.Command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
/**
 * <p>
 * This class define the command for change the stroke color for the selected shape
 * <p><!-- -->
 */
public class SelectStrokeColor implements Command {

    private Shape shape;
    private Color strokeColor;
    /**
     * <p>
     * This is the constructor for the select stroke color command, so it initializes the shape and the stroke color
     * <p><!-- -->
     * @param shape
     * @param strokeColor
     */

    public SelectStrokeColor(Shape shape, Color strokeColor) {
        this.shape = shape;
        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * This method perform the operation for chaging the stroke color of the selected shape
     * <p><!-- -->
     */

    @Override
    public void execute() {
       

        shape.setStroke(strokeColor);
        
    }

   

    @Override
    public void undo() {
        
        
    }
    
}
