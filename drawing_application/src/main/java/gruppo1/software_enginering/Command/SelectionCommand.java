package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.Node;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * <p>
 * This class define the command of selection for a clicked shape
 * <p><!-- -->
 */
public class SelectionCommand implements Command{

    private SelectionModel selection;
    private Node node;
    private Pane drawingSurface;
    
    


    /**
     * <p>
     * This is the constructor for the selection command, so it initializes the node, the drawing surface and the selection model
     * <p><!-- -->
     * @param selection
     * @param node
     * @param drawingSurface
     */

    public SelectionCommand(SelectionModel selection, Node node, Pane drawingSurface) {
        this.selection = selection;
        this.node = node;
        this.drawingSurface = drawingSurface;

    }

    
    /**
     * <p>
     * This method perform the operation of selection 
     * <p><!-- -->
     */
    @Override
    public void execute() {

        
        if (this.node instanceof Shape ){
            Shape shape_selected = (Shape) node;
           
            selection.add(shape_selected);
            selection.addView(drawingSurface);}
            
        
     }
        
        
    

    @Override
    public void undo() {
        
        
    }
    
}
