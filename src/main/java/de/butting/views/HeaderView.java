package de.butting.views;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Daniel Niebuhr
 */

public class HeaderView extends HBox {

    //	private Button homeBtn = new Button();
//	private Button exitBtn = new Button("Exit");
//	private Label isAdminLabel = new Label("Admin");
//	private Label adminPlaceholerLabel = new Label();
//	private FontAwesomeIconView homeBtnIcon = new FontAwesomeIconView(FontAwesomeIcon.CUBES);
    private final Label headlineLabel = new Label("BUTTING QR-Generator");
    private final Image image = new Image("file:src/main/resources/Butting-Logo_mit_Schrift.png", 325, 70, false, false);
    private final ImageView imgView = new ImageView(image);

    public HeaderView createView() {
        initializeContent();
        return this;
    }

    private void initializeContent() {
        setSizes();
        setStyles();
        this.setMinWidth(380);
        VBox headlineDateTimeBox = new VBox();
        headlineDateTimeBox.setMinHeight(60);
        headlineDateTimeBox.getChildren()
                .addAll(this.headlineLabel, imgView);
        this.setSpacing(20);
//		this	.getChildren()
//			.addAll(this.homeBtn, this.placeholderLabel, headlineDateTimeBox, this.adminPlaceholerLabel,
//					this.exitBtn);
        this.getChildren()
                .addAll(this.headlineLabel, imgView);
    }

    private void setSizes() {
        this.headlineLabel.setPadding(new Insets(15, 55, 5, 40));
        this.image.getHeight();
        this.setPadding(new Insets(10, 10, 10, 10));
//		HBox.setMargin(this.isAdminLabel, new Insets(25, 0, 0, 0));
//		this.isAdminLabel.setPadding(new Insets(1, 1, 1, 1));
//		this.homeBtn.setPadding(new Insets(15, 10, 15, 10));
//		this.exitBtn.setPadding(new Insets(20, 20, 20, 20));
    }

    private void setStyles() {
        this.headlineLabel.setStyle("-fx-font: 40 arial; -fx-text-fill: white");
        this.setStyle("-fx-border-color: black; -fx-border-width: 0 0 5 0; -fx-background-color: #FFA500;");
//		this.homeBtn.setGraphic(this.homeBtnIcon);
//		this.homeBtnIcon.setSize("40px");
//		this.timeLabel.setStyle("-fx-font: 24 arial;");
//		this.isAdminLabel.setStyle(
//				"-fx-font: 24 arial; -fx-border-radius: 4; -fx-border-color: black; -fx-border-width: 2 2 2 2;");
//		this.homeBtn.setStyle(
//				"-fx-font: 24 arial; -fx-background-radius: 10; -fx-border-radius: 10; -fx-background-color: #1F2F57; -fx-text-fill: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;");
//		this.exitBtn.setStyle(
//				"-fx-font: 24 arial; -fx-background-radius: 10; -fx-border-radius: 10; -fx-background-color: #1F2F57; -fx-text-fill: white;  -fx-border-color: black; -fx-border-width: 3 3 3 3;");
    }

}
