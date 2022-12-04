package gruppo1.software_enginering;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    

    @Override
    public void start(Stage stage) throws IOException {
        
        Scene scene = new Scene(loadFXML("primary"),800, 900);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setTitle("Drawing Application");
        stage.setScene(scene);
        stage.setResizable(false);
        
        
        stage.show();

    }
    
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    

}/* 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Rotate;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        final MouseContext refPoint = new MouseContext();
        final Rotate rotate = new Rotate();
        Pane root = new Pane();
        Rectangle rect = new Rectangle(100, 100);

        //set pivot on rectangle center
        rotate.setPivotX((rect.getX() + rect.getWidth()) / 2);
        rotate.setPivotY((rect.getY() + rect.getHeight()) / 2);

        rect.setStyle(
                "-fx-stroke: blue; "
                + "-fx-stroke-width: 2px; "
                + "-fx-stroke-dash-array: 12 2 4 2; "
                + "-fx-stroke-dash-offset: 6; "
                + "-fx-stroke-line-cap: butt; "
                + "-fx-fill: rgba(255, 255, 255, .0);"
        );

        Group group = new Group();

        // make a rectangle movable by dragging it around with the mouse.
        rect.setOnMousePressed(mouseEvent -> {
            // record a delta distance for the drag and drop operation.
            refPoint.sceneX = mouseEvent.getSceneX();
            refPoint.sceneY = mouseEvent.getSceneY();
            group.getScene().setCursor(Cursor.MOVE);
        });

        rect.setOnMouseReleased(mouseEvent -> {
            group.getScene().setCursor(Cursor.HAND);
        });

        rect.setOnMouseDragged(mouseEvent -> {
            // Get the mouse deltas
            double deltaX = mouseEvent.getSceneX() - refPoint.sceneX;
            double deltaY = mouseEvent.getSceneY() - refPoint.sceneY;

            group.setTranslateX(group.getTranslateX() + deltaX);
            group.setTranslateY(group.getTranslateY() + deltaY);

            refPoint.sceneX = mouseEvent.getSceneX();
            refPoint.sceneY = mouseEvent.getSceneY();
        });

        Circle resizeCircle = new Circle(7);

        resizeCircle.centerXProperty().bind(rect.xProperty());
        resizeCircle.centerYProperty().bind(rect.yProperty());

        // Handle resize
        resizeCircle.setOnMousePressed(e -> {
            var sceneCenter = resizeCircle.localToScene(resizeCircle.getCenterX(), resizeCircle.getCenterY());
            refPoint.sceneX = e.getSceneX();
            refPoint.sceneY = e.getSceneY();
            refPoint.offX = rect.getWidth();
            refPoint.offY = rect.getHeight();
        });

        resizeCircle.setOnMouseDragged(e -> {
            try {
                var sceneToLocal = group.getLocalToSceneTransform().createInverse();
                var localRef = sceneToLocal.transform(refPoint.sceneX, refPoint.sceneY);
                var localMouse = sceneToLocal.transform(e.getSceneX(), e.getSceneY());

                var dx = localMouse.getX() - localRef.getX();
                var dy = localMouse.getY() - localRef.getY();

                var x = localMouse.getX();
                var y = localMouse.getY();
                var w = Math.abs(refPoint.offX-dx);
                var h = Math.abs(refPoint.offY-dy);
                rect.setX(x);
                rect.setY(y);
                rect.setWidth(w);
                rect.setHeight(h);

                rotate.setPivotX(x + w/2);
                rotate.setPivotY(y + h/2);
            } catch (NonInvertibleTransformException ex) {}
            e.consume();
        });

        // Anchor for rotate the rectangle
        Circle rotateCircle = new Circle(7);
        rotateCircle.centerXProperty().bind(rect.xProperty().add(rect.widthProperty().divide(2)));
        rotateCircle.centerYProperty().bind(rect.yProperty().subtract(25d));

        rotateCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            var sceneCenter = rotateCircle.localToScene(rotateCircle.getCenterX(), rotateCircle.getCenterY());
            refPoint.sceneX = e.getSceneX();
            refPoint.sceneY = e.getSceneY();
            refPoint.offX = sceneCenter.getX()-refPoint.sceneX;
            refPoint.offY = sceneCenter.getY()-refPoint.sceneY;
        });

        // When it's dragged rotate the box
        rotateCircle.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

            var localToScene = group.getLocalToSceneTransform();

            var x2 = event.getSceneX()+refPoint.offX;
            var y2 = event.getSceneY()+refPoint.offY;

            var pivotPoint = localToScene.transform(rotate.getPivotX(), rotate.getPivotY());
            double angle = Math.toDegrees(Math.atan2(x2-pivotPoint.getX(), pivotPoint.getY()-y2));
            // Rotate the rectangle
            rotate.setAngle(angle);
        });

        group.getChildren().addAll(rect, rotateCircle, resizeCircle);

        group.setLayoutX(100);
        group.setLayoutY(100);
        group.getTransforms().add(rotate);

        root.getChildren().add(group);

        Scene scene = new Scene(root, 400, 400);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // records relative x and y co-ordinates.
    private static class MouseContext {
        double sceneX, sceneY;
        double offX, offY;
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/