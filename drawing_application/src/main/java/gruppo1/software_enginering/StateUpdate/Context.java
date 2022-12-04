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
    

    public void changeState(State state){
        this.state = state;
    }


   
    public Command onMousePressed(MouseEvent event, Pane drawingSurface) {

        /*this.state.selectFill(fill);
        /*this.state.selectStrokeColor(strokeColor);
        /*this.state.selectFillColor(fillColor);*/
        
        return this.state.onMousePressed(event, drawingSurface);
    }

   
    public Command onMouseDrag(MouseEvent event) {
        
        return this.state.onMouseDrag(event);
    }
    public Command onMouseReleased(MouseEvent event){
        return this.state.onMouseReleased(event);
    }

   
    public Command selectStrokeColor(Color strokeColor) {
        
        return this.state.selectStrokeColor(strokeColor);
    }

   
    public Command selectFillColor(Color fill_color) {
        
        return this.state.selectFillColor(fill_color);
    }

   
    public Command selectFill(boolean fill) {
        
        return this.state.selectFill(fill);
    }

    
    public void setImage(ImageView image) {
        
        this.state.setImage(image);
        
    }

    
    public void setImageMODE(ImageView image) {
        this.state.setImageMODE(image);
        
    }

    public void resetMode(Pane drawingSurface) {
        this.state.resetMode(drawingSurface);
    }



    




}
