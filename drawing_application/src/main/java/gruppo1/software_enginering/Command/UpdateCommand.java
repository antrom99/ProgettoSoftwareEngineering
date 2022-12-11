package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.Shape.MyShape;

public class UpdateCommand implements Command {

    private MyShape shape;
    private double dragPoint_x;
    private double dragPoint_y;
    

    public UpdateCommand(MyShape shape, double dragPoint_x, double dragPoint_y) {
        this.shape = shape;
        this.dragPoint_x = dragPoint_x;
        this.dragPoint_y = dragPoint_y;
    }

    @Override
    public void execute() {
        
        shape.updateAttribute(dragPoint_x, dragPoint_y);
        
        
    }

    
    
}
