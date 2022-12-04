package gruppo1.software_enginering.Command;

/*import gruppo1.software_enginering.SelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.NonInvertibleTransformException;*/

public class ResizeCommand implements Command {

    /*private Shape shape ;
    private Circle resizeCircle;
    private MouseEvent event;
    private double x;
    private double y;

   
    

    

    public ResizeCommand(Shape shape, Circle resizeCircle, MouseEvent event, double x, double y) {
        this.shape = shape;
        this.resizeCircle = resizeCircle;
        this.event = event;
        this.x = x;
        this.y = y;
    }*/

    

    @Override
    public void execute() {

       /*  double release_x = event.getX()-x;
        double release_y = event.getY()-y;
        if(resizeCircle != null){
            if(resizeCircle.getCenterX()+release_x>773)
                release_x = 773-resizeCircle.getCenterX();
            if(resizeCircle.getCenterX()+release_x<0)
                release_x = -resizeCircle.getCenterX();
            if(resizeCircle.getCenterY()+release_y>715)
                release_y = 715-resizeCircle.getCenterY();
            if(resizeCircle.getCenterY()+release_y<0)
                release_y = -resizeCircle.getCenterY()+26;
            }

            if(shape instanceof Rectangle){

                Rectangle rect = (Rectangle) shape;
                rect.setX(rect.getX()+release_x);
                rect.setY(rect.getY()+release_y);

            }
            if (shape instanceof Ellipse){

                Ellipse ellipse = (Ellipse) shape;
                ellipse.setCenterX(ellipse.getCenterX()+release_x);
                ellipse.setCenterY(ellipse.getCenterY()+release_y);


            }
            if (shape instanceof Line){

                Line line = (Line) shape;
                line.setStartX(line.getStartX()+release_x);
                line.setStartY(line.getStartY()+release_y);
                
            }*/

        
       //selection.getShape_element().setLayoutX(selection.getShape_element().);
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
