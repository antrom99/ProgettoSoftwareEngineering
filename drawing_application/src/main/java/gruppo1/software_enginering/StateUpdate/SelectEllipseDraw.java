package gruppo1.software_enginering.StateUpdate;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.DrawCommand;
import gruppo1.software_enginering.Command.UpdateCommand;
import gruppo1.software_enginering.Shape.MyEllipse;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SelectEllipseDraw implements State{
    private Color strokeColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private boolean fill = false;
    private MyEllipse ellipse;

    public SelectEllipseDraw(Color strokeColor, Color fillColor, boolean fill) {
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.fill = fill;
    }

    @Override
    public Command onMousePressed(MouseEvent event, Pane drawingSurface) {
        double pressedX = event.getX();
        double pressedY = event.getY();
        ellipse = new MyEllipse(pressedX, pressedY,  strokeColor,fillColor, fill);
        return new DrawCommand(ellipse, drawingSurface);
        
    }

    @Override
    public Command onMouseDrag(MouseEvent event) {
        double dragX = event.getX();
        double dragY = event.getY();
        
        return new UpdateCommand(ellipse, dragX, dragY);
    }

    @Override
    public Command selectStrokeColor(Color strokeColor) {
        this.setStrokeColor(strokeColor);
        return null;
    }

    @Override
    public Command selectFillColor(Color fill_color) {
        this.setFillColor(fill_color);
        return null;
    }

    @Override
    public Command selectFill(boolean fill) {
        this.setFill(fill);
        return null;
    }

    @Override
    public void setImage(ImageView image) {
        image.setImage(new Image(getClass().getResourceAsStream("Image_State/ellipse.png")));
        
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public void setEllipse(MyEllipse ellipse) {
        this.ellipse = ellipse;
    }

    @Override
    public void setImageMODE(ImageView image) {
        // idle
    }

    @Override
    public void resetMode(Pane drawingSurface) {
        
        
    }

    @Override
    public Command onMouseReleased(MouseEvent event) {
        
        return null;
    }
    
}