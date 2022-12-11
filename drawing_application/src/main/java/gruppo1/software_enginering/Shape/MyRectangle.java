package gruppo1.software_enginering.Shape;

import java.util.InputMismatchException;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * @author Gruppo1 
 * <p>
 * The class MyRectangle implements the interface MyShape and implemented the abstract method.
 * In this class is used the principles of composition over inheritance it is 
 * the principle that classes should achieve polymorphic behavior and code reuse by their composition.
 * <p><!-- -->
 */
public class MyRectangle implements MyShape  {
    Rectangle myRectangle;
    private double pressedPoint_x;
    private double pressedPoint_y;


    /**
     * <p>
     * Costructor of MyRectangle
     * 
     * 
     * This is the costructor of MyRectangle with  a  String st like a input parameter. 
     * This method verify that the string st is a string that rappresent a Rectangle,
     * if this check is passed then it discover the parameter for create a rectangle from a string and create it 
     * else it throws InputMismatchExeption
     * 
     * <p><!-- -->
     * @param st
     * 
     * 
     */ 

    public MyRectangle(String st){

        
        if (this.lineIsRectangle(st)){
            String split[];
            st = st.replace("[","");
            st=st.replace("]", "");
            st=st.replace("=", "");
            st=st.replace(" ", "");
            st=st.replace("strokeWidth", "");        
            st=st.replace("stroke", "");
            st=st.replace("Rectangle", " ");
            st=st.replaceFirst("x", "");
            st=st.replace("y", "");
            st=st.replace("width", "");
            st=st.replace("height", "");
            st=st.replace("fill", "");


            split=st.split(",");
            System.out.println(split.toString());

            this.myRectangle= new Rectangle(Double.parseDouble(split[0]), Double.parseDouble(split[1]),Double.parseDouble(split[2]), Double.parseDouble(split[3]));
            this.pressedPoint_x = Double.parseDouble(split[0]);
            this.pressedPoint_y = Double.parseDouble(split[1]);

            if(split[4].contains("null")){

                this.myRectangle.setFill(null);

            }else{

                this.myRectangle.setFill(Paint.valueOf(split[4]));
            }


            this.myRectangle.setStroke(Paint.valueOf(split[5]));
            this.myRectangle.setStrokeWidth(Double.parseDouble(split[6]));
        }else {

            
            throw new InputMismatchException();
        }
    }

    /**
     * <p>
     * 
     * This is a constructor for myRectangle with a type Rectangle (Javafx) as input parameter. 
     * This method create an object of a class MyRectngle with Rectangle parameter in this way MyRectangle 
     * can encapsulate the object Rectangle.
     * 
     * <p><!-- -->
     * @param rectangle
     */ 

