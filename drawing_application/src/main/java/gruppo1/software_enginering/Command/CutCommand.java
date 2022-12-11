package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * <p>
 * This Class define a command of Cut for the selected shape
 * <p><!-- -->
 * @see Command
 */
public class CutCommand implements Command{


    private SelectionModel selection;
    private Pane drawingSurface;
    
    /**
     * <p>
     * This is  the costructor for the command of cut, it initializes the selection model and the Drawing surface
     * <p><!-- -->
     * @param selection
     * @param drawingSurface
     */

    public CutCommand(SelectionModel selection, Pane drawingSurface){


        this.selection=selection;
        this.drawingSurface=drawingSurface;
        

    }

    /**
     * <p>
     * This method perform the operation of cut, so memorize the shape selected in a static object ,remove the selection and delete the shape from Drawing Surface
     * <p><!-- -->
     */
    @Override
    public void execute() {

        // COPY COMMAND

        Shape shape = selection.getShape_element();


        CopyCommand copy = new CopyCommand(selection, drawingSurface);
        copy.execute();

        // DELETE COMMAND
        selection.setShape_element(shape);

        DeleteCommand delete= new DeleteCommand(drawingSurface, selection);
        delete.execute();



        
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
