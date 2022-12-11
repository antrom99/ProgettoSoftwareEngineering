package gruppo1.software_enginering.Command;


import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import javafx.scene.layout.Pane;


public class PasteCommand implements Command{

    private MyShape shapeCopy;
    private Pane drawingSurface;
    private SelectionModel selection;

    public PasteCommand(MyShape shapeCopy, Pane drawingSurface, SelectionModel selection){

        this.shapeCopy=shapeCopy;
        this.drawingSurface=drawingSurface;
        this.selection=selection;

    }

    @Override
    public void execute() {

        if (shapeCopy!=null){

            Command command_for_paste = new DrawCommand(shapeCopy, drawingSurface);
            command_for_paste.execute();;
            Command command_for_selection = new SelectionCommand(selection, shapeCopy.getShape(), drawingSurface);
            command_for_selection.execute();
            selection.setShape_element(shapeCopy.getShape());

        }
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
