package gruppo1.software_enginering.Shape;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;



public interface MyShape   {
    
    public abstract void draw (/*GraphicsContext drawingSurface*/ Pane drawingSurface);
    public abstract void updateAttribute(double dragPoint_x, double dragPoint_y);
    public abstract MyShape cloneShape();
    public abstract Shape getShape();
    public abstract Rectangle view();
   
    //public abstract Rectangle
    //public static void updateAttribute(Shape shape,double dragPoint_x, double dragPoint_y);
    

    
}
