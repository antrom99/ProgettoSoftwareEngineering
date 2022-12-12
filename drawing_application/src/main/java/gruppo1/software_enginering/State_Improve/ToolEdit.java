package gruppo1.software_enginering.State_Improve;

import gruppo1.software_enginering.Command.Invoker;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
/**
 * 
 * <p>
 * Class for the state of edit 
 * <p><!-- -->
 */
public class ToolEdit implements Tool{


    
    

    public ToolEdit(Invoker invoker,Pane drawingSurface,ToolContext toolContext, ImageView imageMode ) {
        if(imageMode !=null)
            this.setModeImage(imageMode);
        
        drawingSurface.setOnMousePressed(event->{
            if (event.isSecondaryButtonDown() ){

                toolContext.setCurrentTool(new ToolContextMenu(invoker,toolContext,(Node) event.getTarget(), event.getScreenX(), event.getScreenY(), drawingSurface));
                toolContext.doOperation();

            }else if (event.getTarget() instanceof Shape){
                
                
                toolContext.setCurrentTool(new ToolSelection(invoker, toolContext, event.getX(), event.getY() ,(Node)event.getTarget(), drawingSurface));
                //toolContext.getCurrentTool().onMousePressed(drawingSurface, event.getX(), event.getY());
                toolContext.doOperation();
            }
                 
            event.consume();

        });

    }

    public ToolEdit(Invoker invoker,Pane drawingSurface,ToolContext toolContext) {
       
        
        drawingSurface.setOnMousePressed(event->{
            if (event.isSecondaryButtonDown() ){

                toolContext.setCurrentTool(new ToolContextMenu(invoker,toolContext,(Node) event.getTarget(), event.getScreenX(), event.getScreenY(), drawingSurface));
                toolContext.doOperation();

            }else if (event.getTarget() instanceof Shape){
                
                
                toolContext.setCurrentTool(new ToolSelection(invoker,toolContext, event.getX(), event.getY() ,(Node)event.getTarget(), drawingSurface));
                //toolContext.getCurrentTool().onMousePressed(drawingSurface, event.getX(), event.getY());
                toolContext.doOperation();
            }
                 
            event.consume();

        });

    }

    

    
    /** 
     * @param image
     */
    public void setModeImage(ImageView image){

        image.setImage(new Image(getClass().getResourceAsStream("Image_State/cursor2.png")));

    }
    
}
