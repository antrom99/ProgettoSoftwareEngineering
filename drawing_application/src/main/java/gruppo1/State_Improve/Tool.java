package gruppo1.State_Improve;

import javafx.scene.layout.Pane;

public interface Tool {

    public default void onMousePressed(Pane drawingSurface, double pressed_x, double pressed_y){

    }

    public default void onMouseDragged(Pane drawingSurface, double dragged_x, double dragged_y){

    }

    public default void onMouseReleased(Pane drawingSurface, double released_x, double released_y){

        
    }
    
}
