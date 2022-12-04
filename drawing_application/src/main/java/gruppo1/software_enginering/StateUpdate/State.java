package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.Command.Command;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public interface State {
    public abstract Command onMousePressed(/*double pressedX, double pressedY*/MouseEvent event, Pane drawingSurface);
    public abstract Command onMouseDrag(MouseEvent event);
    public abstract Command onMouseReleased(MouseEvent event);
    public abstract Command selectStrokeColor(Color strokeColor);
    public abstract Command selectFillColor(Color fill_color);
    public abstract Command selectFill(boolean fill);
    public abstract void setImage(ImageView image);
    public abstract void setImageMODE(ImageView image);
    public abstract void resetMode(Pane drawingSurface);
    
    
}
