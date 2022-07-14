package de.butting.components;

import javafx.scene.control.Button;

/**
 * @author Jonas Klopp
 * @author Christoph Ruhe
 */

public class DefaultButton extends Button {

    public DefaultButton(String text) {
        super(text);
        this.setStyle(
                "-fx-font: 30 arial; -fx-background-radius: 10px ;-fx-background-color: #A9A9A9; -fx-text-fill: white; ");
        this.setMinWidth(300);
        this.setMinHeight(50);
    }

}
