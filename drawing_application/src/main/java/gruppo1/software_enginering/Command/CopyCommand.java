package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;
/**
 * <p>
 * This Class define a command of Copy for the selected shape
 * <p><!-- -->
 * @see Command
 */

public class CopyCommand implements Command{


    private SelectionModel selection;
    private Pane drawingSurface;
    

    /**
     * <p>
     * This is  the costructor for the command of copy, it initializes the selection model and the Drawing surface
     * <p><!-- -->
     * @param selection
     * @param drawingSurface
     */
    public CopyCommand(SelectionModel selection, Pane drawingSurface){


        this.selection=selection;
        this.drawingSurface=drawingSurface;
        

    }


    /**
     * <p>
     * This method perform the operation of copy, so memorize the shape selected in a static object and remove the selection.
     * <p><!-- -->
     */

    @Override
    public void execute() {



        ShapeFactory shapeFactory =new ShapeFactory(this.selection.getShape_element());
        MyShape shape = shapeFactory.getShape();
        
    
        
        MyShape clone = shape.cloneShape(); 
        ContextCommand.setShapeCopy(clone);
        this.selection.clear(this.drawingSurface);

        
    }

    @Override
    public void undo() {
        
        
    }
    
}
