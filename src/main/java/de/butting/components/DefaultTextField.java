package de.butting.components;

import javafx.scene.control.TextField;

/**
 * @author Jonas Klopp
 * @author Christoph Ruhe
 */

public class DefaultTextField extends TextField {

    public DefaultTextField(String text) {
        this.setPromptText(text);
        this.setStyle(
                "-fx-font: 30 arial; -fx-border-radius: 10; -fx-background-radius: 10; -fx-border-color: #A9A9A9; -fx-border-width: 2 2 2 2;");
        this.setWidth(300);
        this.setHeight(50);
    }

}
