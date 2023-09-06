package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.DBInit;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application implements BackConstants{
	
	//**************Attributs**************
	public InternDirectory internsToTest;
	
	public void init () {
	}

	public static void main(String[] args) {
        launch(args);
    }

	//**************Stage launching**************
    @Override
    public void start(Stage stage) throws Exception{
  	
		DBInit testNewDB = new DBInit(stage);	
		InternsDirectoryTree internDir =  new InternsDirectoryTree();
		List<Intern> internsList = new ArrayList<Intern>();
		internsList = internDir.getAllInternInDB(internsList, START_VALUE);
		for (Intern intern : internsList) {
			System.out.println(intern);
			}
		internsList.clear();
		internsList = internDir.getInTreegetAllInternsWithLocation(internsList, START_VALUE, "92");
		System.out.println(internsList.size());
		for (Intern intern : internsList) {
			System.out.println(intern);
			}
		internsList.clear();
    	//UserTableView UserInternTableStackPane = new UserTableView(internsToTest);
    	VBox rootTest = new VBox();
        Scene scene = new Scene(rootTest, 100, 100);
        stage.setTitle("About interns");
        stage.setScene(scene);
        stage.show();
    }

    
}