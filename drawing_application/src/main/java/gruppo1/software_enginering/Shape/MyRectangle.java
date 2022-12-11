package gruppo1.software_enginering.Shape;

import java.util.InputMismatchException;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * @author: Gruppo1 (Antonio Nocerino, Antonio Romano)
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

    public MyRectangle(String st){

        System.out.println(this.lineIsRectangle(st));
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

            System.out.println(st);
            throw new InputMismatchException();
        }
    }

    public MyRectangle(Rectangle rectangle) {
        this.myRectangle = rectangle;
        this.pressedPoint_x= rectangle.getX();
        this.pressedPoint_y = rectangle.getY();
        this.myRectangle.setFill(rectangle.getFill());
        this.myRectangle.setStroke(rectangle.getStroke());
        this.myRectangle.setStrokeWidth(rectangle.getStrokeWidth());
    }

   

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
     * @param fillColor
     */
    public void setFillColor(Color fillColor){

        this.myRectangle.setFill(fillColor);

    }


    
    /** 
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor){
        this.myRectangle.setStroke(strokeColor);
    }

    

    
    /** 
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
     * @param drawingSurface
     */
    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myRectangle);
        
        
    }

    
    /** 
     * @return Rectangle
     */
    public Rectangle getMyRectangle() {
        return myRectangle;
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
     * @param dragPoint_x
     * @param dragPoint_y
     */
    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setHeight(dragPoint_y);
        this.setWidth(dragPoint_x);
        
    }
   
   /** 
    * @return MyRectangle
    */
   /*  public MyRectangle(double x, double y, double width, double height){
        this.myRectangle = new Rectangle(x, y, width, height);
        this.
    }*/

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
                        //drawingPane.getChildren().remove(rect);
                        //drawingPane.getChildren().add(clone);
                        //selection.setShape_element(clone);
        
        
    }

    
    /** 
     * @return Shape
     */
    @Override
    public Shape getShape() {
        
        return this.getMyRectangle();
    }

    
    /** 
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