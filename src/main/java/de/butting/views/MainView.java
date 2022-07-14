package de.butting.views;

import de.butting.components.DefaultButton;
import de.butting.components.DefaultLabel;
import de.butting.components.DefaultTextField;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Daniel Niebuhr
 */

public class MainView extends BorderPane {

    private final DefaultButton generateBtn = new DefaultButton("Generieren");
    private final DefaultButton saveAsImageBtn = new DefaultButton("Als Bild speichern");
    private final DefaultLabel inputUrlHereLabel = new DefaultLabel("URL hier einfügen:");
    private final DefaultTextField urlTextField = new DefaultTextField("URL eingeben");

    private Image image = null;

    public MainView createView() {
        initializeContent(image);
        return this;
    }

    public void initializeContent(Image image) {
        setStyles();
        this.image = image;
        HBox bottomBox = new HBox(40);
        VBox leftBox = new VBox(20);
        VBox rightBox = new VBox(20);
        VBox generateBtnVBox = new VBox();
        VBox saveBtnVBox = new VBox();

        ImageView imgView = new ImageView(image);

        rightBox.getChildren()
                .add(imgView);
        leftBox.getChildren()
                .addAll(inputUrlHereLabel, urlTextField);
        generateBtnVBox.getChildren()
                .add(generateBtn);
        saveBtnVBox.getChildren()
                .add(saveAsImageBtn);
        bottomBox.getChildren()
                .addAll(generateBtnVBox, saveBtnVBox);

        bottomBox.setPadding(new Insets(20, 20, 50, 20));
        leftBox.setPadding(new Insets(100, 20, 0, 70));
        rightBox.setPadding(new Insets(50, 100, 0, 30));
        generateBtnVBox.setPadding(new Insets(0, 100, 0, 70));
        saveBtnVBox.setPadding(new Insets(0, 30, 0, 65));

        this.setLeft(leftBox);
        this.setRight(rightBox);
        this.setBottom(bottomBox);
    }

    private void setStyles() {
        this.setStyle("-fx-background-color: #F5F5F5");
    }

    public DefaultButton getGenerateBtn() {
        return generateBtn;
    }

    public DefaultTextField getUrlTextField() {
        return urlTextField;
    }

    public DefaultButton getSaveAsImageBtn() {
        return saveAsImageBtn;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
