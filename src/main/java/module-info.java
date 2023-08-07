module guessing.numbers {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports leguar.guessingnumbers.game;

    opens leguar.guessingnumbers.game;
}