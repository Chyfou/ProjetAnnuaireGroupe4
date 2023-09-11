package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.DBInit;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.backpackage.person.DBInitUser;
import fr.isika.cda26.project1.groupe4.backpackage.person.User;
import fr.isika.cda26.project1.groupe4.backpackage.person.UsersTree;
import fr.isika.cda26.project1.groupe4.frontpackage.methods.SystemInfo;
import fri.isika.cda26.project1.groupe4.frontpackage.constants.FrontConstants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Launch application.
 * 
 * @author Sabrine SADEQ, Thibault SALGUS & Sabrine SADEQ.
 *
 */

public class App extends Application implements FrontConstants, BackConstants {

// ********************LAUNCHER********************
	public static void main(String[] args) {
		launch();
	}

// ********************OVERRIDEN METHODS********************
	@Override
	public void init() {
		System.out.println("Application start.");
		var javafxVersion = SystemInfo.javafxVersion();
		var javaVersion = SystemInfo.javaVersion();
		System.out.println("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

	}

	@Override
	public void stop() {
		System.out.println("Application stop.");

	}

	@Override
	public void start(Stage stage) throws Exception {
//***************************** INIT WITH STAGE 
		 DBInit dii = new DBInit(stage);
		 DBInitUser diu = new DBInitUser(stage);
		 
//***************************** LEAVES 		 
		 InternsDirectoryTree idt = new InternsDirectoryTree();

		List<Intern> internsList = new ArrayList<Intern>();
		internsList = idt.getAllInternInDB(internsList, START_VALUE);

//***************************** ROOT 
		CurrentUserAccount root = new CurrentUserAccount(internsList);

//***************************** SCENE 
		Scene scene = new Scene(root);

//***************************** STAGE 
		stage.setScene(scene);
		stage.setTitle("My Intern Directory Application");
		stage.getIcons().add(new Image(MINI_ISIKA_LOGO));
		stage.setResizable(false);
		stage.setHeight(STAGE_HEIGHT);
		stage.setWidth(STAGE_WIDTH);
		stage.show();

	}

}
