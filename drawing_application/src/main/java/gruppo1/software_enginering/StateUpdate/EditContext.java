package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Command.Command;
//import gruppo1.software_enginering.Command.SelectionCommand;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class EditContext {

    private SelectionModel selection = new SelectionModel();

    /*public EditContext(EditState edit) {
        this.edit = edit;

        //IDLE STATE
    }*/

    private EditState edit;

    public void changeState(EditState state){
        this.edit = state;
    }

    public Command onMousePressed(MouseEvent event, Pane drawingSurface) {

        return this.edit.onMousePressed(event, drawingSurface, selection);
    }


    
    
}
