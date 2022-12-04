package gruppo1.software_enginering.Shape;

//import javafx.geometry.Point2D;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class MyLine implements MyShape{

    private Line myLine;

    public MyLine(double start_x, double start_y, Color strokeColor) {
        this.myLine =  new Line(start_x, start_y, start_x, start_y);
        this.myLine.setStroke(strokeColor);
        this.myLine.setStrokeWidth(3);
    }

    public void setStrokeColor(Color strokeColor){
        this.myLine.setStroke(strokeColor);
    }

    public void setEndX(double end_x){
        if(end_x<0)
            end_x = 0;
        if(end_x>773)
            end_x = 773;
        this.myLine.setEndX(end_x);
    }

    public void setEndY(double end_y){
        if(end_y<0)
            end_y = 0;
        if(end_y>715)
            end_y=715;
        this.myLine.setEndY(end_y);
    }

    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myLine);
        
    }

    public Line getMyLine() {
        return myLine;
    }

    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setEndX(dragPoint_x);
        this.setEndY(dragPoint_y);
        
    }
    

   /*  private Line myLine ;
    private Color strokeColor;


    


    public MyLine(Point2D pressedPoint2D, Point2D releasedPoint2D, Color strokeColor) {
        
        
            releasedPoint2D = new Point2D( 0,releasedPoint2D.getY() );
        this.myLine = new Line(pressedPoint2D.getX(), pressedPoint2D.getY(), releasedPoint2D.getX(), releasedPoint2D.getY());
        this.strokeColor = strokeColor;
    }



    
    
    
    @Override
    public void draw(/*GraphicsContext drawingSurface*/ /*Pane drawingSurface) {

        
        this.myLine.setStroke(strokeColor);
        drawingSurface.getChildren().add(this.myLine);
        /*drawingSurface.setStroke(this.strokeColor);
        //drawingSurface.setLineWidth(5);
        
        drawingSurface.strokeLine(this.pressedPoint2D.getX(), this.pressedPoint2D.getY(), this.releasedPoint2D.getX(), this.releasedPoint2D.getY());*/
   /*  }




    public Color getStrokeColor() {
        return strokeColor;
    }






    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }






    public Line getMyLine() {
        return myLine;
    }






    public void setMyLine(Line myLine) {
        this.myLine = myLine;
    }


    */
}
