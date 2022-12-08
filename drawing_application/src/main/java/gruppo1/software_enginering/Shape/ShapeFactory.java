package gruppo1.software_enginering.Shape;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ShapeFactory {
    private MyShape shape;

    public ShapeFactory(Shape shape){

        if(shape instanceof Rectangle)
            this.shape = new MyRectangle((Rectangle) shape);
        if (shape instanceof Ellipse)
            this.shape = new MyEllipse((Ellipse) shape);
        if(shape instanceof Line)
            this.shape = new MyLine((Line)shape);
            
            

    }
    public ShapeFactory(String nShape){

        String st=nShape.replace("[","");
        st=st.replace("]", "");
        st=st.replace("=", "");
        st=st.replace(" ", "");
        st=st.replace("strokeWidth", "");        
        st=st.replace("stroke", "");
        if (st.contains("Line"))
            this.shape=new MyLine(st);
        if (st.contains("Rectangle"))
            this.shape=new MyRectangle(st);
        if(st.contains("Ellipse"))
            this.shape=new MyEllipse(st);
    }

    
    /** 
     * @return MyShape
     */
    public MyShape getShape() {
        return shape;
    }
    
}
