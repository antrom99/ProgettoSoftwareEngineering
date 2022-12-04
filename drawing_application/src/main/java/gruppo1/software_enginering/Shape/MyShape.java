package gruppo1.software_enginering.Shape;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;



public interface MyShape  {
    
    public abstract void draw (/*GraphicsContext drawingSurface*/ Pane drawingSurface);
    public abstract void updateAttribute(double dragPoint_x, double dragPoint_y);
    //public static void updateAttribute(Shape shape,double dragPoint_x, double dragPoint_y);
    

    
}
