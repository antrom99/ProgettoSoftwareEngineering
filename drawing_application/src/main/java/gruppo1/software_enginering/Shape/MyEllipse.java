package gruppo1.software_enginering.Shape;


import java.util.InputMismatchException;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * @author Gruppo1 
 * <p>
 * The class MyEllipse implements the interface MyShape and implemented the abstract method.
 * In this class is used the principles of composition over inheritance it is 
 * the principle that classes should achieve polymorphic behavior and code reuse by their composition.
 * <p><!-- -->
 */

public class MyEllipse implements MyShape {

   
    private Ellipse myEllipse;
    private double pressedPoint_x;
    private double pressedPoint_y;


    /**
     * <p>
     * 
     * This is a constructor for MyEllipse with a type Ellipse (Javafx) as input parameter. 
     * This method create an object of a class MyEllipse with Ellipse parameter in this way MyEllipse 
     * can encapsulate the object Ellipse.
     * 
     * <p><!-- -->
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
     * <p>
     * Costructor of MyEllipse
     * 
     * 
     * This is the costructor of MyEllipse with  a  String st like a input parameter. 
     * This method verify that the string st is a string that rappresent an Ellipse,
     * if this check is passed then it discover the parameter for create an Ellipse from a string and create it 
     * else it throws InputMismatchExeption
     * 
     * <p><!-- -->
     * @param st
     */
    public MyEllipse(String st){

        if(this.lineIsEllipse(st)){

            String[] split;
            st = st.replace("[","");
            st=st.replace("]", "");
            st=st.replace("=", "");
            st=st.replace(" ", "");
            st=st.replace("strokeWidth", "");        
            st=st.replace("stroke", "");
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
        }else 
            throw new InputMismatchException();


    }

