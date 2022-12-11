package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import javafx.scene.Node;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class SelectionCommand implements Command{

    private SelectionModel selection;
    private Node node;
    private Pane drawingSurface;
    //private boolean isSelected;
    


    

    public SelectionCommand(SelectionModel selection, Node node, Pane drawingSurface) {
        this.selection = selection;
        this.node = node;
        this.drawingSurface = drawingSurface;

    }

    

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
