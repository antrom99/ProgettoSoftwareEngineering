package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class CutCommand implements Command{

    private Shape shape;
    private SelectionModel selection;
    private Pane drawingSurface;
    


    public CutCommand(Shape shape, SelectionModel selection, Pane drawingSurface){

        this.shape=shape;
        this.selection=selection;
        this.drawingSurface=drawingSurface;
        

    }


    @Override
    public void execute() {

        // COPY COMMAND

        CopyCommand copy = new CopyCommand(shape, selection, drawingSurface);
        copy.execute();

        // DELETE COMMAND

        DeleteCommand delete= new DeleteCommand(shape,drawingSurface,selection);
        delete.execute();



        
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
