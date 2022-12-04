package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.SelectionCommand;
import javafx.scene.Node;
//import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SelectionState implements EditState {

    @Override
    public Command onMousePressed(MouseEvent event, Pane drawingSurface, SelectionModel selection) {
        
        return new SelectionCommand(selection, (Node) event.getTarget(), drawingSurface);
    }

    @Override
    public Command onMouseDrag(MouseEvent event) {
        //IDLE
        return null;
    }

    @Override
    public Command onMouseReleased(MouseEvent event) {
        //IDLE
        return null;
    }
    
}
