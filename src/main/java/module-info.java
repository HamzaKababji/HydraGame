module se2203.hydragame {
    requires javafx.controls;
    requires javafx.fxml;


    opens se2203.hydragame to javafx.fxml;
    exports se2203.hydragame;
}