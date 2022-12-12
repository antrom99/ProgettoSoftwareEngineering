package gruppo1.software_enginering.State_Improve;



import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.Invoker;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * 
 * <p>
 * 
 * Class Context for the managing of State
 * <p><!-- -->
 */

public class ToolContext {



    private Tool currentTool;
    private Pane drawingSurface;
    private Invoker invoker;
   


    
    /** 
     * @return Tool
     */
    public Tool getCurrentTool() {
        return currentTool;
    }


    public ToolContext(Tool currentTool, Pane drawingSurface, Invoker invoker) {
        this.currentTool = currentTool;
        this.drawingSurface = drawingSurface;
        this.invoker= invoker;
    }


    public void doOperation(){
        drawingSurface.setOnMousePressed(event->{

            
            
            Command command = this.currentTool.onMousePressed(drawingSurface,(Node) event.getTarget() ,event.getX(), event.getY());
            if (command !=null)
                invoker.execute(command);

            event.consume();
        });

        drawingSurface.setOnMouseDragged(event->{

            
            Command command =this.currentTool.onMouseDragged(drawingSurface,event.getX(), event.getY());
            if (command !=null)
                invoker.execute(command);
            event.consume();
        });

        drawingSurface.setOnMouseReleased(event->{


            
            Command command =this.currentTool.onMouseReleased(drawingSurface, event.getX(), event.getY());
            if (command !=null)
                invoker.execute(command);
            event.consume();
        });
        
    }


    
    /** 
     * @param fill
     * @param fillColor
     */
    public void setFill(boolean fill,Color fillColor){
        Command command =this.currentTool.setFill(fill, fillColor);
        if (command !=null)
                invoker.execute(command);
    }

    
    /** 
     * @param fillColor
     */
    public void setFillColor(Color fillColor){
        Command command =this.currentTool.setFillColor(fillColor);
        if (command !=null)
                invoker.execute(command);
    }

    
    /** 
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor){
        Command command =this.currentTool.setStrokeColor(strokeColor);
        if (command !=null)
                invoker.execute(command);
    }

    public void resetState(){
        this.currentTool.resetState(drawingSurface);  
    }

    
    /** 
     * @param currentTool
     */
    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
       
    }


    
    
}
