package ma.youcode.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import ma.youcode.main.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}