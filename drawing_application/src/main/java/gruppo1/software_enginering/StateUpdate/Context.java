package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.Command.Command;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Context {
    private State state;
    

    public Context(State state) {
        this.state = state;
    }
    

    
    /** 
     * @param state
     */
    public void changeState(State state){
        this.state = state;
    }


   
    
    /** 
     * @param event
     * @param drawingSurface
     * @return Command
     */
    public Command onMousePressed(MouseEvent event, Pane drawingSurface) {

        /*this.state.selectFill(fill);
        /*this.state.selectStrokeColor(strokeColor);
        /*this.state.selectFillColor(fillColor);*/
        
        return this.state.onMousePressed(event, drawingSurface);
    }

   
    
    /** 
     * @param event
     * @return Command
     */
    public Command onMouseDrag(MouseEvent event) {
        
        return this.state.onMouseDrag(event);
    }
    
    /** 
     * @param event
     * @return Command
     */
    public Command onMouseReleased(MouseEvent event){
        return this.state.onMouseReleased(event);
    }

   
    
    /** 
     * @param strokeColor
     * @return Command
     */
    public Command selectStrokeColor(Color strokeColor) {
        
        return this.state.selectStrokeColor(strokeColor);
    }

   
    
    /** 
     * @param fill_color
     * @return Command
     */
    public Command selectFillColor(Color fill_color) {
        
        return this.state.selectFillColor(fill_color);
    }

   
    
    /** 
     * @param fill
     * @return Command
     */
    public Command selectFill(boolean fill) {
        
        return this.state.selectFill(fill);
    }

    
    
    /** 
     * @param image
     */
    public void setImage(ImageView image) {
        
        this.state.setImage(image);
        
    }

    
    
    /** 
     * @param image
     */
    public void setImageMODE(ImageView image) {
        this.state.setImageMODE(image);
        
    }

    
    /** 
     * @param drawingSurface
     */
    public void resetMode(Pane drawingSurface) {
        this.state.resetMode(drawingSurface);
    }



    




}
