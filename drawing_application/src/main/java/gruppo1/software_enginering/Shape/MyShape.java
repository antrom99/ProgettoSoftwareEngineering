package gruppo1.software_enginering.Shape;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 * <p>
 * Interface MyShape for the Shape in the Drawing Application,
 * this interface declare the abstract method  signature that describe
 * a behavoir that classes (MyRectangle, MyEllipse, MyLine) must implemented
 * <p><!-- -->
 */
public interface MyShape   {
    
    public abstract void draw ( Pane drawingSurface);
    public abstract void updateAttribute(double dragPoint_x, double dragPoint_y);
    public abstract MyShape cloneShape();
    public abstract Shape getShape();
    public abstract Rectangle view();

   
    
    

    
}
