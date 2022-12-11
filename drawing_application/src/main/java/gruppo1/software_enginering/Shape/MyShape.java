package gruppo1.software_enginering.Shape;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;



public interface MyShape   {
    
    public abstract void draw ( Pane drawingSurface);
    public abstract void updateAttribute(double dragPoint_x, double dragPoint_y);
    public abstract MyShape cloneShape();
    public abstract Shape getShape();
    public abstract Rectangle view();
   
    
    

    
}
