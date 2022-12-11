package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;


import javafx.scene.layout.Pane;

public class OnTheBackCommand implements Command{

    private Pane drawingSurface;
    private SelectionModel selection;


    public OnTheBackCommand( SelectionModel selection, Pane drawingSurface){

        this.drawingSurface= drawingSurface;
        this.selection= selection;

    }

    @Override
    public void execute() {
        
        this.selection.getShape_element().toBack();
        this.selection.clear(drawingSurface);
        
    }

    @Override
    public void undo() {

        
    }
    
}
