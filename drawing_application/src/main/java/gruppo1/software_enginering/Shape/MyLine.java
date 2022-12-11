package gruppo1.software_enginering.Shape;

import java.util.InputMismatchException;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * @author Gruppo1 
 * <p>
 * The class MyLine implements the interface MyShape and implemented the abstract method.
 * In this class is used the principles of composition over inheritance it is 
 * the principle that classes should achieve polymorphic behavior and code reuse by their composition.
 * <p><!-- -->
 */

public class MyLine implements MyShape{

    private Line myLine;

    /**
     * <p>
     * 
     * This is a constructor for myLine with a type Line (Javafx) as input parameter. 
     * This method create an object of a class MyLine with Line parameter in this way MyLine
     * can encapsulate the object Line.
     * 
     * <p><!-- -->
     * @param line
     */

    public MyLine(Line line){
        this.myLine = line;
        this.myLine.setStroke(line.getStroke());
        this.myLine.setStrokeWidth(line.getStrokeWidth());
    }

    /**
     *  <p>
     * Costructor of MyLine
     * 
     * 
     * This is the costructor of MyLine with  a  String st like a input parameter. 
     * This method verify that the string st is a string that rappresent a Line,
     * if this check is passed then it discover the parameter for create a Line from a string and create it 
     * else it throws InputMismatchExeption
     * 
     * <p><!-- -->
     * @param st
     */

    public MyLine(String st){
        if (this.lineIsLine(st)){
            String split[];
            st = st.replace("[","");
            st=st.replace("]", "");
            st=st.replace("=", "");
            st=st.replace(" ", "");
            st=st.replace("strokeWidth", "");        
            st=st.replace("stroke", "");
            st=st.replace("Line", " ");
            st=st.replace("startX", " ");
            st=st.replace("endY", " ");
            st=st.replace("endX", " ");
            st=st.replace("startY", " ");

            split=st.split(",");   

            this.myLine = new Line(Double.parseDouble(split[0]), 
            Double.parseDouble(split[1]),Double.parseDouble(split[2]), Double.parseDouble(split[3]));
            
            this.myLine.setStroke(Paint.valueOf(split[4]));
            this.myLine.setStrokeWidth(Double.parseDouble(split[5]));
            }else 
                throw new InputMismatchException();

    }

     /**
     *  <p>
     * 
     * This is a constructor for myLine with  start_x,  start_y, strokeColor as input parameter.
     * This method create an object of a class MyLine with point(start_x, start_y) as the start point of MyLine
     * with strokeColor. The MyLine create have length 0.
     * <p><!-- -->
     * @param start_x
     * @param start_y
     * @param strokeColor
     */

