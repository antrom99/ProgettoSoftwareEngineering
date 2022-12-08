package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.ContextCommand;

import gruppo1.software_enginering.Command.MoveCommand;
import gruppo1.software_enginering.Command.ReDrawCommand;
import gruppo1.software_enginering.Command.SelectStrokeColor;
import gruppo1.software_enginering.Command.SelectionCommand;

import gruppo1.software_enginering.Command.SelectFillColor;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javafx.scene.shape.Shape;

public class Edit implements State{

    private SelectionModel selection = new SelectionModel();
    private boolean isRotate = false;
    private boolean isResize = false;
    private boolean isMove = false;
    private double x;
    private double y;
    private ContextMenu contextMenu = new ContextMenu();
    private boolean isContextMenu = false;
    private Pane drawingSurface;
    
    





    /** 
     * @param event
     * @param drawingSurface
     * @return Command
     */
    @Override
    public Command onMousePressed(MouseEvent event, Pane drawingSurface) {
        //state --> do Operation() 
        //if Move state = MOVE Command--ResetOperation
        //if Selection = SelectionCommand--ResetOperation
        //Context Menu = contextCommand -- Resetoperation
        //interface EditState = doOperation()--resetOperation
        //In Selection State if I click a shape with PrimaryButtonDown --> SelectionShapeCommand 
        //                   if I click a circle if a circle is resize --> changeStateResize -->do operation-->command Resize
        //                   if I click a circle if a circle is rotate --> changeStateRotate -->do operation-->command Rotate


        this.drawingSurface = drawingSurface;
        contextMenu.getItems().clear(); //reset dello state precedente --> implementato solo nel Context state
        
        //state.resetState()
        x = event.getX();//input per il drag
        y = event.getY();//input per il drag

        //check for context = isSecondaryButtonDown if currentState = contextState => resetState => memoria dello statocorrente


      
            
        Boolean check_for_context = (event.isSecondaryButtonDown() && isContextMenu==false ) && !(event.getTarget() instanceof Circle) && !(event.getTarget().equals(selection.getView_element())) && !(event.getTarget().equals(selection.getShape_element()));
        Boolean check_press_pivot = event.getTarget() instanceof Circle;
        isMove = false;
        isResize = false;
        isResize = false;
        if (check_for_context){

           isContextMenu = true;
           return new ContextCommand(selection, (Node) event.getTarget(), event.getScreenX(),event.getScreenY(), drawingSurface, contextMenu);

        }else {
            
            isContextMenu=false;
            if (check_press_pivot){
                Circle starter = (Circle) event.getTarget();
                    if (starter.equals(selection.getResizeCircle()))
                        isResize = true;
                     else
                        isRotate = true;
            }else{

                isMove = true;
                return new SelectionCommand(selection,(Node) event.getTarget(), drawingSurface);

            }

        }
        return null;

        //return null;
        
    }

    

    
    
    /** 
     * @param event
     * @return Command
     */
    @Override
    public Command onMouseDrag(MouseEvent event) {

        Shape shape_selected = selection.getShape_element();
        Rectangle view_current = selection.getView_element();

        if (isResize){

            //ShapeFactory shapeFactory = new ShapeFactory(shape_selected);
            //MyShape shape = shapeFactory.getShape();
            //shape.updateAttribute(event.getX(), event.getY());
            
            //shape_selected.resize(event.getX(), event.getY());
            //double resize=Math.abs()
           // shape.updateAttribute(selection.getView_element().getWidth()- event.getX(),selection.getView_element().getHeight()-event.getY() );
            
            return null;
            
        }else if(isRotate){
            
            return null;
        }else if (isMove){
            
            
            return new MoveCommand(shape_selected, view_current, event.getX(), event.getY(), x, y);
        }

        return null;
        
    }


    
    
    /** 
     * @param strokeColor
     * @return Command
     */
    @Override
    public Command selectStrokeColor(Color strokeColor) {
        //idle

        if(selection.getShape_element()!= null)
            return new SelectStrokeColor(selection.getShape_element(), strokeColor);

        return null;
    }

    
    /** 
     * @param fill_color
     * @return Command
     */
    @Override
    public Command selectFillColor(Color fill_color) {


        if(selection.getShape_element()!= null)
            return new SelectFillColor(selection.getShape_element(), fill_color);
        return null;
    }

    
    /** 
     * @param fill
     * @return Command
     */
    @Override
    public Command selectFill(boolean fill) {
        // Idle
        return null;
    }
    
    /** 
     * @param image
     */
    @Override
    public void setImageMODE(ImageView image){
        image.setImage(new Image(getClass().getResourceAsStream("Image_State/cursor2.png")));
    }

    
    /** 
     * @param image
     */
    @Override
    public void setImage(ImageView image) {
        // idle
        
    }

    
    /** 
     * @param drawingSurface
     */
    @Override
    public void resetMode(Pane drawingSurface) {
        this.selection.clear(drawingSurface);
        
    }

    
    /** 
     * @param event
     * @return Command
     */
    @Override
    public Command onMouseReleased(MouseEvent event) {

        //Se sono nello stato MOVE-- > allora 

        //strategy
        if(isMove){
            if (selection.getShape_element() !=null &&  !(selection.getShape_element() instanceof Circle)){

                if(selection.getShape_element().getTranslateX() != 0 || selection.getShape_element().getTranslateY()!= 0){
                    /*ShapeFactory shapeFactory = new ShapeFactory(selection.getShape_element());
                    MyShape shape = shapeFactory.getShape();
                    MyShape newShape = shape.cloneShape(); // da testare
                    drawingPane.getChildren().remove(shape.getShape());
                    Command command = new DrawCommand(newShape, drawingPane);
                    command.execute();
                    selection.setShape_element(newShape.getShape());
   
    
    */          
                    return new ReDrawCommand(selection, drawingSurface);


                   
                }
            }

        }

        
    
    return null;
}


}
