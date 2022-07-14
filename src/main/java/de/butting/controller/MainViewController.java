package de.butting.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import de.butting.views.MainView;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Daniel Niebuhr
 *
 */

public class MainViewController extends ViewController<MainView> {

	private MainView mainMenuView;

	public MainViewController() {
	}

	@Override
	public MainView getView() {
		if (Objects.isNull(this.mainMenuView)) {
			createView();
		}
		return this.mainMenuView;
	}

	@Override
	public void createView() {
		this.mainMenuView = new MainView().createView();
		initializeContent();
		initActionHandlers();
	}

	private void initializeContent() {
		HeaderViewController headerViewController = new HeaderViewController();
		this	.getView()
			.setTop(headerViewController.getView());
	}

	private void initActionHandlers() {
		FileChooser fileChooser = new FileChooser();

		fileChooser	.getExtensionFilters()
				.addAll(new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
						new FileChooser.ExtensionFilter("PNG", "*.png"));
		fileChooser.setInitialFileName("QR-Code");

		this	.getView()
			.getGenerateBtn()
			.setOnAction(e -> {
				String url = this	.getView()
							.getUrlTextField()
							.getText();
				if (!url.isEmpty() && url.length() <= 600) {
					generateQRcode(url);
				}
			});
		this	.getView()
			.getSaveAsImageBtn()
			.setOnAction(e -> {
				Image image = this.getView()
							.getImage();
				if (image != null) {
					exportImage(fileChooser);
				}
			});

	}

	private void generateQRcode(String url) {
		try {
			String charset = "UTF-8";

			Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
			hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			BitMatrix matrix = new MultiFormatWriter().encode(new String(url.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, 300, 300);
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix);
			this	.getView()
				.initializeContent(SwingFXUtils.toFXImage(bufferedImage, null));
			;

		} catch (Exception e) {
			System.out.println("Generieren des QR-Codes fehlgeschlagen!");
			e.printStackTrace();
		}
	}

	private void exportImage(FileChooser fileChooser) {
		Stage stage = new Stage();
		File file = fileChooser.showSaveDialog(stage);

		if (file != null) {
			try {
				ImageIO.write(SwingFXUtils.fromFXImage(this	.getView()
												.getImage(),
						null), "png", file);
			} catch (IOException e) {
				System.out.println("Speichern des Bildes fehlgeschlagen!");
				e.printStackTrace();
			}
		}
	}
}
