module com.mycompany.songnotebook {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.songnotebook to javafx.fxml;
    exports com.mycompany.songnotebook;
}
