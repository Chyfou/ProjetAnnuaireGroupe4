package fr.isika.cda26.project1.groupe4.backpackage.person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.DBFileManager;
import javafx.stage.Stage;

public class DBInitUser extends DBFileManager {

//*************************  CONSTRUCTORS  ***************************************		
	/**
	 * Empty constructor. Initialize the Db directories and files.
	 */
	public DBInitUser(Stage stage) {
		super();
		int lengthDBfile = lengthOfUserDBFile();
		System.out.println("******************TAILLLLLLO**"+ lengthDBfile );
		if (lengthDBfile == 0) {
			createUsersDBFiles();
			System.out.println("Ask Admin for User's DON files.");
			File donUsersFile = getDonFile(stage);
			System.out.println("User's DON files caught.");
			System.out.println("Reading User's DON File in progress");
			writeUsersInDBFrom(donUsersFile);
			System.out.println("Reading User's Don file done.");
		}
	}

//********************************** PRIVATES METHODS ************************************
	/**
	 * Get all values in DON file to create Interns Object in Binary DB file.
	 * 
	 * @param donUsersFile (:File)
	 */
	private void writeUsersInDBFrom(File donUsersFile) {
		FileReader fr;
		try {
			fr = new FileReader(donUsersFile);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			while (br.ready()) {
				int iterator = START_VALUE;

				while (iterator != STOP_VALUE) {
					content = br.readLine();
					User userToAdd = new User(content);
					content = br.readLine();
					userToAdd.setName(content);
					content = br.readLine();
					userToAdd.setForename(content);
					content = br.readLine();
					userToAdd.setEmail(content);
					content = br.readLine();
					userToAdd.setPassword(content);
					content = br.readLine();
					iterator = STOP_VALUE;
					userToAdd.writeUserInDB();
					// internToAdd.writeInternInDB();
				}
			}
			File db = new File(DB_URL + DIRECTORY_DB_FILE);
			System.out.println(db.length());
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
