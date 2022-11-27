package gruppo1.software_enginering.State;

import gruppo1.software_enginering.Command.Command;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class SelectedShape {
    private SelectionShape shapeSelected;

    public SelectedShape(SelectionShape shapeSelected) {
        this.shapeSelected = shapeSelected;
    }

    public void changeSelectedShape(SelectionShape shapeSelected){
        this.shapeSelected = shapeSelected;
    }

    public Command makeDrawCommandShape(Point2D pressedPoint2d, Point2D releasedPoint2d, Color strokeColor,
            Color fillColor, boolean fill, GraphicsContext drawingSurface) {
                return this.shapeSelected.makeDrawCommandShape(pressedPoint2d, releasedPoint2d, strokeColor, fillColor, fill, drawingSurface);
            }

    public void setImage(ImageView currentShape){
        this.shapeSelected.setImage(currentShape);
    }

    public SelectionShape getShapeSelected() {
        return shapeSelected;
    }
}
