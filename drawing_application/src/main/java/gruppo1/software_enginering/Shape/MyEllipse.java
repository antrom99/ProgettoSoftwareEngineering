package gruppo1.software_enginering.Shape;

import javafx.geometry.Point2D;
//import javafx.geometry.Point2D;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class MyEllipse implements MyShape {

   
    private Ellipse myEllipse;
    private double pressedPoint_x;
    private double pressedPoint_y;


    /**
     * @param ellipse
     */
    public MyEllipse (Ellipse ellipse){
        this.myEllipse = ellipse;
        this.pressedPoint_x= ellipse.getCenterX();
        this.pressedPoint_y = ellipse.getCenterY();
        this.myEllipse.setFill(ellipse.getFill());
        this.myEllipse.setStroke(ellipse.getStroke());
        this.myEllipse.setStrokeWidth(ellipse.getStrokeWidth());

    }

    /**
     * @param st
     */
    public MyEllipse(String st){

        String[] split;

        st=st.replace("Ellipse", "");
                    st=st.replace("centerX", "");
                    st=st.replace("centerY", "");
                    st=st.replace("radiusX", "");
                    st=st.replace("radiusY", "");
                    st=st.replace("fill", "");
                    st=st.replace("width", "");


                    split=st.split(",");

                    this.myEllipse = new Ellipse(Double.parseDouble(split[0]), Double.parseDouble(split[1]),Double.parseDouble(split[2]), Double.parseDouble(split[3]));
                    this.pressedPoint_x=Double.parseDouble(split[0]);
                    this.pressedPoint_y= Double.parseDouble(split[1]);

                    if(split[4].contains("null")){

                        this.myEllipse.setFill(null);

                    } else{

                        this.myEllipse.setFill(Paint.valueOf(split[4]));
                    }

                        

                    this.myEllipse.setStroke(Paint.valueOf(split[5]));
                    this.myEllipse.setStrokeWidth(Double.parseDouble(split[6]));


    }
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
    
    
    /** 
     * @param dragPoint_y
     */
    public void setRadiusY(double dragPoint_y){
        if(dragPoint_y<0) 
            dragPoint_y = 0;
        if(dragPoint_y>670)
            dragPoint_y=670;
        double radius_y = (dragPoint_y-this.getPressedPoint_y())/2;

        this.myEllipse.setCenterY(this.getPressedPoint_y()+radius_y);
        if(radius_y>0){
            
            this.myEllipse.setRadiusY(radius_y);
        }else{
            this.myEllipse.setRadiusY((this.getPressedPoint_y()-dragPoint_y)/2);
        }
    }

    
    /** 
     * @param dragPoint_x
     */
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

    
    /** 
     * @param fillColor
     */
    public void setFillColor(Color fillColor){

        this.myEllipse.setFill(fillColor);

    }


    
    /** 
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor){
        this.myEllipse.setStroke(strokeColor);
    }


    
    /** 
     * @return Ellipse
     */
    public Ellipse getMyEllipse() {
        return myEllipse;
    }


    
    /** 
     * @return double
     */
    public double getPressedPoint_x() {
        return pressedPoint_x;
    }


    
    /** 
     * @return double
     */
    public double getPressedPoint_y() {
        return pressedPoint_y;
    }

    
    /** 
     * @param drawingSurface
     */
    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myEllipse);
        
    }

    
    /** 
     * @param dragPoint_x
     * @param dragPoint_y
     */
    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setRadiusX(dragPoint_x);
        this.setRadiusY(dragPoint_y);
        
    }

    
    /** 
     * @return MyShape
     */
    @Override
    public MyShape cloneShape() {
        double offset_x = this.myEllipse.getCenterX()+this.myEllipse.getTranslateX();
        double offset_y = this.myEllipse.getCenterY()+this.myEllipse.getTranslateY();
        Ellipse shapeForCopy = new Ellipse(offset_x, offset_y, this.myEllipse.getRadiusX(), this.myEllipse.getRadiusY());
        shapeForCopy.setStroke(this.myEllipse.getStroke());
        shapeForCopy.setFill(this.myEllipse.getFill());
        shapeForCopy.setStrokeWidth(this.myEllipse.getStrokeWidth());
        MyEllipse clone = new MyEllipse(shapeForCopy);
        return clone;
    }

    
    /** 
     * @return Shape
     */
    @Override
    public Shape getShape() {
        
        return this.getMyEllipse();
    }

    
    /** 
     * @return Rectangle
     */
    @Override
    public Rectangle view() {
        Rectangle rect = new Rectangle(this.myEllipse.getCenterX()-this.myEllipse.getRadiusX()-3, this.myEllipse.getCenterY()-this.myEllipse.getRadiusY()-3,this.myEllipse.getRadiusX()*2+6, this.myEllipse.getRadiusY()*2+6);
        rect.setStyle(
                    "-fx-stroke: blue; " +
                    "-fx-stroke-width: 2px; " +
                    "-fx-stroke-dash-array: 12 2 4 2; " +
                    "-fx-stroke-dash-offset: 6; " +
                    "-fx-stroke-line-cap: butt; " +
                    "-fx-fill: rgba(255, 255, 255, .0);"
        );

        return rect;
    }

   

    

   
}
