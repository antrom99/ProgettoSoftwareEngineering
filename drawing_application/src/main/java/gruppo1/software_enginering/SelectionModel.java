package gruppo1.software_enginering;



import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Shear;
import javafx.scene.transform.Rotate;

public class SelectionModel {

    //Set<Shape> selection = new HashSet<>();
    //Set<Rectangle> view = new HashSet<>();

    private Rectangle view_element = new Rectangle();
    private Shape shape_element = new Rectangle();
    private Rotate  rotate= new Rotate();
    private Circle rotateCircle = new Circle(7);
    private  Circle resizeCircle = new Circle(7);
   
    //Rectangle selectionView = new Rectangle(); 
    //Hashtable< Rectangle,Shape> selection1 = new Hashtable<>();

   // Integer intero = 0;

   
    
    


    public void add( Node node, Pane drawingSurface) {
        
        if (node instanceof Rectangle){

            

            SelectionModelRectangle rectangle  = new SelectionModelRectangle((Rectangle)node);
            
            //selection.add((Rectangle) node);
            //view.add(rectangle.getSelectionView());

            shape_element = (Rectangle) node;
            shape_element.setViewOrder(-1);
            //shape_element.layoutBoundsProperty();
            view_element = (Rectangle) rectangle.getSelectionView();
            
            
            


        }
            


        if(node instanceof Ellipse){
            SelectionModelEllipse rectangle  = new SelectionModelEllipse((Ellipse) node);
            
            
            //selection.add( (Ellipse)node);
            //view.add(rectangle.getSelectionView());

            shape_element = (Ellipse) node;
            shape_element.setViewOrder(-1);
            view_element = (Rectangle) rectangle.getSelectionView();
          
        }

        if(node instanceof Line){

            SelectionModelLine rectangle  = new SelectionModelLine((Line) node);
            
            //selection.add( (Line)node);
            //view.add(rectangle.getSelectionView());


            shape_element = (Line) node;
            shape_element.setViewOrder(-1);
            view_element = (Rectangle) rectangle.getSelectionView();
            

            
            

        }


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
            //view_element.xProperty().bind(shape_element.xProperty());
       

        
    }

    


    public void addView(Pane drawingSurface){
        //for(Rectangle rect : view)
          //  drawingSurface.getChildren().add(rect);
        if(view_element!=null){
            drawingSurface.getChildren().addAll(view_element, resizeCircle, rotateCircle);
        
        }
        
        
    }

    

    public void remove( Node node) {
       
        //selection.remove( node);
        shape_element = null;
    }

    public void remove(Rectangle selcted, Pane drawingSurface){
        //view.remove(selcted);
        view_element=null;
        //drawingSurface.getChildren().remove(selcted);
        drawingSurface.getChildren().removeAll(selcted,resizeCircle,rotateCircle);

    }
    //fix bug
    public void clear(Pane drawingSurface) {
                if(shape_element!= null)
                    shape_element.setViewOrder(0);
                //while (!selection.isEmpty())
                  //  remove(selection.iterator().next());
                //while(!view.isEmpty())
                  //  remove(view.iterator().next(), drawingSurface);
                //if(!shape_element.equals(null))
                    remove(shape_element);
                //if(!view_element.equals(null))
                    remove(view_element,drawingSurface);
        

    }
// fix bug
    public boolean contains( Node node) {
        //System.out.println(node+" "+view_element);
        boolean value = false;
        if(shape_element!=null && view_element != null)
            value = shape_element.equals(node) || view_element.equals(node);
        return value;
        //return view.contains(node);
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

