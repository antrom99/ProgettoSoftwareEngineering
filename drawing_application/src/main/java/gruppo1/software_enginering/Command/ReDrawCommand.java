package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;

/**
 * <p>
 * This class define the command for perfoming the shape redrawing operation
 * <p><!-- -->
 */

public class ReDrawCommand implements Command {

    private SelectionModel selection;
    private Pane drawingSurface;

    /**
     * <p>
     * This is the constructor for ReDraw Command, so it initialize the shape for drawing and the drawing surface
     * <p><!-- -->
     * @param selection
     * @param drawingSurface
     */

    public ReDrawCommand(SelectionModel selection, Pane drawingSurface) {
        this.selection = selection;
        this.drawingSurface = drawingSurface;


    }

    /**
     * <p>
     * This method execute the redrawing operation  of the shape on the drawing surface, so this method create a clone of the selected shape, draw it 
     * and delete the shape previously selected
     * <p><!-- -->
     */
    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ShapeFactory(selection.getShape_element());
        MyShape shape = shapeFactory.getShape();
        MyShape newShape = shape.cloneShape(); // da testare
        drawingSurface.getChildren().remove(shape.getShape());
        Command command = new DrawCommand(newShape, drawingSurface);
        command.execute();
        selection.setShape_element(newShape.getShape());
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
