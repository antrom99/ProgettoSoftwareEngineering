package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;

public class OnTheFrontCommand implements Command{

    private Pane drawingSurface;
    private SelectionModel selection;



    public OnTheFrontCommand(SelectionModel selection, Pane drawingSurface){
        
        this.selection= selection;
        this.drawingSurface= drawingSurface;

    }

    @Override
    public void execute() {
       
        this.selection.getShape_element().toFront();
        this.selection.clear(drawingSurface);
        
    }

    @Override
    public void undo() {
        
        
    }

    
}
