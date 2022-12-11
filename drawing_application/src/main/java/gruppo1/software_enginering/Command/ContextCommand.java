package gruppo1.software_enginering.Command;

import java.util.ArrayList;


import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Shape.MyShape;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * <p>
 * This Class manage the command for the context menu functionality
 * <p><!-- -->
 */

public class ContextCommand implements Command{

    private SelectionModel selection;
    private Node node;
    private Pane drawingSurface;
    private static MyShape shapeCopy;

    private ArrayList<MenuItem> list = new ArrayList<>();




    /** 
     * <p>
     * Static method to get the static object MyShape 
     * <p><!-- -->
     * @return MyShape
     */
    public static MyShape getShapeCopy() {
        return shapeCopy;
    }



    
    /** 
     * <p>
     * Static method to set the static object MyShape 
     * <p><!-- -->
     * @param shapeCopy
     */
    public static void setShapeCopy(MyShape shapeCopy) {
        ContextCommand.shapeCopy = shapeCopy;
    }

    /**
     * 
     * <p>
     * The Constructor of the Context Menu, this constructor create a context menu  for the Drawing Application  if a user click a shape
     * on Drawing Surface the application shows a context menu for a shape and provide the selection for it else if a user click on Drawing Surface 
     * shows context menu for a Drawing Surface
     * <p><!-- -->
     * @param selection
     * @param node
     * @param screenX
     * @param screenY
     * @param drawingSurface
     * @param contextMenu
     */

    public ContextCommand(SelectionModel selection, Node node, double screenX, double screenY, Pane drawingSurface, ContextMenu contextMenu){

        this.selection=selection;
        this.node = node;
        this.drawingSurface=drawingSurface;
        
        
 
        Command command = new SelectionCommand(this.selection,(Node) this.node, this.drawingSurface);
        command.execute();  
        MenuItem menuItem1 = new MenuItem("Cut");
        MenuItem menuItem2 = new MenuItem("Copy");
        MenuItem menuItem3 = new MenuItem("Paste");
        MenuItem menuItem4 = new MenuItem("Delete");
        MenuItem menuItem5 = new MenuItem("onTheFront");
        MenuItem menuItem6 = new MenuItem("onTheBack");
        


        




        this.list.add(menuItem1);
        this.list.add(menuItem2);
        this.list.add(menuItem3);
        this.list.add(menuItem4);
        this.list.add(menuItem5);
        this.list.add(menuItem6);
        

            
        if(this.node instanceof Shape ){

            contextMenu.getItems().addAll(menuItem1,menuItem2,menuItem4,menuItem5,menuItem6);
            contextMenu.show(this.node, Side.RIGHT,5, 5);

         }else{            

            contextMenu.getItems().addAll(menuItem3);
            contextMenu.show(this.node, screenX, screenY);
        }
        

    }

   

    /**<p>
     * This  method select the command that must be execute when there is the event of click on a manu items of a context menu
     * <p><!-- -->
     */
    @Override
    public void execute(){


        // DELETE OPERATION 

        this.list.get(3).setOnAction(e ->{
            
            DeleteCommand delete= new DeleteCommand(this.drawingSurface,this.selection);
            delete.execute();
            
        });

        
        // COPY OPERATION

        this.list.get(1).setOnAction(e ->{

            
            
            CopyCommand copy = new CopyCommand( this.selection, this.drawingSurface);
            copy.execute();

        });

        
        // CUT OPERATION

        this.list.get(0).setOnAction(e ->{

            

            CutCommand cut = new CutCommand(this.selection, this.drawingSurface);
            cut.execute();

        });


        // PASTE OPERATION

        this.list.get(2).setOnAction(e -> {

            

            PasteCommand paste = new PasteCommand(ContextCommand.getShapeCopy(),this.drawingSurface,this.selection);
            paste.execute();


        }); 
        
        
        
        //FRONT OPERATION

        this.list.get(4).setOnAction(e ->{

            OnTheFrontCommand front = new OnTheFrontCommand( this.selection, this.drawingSurface);
            front.execute();

        });


        //BACK OPERATION

        this.list.get(5).setOnAction(e ->{

            OnTheBackCommand back = new OnTheBackCommand(this.selection, this.drawingSurface);
            back.execute();

        });



    }




}
