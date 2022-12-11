package gruppo1.software_enginering;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class SelectionModel {

    private Rectangle view_element = new Rectangle();
    private Shape shape_element = new Rectangle();

   
    
    /** 
     * @param node
     * @param drawingSurface
     */
    public void add( Node node) {

        shape_element = (Shape) node;
        ShapeFactory shapeFactory = new ShapeFactory(shape_element) ;
        MyShape shapeSelected = shapeFactory.getShape();
        shape_element.setViewOrder((-1));
        view_element = shapeSelected.view();
        view_element.translateXProperty().bind(shape_element.translateXProperty());
        view_element.translateYProperty().bind(shape_element.translateYProperty());

           
    }
    
    
    /** 
     * @param drawingSurface
     */
    public void addView(Pane drawingSurface){
       
        if(view_element!=null){
            drawingSurface.getChildren().add(view_element);
        
        }
         
    }

    
    /** 
     * @param node
     */
    public void remove( Node node) {
        
        shape_element = null;

    }

    
    /** 
     * @param selcted
     * @param drawingSurface
     */
    public void remove(Rectangle selcted, Pane drawingSurface){
        
        view_element=null;
        drawingSurface.getChildren().removeAll(selcted);

    }
   
    
    /** 
     * @param drawingSurface
     */
    public void clear(Pane drawingSurface) {

                if(shape_element!= null)
                    shape_element.setViewOrder(0);
                remove(shape_element);
                remove(view_element,drawingSurface);
        
    }

/** 
 * @param node
 * @return boolean
 */
// fix bug
    public boolean contains( Node node) {
        
        boolean value = false;
        if(shape_element!=null && view_element != null)
            value = shape_element.equals(node) || view_element.equals(node);
        return value;
        
    }

    
    /** 
     * @return Rectangle
     */
    public Rectangle getView_element() {
        return view_element;
    }

     
     /** 
      * @return Shape
      */
     public Shape getShape_element() {
        return shape_element;
    }

    
    /** 
     * @param view_element
     */
    public void setView_element(Rectangle view_element) {
        this.view_element = view_element;
    }

    
    /** 
     * @param shape_element
     */
    public void setShape_element(Shape shape_element) {
        this.shape_element = shape_element;
    }

    
   
    



    
}

