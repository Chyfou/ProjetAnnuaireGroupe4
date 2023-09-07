package fr.isika.cda26.project1.groupe4.frontpackage.views.app;

import fr.isika.cda26.project1.groupe4.frontpackage.views.classes.CurrentUserAccount;
import fr.isika.cda26.project1.groupe4.frontpackage.views.classes.FrontConstants;
import fr.isika.cda26.project1.groupe4.frontpackage.views.classes.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application implements FrontConstants {

//****************************** ATTRIBUTES *********************************************************
	


	public static void main(String[] args) {
		launch();
	}

// *************************  OVERRIDDEN METHODS *****************************************************
	@Override
	public void init() {
		System.out.println("DB connected");
		var javafxVersion = SystemInfo.javafxVersion();
		var javaVersion = SystemInfo.javaVersion();
		System.out.println("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");



	}

	@Override
	public void stop() {
		System.out.println("DB disconnected");

	}

	@Override
	public void start(Stage stage) throws Exception {

// ****** ROOT***************************************************************************************
		CurrentUserAccount root = new CurrentUserAccount();
		
        
// ****** SCENE**************************************************************************************
		Scene scene = new Scene(root);
		
// ****** STAGE**************************************************************************************
		stage.setScene(scene);
		stage.setTitle("my intern directory application");
		stage.setHeight(STAGE_HEIGHT);
		stage.setWidth(STAGE_WIDTH);
		stage.show();

	}

}
