module gruppo1.software_enginering {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.desktop;
    requires javafx.swing;
    

    opens gruppo1.software_enginering to javafx.fxml;
    exports gruppo1.software_enginering;
}

