package gruppo1.software_enginering;

import javafx.scene.shape.Rectangle;

public class SelectionModelRectangle {

    private Rectangle rectangleSelected;

    public SelectionModelRectangle(Rectangle rectangleSelected) {
        this.rectangleSelected = rectangleSelected;
    }
    

    public Rectangle getSelectionView(){

        Rectangle rect = new Rectangle(rectangleSelected.getX()-3, rectangleSelected.getY()-3, rectangleSelected.getWidth()+6, rectangleSelected.getHeight()+6);
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
