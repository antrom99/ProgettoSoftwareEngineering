package gruppo1.software_enginering.Shape;

//import javafx.geometry.Point2D;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class MyEllipse implements MyShape {

   
    private Ellipse myEllipse;
    private double pressedPoint_x;
    private double pressedPoint_y;
    public MyEllipse(double pressedPoint_x, double pressedPoint_y, Color strokeColor, Color fillColor, boolean isFill) {

        this.myEllipse = new Ellipse(pressedPoint_x, pressedPoint_y, 0, 0);
        this.pressedPoint_x = pressedPoint_x;
        this.pressedPoint_y = pressedPoint_y;
        if(isFill)
            this.myEllipse.setFill(fillColor);
        else
            this.myEllipse.setFill(null);
        this.myEllipse.setStroke(strokeColor);
        this.myEllipse.setStrokeWidth(3);
    }
    
    public void setRadiusY(double dragPoint_y){
        if(dragPoint_y<0) 
            dragPoint_y = 0;
        if(dragPoint_y>715)
            dragPoint_y=715;
        double radius_y = (dragPoint_y-this.getPressedPoint_y())/2;

        this.myEllipse.setCenterY(this.getPressedPoint_y()+radius_y);
        if(radius_y>0){
            
            this.myEllipse.setRadiusY(radius_y);
        }else{
            this.myEllipse.setRadiusY((this.getPressedPoint_y()-dragPoint_y)/2);
        }
    }

    public void setRadiusX(double dragPoint_x){
        if(dragPoint_x<0) 
            dragPoint_x = 0;
        if(dragPoint_x>773)
            dragPoint_x=773;
        double radius_x = (dragPoint_x-this.getPressedPoint_x())/2;

        this.myEllipse.setCenterX(this.getPressedPoint_x()+radius_x);
        if(radius_x>0){
            
            this.myEllipse.setRadiusX(radius_x);
        }else{
            this.myEllipse.setRadiusX((this.getPressedPoint_x()-dragPoint_x)/2);
        } 
    }

    public void setFillColor(Color fillColor){

        this.myEllipse.setFill(fillColor);

    }


    public void setStrokeColor(Color strokeColor){
        this.myEllipse.setStroke(strokeColor);
    }


    public Ellipse getMyEllipse() {
        return myEllipse;
    }


    public double getPressedPoint_x() {
        return pressedPoint_x;
    }


    public double getPressedPoint_y() {
        return pressedPoint_y;
    }

    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myEllipse);
        
    }

    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setRadiusX(dragPoint_x);
        this.setRadiusY(dragPoint_y);
        
    }

    /*private Ellipse myEllipse ;
    private Color fillColor;
    private Color strokeColor;
    private boolean fill;


    public MyEllipse() {
    }

    public MyEllipse(Point2D pressedPoint2D, Point2D releasedPoint2D, Color fillColor, Color strokeColor,
            boolean fill) {
        if ( releasedPoint2D.getY()<0)
            releasedPoint2D = new Point2D(releasedPoint2D.getX(), 0);
        if ( releasedPoint2D.getX()<0)
            releasedPoint2D = new Point2D( 0,releasedPoint2D.getY() ); 
        if ( releasedPoint2D.getY()>715)
            releasedPoint2D = new Point2D(releasedPoint2D.getX(), 715);
        if ( releasedPoint2D.getX()>793)
            releasedPoint2D = new Point2D( 793,releasedPoint2D.getY() );      
        this.myEllipse = new Ellipse(startPointforDrawing(pressedPoint2D, releasedPoint2D).getX(), startPointforDrawing(pressedPoint2D, releasedPoint2D).getY(), getWidth(pressedPoint2D, releasedPoint2D)/2, getHeigth(pressedPoint2D, releasedPoint2D)/2);
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.fill = fill;
    }
    // raggio lungo x
    public double getWidth(Point2D pressedPoint2D, Point2D releasedPoint2D){
        return Math.abs(pressedPoint2D.getX()-releasedPoint2D.getX());
    }
    // raggio lungo y
    public double getHeigth(Point2D pressedPoint2D, Point2D releasedPoint2D){

        return Math.abs(pressedPoint2D.getY()-releasedPoint2D.getY());

    }

    public Point2D startPointforDrawing(Point2D pressedPoint2D, Point2D releasedPoint2D){
        return new Point2D(Math.min(pressedPoint2D.getX(), releasedPoint2D.getX())+this.getWidth(pressedPoint2D,releasedPoint2D)/2, Math.min(pressedPoint2D.getY(), releasedPoint2D.getY())+this.getHeigth( pressedPoint2D, releasedPoint2D)/2);


    }



    @Override
    public void draw(/*GraphicsContext drawingSurface*//*  Pane drawingSurface) {

        
        myEllipse.setFill(null);
        myEllipse.setStroke(strokeColor);
        
        if(fill){
            myEllipse.setFill(fillColor);
            drawingSurface.getChildren().add(myEllipse);
        }else{
            drawingSurface.getChildren().add(myEllipse);
        }
        
        /*drawingSurface.setFill(fillColor);
        drawingSurface.setStroke(strokeColor);
        if(fill){
            drawingSurface.fillOval(this.startPointforDrawing().getX(), this.startPointforDrawing().getY(), this.getWidth(), this.getHeigth());
        }
        drawingSurface.strokeOval(this.startPointforDrawing().getX(), this.startPointforDrawing().getY(), this.getWidth(), this.getHeigth());*/
        
   /*  }


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
*/

}
