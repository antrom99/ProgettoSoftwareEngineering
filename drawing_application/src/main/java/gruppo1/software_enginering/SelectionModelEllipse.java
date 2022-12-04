package gruppo1.software_enginering;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class SelectionModelEllipse {

    public SelectionModelEllipse(Ellipse ellispeSelected) {
        this.ellispeSelected = ellispeSelected;
    }

    private Ellipse ellispeSelected;
    
    public Rectangle getSelectionView(){

        Rectangle rect = new Rectangle(ellispeSelected.getCenterX()-ellispeSelected.getRadiusX()-3, ellispeSelected.getCenterY()-ellispeSelected.getRadiusY()-3,ellispeSelected.getRadiusX()*2+6, ellispeSelected.getRadiusY()*2+6);
        rect.setStyle(
                    "-fx-stroke: blue; " +
                    "-fx-stroke-width: 2px; " +
                    "-fx-stroke-dash-array: 12 2 4 2; " +
                    "-fx-stroke-dash-offset: 6; " +
                    "-fx-stroke-line-cap: butt; " +
                    "-fx-fill: rgba(255, 255, 255, .0);"
        );

        return rect;

        
    }
}
