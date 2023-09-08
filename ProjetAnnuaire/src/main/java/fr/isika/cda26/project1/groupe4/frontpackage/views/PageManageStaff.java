package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PageManageStaff extends BorderPane implements FrontConstants{
	
	    private Button internDirectory= new Button(" Intern directory ");
		private Button settings= new Button(" Settings ");
		private Button signout= new Button(" Sign out ");
		private TextField search = new TextField(" search");
  		private Button createButton= new Button(" Create an account ");
  		private Button removeButton= new Button(" Remove an account ");
  		private Button updateButton= new Button(" Update an account ");
  		private Button newFileButton= new Button(" Add new interns file ");
  		private List<Intern> internsList;

  		public PageManageStaff(List<Intern> internsList) {
  			super();
  			this.internsList =  new ArrayList<Intern>(internsList);

//******************I instanciate my BorderPane************************************
	          BorderPane root=new BorderPane();
 
//******************I instanciate my leftPannel************************************
      		Pane leftPannel=new Pane();
//******************** I instanciate vbox of my leftPannel****************************
      		VBox vboxLeftPannel = new VBox(100);
      		Label adminlabel = new Label(" Menu");
      		adminlabel.setStyle(BUTTON_FONT_2);
            vboxLeftPannel.getChildren().addAll(adminlabel,internDirectory,settings, signout);
      		leftPannel.getChildren().add(vboxLeftPannel);
//*******************I add icons***************************************************
      		HBox hbox1= new HBox(HBOX_SPACING);
    		HBox hbox2= new HBox(HBOX_SPACING);
    		HBox hbox3= new HBox(HBOX_SPACING);
    		HBox hbox4= new HBox(HBOX_SPACING);
    	    hbox1.getChildren().add(adminlabel);
    	    Image imageStaff = new Image("Intern_logo.png");
    		ImageView imageView1 = new ImageView();
    		imageView1.setImage(imageStaff);
    		hbox2.getChildren().addAll(imageView1,internDirectory);
    		Image imageSettings = new Image("Settings_logo.png");
    		ImageView imageView2 = new ImageView();
    		imageView2.setImage(imageSettings);
    		hbox3.getChildren().addAll(imageView2,settings);
    		Image imageSignout = new Image("Sign_out_logo.png");
    		ImageView imageView3 = new ImageView();
    		imageView3.setImage(imageSignout);
    		hbox4.getChildren().addAll(imageView3,signout);
    		hbox2.setAlignment(Pos.CENTER_RIGHT);
    		hbox3.setAlignment(Pos.CENTER_RIGHT);
    		hbox4.setAlignment(Pos.CENTER_RIGHT);
    		vboxLeftPannel.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);
 
//********************I stylist buttons of my LeftPannel******************************
    		internDirectory.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
			settings.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
			signout.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

			
//********************I instanciate AnchorPane in my center****************************
      		AnchorPane anchorLeft = new AnchorPane();
//****************I stylist AchorPane************************************************** 		
    		anchorLeft.setStyle(LEFT_PANNEL_COLOR);
//**************I position  components in AnchorPane***********************************	
    		anchorLeft.getChildren().add(vboxLeftPannel);
    		leftPannel.getChildren().add(anchorLeft);
    		AnchorPane.setTopAnchor(vboxLeftPannel, 200.0);
    		AnchorPane.setRightAnchor(vboxLeftPannel, 5.0);
    		AnchorPane.setLeftAnchor(vboxLeftPannel, 5.0);
    		
//********I stylist my leftPannel and its components***********************************
      		leftPannel.setStyle(LEFT_PANNEL_COLOR);
      		leftPannel.setPrefSize(LEFT_PANNEL_WIDTH,LEFT_PANNEL_HEIGHT );
      		vboxLeftPannel.setAlignment(Pos.CENTER_RIGHT);
      		adminlabel.setStyle("-fx-font-weight: bold");
      		adminlabel.setStyle(FONT_TITLE_1);
//********* I instanciate my rightPannel**********************************************
      		Pane rightPannel=new Pane();
      		VBox vboxRightPannel=new VBox(50);
      		Label labelStaffDirectory=new Label(" Staff directory ");
      		TableView<Intern> table = new TableView<Intern>();
      		vboxRightPannel.getChildren().addAll(labelStaffDirectory,table);
       		labelStaffDirectory.setStyle(FONT_TITLE_3);

      		
//*******************I instanciate AnchorPane OF MY RightPannel******************************************
      		AnchorPane anchorRight = new AnchorPane();
    		anchorRight.setStyle(BACKGROUND_COLOR);
    		anchorRight.getChildren().add(vboxRightPannel);
    		rightPannel.getChildren().add(anchorRight);
            AnchorPane.setTopAnchor(vboxRightPannel, 200.0);
    		AnchorPane.setRightAnchor(vboxRightPannel, 10.0);
    		AnchorPane.setLeftAnchor(vboxRightPannel, 10.0);
    		rightPannel.setPrefSize(RIGHT_PANNEL_WIDTH,STAGE_HEIGHT );
//*********************I instanciate labels and buttons in the center*************************************
      		VBox vboxCenter=new VBox(50);
      		Label manageStaff= new Label(" Manage staff");
      		manageStaff.setStyle(FONT_TITLE_3);
      		vboxCenter.getChildren().addAll(manageStaff,search,createButton,removeButton,updateButton,newFileButton);
      		vboxCenter.setAlignment(Pos.CENTER);
      		vboxCenter.setPrefSize(200,200 );
//**************I position my components in the BorderPane******************************
		    setLeft(leftPannel);
		    setRight(rightPannel);
		    setCenter(vboxCenter);
		    setStyle(BACKGROUND_COLOR);
		    
//***************************The Events************************************************
		    
		    createButton.setOnAction(new EventHandler<ActionEvent>() {

		    	@Override
				public void handle(ActionEvent arg0) {
					CreateAnAccount createAnAccount = new CreateAnAccount(PageManageStaff.this.internsList);
					Scene scene = new Scene(createAnAccount);
					Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

					stage.setScene(scene);
				}
			});
		
                settings.setOnAction(new EventHandler<ActionEvent>() {

		    	public void handle(ActionEvent arg0) {
					Settings settings= new Settings(PageManageStaff.this.internsList);
					Scene scene = new Scene(settings);
					Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

					stage.setScene(scene);
				}
			});
                signout.setOnAction(new EventHandler<ActionEvent>() {

    		    	public void handle(ActionEvent arg0) {
    					CurrentUserAccount pageCurrentUser= new CurrentUserAccount(PageManageStaff.this.internsList);
    					Scene scene = new Scene(pageCurrentUser);
    					Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

    					stage.setScene(scene);
    				}
    			});
                
                internDirectory.setOnAction(new EventHandler<ActionEvent>() {

    		    	public void handle(ActionEvent arg0) {
    					SuperAdminPage adminPage= new SuperAdminPage(PageManageStaff.this.internsList);
    					Scene scene = new Scene(adminPage);
    					Stage stage = (Stage) PageManageStaff.this.getScene().getWindow();

    					stage.setScene(scene);
    				}
    			});
                
                
  
 }

public Button getInternDirectory() {
	return internDirectory;
}

public void setInternDirectory(Button internDirectory) {
	this.internDirectory = internDirectory;
}

public Button getSettings() {
	return settings;
}

public void setSettings(Button settings) {
	this.settings = settings;
}

public Button getSignout() {
	return signout;
}

public void setSignout(Button signout) {
	this.signout = signout;
}

public TextField getSearch() {
	return search;
}

public void setSearch(TextField search) {
	this.search = search;
}

public Button getCreateButton() {
	return createButton;
}

public void setCreateButton(Button createButton) {
	this.createButton = createButton;
}

public Button getRemoveButton() {
	return removeButton;
}

public void setRemoveButton(Button removeButton) {
	this.removeButton = removeButton;
}

public Button getUpdateButton() {
	return updateButton;
}

public void setUpdateButton(Button updateButton) {
	this.updateButton = updateButton;
}

public Button getNewFileButton() {
	return newFileButton;
}

public void setNewFileButton(Button newFileButton) {
	this.newFileButton = newFileButton;
}


	}
