package fr.isika.cda26.project1.groupe4.frontpackage.views.classes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends BorderPane implements FrontConstants {
	
	 
	  private  Button btn=new Button("Log in");
	
	  public Login() {
      super();

//******************I instanciate my BorderPane*******************************************
        BorderPane root=new BorderPane();
     
//*******************I instanciate VBox of my leftPannel**************************
		VBox vbox1 = new VBox();
		Label wlc = new Label(" Welcome back ");
		vbox1.getChildren().add(wlc);
//******************I stylist my leftpannel*************************************************
 		vbox1.setStyle(LEFT_PANNEL_COLOR);
 		vbox1.setPrefSize(LEFT_PANNEL_WIDTH, LEFT_PANNEL_HEIGHT);   
     	vbox1.setAlignment(Pos.TOP_CENTER);
     		
//*******************I stylist labels of my leftPannel**************************************
     	wlc.setStyle(BUTTON_FONT_1);

//***************** I instanciate labels and text fields of my VBox*****************
     	AnchorPane anchor = new AnchorPane();
		GridPane grid=new GridPane();
//login:
		Label loglabel=new Label(" Log in ");
		
//name:
		Label name=new Label(" Name ");
		TextField textname= new TextField();
//forename:
		Label forename=new Label(" Forename ");
		TextField textforename= new TextField();
//password
		Label password=new Label(" Password ");
		PasswordField textpasseword=new PasswordField();
		
//*******************I instanciate AnchorPane in my center***********************************************

		anchor.setStyle(BACKGROUND_COLOR);
		anchor.getChildren().addAll(loglabel,grid,btn);
		anchor.setTopAnchor(loglabel, 100.0);
		anchor.setLeftAnchor(loglabel, 400.0);
		anchor.setRightAnchor(loglabel, 400.0);
		anchor.setTopAnchor(grid, 200.0);
		anchor.setRightAnchor(grid, 300.0);
		anchor.setLeftAnchor(grid, 300.0);
		anchor.setTopAnchor(btn, 500.0);
		anchor.setRightAnchor(btn, 680.0);
		anchor.setLeftAnchor(btn, 380.0);
		
		
		
//******************I stylist labels of my VBox**************************************
		loglabel.setStyle(BUTTON_FONT_1);
		name.setStyle(FONT_TITLE_1);
		forename.setStyle(FONT_TITLE_1);
		password.setStyle(FONT_TITLE_1);
		btn.setStyle(BUTTON_FONT_1);
		btn.setStyle(LIGHT_BUTTONS_COLOR);
		
//****we add several child Nodes on the same row with the addRow() method************
		grid.addRow(2, name,textname);
		grid.addRow(4, forename,textforename);
		grid.addRow(6, password,textpasseword);
	
//********************add padding to my pannel***************************************
		grid.setPadding(new Insets(PADDING_VALUE,PADDING_VALUE,PADDING_VALUE,PADDING_VALUE));
		grid.setStyle(BACKGROUND_COLOR);
		grid.setVgap(VGAP_VALUE);
		grid.setHgap(HGAP_VALUE);
		
	
//********************I position my components in root********************************
		  setLeft(vbox1);
		  setCenter(anchor);
		  
//****************************The Events****************************************
			btn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
				 AdminPage admin=new AdminPage();
				 Scene scene=new Scene(admin);
				Stage stage=(Stage) Login.this.getScene().getWindow();
				
			     stage.setScene(scene);
				 
					
				}
			});
		
	}
	public Button getBtn() {
		return btn;
	}
	public void setBtn(Button btn) {
		this.btn = btn;
	}

	

	
}
