package gruppo1.software_enginering.State_Improve;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.Invoker;
import gruppo1.software_enginering.Command.MoveCommand;
import gruppo1.software_enginering.Command.ReDrawCommand;
import gruppo1.software_enginering.Command.SelectFillColor;
import gruppo1.software_enginering.Command.SelectStrokeColor;
import gruppo1.software_enginering.Command.SelectionCommand;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

//idea = stato di edit = nel costruttore --> istanzio l'immagine 
//devo sapere quale shape è stato selezionato

public class ToolSelection implements Tool {
    private SelectionModel selection = new SelectionModel();
    //private Node shape ;
    private double startx;
    private double start_y;
    private ToolContext toolContext;
    private Invoker invoker;

    
    

    public ToolSelection( Invoker invoker, ToolContext toolContext, double click_x, double click_y,Node shape, Pane drawingSurface) {

        this.startx=click_x;
        this.start_y=click_y;
        this.toolContext = toolContext;
        this.invoker = invoker;

        Command command  = new SelectionCommand(selection, shape, drawingSurface);
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

        
        
        
            this.resetState(drawingSurface);
            this.toolContext.setCurrentTool(new ToolEdit( invoker ,drawingSurface, toolContext));
            this.startx = pressed_x;
            this.start_y =pressed_y;
            return null;
        
    }
            
            

        
    
    


    
    /** 
     * @param drawingSurface
     * @param dragged_x
     * @param dragged_y
     * @return Command
     */
    @Override
    public Command  onMouseDragged(Pane drawingSurface, double dragged_x, double dragged_y) {
        if (selection.getShape_element() != null ){
           
            Command command =new MoveCommand(selection.getShape_element(), selection.getView_element(), dragged_x, dragged_y, this.startx, this.start_y);
            command.execute();
        
           
            
        }
        return null;
    }


    
    /** 
     * @param drawingSurface
     * @param released_x
     * @param released_y
     * @return Command
     */
    @Override
    public Command onMouseReleased(Pane drawingSurface, double released_x, double released_y) {

        
        if (selection.getShape_element() !=null){

            if(selection.getShape_element().getTranslateX() != 0 || selection.getShape_element().getTranslateY()!= 0){

                Command command = new ReDrawCommand(selection, drawingSurface);
                return command;

            }
        }

        return null;
       
    }


    
    /** 
     * @param drawingSurface
     */
    @Override
    public void resetState(Pane drawingSurface) {
        
        this.selection.clear(drawingSurface);
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
