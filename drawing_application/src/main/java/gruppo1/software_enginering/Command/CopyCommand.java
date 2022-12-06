package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
//import gruppo1.software_enginering.StateUpdate.Context;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class CopyCommand implements Command{

    private Shape shape;
    private SelectionModel selection;
    private Pane drawingSurface;
    











    public CopyCommand(Shape shape, SelectionModel selection, Pane drawingSurface){

        this.shape=shape;
        this.selection=selection;
        this.drawingSurface=drawingSurface;
        

    }

















    @Override
    public void execute() {


        ShapeFactory shapeFactory= new ShapeFactory(this.shape);
        MyShape shape = shapeFactory.getShape();
        MyShape clone = shape.cloneShape();
        ContextCommand.setShapeCopy(clone);
        this.selection.clear(this.drawingSurface);




        
    }

    @Override
    public void undo() {
        
        
    }
    
}
