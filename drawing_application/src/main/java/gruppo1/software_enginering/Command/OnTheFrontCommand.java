package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;
/**
 * <p>
 * This Class define on the front command for the selected shape
 * <p><!-- -->
 */
public class OnTheFrontCommand implements Command{

    private Pane drawingSurface;
    private SelectionModel selection;

    /**
     * <p>
     * This is the costructor for on the front operation, so it initializes the selection model and the drawing surface
     * <p><!-- -->
     * @param selection
     * @param drawingSurface
     */

    public OnTheFrontCommand(SelectionModel selection, Pane drawingSurface){
        
        this.selection= selection;
        this.drawingSurface= drawingSurface;

    }

    /**
     * 
     * <p>
     * This method execute the operation for switch the selected shape on the front on the drawing surface 
     * <p><!-- -->
     */

    @Override
    public void execute() {
       
        this.selection.getShape_element().toFront();
        this.selection.clear(drawingSurface);
        
    }

    @Override
    public void undo() {
        
        
    }

    
}
