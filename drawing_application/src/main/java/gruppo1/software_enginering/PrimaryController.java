/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package gruppo1.software_enginering;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import gruppo1.software_enginering.Command.Command;
import gruppo1.software_enginering.Command.Invoker;
import gruppo1.software_enginering.Command.UploadCommand;
import gruppo1.software_enginering.StateUpdate.Context;
import gruppo1.software_enginering.StateUpdate.Edit;
import gruppo1.software_enginering.StateUpdate.SelectEllipseDraw;
import gruppo1.software_enginering.StateUpdate.SelectLineDraw;
import gruppo1.software_enginering.StateUpdate.SelectRectangleDraw;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;



public class PrimaryController {

    


    private  Invoker inv = new Invoker();
    private Context appContext;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Canvas"
    private Pane Canvas; // Value injected by FXMLLoader

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

    @FXML // fx:id="currentMode"
    private ImageView currentMode; // Value injected by FXMLLoader

    @FXML // fx:id="disable_fill_color"
    private CheckBox disable_fill_color; // Value injected by FXMLLoader

    @FXML // fx:id="label_drawing_mode"
    private Label label_drawing_mode; // Value injected by FXMLLoader

    @FXML // fx:id="label_select_mode"
    private Label label_selection_mode; // Value injected by FXMLLoader

    @FXML // fx:id="Cursor_Button"
    private Button Cursor_Button; // Value injected by FXMLLoader


    



   
    @FXML
    void save_function(ActionEvent event) {
        appContext.resetMode(Canvas);
        
        
        FileChooser openFile = new FileChooser();

        openFile.setTitle("Save file");

        File file = openFile.showSaveDialog(border_pane.getScene().getWindow());

        if(file != null){

            try{   
                PrintWriter out = new PrintWriter(new FileWriter(file)); 
                FileOutputStream fos = new FileOutputStream(file);
                for(Node s : Canvas.getChildren()){
                    out.print(s);
                    System.out.println();
                    out.print("\n");
                }
                fos.close();
                out.close();

            }catch(IOException ex){
                System.out.println("Error");
            }

        }
    }
    @FXML
    void selectContourColor(ActionEvent event){
        
        Command command = appContext.selectStrokeColor(ColorPicker_Contour.getValue());
       
        if (command !=null)
            inv.execute(command);

    }
    @FXML
    void selectFillColor(ActionEvent event){

        Command command =appContext.selectFillColor(ColorPicker_Fill.getValue());
        
        if (command !=null)
            inv.execute(command);
        
    }

    @FXML
    void selectEllipse(ActionEvent event) {

        appContext.changeState(new SelectEllipseDraw(ColorPicker_Contour.getValue(), ColorPicker_Fill.getValue(), disable_fill_color.isSelected()));
        appContext.setImage(currentShape);

        
        
    }

    @FXML
    void selectLine(ActionEvent event) {

        
        appContext.changeState(new SelectLineDraw(ColorPicker_Contour.getValue()));
        appContext.setImage(currentShape);
        disable_fill_color.setSelected(false);
        
        
        ColorPicker_Fill.setDisable(true);
        label_color_fill.setDisable(true);
        
    }

    @FXML
    void selectRectangle(ActionEvent event) throws FileNotFoundException {
      
        appContext.changeState(new SelectRectangleDraw(ColorPicker_Contour.getValue(), ColorPicker_Fill.getValue(), disable_fill_color.isSelected()));
        appContext.setImage(currentShape);

    }   
    @FXML
    void selectCursor(ActionEvent event){
        label_drawing_mode.setDisable(true);
        label_selection_mode.setDisable(false);
        Ellipse_Button.setDisable(true);
        Line_Button.setDisable(true);
        Rectangle_Button.setDisable(true);
        
        disable_fill_color.setSelected(false);
        ColorPicker_Fill.setDisable(true);
        label_color_fill.setDisable(true);
        appContext.resetMode(Canvas);
        appContext.changeState(new Edit());
        appContext.setImageMODE(currentMode);
        
        
       
        
    }

    @FXML
    void selectDrawingMode(ActionEvent event){
        label_drawing_mode.setDisable(false);
        label_selection_mode.setDisable(true);
        Ellipse_Button.setDisable(false);
        Line_Button.setDisable(false);
        Rectangle_Button.setDisable(false);
        
       
        appContext.resetMode(Canvas);
        appContext.changeState(new SelectLineDraw(ColorPicker_Contour.getValue()));
        appContext.setImage(currentShape);
        appContext.setImageMODE(currentMode);
        disable_fill_color.setSelected(false);
        ColorPicker_Fill.setDisable(true);
        label_color_fill.setDisable(true);
        
       
        
    }

   
    @FXML
    void clickPoint(MouseEvent event) {

        
        
        Command command = appContext.onMousePressed(event, Canvas);
        if (command !=null)
            inv.execute(command);
        
    }

   // }
    @FXML
    void dragOperation(MouseEvent event){

        Command command = appContext.onMouseDrag(event);
        if (command !=null)
            inv.execute(command);
    }

        
    
    @FXML
    void clickRelase(MouseEvent event) {

        appContext.onMouseReleased(event);
    }

 

    @FXML
    void click_fill_color_checkbox(ActionEvent event) {

         appContext.selectFill(disable_fill_color.isSelected());
       
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

        

        Command command = new UploadCommand(Canvas/*drawingSurface*/,border_pane);
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
        assert label_drawing_mode != null : "fx:id=\"label_drawing_mode\" was not injected: check your FXML file 'primary.fxml'.";
        assert label_selection_mode != null : "fx:id=\"label_selection_mode\" was not injected: check your FXML file 'primary.fxml'.";
        assert currentMode != null : "fx:id=\"currentMode\" was not injected: check your FXML file 'primary.fxml'.";


        label_selection_mode.setDisable(true);
        //selectedShape = new SelectedShape(new LineSelected());

        appContext = new Context(new SelectLineDraw(ColorPicker_Contour.getValue()));
        appContext.setImage(currentShape);
        appContext.setImageMODE(currentMode);
        

       
       
       //Canvas.getChildren().add(new Rectangle(0,0,50,60));

        Canvas.setOnMouseExited(e->{
            Canvas.setCursor(Cursor.CROSSHAIR);
        });
        

    }


    public void commandExecute(Command comand){
        inv.execute(comand);
    }

   
}

