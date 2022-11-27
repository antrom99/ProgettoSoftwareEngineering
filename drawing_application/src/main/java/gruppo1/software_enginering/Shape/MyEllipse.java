package gruppo1.software_enginering.Shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyEllipse implements MyShape {
    private Point2D pressedPoint2D;
    private Point2D releasedPoint2D;
    private Color fillColor;
    private Color strokeColor;
    private boolean fill;


    public MyEllipse() {
    }

    public MyEllipse(Point2D pressedPoint2D, Point2D releasedPoint2D, Color fillColor, Color strokeColor,
            boolean fill) {
        this.pressedPoint2D = pressedPoint2D;
        this.releasedPoint2D = releasedPoint2D;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.fill = fill;
    }

    public double getWidth(){
        return Math.abs(this.pressedPoint2D.getX()-this.releasedPoint2D.getX());
    }

    public double getHeigth(){

        return Math.abs(this.pressedPoint2D.getY()-this.releasedPoint2D.getY());

    }

    public Point2D startPointforDrawing(){
        return new Point2D(Math.min(this.pressedPoint2D.getX(), this.releasedPoint2D.getX()), Math.min(this.pressedPoint2D.getY(), this.releasedPoint2D.getY()));
    }



    @Override
    public void draw(GraphicsContext drawingSurface) {
        
        drawingSurface.setFill(fillColor);
        drawingSurface.setStroke(strokeColor);
        if(fill){
            drawingSurface.fillOval(this.startPointforDrawing().getX(), this.startPointforDrawing().getY(), this.getWidth(), this.getHeigth());
        }
        drawingSurface.strokeOval(this.startPointforDrawing().getX(), this.startPointforDrawing().getY(), this.getWidth(), this.getHeigth());
        
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

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }


}
