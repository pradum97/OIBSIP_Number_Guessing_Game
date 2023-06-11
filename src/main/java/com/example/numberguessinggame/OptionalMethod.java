package com.example.numberguessinggame;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class OptionalMethod {

    public void show_popup(String message, Object textField) {
        ContextMenu form_Validator = new ContextMenu();
        form_Validator.setAutoHide(true);
        form_Validator.getItems().add(new MenuItem(message));
        form_Validator.show((Node) textField, Side.RIGHT, 10, 0);
    }

}
