/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package gruppo1.software_enginering;



import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;

import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.Invoker;
import gruppo1.software_enginering.Command.UploadCommand;
import gruppo1.software_enginering.State.EllipseSelected;
import gruppo1.software_enginering.State.LineSelected;
import gruppo1.software_enginering.State.RectangleSelected;
import gruppo1.software_enginering.State.SelectedShape;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;



public class PrimaryController {

    private Point2D pressedPoint2D;


    private  Invoker inv = new Invoker();

    private SelectedShape selectedShape;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Canvas"
    private Canvas Canvas; // Value injected by FXMLLoader

    @FXML // fx:id="border_pane"
    private BorderPane border_pane; // Value injected by FXMLLoader

    @FXML // fx:id="ColorPicker_Contour"
    private ColorPicker ColorPicker_Contour; // Value injected by FXMLLoader

    @FXML // fx:id="ColorPicker_Fill"
    private ColorPicker ColorPicker_Fill; // Value injected by FXMLLoader

    @FXML // fx:id="Ellipse_Button"
    private Button Ellipse_Button; // Value injected by FXMLLoader

    @FXML // fx:id="Line_Button"
    private Button Line_Button; // Value injected by FXMLLoader

    @FXML // fx:id="Rectangle_Button"
    private Button Rectangle_Button; // Value injected by FXMLLoader

    @FXML // fx:id="Upload"
    private MenuItem Upload; // Value injected by FXMLLoader


    @FXML // fx:id="label_color_fill"
    private Label label_color_fill; // Value injected by FXMLLoader

    @FXML // fx:id="currentShape"
    private ImageView currentShape; // Value injected by FXMLLoader

    @FXML // fx:id="disable_fill_color"
    private CheckBox disable_fill_color; // Value injected by FXMLLoader

    



   
    @FXML
    void save_function(ActionEvent event) {
        
        
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Save file");
        File file = openFile.showSaveDialog(border_pane.getScene().getWindow());
        if(file != null){
            try{
                WritableImage writableImage = new WritableImage(1080, 790);
                Canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);


            }catch(IOException ex){
                System.out.println("Error");
            }
        }
    }

    @FXML
    void selectEllipse(ActionEvent event) {

        selectedShape.changeSelectedShape(new EllipseSelected());
        selectedShape.setImage(currentShape);
        
    }

    @FXML
    void selectLine(ActionEvent event) {

        selectedShape.changeSelectedShape(new LineSelected());
        selectedShape.setImage(currentShape);
        disable_fill_color.setSelected(false);
        ColorPicker_Fill.setDisable(true);
        label_color_fill.setDisable(true);
    }

    @FXML
    void selectRectangle(ActionEvent event) throws FileNotFoundException {
        selectedShape.changeSelectedShape(new RectangleSelected());
        selectedShape.setImage(currentShape);

    }   

    @FXML
    void clickPoint(MouseEvent event) {
        pressedPoint2D = new Point2D(event.getX(),event.getY());
    }

    @FXML
    void clickRelase(MouseEvent event) {
        
        GraphicsContext drawingSurface = Canvas.getGraphicsContext2D();
        Point2D releasedPoint2D = new Point2D(event.getX(), event.getY());
        Command command = selectedShape.makeDrawCommandShape(pressedPoint2D, releasedPoint2D, ColorPicker_Contour.getValue(), ColorPicker_Fill.getValue(), disable_fill_color.isSelected(), drawingSurface);
        commandExecute(command);
    }

   


    @FXML
    void click_checkbox(ActionEvent event) {

         if (!disable_fill_color.isSelected()){
            ColorPicker_Fill.setDisable(true);
            label_color_fill.setDisable(true);
            
        }
        else{
            ColorPicker_Fill.setDisable(false);
            label_color_fill.setDisable(false);
            
        }

    }

    @FXML
    void upload_function(ActionEvent event) {

        GraphicsContext drawingSurface = Canvas.getGraphicsContext2D();
        Command command = new UploadCommand(drawingSurface,border_pane);
        commandExecute(command);


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Canvas != null : "fx:id=\"Canvas\" was not injected: check your FXML file 'primary.fxml'.";
        assert ColorPicker_Contour != null : "fx:id=\"ColorPicker_Contour\" was not injected: check your FXML file 'primary.fxml'.";
        assert ColorPicker_Fill != null : "fx:id=\"ColorPicker_Fill\" was not injected: check your FXML file 'primary.fxml'.";
        assert Ellipse_Button != null : "fx:id=\"Ellipse_Button\" was not injected: check your FXML file 'primary.fxml'.";
        assert Line_Button != null : "fx:id=\"Line_Button\" was not injected: check your FXML file 'primary.fxml'.";
        assert Rectangle_Button != null : "fx:id=\"Rectangle_Button\" was not injected: check your FXML file 'primary.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'primary.fxml'.";
        assert currentShape != null : "fx:id=\"currentShape\" was not injected: check your FXML file 'primary.fxml'.";
        assert disable_fill_color != null : "fx:id=\"disable_fill_color\" was not injected: check your FXML file 'primary.fxml'.";
        assert label_color_fill != null : "fx:id=\"label_color_fill\" was not injected: check your FXML file 'primary.fxml'.";

        selectedShape = new SelectedShape(new LineSelected());

       

        Canvas.setOnMouseExited(e->{
            Canvas.setCursor(Cursor.CROSSHAIR);
        });
        

    }


    public void commandExecute(Command comand){
        inv.execute(comand);
    }

        
}

