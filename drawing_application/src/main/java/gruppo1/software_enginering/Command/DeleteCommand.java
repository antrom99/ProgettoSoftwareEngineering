package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;


public class DeleteCommand implements Command{


    private Pane drawingSurface;
    private SelectionModel selection;




    public DeleteCommand(Pane drawingSurface,SelectionModel selection){


        this.drawingSurface=drawingSurface;
        this.selection=selection;


    }








    @Override
    public void execute() {


        


        this.drawingSurface.getChildren().remove(this.selection.getShape_element());
        this.selection.clear(this.drawingSurface);



        

        
    }

    @Override
    public void undo() {
        
        
    }
    
}
