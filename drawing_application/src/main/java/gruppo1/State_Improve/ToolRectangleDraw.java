package gruppo1.State_Improve;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.DrawCommand;
import gruppo1.software_enginering.Command.UpdateCommand;
import gruppo1.software_enginering.Shape.MyRectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ToolRectangleDraw implements Tool {

    private MyRectangle myrectangle;
    private Color colorStroke;
    private Color colorFill;
    private boolean isFill;

    @Override
    public void onMouseDragged(Pane drawingSurface, double dragged_x, double dragged_y) {

        Command command = new  UpdateCommand(this.myrectangle, dragged_x, dragged_y);
        command.execute();
        
    }

    @Override
    public void onMousePressed(Pane drawingSurface, double pressed_x, double pressed_y) {
        this.myrectangle = new MyRectangle(pressed_x, pressed_y, this.colorStroke, this.colorFill, this.isFill);
        Command command = new DrawCommand(this.myrectangle, drawingSurface);
        command.execute();

        
    }
    
}
