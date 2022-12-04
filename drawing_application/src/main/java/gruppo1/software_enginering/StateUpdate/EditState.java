package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Command.Command;
//import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public interface EditState  {


    public abstract Command onMousePressed(MouseEvent event, Pane drawingSurface, SelectionModel selection);
    public abstract Command onMouseDrag(MouseEvent event);
    public abstract Command onMouseReleased(MouseEvent event);

    }
