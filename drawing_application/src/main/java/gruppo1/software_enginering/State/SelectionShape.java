package gruppo1.software_enginering.State;

import gruppo1.software_enginering.Command.Command;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public interface SelectionShape {
    public Command makeDrawCommandShape(Point2D pressedPoint2d, Point2D releasedPoint2d, Color strokeColor, Color fillColor, boolean fill, GraphicsContext drawingSurface);
    public void setImage(ImageView currentShape);
}
