package gruppo1.software_enginering.Shape;

import javafx.geometry.Point2D;
//import javafx.geometry.Point2D;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MyLine implements MyShape{

    private Line myLine;

    public MyLine(Line line){
        this.myLine = line;
        this.myLine.setStroke(line.getStroke());
        this.myLine.setStrokeWidth(line.getStrokeWidth());
    }

    public MyLine(String st){
        String split[];
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
    }

    public MyLine(double start_x, double start_y, Color strokeColor) {
        this.myLine =  new Line(start_x, start_y, start_x, start_y);
        this.myLine.setStroke(strokeColor);
        this.myLine.setStrokeWidth(3);
    }

    
    /** 
     * @param strokeColor
     */
    public void setStrokeColor(Color strokeColor){
        this.myLine.setStroke(strokeColor);
    }

    
    /** 
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
     * @param end_y
     */
    public void setEndY(double end_y){
        if(end_y<0)
            end_y = 0;
        if(end_y>670)
            end_y=670;
        this.myLine.setEndY(end_y);
    }

    
    /** 
     * @param drawingSurface
     */
    @Override
    public void draw(Pane drawingSurface) {
        
        drawingSurface.getChildren().add(this.myLine);
        
    }

    
    /** 
     * @return Line
     */
    public Line getMyLine() {
        return myLine;
    }

    
    /** 
     * @param dragPoint_x
     * @param dragPoint_y
     */
    @Override
    public void updateAttribute(double dragPoint_x, double dragPoint_y) {
        
        this.setEndX(dragPoint_x);
        this.setEndY(dragPoint_y);
        
    }

    
    /** 
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
     * @return Shape
     */
    @Override
    public Shape getShape() {
        
        return this.getMyLine();
    }

    
    /** 
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

   


    

}
