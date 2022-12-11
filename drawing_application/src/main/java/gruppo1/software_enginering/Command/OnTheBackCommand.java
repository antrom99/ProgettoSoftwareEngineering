package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;


import javafx.scene.layout.Pane;
/**
 * <p>
 * This Class define ton the back command for the selected shape
 * <p><!-- -->
 */
public class OnTheBackCommand implements Command{

    private Pane drawingSurface;
    private SelectionModel selection;
    /**
     * <p>
     * This is the costructor for on the back operation, so it initializes the selection model and the drawing surface
     * <p><!-- -->
     * @param selection
     * @param drawingSurface
     */

    public OnTheBackCommand( SelectionModel selection, Pane drawingSurface){

        this.drawingSurface= drawingSurface;
        this.selection= selection;

    }
    /**
     * 
     * <p>
     * This method execute the operation for switch the selected shape on the back on the drawing surface 
     * <p><!-- -->
     */

    @Override
    public void execute() {
        
        this.selection.getShape_element().toBack();
        this.selection.clear(drawingSurface);
        
    }

    @Override
    public void undo() {

        
    }
    
}
