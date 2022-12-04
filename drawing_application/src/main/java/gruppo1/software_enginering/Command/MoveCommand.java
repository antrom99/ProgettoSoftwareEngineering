package gruppo1.software_enginering.Command;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MoveCommand implements Command{

    private Shape shape ;
    private Rectangle view;
    private MouseEvent event;
    private double x;
    private double y;
  

    

    public MoveCommand(Shape shape, Rectangle view,MouseEvent event, double x, double y) {
        this.shape = shape;
        this.event = event;
        this.x = x;
        this.y = y;
        this.view = view;
        
    }

    @Override
    public void execute() {

        double release_x = event.getX()-x;
        double release_y = event.getY()-y;

        /*if(release_x >773)
            release_x = 773;
        if(release_y > 715)
            release_y = 715;*/
        if(view != null){
            if(view.getX()+view.getWidth()+release_x>773)
                release_x = 773-view.getX()-view.getWidth();
            if(view.getX()+release_x<0)
                release_x = -view.getX();
            if(view.getY()+view.getHeight()+release_y>715)
                release_y = 715-view.getY()-view.getHeight();
            if(view.getY()+release_y<0)
                release_y = -view.getY()+26;
            }
        if( shape!=null) {
            shape.setTranslateX( release_x);
        
            shape.setTranslateY( release_y);
        

    
        }
        
    }

    @Override
    public void undo() {
        
        
    }
    
}
