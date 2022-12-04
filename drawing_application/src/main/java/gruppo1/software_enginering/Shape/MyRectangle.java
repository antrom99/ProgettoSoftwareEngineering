package gruppo1.software_enginering.Shape;

//import java.math.MathContext;

//import javafx.geometry.Point2D;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Shape;


public class MyRectangle implements MyShape  {
    Rectangle myRectangle;
    private double pressedPoint_x;
    private double pressedPoint_y;

    public MyRectangle(double pressedPoint_x, double pressedPoint_y, Color strokeColor, Color fillColor, boolean isFill) {
        this.myRectangle = new Rectangle(pressedPoint_x, pressedPoint_y, 0, 0);
        this.pressedPoint_x = pressedPoint_x;
        this.pressedPoint_y = pressedPoint_y;
        if(isFill)
            this.myRectangle.setFill(fillColor);
        else
            this.myRectangle.setFill(null);
        this.myRectangle.setStroke(strokeColor);
        this.myRectangle.setStrokeWidth(3);
    }

    public void setFillColor(Color fillColor){

        this.myRectangle.setFill(fillColor);

    }


    public void setStrokeColor(Color strokeColor){
        this.myRectangle.setStroke(strokeColor);
    }

    

    public void setHeight(double dragPoint_y){
        if(dragPoint_y<0) 
            dragPoint_y = 0;
        if(dragPoint_y>715)
            dragPoint_y=715;

        double offset_y = dragPoint_y-this.getPressedPoint_y();
        if(offset_y>0)
            this.myRectangle.setHeight(offset_y);
        else{
            this.myRectangle.setY(dragPoint_y);
            this.myRectangle.setHeight(this.pressedPoint_y-dragPoint_y);
        }

    }

    public void setWidth(double dragPoint_x){
        if(dragPoint_x<0)
            dragPoint_x=0;
        if(dragPoint_x>773)
            dragPoint_x=773;
        double offset_x = dragPoint_x-this.getPressedPoint_x();
        if(offset_x>0)
            this.myRectangle.setWidth(offset_x);
        else{
            this.myRectangle.setX(dragPoint_x);
            this.myRectangle.setWidth(this.getPressedPoint_x()-dragPoint_x);
        }
    }

    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myRectangle);
        
        
    }

    public Rectangle getMyRectangle() {
        return myRectangle;
    }

    public double getPressedPoint_x() {
        return pressedPoint_x;
    }

    public double getPressedPoint_y() {
        return pressedPoint_y;
    }

    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setHeight(dragPoint_y);
        this.setWidth(dragPoint_x);
        
    }

    

    


    
   


    /*public MyRectangle() {
    }

    public MyRectangle(Point2D pressedPoint2D, Point2D releasedPoint2D, Color fillColor, Color strokeColor,
            boolean fill) {
      
        this.myRectangle = new Rectangle(startPointforDrawing(pressedPoint2D, releasedPoint2D).getX(), startPointforDrawing(pressedPoint2D, releasedPoint2D).getY(), getWidth(pressedPoint2D, releasedPoint2D), getHeigth(pressedPoint2D, releasedPoint2D));
        myRectangle.setStroke(strokeColor);
        myRectangle.setFill(Color.TRANSPARENT);
        if (fill){
            myRectangle.setFill(fillColor);
        }
    }

    public double getWidth(Point2D pressedPoint2D, Point2D releasedPoint2D){
        return Math.abs(pressedPoint2D.getX()-releasedPoint2D.getX());
    }

    public double getHeigth(Point2D pressedPoint2D, Point2D releasedPoint2D){

        return Math.abs(pressedPoint2D.getY()-releasedPoint2D.getY());

    }

    public Point2D startPointforDrawing(Point2D pressedPoint2D, Point2D releasedPoint2D){ 

        if ( releasedPoint2D.getY()<0)
             releasedPoint2D = new Point2D(releasedPoint2D.getX(), 0);
        if ( releasedPoint2D.getX()<0)
             releasedPoint2D = new Point2D( 0,releasedPoint2D.getY() ); 
        return new Point2D(Math.min(pressedPoint2D.getX(), releasedPoint2D.getX()), Math.min(pressedPoint2D.getY(), releasedPoint2D.getY()));
    }


  

    @Override
    public void draw(/*GraphicsContext drawingSurface*/ /*Pane drawingSurface) {
        
        drawingSurface.getChildren().add(myRectangle);
        
    }

    public Rectangle getMyRectangle() {
        return myRectangle;
    }*/
    

  
}