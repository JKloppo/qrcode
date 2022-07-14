package de.butting.components;

import javafx.scene.control.Label;

/**
 * @author Jonas Klopp
 * @author Christoph Ruhe
 */

public class DefaultLabel extends Label {

    public DefaultLabel() {
        this.setStyle("-fx-font: 24 arial;");
    }

    public DefaultLabel(String text) {
        super(text);
        this.setStyle("-fx-font: 24 arial;");
    }

}
