package gruppo1.software_enginering.State_Improve;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.DrawCommand;
import gruppo1.software_enginering.Command.UpdateCommand;
import gruppo1.software_enginering.Shape.MyRectangle;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * <p>
 * 
 * Class that describe the state for drawing a rectangle
 * <p><!-- -->
 */

public class ToolRectangleDraw implements Tool {

    public ToolRectangleDraw(Color strokeColor, Color fillColor, boolean isFill, ImageView image) {
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.isFill = isFill;
        this.setImage(image);
    }


    private MyRectangle myrectangle;
    private Color strokeColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private boolean isFill = false;

    

    
    /** 
     * @param drawingSurface
     * @param dragged_x
     * @param dragged_y
     * @return Command
     */
    @Override
    public Command  onMouseDragged(Pane drawingSurface, double dragged_x, double dragged_y) {

        Command command = new  UpdateCommand(this.myrectangle, dragged_x, dragged_y);
        command.execute();
        return null;
        
    }

    
    /** 
     * @param drawingSurface
     * @param node
     * @param pressed_x
     * @param pressed_y
     * @return Command
     */
    @Override
    public Command  onMousePressed(Pane drawingSurface, Node node, double pressed_x, double pressed_y) {
        this.myrectangle = new MyRectangle(pressed_x, pressed_y, this.strokeColor, this.fillColor, this.isFill);
        
        Command command = new DrawCommand(this.myrectangle, drawingSurface);
        return command;

        
    }

    
    /** 
     * @param isFill
     * @param fillColor
     * @return Command
     */
    @Override
    public Command  setFill(boolean isFill, Color fillColor) {
       this.isFill = isFill;
       return null;
    }

    
    /** 
     * @param fillColor
     * @return Command
     */
    @Override
    public Command  setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return null;

    }

    
    /** 
     * @param strokeColor
     * @return Command
     */
    @Override
    public Command  setStrokeColor(Color strokeColor) {
        
        this.strokeColor = strokeColor;
        return null;

    }
    

    
    /** 
     * @param image
     */
    public void  setImage(ImageView image) {
        image.setImage(new Image(getClass().getResourceAsStream("Image_State/rectangle.png")));
        
    }
}
