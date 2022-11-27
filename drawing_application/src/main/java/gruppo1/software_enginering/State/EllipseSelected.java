package gruppo1.software_enginering.State;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.DrawCommand;
//import gruppo1.software_enginering.Command.CommandDeprecati.DrawEllipseCommand;
import gruppo1.software_enginering.Shape.MyEllipse;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class EllipseSelected implements SelectionShape {

    @Override
    public Command makeDrawCommandShape(Point2D pressedPoint2d, Point2D releasedPoint2d, Color strokeColor,
            Color fillColor, boolean fill, GraphicsContext drawingSurface) {
        
        MyEllipse ellipse = new MyEllipse(pressedPoint2d, releasedPoint2d, fillColor, strokeColor,fill);
        
        //return new DrawEllipseCommand(ellipse, drawingSurface);
        return new DrawCommand(ellipse, drawingSurface);
    }

    @Override
    public void setImage(ImageView currentShape) {
        
        currentShape.setImage(new Image(getClass().getResourceAsStream("Image_State/ellipse.png")));
        
    }
    
}
