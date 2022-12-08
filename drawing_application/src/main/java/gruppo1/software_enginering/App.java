package gruppo1.software_enginering;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    

    
    /** 
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        
        Scene scene = new Scene(loadFXML("primary"),800, 900);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setTitle("Drawing Application");
        stage.setScene(scene);
        stage.setResizable(false);
        
        
        stage.show();

    }
    
    
    
    /** 
     * @param fxml
     * @return Parent
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    

}