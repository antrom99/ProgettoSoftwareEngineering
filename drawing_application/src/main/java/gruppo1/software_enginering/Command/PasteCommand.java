package gruppo1.software_enginering.Command;


import gruppo1.software_enginering.SelectionModel;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PasteCommand implements Command{

    private Shape shapeCopy;
    private Pane drawingSurface;
    private SelectionModel selection;















    public PasteCommand(Shape shapeCopy, Pane drawingSurface, SelectionModel selection){

        this.shapeCopy=shapeCopy;
        this.drawingSurface=drawingSurface;
        this.selection=selection;



    }


    @Override
    public void execute() {
        

        // PASTE LINE

        if( shapeCopy instanceof Line){

            Line line = (Line) shapeCopy;
            
            Line linePaste = new Line(line.getStartX(),line.getStartY(),line.getEndX(),line.getEndY());
            linePaste.setStroke(line.getStroke());
            linePaste.setStrokeWidth(line.getStrokeWidth());

            this.drawingSurface.getChildren().add(linePaste);

            Command command = new SelectionCommand(selection,shapeCopy, drawingSurface);
            command.execute();

        }

        // PASTE RECTANGLE

        if(shapeCopy instanceof Rectangle){

            Rectangle rectangle = (Rectangle) shapeCopy;

            Rectangle rectanglePaste = new Rectangle(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
            rectanglePaste.setStroke(rectangle.getStroke());
            rectanglePaste.setFill(rectangle.getFill());
            rectanglePaste.setStrokeWidth(rectangle.getStrokeWidth());

            drawingSurface.getChildren().add(rectanglePaste);

            Command command = new SelectionCommand(selection,shapeCopy, drawingSurface);
            command.execute();
            //selection.setShape_element(rectanglePaste); CHECK COLOR NOT CHANGE !!!

        }

        // PASTE ELLIPSE

        if(shapeCopy instanceof Ellipse){

            Ellipse ellipse = (Ellipse) shapeCopy;

            Ellipse ellipsePaste = new Ellipse(ellipse.getCenterX(),ellipse.getCenterY(),ellipse.getRadiusX(),ellipse.getRadiusY());
            ellipsePaste.setStroke(ellipse.getStroke());
            ellipsePaste.setFill(ellipse.getFill());
            ellipsePaste.setStrokeWidth(ellipse.getStrokeWidth());

            drawingSurface.getChildren().add(ellipsePaste);

            Command command = new SelectionCommand(selection,shapeCopy, drawingSurface);
            command.execute();
            
        }





        
    }

    @Override
    public void undo() {
        
        
    }
    
}
