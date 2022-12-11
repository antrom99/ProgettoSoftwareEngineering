package gruppo1.software_enginering.State_Improve;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.ContextCommand;
import gruppo1.software_enginering.Command.Invoker;
import gruppo1.software_enginering.Command.SelectFillColor;
import gruppo1.software_enginering.Command.SelectStrokeColor;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ToolContextMenu implements Tool{

    private ContextMenu contextMenu = new ContextMenu(); 
    private SelectionModel selection= new SelectionModel();
    private ToolContext toolContext;
    private Invoker invoker;
    

    public ToolContextMenu(Invoker invoker, ToolContext toolContext, Node node , double scene_x, double scene_y, Pane drawinSurface) {

      
        this.toolContext = toolContext;
        this.invoker = invoker;
        Command command = new ContextCommand(selection, node,  scene_x, scene_y, drawinSurface, contextMenu);
        invoker.execute(command);



    }



    
    /** 
     * @param drawingSurface
     * @param node
     * @param pressed_x
     * @param pressed_y
     * @return Command
     */
    @Override
    public Command onMousePressed(Pane drawingSurface, Node node, double pressed_x, double pressed_y) {


        //roolback
        contextMenu.getItems().clear();
        selection.clear(drawingSurface);
        toolContext.setCurrentTool(new ToolEdit(invoker, drawingSurface, toolContext));
        return null;
    }


    
    /** 
     * @param fillColor
     * @return Command
     */
    @Override
    public Command setFillColor(Color fillColor) {

        Command command = new SelectFillColor(selection.getShape_element(), fillColor);
        return command;
        
    }


    
    /** 
     * @param strokeColor
     * @return Command
     */
    @Override
    public Command setStrokeColor(Color strokeColor) {
        Command command = new SelectStrokeColor(selection.getShape_element(), strokeColor);
        return command;
        
    }


    
    /** 
     * @param isFill
     * @param fillColor
     * @return Command
     */
    @Override
    public Command setFill(boolean isFill,Color fillColor) {
        Command command;
        if (isFill)
            command = new SelectFillColor(selection.getShape_element(),fillColor);
        else{
            command = new SelectFillColor(selection.getShape_element(),null);
                
        }
        return command; 
    }
    
}