    public MyRectangle(Rectangle rectangle) {
        this.myRectangle = rectangle;
        this.pressedPoint_x= rectangle.getX();
        this.pressedPoint_y = rectangle.getY();
        this.myRectangle.setFill(rectangle.getFill());
        this.myRectangle.setStroke(rectangle.getStroke());
        this.myRectangle.setStrokeWidth(rectangle.getStrokeWidth());
    }

   
    /**
    * <p>
    * 
    * This is a constructor for myRectangle with  pressedPoint_x,  pressedPoint_y, strokeColor, fillColor, isFill as input parameter.
    * This method create an object of a class MyRectngle with point(pressedPoint_x, pressedPoint_y) as upper corner point of the rectangle 
    * with strokeColor, if isFill is true with fillColor and with strokeWidth=3. The MyRectangle create have height and width equals to 0
    * <p><!-- -->
    *@param pressedPoint_x  
    *@param pressedPoint_y
    *@param strokeColor
    *@param fillColor
    *@param isFill
    *
    *
    */
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

    
    /** 
     * <p>
     * Method to set the fillColor of a MyRectangle
     * <p><!-- -->
     * @param fillColor
     */
    public void setFillColor(Color fillColor){

        this.myRectangle.setFill(fillColor);

    }


    
    /** 
     * <p>
     * Method to set the strokeColor of a MyRectangle
     * <p><!-- -->
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor){
        this.myRectangle.setStroke(strokeColor);
    }

    

    
    /** 
     * <p>
     * Method to set the Height of MyRectangle respect the y coordinate of the dragPoint. This method verify if the coordinate y of
     * a dragPoint is a coordinate of a Drawing Surface else set it in the Drawing Surface and calculate the Heigth for MyRectangle and set it.
     * <p><!-- -->
     * @param dragPoint_y
     */
    public void setHeight(double dragPoint_y){
        if(dragPoint_y<0) 
            dragPoint_y = 0;
        if(dragPoint_y>710)
            dragPoint_y=710;

        double offset_y = dragPoint_y-this.getPressedPoint_y();
        if(offset_y>0)
            this.myRectangle.setHeight(offset_y);
        else{
            this.myRectangle.setY(dragPoint_y);
            this.myRectangle.setHeight(this.pressedPoint_y-dragPoint_y);
        }

    }

    
    /** 
     * 
     * <p>
     * Method to set the Width  of MyRectangle respect the  x coordinate of the dragPoint. This method verify if the coordinate x of
     * a dragPoint is a coordinate  of a Drawing Surface else set it in the Drawing Surface and calculate the Width for MyRectangle and set it.
     * <p><!-- -->
     * @param dragPoint_x
     */
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

    
    /** 
     * <p>
     * This method perform the operation of drawing of a MyRectangle on drawing surface
     * <p><!-- -->
     * @param drawingSurface
     */
    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myRectangle);
        
        
    }

    
    /** 
     * <p>
     * Method to get the attribure myRectangle of the object 
     * <p><!-- -->
     * @return Rectangle
     */
    public Rectangle getMyRectangle() {
        return myRectangle;
    }

    
    /** 
     * <p>
     * Method to get the attribure pressedPoint_x_ of the object  that rappresent the coordinate x of the upper left corner of the object Rectangle
     * <p><!-- -->
     * @return double
     */
    public double getPressedPoint_x() {
        return pressedPoint_x;
    }

    
    /** 
     * <p>
     * Method to get the attribure pressedPoint_y of the object  that rappresent the coordinate y the upper left corner of the object Rectangle
     * <p><!-- -->
     * @return double
     */
    public double getPressedPoint_y() {
        return pressedPoint_y;
    }

    
    /** 
     * 
     * <p>
     * Method for updating the arrtibute of MyRectangle respect the coordinate x,y of a drag Point
     * <p><!-- -->
     * @param dragPoint_x
     * @param dragPoint_y
     */
    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setHeight(dragPoint_y);
        this.setWidth(dragPoint_x);
        
    }
   
   /** 
    * <p>
    *Method for cloning the object MyRectangle, it create other MyRectangle that have the same parameter.
    <p><!-- -->
    * @return MyRectangle
    */


    @Override
    public MyRectangle cloneShape() {

                        
                        double offset_x = this.myRectangle.getX()+this.myRectangle.getTranslateX();
                        double offset_y = this.myRectangle.getY()+this.myRectangle.getTranslateY();
                        Rectangle shapeForCopy = new Rectangle(offset_x,offset_y, this.myRectangle.getWidth(), this.myRectangle.getHeight());
                        
                        shapeForCopy.setStroke(this.myRectangle.getStroke());
                        shapeForCopy.setFill(this.myRectangle.getFill());
                        shapeForCopy.setStrokeWidth(this.myRectangle.getStrokeWidth());
                        MyRectangle clone = new MyRectangle(shapeForCopy);
                        
                        return clone;
                        
        
        
    }

    
    /** 
     * 
     * <p>
     * 
     * Method to get Shape that compose MyRectangle
     * 
     * <p><!-- -->
     * @return Shape
     */
    @Override
    public Shape getShape() {
        
        return this.getMyRectangle();
    }

    
    /** 
     * 
     * <p>
     *
     * This method return the Rectangle that rappresented the scene of the MyRectangle
     *  
     * <p><!-- -->
     * @return Rectangle
     */
    @Override
    public Rectangle view() {
        Rectangle rect = new Rectangle(this.myRectangle.getX()-3, this.myRectangle.getY()-3, this.myRectangle.getWidth()+6, this.myRectangle.getHeight()+6);
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
     * 
     * <p>
     * This method verify if a string lineCurrent rappresent a myRectangle
     * <p><!-- -->
     * @param lineCurrent
     * @return boolean
     */
    public boolean lineIsRectangle(String lineCurrent) {
        String [] split=lineCurrent.split(",");
        String check;
        if(split.length == 7 && split[0].startsWith("Rectangle")){

            if(split[0].startsWith("Rectangle[x=")){
              check = split[0].replace("Rectangle[x=", "");
  
              try {
                Double.parseDouble(check);
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[0] RECTANGLE");
                return false;
              }
  
            }else{
              return false;
            }
  
            if(split[1].startsWith(" y=")){
              check = split[1].replace(" y=", "");
  
              try {
                Double.parseDouble(check);
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[1] RECTANGLE");
                return false;
              }
  
            }else{
              return false;
            }
  
  
            if(split[2].startsWith(" width=")){
              check = split[2].replace(" width=", "");
  
              try {
                Double.parseDouble(check);
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[2] RECTANGLE");
                return false;
              }
  
            }else{
              return false;
            }
  
  
            if(split[3].startsWith(" height=")){
              check = split[3].replace(" height=", "");
  
              try {
                Double.parseDouble(check);
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[3] RECTANGLE");
                return false;
              }
  
            }else{
              return false;
            }
  
  
  
            if(split[4].startsWith(" fill=")){
              check = split[4].replace(" fill=", "");
  
              try {
                if(!check.contains("null"))  
                   Paint.valueOf(check);
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[4] RECTANGLE");
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
                System.out.println("ECCEZIONE DOUBLE GESITA split[5] RECTANGLE");
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
                System.out.println("ECCEZIONE DOUBLE GESITA split[6] RECTANGLE");
                return false;
              }
  
            }else{
              return false;
            }
  
  
            //check superati
  
            return true;
  
          }
          return false;
    }
  


    
  
}