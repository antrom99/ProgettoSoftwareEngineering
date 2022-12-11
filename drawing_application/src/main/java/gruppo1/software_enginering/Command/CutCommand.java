package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;


public class CutCommand implements Command{


    private SelectionModel selection;
    private Pane drawingSurface;
    


    public CutCommand(SelectionModel selection, Pane drawingSurface){


        this.selection=selection;
        this.drawingSurface=drawingSurface;
        

    }


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
