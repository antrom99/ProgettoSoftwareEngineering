package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;

/**
 * <p>
 * This Class define a command of Delete for the selected shape
 * <p><!-- -->
 * @see Command
 */
public class DeleteCommand implements Command{


    private Pane drawingSurface;
    private SelectionModel selection;


    /**
     * <p>
     * This is  the costructor for the command of delete, it initializes the selection model and the Drawing surface
     * <p><!-- -->
     * @param drawingSurface
     * @param selection
     */

    public DeleteCommand(Pane drawingSurface,SelectionModel selection){


        this.drawingSurface=drawingSurface;
        this.selection=selection;


    }


    /**
     * This method perform the operation of delete for a shape, so it removes the shape from the Drawing Surface and remove the selection
     */

    @Override
    public void execute() {


        


        this.drawingSurface.getChildren().remove(this.selection.getShape_element());
        this.selection.clear(this.drawingSurface);



        

        
    }

    @Override
    public void undo() {
        
        
    }
    
}
