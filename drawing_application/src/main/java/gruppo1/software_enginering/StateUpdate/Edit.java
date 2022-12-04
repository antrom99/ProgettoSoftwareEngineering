package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.SelectionModel;
import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.ContextCommand;
import gruppo1.software_enginering.Command.MoveCommand;
//import gruppo1.software_enginering.Command.ResizeCommand;
import gruppo1.software_enginering.Command.SelectStrokeColor;
import gruppo1.software_enginering.Command.SelectionCommand;
import gruppo1.software_enginering.Command.SelectFillColor;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
//import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Shape;
import javafx.scene.shape.Shape;

public class Edit implements State{

    private SelectionModel selection = new SelectionModel();
   // private EditContext context_edit = new EditContext();
    private boolean isRotate = false;
    private boolean isResize = false;
    private boolean isMove = false;

    
    private double x;
    private double y;
    private ContextMenu contextMenu = new ContextMenu();
    private boolean isContextMenu = false;
   
    //double traslatex;
    //double traslatey;
    Pane drawingPane ;
    @Override
    public Command onMousePressed(MouseEvent event, Pane drawingSurface) {

        this.drawingPane = drawingSurface;

        contextMenu.getItems().clear();


        // SI DEVE CAMBIARE L'ARCHITETTURA QUESTO CODICE FUNZIONA SOLO

        if ((event.isSecondaryButtonDown() && isContextMenu==false ) && !(event.getTarget() instanceof Circle) && !(event.getTarget().equals(selection.getView_element())) && !(event.getTarget().equals(selection.getShape_element()))){

            //ContextMenu
            isResize = false;
            isRotate = false;
            isMove = false;
            isContextMenu = true;
            // create new contextmenu
            //return COMMAND on press  <-- di CONTEXT MENU
            
            return new ContextCommand(selection, event, drawingSurface, contextMenu);// Context Command
        }else {
            
            isContextMenu=false;
            if (event.getTarget() instanceof Circle){
                Circle starter = (Circle) event.getTarget();
                    if (starter.equals(selection.getResizeCircle())){
                        isResize = true;


                    //resize
                        
                    }else
                        isRotate = true;
                    

                    //rotate

                    return null;
            }else{
                isResize = false;
                isRotate = false;
                isMove = true;
                x = event.getX();
                y = event.getY();

                //context_edit.changeState(new SelectionState());
            
                //return context_edit.onMousePressed(event, drawingSurface);
                return new SelectionCommand(selection,(Node) event.getTarget(), drawingSurface);

            }

        }
       
        
        //select shape from Canvas
        
    }

    //Shape selected_shape1 ;
    @Override
    public Command onMouseDrag(MouseEvent event) {

        

        if (isResize){
            //resize
            return null;
            //return null;
            //return new ResizeCommand(selection.getShape_element(), selection.getResizeCircle(), event, x, y);
        }else if(isRotate){
            //rotate
            return null;
        }else if (isMove){
            //move 
            Shape shape_selected = selection.getShape_element();
            Rectangle view_current = selection.getView_element();
            return new MoveCommand(shape_selected, view_current, event, x, y);
        }
        return null;
    }

    @Override
    public Command selectStrokeColor(Color strokeColor) {
        //idle

        if(selection.getShape_element()!= null)
            return new SelectStrokeColor(selection.getShape_element(), strokeColor);

        return null;
    }

    @Override
    public Command selectFillColor(Color fill_color) {


        if(selection.getShape_element()!= null)
            return new SelectFillColor(selection.getShape_element(), fill_color);
        return null;
    }

    @Override
    public Command selectFill(boolean fill) {
        // Idle
        return null;
    }
    @Override
    public void setImageMODE(ImageView image){
        image.setImage(new Image(getClass().getResourceAsStream("Image_State/cursor2.png")));
    }

    @Override
    public void setImage(ImageView image) {
        // idle
        
    }

    @Override
    public void resetMode(Pane drawingSurface) {
        this.selection.clear(drawingSurface);
        
    }

    @Override
    public Command onMouseReleased(MouseEvent event) {

        //Se sono nello stato MOVE-- > allora 

        //strategy
        if(isMove){
            if (selection.getShape_element() !=null &&  !(selection.getShape_element() instanceof Circle)){

                if(selection.getShape_element().getTranslateX() != 0 || selection.getShape_element().getTranslateY()!= 0){

                    if (selection.getShape_element() instanceof Rectangle){
                        Rectangle rect = (Rectangle) selection.getShape_element();
                        double offset_x = rect.getX()+rect.getTranslateX();
                        double offset_y = rect.getY()+rect.getTranslateY();
                        Rectangle rect_move = new Rectangle(offset_x,offset_y, rect.getWidth(), rect.getHeight());
                        rect_move.setFill(rect.getFill());
                        rect_move.setStroke(rect.getStroke());
                        rect_move.setStrokeWidth(rect.getStrokeWidth());
                        drawingPane.getChildren().remove(rect);
                        drawingPane.getChildren().add(rect_move);
                        selection.setShape_element(rect_move);
        
                    }
                    if (selection.getShape_element() instanceof Line){
                        Line line = (Line) selection.getShape_element();
                        Line line_move = new Line(line.getStartX()+line.getTranslateX(), line.getStartY()+line.getTranslateY(),line.getEndX()+line.getTranslateX(),line.getEndY()+line.getTranslateY());
                        line_move.setStroke(line.getStroke());
                        line_move.setStrokeWidth(line.getStrokeWidth());
                        drawingPane.getChildren().remove(line);
                        drawingPane.getChildren().add(line_move);
                        selection.setShape_element(line_move);
        
        
        
                    }
                    if (selection.getShape_element() instanceof Ellipse){
                        Ellipse ellipse= (Ellipse) selection.getShape_element();
                        double offset_x =ellipse.getCenterX()+ellipse.getTranslateX();
                        double offset_y = ellipse.getCenterY()+ellipse.getTranslateY();
                        Ellipse ellipse_move = new Ellipse(offset_x,offset_y, ellipse.getRadiusX(), ellipse.getRadiusY());
                        ellipse_move.setFill(ellipse.getFill());
                        ellipse_move.setStroke(ellipse.getStroke());
                        ellipse_move.setStrokeWidth(ellipse.getStrokeWidth());
                        drawingPane.getChildren().remove(ellipse);
                        drawingPane.getChildren().add(ellipse_move);
                        selection.setShape_element(ellipse_move);
                        
                    }
                }
            }

    }

        
    
    return null;
}


}
