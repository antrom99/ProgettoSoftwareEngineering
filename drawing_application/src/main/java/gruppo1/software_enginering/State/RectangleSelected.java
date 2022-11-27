package gruppo1.software_enginering.State;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.DrawCommand;
//import gruppo1.software_enginering.Command.CommandDeprecati.DrawRectangleCommand;
import gruppo1.software_enginering.Shape.MyRectangle;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class RectangleSelected implements SelectionShape {

    

    @Override
    public Command makeDrawCommandShape(Point2D pressedPoint2d, Point2D releasedPoint2d, Color strokeColor,
            Color fillColor, boolean fill, GraphicsContext drawingSurface) {
        
        MyRectangle rectangle = new MyRectangle(pressedPoint2d, releasedPoint2d, fillColor, strokeColor, fill);
        
        //return new DrawRectangleCommand(rectangle, drawingSurface);
        return new DrawCommand(rectangle, drawingSurface);
    }

    @Override
    public void setImage(ImageView currentShape) {
        
        currentShape.setImage(new Image(getClass().getResourceAsStream("Image_State/rectangle.png")));
        
    }
    
}
