package gruppo1.software_enginering;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class SelectionModelLine {

    private Line selectedLine;

    public SelectionModelLine(Line selectedLine) {
        this.selectedLine = selectedLine;
    }

    public Rectangle getSelectionView(){



        Rectangle rect = new Rectangle(Math.min(selectedLine.getStartX(), selectedLine.getEndX())-3,Math.min(selectedLine.getStartY(), selectedLine.getEndY())-3, Math.abs(selectedLine.getStartX()-selectedLine.getEndX())+6, Math.abs(selectedLine.getStartY()-selectedLine.getEndY())+6);
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
