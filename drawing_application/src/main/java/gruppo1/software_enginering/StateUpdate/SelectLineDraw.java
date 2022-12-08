package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.DrawCommand;
import gruppo1.software_enginering.Command.UpdateCommand;
import gruppo1.software_enginering.Shape.MyLine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SelectLineDraw implements State{
    private MyLine line;
    private Color strokeColor = Color.BLACK ;

    public SelectLineDraw(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    
    /** 
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    
    /** 
     * @param event
     * @param drawingSurface
     * @return Command
     */
    @Override
    public Command onMousePressed(MouseEvent event, Pane drawingSurface) {
        double pressedX = event.getX();
        double pressedY = event.getY();
        
        this.line = new MyLine(pressedX, pressedY, strokeColor);

        return new DrawCommand(line, drawingSurface);
    }

    
    /** 
     * @param event
     * @return Command
     */
    @Override
    public Command onMouseDrag(MouseEvent event) {
        double dragX = event.getX();
        double dragY = event.getY();
        
        return new UpdateCommand(line, dragX, dragY);
    }

    
    /** 
     * @param strokeColor
     * @return Command
     */
    @Override
    public Command selectStrokeColor(Color strokeColor) {
        this.setStrokeColor(strokeColor);
        return null;
    }

    
    /** 
     * @param fill_color
     * @return Command
     */
    @Override
    public Command selectFillColor(Color fill_color) {
        // IDLE
        return null;
    }

    
    /** 
     * @param fill
     * @return Command
     */
    @Override
    public Command selectFill(boolean fill) {
        // IDLE
        return null;
    }

    
    /** 
     * @param image
     */
    @Override
    public void setImage(ImageView image) {
        image.setImage(new Image(getClass().getResourceAsStream("Image_State/line.png")));
        
    }

    
    /** 
     * @param image
     */
    public void setImageMODE(ImageView image){
        image.setImage(new Image(getClass().getResourceAsStream("Image_State/matita.png")));
    }

    
    /** 
     * @param drawingSurface
     */
    @Override
    public void resetMode(Pane drawingSurface) {
        
        
    }

    
    /** 
     * @param event
     * @return Command
     */
    @Override
    public Command onMouseReleased(MouseEvent event) {
        
        return null;
    }
    
}
