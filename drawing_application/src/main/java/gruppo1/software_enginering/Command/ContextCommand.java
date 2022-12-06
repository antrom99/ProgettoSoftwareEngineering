package gruppo1.software_enginering.Command;

import java.util.ArrayList;


import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ContextCommand implements Command{

    private SelectionModel selection;
    private MouseEvent event;
    private Pane drawingSurface;
   // private ContextMenu contextMenu;
    private static MyShape shapeCopy;
    private ArrayList<MenuItem> list = new ArrayList<>();
    

    





    public static MyShape getShapeCopy() {
        return shapeCopy;
    }



    public static void setShapeCopy(MyShape shapeCopy) {
        ContextCommand.shapeCopy = shapeCopy;
    }



    public ContextCommand(SelectionModel selection, MouseEvent event, Pane drawingSurface, ContextMenu contextMenu){

        this.selection=selection;
        this.event=event;
        this.drawingSurface=drawingSurface;
        //this.contextMenu = contextMenu;
 
        Command command = new SelectionCommand(this.selection,(Node) this.event.getTarget(), this.drawingSurface);
        command.execute();  
        MenuItem menuItem1 = new MenuItem("Cut");
        MenuItem menuItem2 = new MenuItem("Copy");
        MenuItem menuItem3 = new MenuItem("Paste");
        MenuItem menuItem4 = new MenuItem("Delete");

        this.list.add(menuItem1);
        this.list.add(menuItem2);
        this.list.add(menuItem3);
        this.list.add(menuItem4);
        
        contextMenu.getItems().clear();
            
        if(this.event.getTarget() instanceof Shape ){

            contextMenu.getItems().addAll(menuItem1,menuItem2,menuItem4);
            contextMenu.show((Node) event.getTarget(), Side.RIGHT,5, 5);

         }else{            

            contextMenu.getItems().addAll(menuItem3);
            //contextMenu.show((Node) event.getTarget(), Side.RIGHT, event.getX(), event.getY()); 
            contextMenu.show((Node) event.getTarget(), event.getScreenX(), event.getScreenY());
        }
        

    }

    public ContextCommand(){}


    @Override
    public void execute(){



        // DELETE OPERATION 

        this.list.get(3).setOnAction(e ->{
            
            DeleteCommand delete= new DeleteCommand((Shape) event.getTarget(),drawingSurface,selection);
            delete.execute();
            
        });

        
        // COPY OPERATION

        this.list.get(1).setOnAction(e ->{

            
            
            CopyCommand copy = new CopyCommand((Shape) event.getTarget(), selection, drawingSurface);
            copy.execute();

        });

        
        // CUT OPERATION

        this.list.get(0).setOnAction(e ->{

            

            CutCommand cut = new CutCommand((Shape) event.getTarget(), selection, drawingSurface);
            cut.execute();

        });


        // PASTE OPERATION

        this.list.get(2).setOnAction(e -> {

            

            PasteCommand paste = new PasteCommand(ContextCommand.getShapeCopy(),this.drawingSurface,selection);
            paste.execute();


        });


        





        









    


        


    }






        



     



        

      
        



      
        

        
        
    

    @Override
    public void undo() {
        
        
    }
    





}
