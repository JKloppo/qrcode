package de.butting.controller;

import javafx.scene.layout.Pane;

/**
 * @author Daniel Niebuhr
 */

public abstract class ViewController<V extends Pane> {

    public ViewController() {
    }

    public abstract V getView();

    public abstract void createView();

}
