package gruppo1.software_enginering;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * <p>
 * Model class for the alert
 * <p><!-- -->
 */

public class MyAlertModel {



    public MyAlertModel(String title, String header, String content, AlertType type){


      Alert alert = new Alert(type);
      alert.setTitle(title);
      alert.setHeaderText(header);
      alert.setContentText(content);
      alert.showAndWait();


    }




    
}
