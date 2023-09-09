package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.backpackage.person.DBUsersManager;
import fr.isika.cda26.project1.groupe4.backpackage.person.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Launch application.
 * 
 * @author Sabrine SADEQ.
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
		InternsDirectoryTree idt = new InternsDirectoryTree();
		DBUsersManager dum = new DBUsersManager();
		List<User> usersList = new ArrayList<User>();
		dum.getAllUsersInDB(usersList);
		for (User user : usersList) {
			System.out.println(user);
		}
		List<Intern> internsList = new ArrayList<Intern>();
		idt.getAllInternInDB(internsList, START_VALUE);
		for (Intern intern : internsList) {
			System.out.println(intern);
		}

//Main root.
		CurrentUserAccount root = new CurrentUserAccount(internsList);

//Initialized Scene
		Scene scene = new Scene(root);

//Initialized Stage.
		stage.setScene(scene);
		stage.setTitle("My Intern Directory Application");
		stage.getIcons().add(new Image(("Mini_Isika_logo.png")));
		stage.setHeight(STAGE_HEIGHT);
		stage.setWidth(STAGE_WIDTH);
		stage.show();

	}

}
