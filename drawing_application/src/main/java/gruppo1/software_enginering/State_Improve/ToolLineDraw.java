package gruppo1.software_enginering.State_Improve;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.DrawCommand;
import gruppo1.software_enginering.Command.UpdateCommand;
import gruppo1.software_enginering.Shape.MyLine;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
/**
 * 
 * <p>
 * 
 * Class that describe the state for drawing a line
 * <p><!-- -->
 */
public class ToolLineDraw implements Tool {

    private MyLine myline;
    private Color strokeColor = Color.BLACK;
    

    public ToolLineDraw(Color strokeColor, ImageView imageTool, ImageView imageMode) {
        this.strokeColor = strokeColor;
        this.setImage(imageTool);
        this.setModeImage(imageMode);
    }

    
    /** 
     * @param drawingSurface
     * @param dragged_x
     * @param dragged_y
     * @return Command
     */
    @Override
    public Command onMouseDragged(Pane drawingSurface, double dragged_x, double dragged_y) {
        
        Command command = new UpdateCommand(myline, dragged_x, dragged_y);
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
    public Command onMousePressed(Pane drawingSurface, Node node, double pressed_x, double pressed_y) {
        
        this.myline = new MyLine(pressed_x, pressed_y, strokeColor);
        Command command = new DrawCommand(myline, drawingSurface);
        return command;
        
    }

    
    /** 
     * @param strokeColor
     * @return Command
     */
    @Override
    public Command setStrokeColor(Color strokeColor) {

        this.strokeColor = strokeColor;

        return null;
        
    }

    
    /** 
     * @param image
     */
    public void setImage(ImageView image) {
        image.setImage(new Image(getClass().getResourceAsStream("Image_State/line.png")));
        
    }

    
    /** 
     * @param image
     */
    public void setModeImage(ImageView image){

        image.setImage(new Image(getClass().getResourceAsStream("Image_State/matita.png")));

    }
    
}
