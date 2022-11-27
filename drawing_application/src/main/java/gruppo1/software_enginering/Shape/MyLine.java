package gruppo1.software_enginering.Shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine implements MyShape{

    private Point2D pressedPoint2D;
    private Point2D releasedPoint2D;
    private Color strokeColor;


    


    public MyLine(Point2D pressedPoint2D, Point2D releasedPoint2D, Color strokeColor) {
        this.pressedPoint2D = pressedPoint2D;
        this.releasedPoint2D = releasedPoint2D;
        this.strokeColor = strokeColor;
    }



    
    
    
    @Override
    public void draw(GraphicsContext drawingSurface) {
        
        drawingSurface.setStroke(this.strokeColor);
        
        drawingSurface.strokeLine(this.pressedPoint2D.getX(), this.pressedPoint2D.getY(), this.releasedPoint2D.getX(), this.releasedPoint2D.getY());
    }






    public Point2D getPressedPoint2D() {
        return pressedPoint2D;
    }






    public void setPressedPoint2D(Point2D pressedPoint2D) {
        this.pressedPoint2D = pressedPoint2D;
    }






    public Point2D getReleasedPoint2D() {
        return releasedPoint2D;
    }






    public void setReleasedPoint2D(Point2D releasedPoint2D) {
        this.releasedPoint2D = releasedPoint2D;
    }






    public Color getStrokeColor() {
        return strokeColor;
    }






    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }


    
}
