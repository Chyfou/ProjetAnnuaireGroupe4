package fr.isika.cda26.project1.groupe4.frontpackage.views;

import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.DBInit;
import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	
	//**************Attributs**************
	public InternDirectory internsToTest;
	
	public void init () {
//		internsToTest = new InternDirectory("isika");
//		internsToTest.isikaInterns.add(new Intern("LACROIX", "Pascale", "91", "BOBI 5", 2008));
//		internsToTest.isikaInterns.add(new Intern("CHAVENAU", "Kim Anh", "92", "ATOD 22", 2014));
//		internsToTest.isikaInterns.add(new Intern("GARIJO", "Rosie", "75", "AI 79", 2011));
//		internsToTest.isikaInterns.add(new Intern("POTIN", "Thomas", "75", "ATOD 21", 2014));
	}

	//**************Stage launching**************
    @Override
    public void start(Stage stage) throws Exception{
  	
		DBInit testNewDB = new DBInit(stage);
    	//UserTableView UserInternTableStackPane = new UserTableView(internsToTest);
    	VBox rootTest = new VBox();
        Scene scene = new Scene(rootTest, 100, 100);
        stage.setTitle("About interns");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}