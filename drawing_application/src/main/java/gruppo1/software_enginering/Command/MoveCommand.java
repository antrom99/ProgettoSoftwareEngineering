package gruppo1.software_enginering.Command;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
/**
 * <p>
 * This Class define the move command for the selected shape
 * <p><!-- -->
 */
public class MoveCommand implements Command{

    private Shape shape ;
    private Rectangle view;
    private double end_x;
    private double end_y;
    private double start_x;
    private double start_y;
  

    /**<p>
     * This is the constructor for the move operation, so it inizialize the parameter for moving
     * <p><!-- -->
     * @param shape
     * @param view
     * @param end_x
     * @param end_y
     * @param start_x
     * @param start_y
     */

    public MoveCommand(Shape shape, Rectangle view,double end_x, double end_y, double start_x, double start_y) {
        this.shape = shape;
        this.end_x=end_x;
        this.end_y = end_y;
        this.start_x = start_x;
        this.start_y = start_y;
        this.view = view;
        
    }

    /**
     * <p>
     * This method execute the moving operation of the selected shape, first of all this method verify that the shape after operation of moving is in to 
     * drawing surface, if this check is false it sets the parameter so that the shape is in srawing surface after the operation, after that proceed with the traslation 
     * of a shape
     * <p><!-- -->
     */

    @Override
    public void execute() {

        double release_x = this.end_x-this.start_x;
        double release_y = this.end_y-this.start_y;

        //Check per la finestra
        if(view != null){
            if(view.getX()+view.getWidth()+release_x>773)
                release_x = 773-view.getX()-view.getWidth();
            if(view.getX()+release_x<0)
                release_x = -view.getX();
            if(view.getY()+view.getHeight()+release_y>670)
                release_y = 710-view.getY()-view.getHeight();
            if(view.getY()+release_y<0)
                release_y = -view.getY();
            }

            
        if( shape!=null) {
            
            shape.setTranslateX( release_x);
            
            shape.setTranslateY( release_y);
        

    
        }
        
    }

    
}
