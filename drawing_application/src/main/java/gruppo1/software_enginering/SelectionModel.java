package gruppo1.software_enginering;
import gruppo1.software_enginering.Shape.MyShape;
import gruppo1.software_enginering.Shape.ShapeFactory;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class SelectionModel {

    private Rectangle view_element = new Rectangle();
    private Shape shape_element = new Rectangle();
    private Rotate  rotate= new Rotate();
    private Circle rotateCircle = new Circle(7);
    private  Circle resizeCircle = new Circle(7);
   
    public void add( Node node, Pane drawingSurface) {

        shape_element = (Shape) node;
        ShapeFactory shapeFactory = new ShapeFactory(shape_element) ;
        MyShape shapeSelected = shapeFactory.getShape();
        shape_element.setViewOrder((-1));
        view_element = shapeSelected.view();
        rotate.setPivotX((view_element.getX() + view_element.getWidth()) / 2);
        rotate.setPivotY((view_element.getY() + view_element.getHeight()) / 2);
        view_element.translateXProperty().bind(shape_element.translateXProperty());
        view_element.translateYProperty().bind(shape_element.translateYProperty());
        resizeCircle.centerXProperty().bind(view_element.xProperty());
        resizeCircle.centerYProperty().bind(view_element.yProperty());
        rotateCircle.centerXProperty().bind(view_element.xProperty().add(view_element.widthProperty().divide(2)));
        rotateCircle.centerYProperty().bind(view_element.yProperty().subtract(25d));
        resizeCircle.translateXProperty().bind(shape_element.translateXProperty());
        rotateCircle.translateXProperty().bind(shape_element.translateXProperty());
        resizeCircle.translateYProperty().bind(shape_element.translateYProperty());
        rotateCircle.translateYProperty().bind(shape_element.translateYProperty());
           
    }
    
    public void addView(Pane drawingSurface){
       
        if(view_element!=null){
            drawingSurface.getChildren().addAll(view_element, resizeCircle, rotateCircle);
        
        }
         
    }

    public void remove( Node node) {
        
        shape_element = null;

    }

    public void remove(Rectangle selcted, Pane drawingSurface){
        
        view_element=null;
        drawingSurface.getChildren().removeAll(selcted,resizeCircle,rotateCircle);

    }
   
    public void clear(Pane drawingSurface) {

                if(shape_element!= null)
                    shape_element.setViewOrder(0);
                remove(shape_element);
                remove(view_element,drawingSurface);
        
    }
// fix bug
    public boolean contains( Node node) {
        
        boolean value = false;
        if(shape_element!=null && view_element != null)
            value = shape_element.equals(node) || view_element.equals(node);
        return value;
        
    }

    public Rectangle getView_element() {
        return view_element;
    }

     public Shape getShape_element() {
        return shape_element;
    }

    public void setView_element(Rectangle view_element) {
        this.view_element = view_element;
    }

    public void setShape_element(Shape shape_element) {
        this.shape_element = shape_element;
    }

    public Rotate getRotate() {
        return rotate;
    }

    public Circle getRotateCircle() {
        return rotateCircle;
    }

    public Circle getResizeCircle() {
        return resizeCircle;
    }

    



    
}