    public MyLine(double start_x, double start_y, Color strokeColor) {
        this.myLine =  new Line(start_x, start_y, start_x, start_y);
        this.myLine.setStroke(strokeColor);
        this.myLine.setStrokeWidth(3);
    }

    
    /** 
     * <p>
     * Method to set the strokeColor of a MyLine
     * <p><!-- --> 
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor){
        this.myLine.setStroke(strokeColor);
    }

    
    /** 
     * 
     * <p>
     * Method to set the coordinate x for the end point of the MyLine  respect the x coordinate of the dragPoint. This method verify if the coordinate x of
     * a dragPoint is a coordinate of a Drawing Surface else set it in the Drawing Surface and set it as the end_x coordinate.
     * <p><!-- -->
     * @param end_x
     */
    public void setEndX(double end_x){
        if(end_x<0)
            end_x = 0;
        if(end_x>773)
            end_x = 773;
        this.myLine.setEndX(end_x);
    }

    
    /** 
     * <p>
     * Method to set the coordinate y for the end point of the MyLine  respect the y coordinate of the dragPoint. This method verify if the coordinate y of
     * a dragPoint is a coordinate of a Drawing Surface else set it in the Drawing Surface and set it as the end_x coordinate.
     * <p><!-- -->
     * @param end_y
     */
    public void setEndY(double end_y){
        if(end_y<0)
            end_y = 0;
        if(end_y>710)
            end_y=710;
        this.myLine.setEndY(end_y);
    }

    
    /** 
     * <p>
     * This method perform the operation of drawing of a MyLine on drawing surface
     * <p><!-- -->
     * @param drawingSurface
     */
    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myLine);
        
    }

    
    /** 
     * <p>
     * Method to get the attribure myLine of the object 
     * <p><!-- -->
     * @return Line
     */
    public Line getMyLine() {
        return myLine;
    }

    
    /** 
     * <p>
     * Method for updating the arrtibute of MyLine respect the coordinate x,y of a drag Point
     * <p><!-- -->
     * @param dragPoint_x
     * @param dragPoint_y
     */
    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setEndX(dragPoint_x);
        this.setEndY(dragPoint_y);
        
    }

    
    /** 
     * 
     * <p>
     * Method for cloning the object MyLine, it create other MyLine that have the same parameter.
     * <p><!-- -->
     * @return MyLine
     */
    @Override
    public MyLine cloneShape() {

        double offsetx = this.myLine.getStartX()+this.myLine.getTranslateX();
        double offsety = this.myLine.getStartY()+this.myLine.getTranslateY();
        double x = this.myLine.getEndX()+this.myLine.getTranslateX();
        double y = this.myLine.getEndY()+this.myLine.getTranslateY();


        Line shapeForCopy = new Line(offsetx, offsety, x, y);

        shapeForCopy.setStroke(this.myLine.getStroke());
        shapeForCopy.setStrokeWidth(this.myLine.getStrokeWidth());
        MyLine clone = new MyLine(shapeForCopy);
        return clone;
        
    }

    
    /**
     * <p>
     * 
     * Method to get Shape that compose MyLine
     * 
     * <p><!-- --> 
     * @return Shape
     */
    @Override
    public Shape getShape() {
        
        return this.getMyLine();
    }

    
    /** 
     * <p>
     *
     * This method return the Rectangle that rappresented the scene of the MyLine
     *  
     * <p><!-- -->
     * @return Rectangle
     */
    @Override
    public Rectangle view() {
        
        Rectangle rect = new Rectangle(Math.min(this.myLine.getStartX(), this.myLine.getEndX())-3,Math.min(this.myLine.getStartY(), this.myLine.getEndY())-3, Math.abs(this.myLine.getStartX()-this.myLine.getEndX())+6, Math.abs(this.myLine.getStartY()-this.myLine.getEndY())+6);
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
     * This method verify if a string lineCurrent rappresent a myLine
     * <p><!-- -->
     * @param lineCurrent
     * @return boolean
     */
    public boolean lineIsLine(String lineCurrent) {
        String [] split=lineCurrent.split(",");
        String check;
        if(split.length == 6){//siamo in LINE



            if(split[0].startsWith("Line[startX=")){
              check = split[0].replace("Line[startX=", "");
  
              try {
                Double.parseDouble(check);
              } catch (NumberFormatException e) {
                System.out.println("ECCEZIONE DOUBLE GESITA");
                return false;
              }
  
            }else{
              return false;
            }
  
            if(split[1].startsWith(" startY=")){
              check = split[1].replace(" startY=", "");
  
              try {
  
                Double.parseDouble(check);
                
              } catch (NumberFormatException e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[1]");
                return false;
              }
  
            }else{
              return false;
            }
  
            if(split[2].startsWith(" endX=")){
              check = split[2].replace(" endX=", "");
  
              try {
                Double.parseDouble(check);
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[2]");
                return false;
              }
  
            }else{
              return false;
            }
  
            if(split[3].startsWith(" endY=")){
              check = split[3].replace(" endY=", "");
  
              try {
                Double.parseDouble(check);
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[3]");
                return false;
              }
  
            }else{
              return false;
  
            }
  
            if(split[4].startsWith(" stroke=")){
              check = split[4].replace(" stroke=", "");
  
              try {
                Paint.valueOf(check);  
              } catch (Exception e) {
                System.out.println("ECCEZIONE DOUBLE GESITA split[4]");
                return false;
              }
  
            }else{
              return false;
            }
  
            if(split[5].startsWith(" strokeWidth=") && split[5].endsWith("]")){
              split[5] = split[5].replace(" strokeWidth=", "");
              check = split[5].replace("]", "");
  
  
              try {
                Double.parseDouble(check);
              } catch (Exception e) {
                System.out.println("return false --> split[5]");
                return false;
              }
  
            }else{
              return false;
            }
  
  
            //tutti i check sono andati a buon fine
  
            return true;
  
  
  
  
          }

        return false;
    }  

}
