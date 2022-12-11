package gruppo1.software_enginering.Command;


import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import javafx.scene.layout.Pane;

/**
 * <p>
 * This Class define a command of Past for the Drawing Surface
 * <p><!-- -->
 * @see Command
 */
public class PasteCommand implements Command{

    private MyShape shapeCopy;
    private Pane drawingSurface;
    private SelectionModel selection;
    /**
     * <p>
     * This is the constructor for the paste operation, so it initialize the selection model, the shapetocopy and the drawing surface
     * <p><!-- -->
     * @param shapeCopy
     * @param drawingSurface
     * @param selection
     */

    public PasteCommand(MyShape shapeCopy, Pane drawingSurface, SelectionModel selection){

        this.shapeCopy=shapeCopy;
        this.drawingSurface=drawingSurface;
        this.selection=selection;

    }

    /**
     * <p>
     * This method perform the operation of past on drawing surface, if the shape to copy is empty it do nothing
     * <p><!-- -->
     */

    @Override
    public void execute() {

        if (shapeCopy!=null){

            Command command_for_paste = new DrawCommand(shapeCopy, drawingSurface);
            command_for_paste.execute();;
            Command command_for_selection = new SelectionCommand(selection, shapeCopy.getShape(), drawingSurface);
            command_for_selection.execute();
            selection.setShape_element(shapeCopy.getShape());

        }
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
