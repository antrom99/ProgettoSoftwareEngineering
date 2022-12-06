package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class DeleteCommand implements Command{

    private Shape shape;
    private Pane drawingSurface;
    private SelectionModel selection;




    public DeleteCommand(Shape shape,Pane drawingSurface,SelectionModel selection){

        this.shape=shape;
        this.drawingSurface=drawingSurface;
        this.selection=selection;


    }








    @Override
    public void execute() {


        


        this.drawingSurface.getChildren().remove(this.shape);
        this.selection.clear(this.drawingSurface);



        

        
    }

    @Override
    public void undo() {
        
        
    }
    
}
