package gruppo1.software_enginering.State_Improve;

import gruppo1.software_enginering.Command.Command;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
/**
 * 
 * <p> 
 * Interface Tool fo the state of my application
 * <p><!-- -->
 */
public interface Tool {

    public default Command onMousePressed(Pane drawingSurface,Node node,  double pressed_x, double pressed_y){

        return null;

    }

    public default Command onMouseDragged(Pane drawingSurface, double dragged_x, double dragged_y){
        return null;
    }

    public default Command onMouseReleased(Pane drawingSurface, double released_x, double released_y){

        return null;
    }
    public default Command setFillColor(Color fillColor){
        return null;
    }
    public default Command setFill(boolean isFill,Color fillColor){
        return null;
    }
    public default Command setStrokeColor(Color strokeColor){
        return null;
    }

    public default void resetState(Pane drawinSurface){
        
    }

    
    
}
