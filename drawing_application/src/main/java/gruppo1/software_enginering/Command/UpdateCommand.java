package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.Shape.MyShape;

/**
 * <p>
 * This class define the command for update the parameter of a shape 
 * <p><!-- -->
 */

public class UpdateCommand implements Command {

    private MyShape shape;
    private double dragPoint_x;
    private double dragPoint_y;
    
    /**
     * <p>
     * This is the constructor for the update command, so it initializes the shape and  the drag point 
     * <p><!-- -->
     * @param shape
     * @param dragPoint_x
     * @param dragPoint_y
     */

    public UpdateCommand(MyShape shape, double dragPoint_x, double dragPoint_y) {
        this.shape = shape;
        this.dragPoint_x = dragPoint_x;
        this.dragPoint_y = dragPoint_y;
    }
    /**
     * 
     * <p>
     * 
     * This method perform the operatione of updating for the shape
     * 
     * <p><!-- -->
     */
    @Override
    public void execute() {
        
        shape.updateAttribute(dragPoint_x, dragPoint_y);
        
        
    }

    
    
}
