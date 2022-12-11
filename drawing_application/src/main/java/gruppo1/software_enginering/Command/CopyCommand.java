package gruppo1.software_enginering.Command;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.layout.Pane;


public class CopyCommand implements Command{


    private SelectionModel selection;
    private Pane drawingSurface;
    


    public CopyCommand(SelectionModel selection, Pane drawingSurface){


        this.selection=selection;
        this.drawingSurface=drawingSurface;
        

    }



    @Override
    public void execute() {



        ShapeFactory shapeFactory =new ShapeFactory(this.selection.getShape_element());
        MyShape shape = shapeFactory.getShape();
        
        //try {
            if(!shape.equals(null)){
               MyShape clone = shape.cloneShape(); 
               ContextCommand.setShapeCopy(clone);
               this.selection.clear(this.drawingSurface);

            }

                
        //} catch (Exception e) {}


        
       


       

        




        
    }

    @Override
    public void undo() {
        
        
    }
    
}
