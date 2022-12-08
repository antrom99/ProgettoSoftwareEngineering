package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;

public class ReDrawCommand implements Command {

    private SelectionModel selection;
    private Pane drawingSurface;

    public ReDrawCommand(SelectionModel selection, Pane drawingSurface) {
        this.selection = selection;
        this.drawingSurface = drawingSurface;


    }

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
