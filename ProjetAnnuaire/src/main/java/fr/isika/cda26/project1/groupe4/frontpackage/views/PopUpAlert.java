package fr.isika.cda26.project1.groupe4.frontpackage.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpAlert implements FrontConstants {
	
	//********************ATTRIBUTES********************
	private Stage popUpWindow;
	private Scene popUpScene;
	private Label popUpLabel;
	private Button popUpButton;
	private VBox popUpVbox;
		
	//********************CONSTRUCTOR********************
	public PopUpAlert() {
		super();
	}
	
	//********************PUBLIC METHODS********************
	/**
	 * Generate popup when id is false for login.
	 */
	public void falseIdPopUp(){
		popUpWindow = new Stage();
		popUpWindow.initModality(Modality.APPLICATION_MODAL);
		popUpLabel = new Label();
		popUpButton = new Button();
		popUpButton.setOnAction(e -> popUpWindow.close());
		popUpVbox = new VBox(20);
		popUpVbox.setPrefSize(250, 100);
		popUpVbox.setStyle(LEFT_PANNEL_COLOR);
		popUpVbox.getChildren().addAll(popUpLabel, popUpButton);
		popUpVbox.setAlignment(Pos.CENTER);
		popUpWindow.setTitle("Oups !");
		popUpLabel.setText("Wrong id, try again.");
		popUpButton.setText("Close");
		popUpScene = new Scene(popUpVbox);
		popUpWindow.setScene(popUpScene);
		popUpWindow.showAndWait();
	}
	
		/**
		 * Generate popup when pdf is downland.
		 */
		public void downLandingPDF(){
			popUpWindow = new Stage();
			popUpWindow.initModality(Modality.APPLICATION_MODAL);
			popUpLabel = new Label();
			popUpButton = new Button();
			popUpButton.setOnAction(e -> popUpWindow.close());
			popUpVbox = new VBox(20);
			popUpVbox.setPrefSize(500, 100);
			popUpVbox.setStyle(TOP_HBOX_COLOR);
			popUpVbox.getChildren().addAll(popUpLabel, popUpButton);
			popUpVbox.setAlignment(Pos.CENTER);
			popUpWindow.setTitle("PDF Downlander");
			popUpLabel.setText("Your extraction is done, you will find the PDF inside your Downland Folder !");
			popUpButton.setText("Close");
			popUpScene = new Scene(popUpVbox);
			popUpWindow.setScene(popUpScene);
			popUpWindow.showAndWait();
		}

	//********************GETTERS & SETTERS********************	
	public Stage getPopUpWindow() {
		return popUpWindow;
	}
	public void setPopUpWindow(Stage popUpWindow) {
		this.popUpWindow = popUpWindow;
	}
	public Scene getPopUpScene() {
		return popUpScene;
	}
	public void setPopUpScene(Scene popUpScene) {
		this.popUpScene = popUpScene;
	}
	public Label getPopUpLabel() {
		return popUpLabel;
	}
	public void setPopUpLabel(Label popUpLabel) {
		this.popUpLabel = popUpLabel;
	}
	public Button getPopUpButton() {
		return popUpButton;
	}
	public void setPopUpButton(Button popUpButton) {
		this.popUpButton = popUpButton;
	}
	public VBox getPopUpVbox() {
		return popUpVbox;
	}
	public void setPopUpVbox(VBox popUpVbox) {
		this.popUpVbox = popUpVbox;
	}
	
}