    /**
     *  <p>
    * 
    * This is a constructor for MyEllipse with  pressedPoint_x,  pressedPoint_y, strokeColor, fillColor, isFill as input parameter.
    * This method create an object of a class MyRectngle with point(pressedPoint_x, pressedPoint_y) as center point of the Ellipse 
    * with strokeColor, if isFill is true with fillColor and with strokeWidth=3.The MyRectangle create have RadiousX and RadiousY equals to 0
    * <p><!-- -->
     * @param pressedPoint_x
     * @param pressedPoint_y
     * @param strokeColor
     * @param fillColor
     * @param isFill
     */
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
     * <p>
     * Method to set the RadiousY of MyEllipse respect the y coordinate of the dragPoint. This method verify if the coordinate y of
     * a dragPoint is a coordinate of a Drawing Surface else set it in the Drawing Surface and calculate the RadiousY for MyEllipse and set it.
     * <p><!-- --> 
     * @param dragPoint_y
     */
    public void setRadiusY(double dragPoint_y){
        if(dragPoint_y<0) 
            dragPoint_y = 0;
        if(dragPoint_y>710)
            dragPoint_y=710;
        double radius_y = (dragPoint_y-this.getPressedPoint_y())/2;

        this.myEllipse.setCenterY(this.getPressedPoint_y()+radius_y);
        if(radius_y>0){
            
            this.myEllipse.setRadiusY(radius_y);
        }else{
            this.myEllipse.setRadiusY((this.getPressedPoint_y()-dragPoint_y)/2);
        }
    }

    
    /** 
     * <p>
     * Method to set the RadiousX of MyRectangle respect the  x coordinate of the dragPoint. This method verify if the coordinate x of
     * a dragPoint is a coordinate  of a Drawing Surface else set it in the Drawing Surface and calculate the RadiousX for MyRectangle and set it.
     * <p><!-- --> 
     * 
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
     * <p>
     * Method to set the fillColor of a MyRectangle
     * <p><!-- --> 
     * @param fillColor
     */
    public void setFillColor(Color fillColor){

        this.myEllipse.setFill(fillColor);

    }


    
    /** 
     * <p>
     * Method to set the strokeColor of a MyEllipse
     * <p><!-- --> 
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor){
        this.myEllipse.setStroke(strokeColor);
    }


    
    /** 
     * <p>
     * Method to get the attribure myEllipse of the object 
     * <p><!-- -->
     * @return Ellipse
     */
    public Ellipse getMyEllipse() {
        return myEllipse;
    }


    
    /** 
     * <p>
     * Method to get the attribure pressedPoint_x_ of the object  that rappresent the coordinate x of the center of myEllipse
     * <p><!-- -->
     * @return double
     */
    public double getPressedPoint_x() {
        return pressedPoint_x;
    }


    
    /** 
     * <p>
     * Method to get the attribure pressedPoint_y of the object  that rappresent the coordinate y of the center of myEllipse
     * <p><!-- -->
     * @return double
     */
    public double getPressedPoint_y() {
        return pressedPoint_y;
    }

    
    /** 
     * <p>
     * This method perform the operation of drawing of a MyEllipse on drawing surface
     * <p><!-- -->
     * @param drawingSurface
     */
    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myEllipse);
        
    }

    
    /**
     * <p>
     * Method for updating the arrtibute of MyEllipse respect the coordinate x,y of a drag Point
     * <p><!-- -->  
     * @param dragPoint_x
     * @param dragPoint_y
     */
    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setRadiusX(dragPoint_x);
        this.setRadiusY(dragPoint_y);
        
    }

    
    /** 
     * <p>
     * Method for cloning the object MyEllipse, it create other MyEllipse that have the same parameter.
     * <p><!-- -->
     * 
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
     * 
     * <p>
     * 
     * Method to get Shape that compose MyEllipse
     * 
     * <p><!-- --> 
     * @return Shape
     */
    @Override
    public Shape getShape() {
        
        return this.getMyEllipse();
    }

    
    /** 
     * <p>
     *
     * This method return the Rectangle that rappresented the scene of the MyEllipse
     *  
     * <p><!-- -->
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



    
    /** 
     * <p>
     * This method verify if a string lineCurrent rappresent a myEllipse
     * <p><!-- -->
     * @param lineCurrent
     * @return boolean
     */
    public boolean lineIsEllipse(String lineCurrent) {
        String [] split=lineCurrent.split(",");
        String check;
   
        if(split.length == 7 && split[0].startsWith("Ellipse")){

            if(split[0].startsWith("Ellipse[centerX=")){
            check = split[0].replace("Ellipse[centerX=", "");

            try {
                Double.parseDouble(check);
            } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[0] ELLIPSE");
                return false;
            }

            }else{
            return false;
            }

            if(split[1].startsWith(" centerY=")){
            check = split[1].replace(" centerY=", "");

            try {
                Double.parseDouble(check);
            } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[1] ELLIPSE");
                return false;
            }

            }else{
            return false;
            }


            if(split[2].startsWith(" radiusX=")){
            check = split[2].replace(" radiusX=", "");

            try {
                Double.parseDouble(check);
            } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[2] ELLIPSE");
                return false;
            }

            }else{
            return false;
            }


            if(split[3].startsWith(" radiusY=")){
            check = split[3].replace(" radiusY=", "");

            try {
                Double.parseDouble(check);
            } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[3] ELLIPSE");
                return false;
            }

            }else{
            return false;
            }



            if(split[4].startsWith(" fill=")){
            check = split[4].replace(" fill=", "");

            try {
                if(!(split[4].contains("null")))
                Paint.valueOf(check);
            } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[4] ELLIPSE");
                return false;
            }

            }else{
            return false;
            }


            if(split[5].startsWith(" stroke=")){
            check = split[5].replace(" stroke=", "");

            try {
                Paint.valueOf(check);
            } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[5] ELLIPSE");
                return false;
            }

            }else{
            return false;
            }



            if(split[6].startsWith(" strokeWidth=") && split[6].endsWith("]")){
            split[6] = split[6].replace(" strokeWidth=", "");
            check = split[6].replace("]", "");

            try {
                Double.parseDouble(check);
            } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[6] ELLIPSe");
                return false;
            }

            }else{
            return false;
            }


            

            return true;


            

        }

        
        return false;
  }

   
}
