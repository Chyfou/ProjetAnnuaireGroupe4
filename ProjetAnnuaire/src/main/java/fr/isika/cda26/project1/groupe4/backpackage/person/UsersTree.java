package fr.isika.cda26.project1.groupe4.backpackage.person;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.DBFileManager;

/**
 * Manager of all User DB file's methods for the frontend .
 * 
 * @author Thibault SALGUES & Yoann FRANCOIS.
 *
 */
public class UsersTree extends DBFileManager {

//*************************  CONSTRUCTORS  ***************************************	
	/**
	 * Empty constructor
	 */
	public UsersTree() {
		super();
	}
//*************************  PUBLIC METHODES  ************************************

	/**
	 * Get by order all users in the interns directory DB file.
	 * 
	 * @param internsList (:List<User>)
	 * @param index       (:int)
	 * @return (::List<User>)
	 */
	public List<User> getAllUsersInDB(List<User> usersList) {
		int fileLenght = lengthOfUserDBFile();
		if (fileLenght != 0) {
			for (int i = 0; i < fileLenght / USER_SIZE; i++) {
				usersList.add(getUserInDBAtIndex(i));
			}
		}
		return usersList;
	}

	/**
	 * Extract one user from the user's DB file at the required position.
	 * 
	 * @param userIndex (:int)
	 * @return (:User)
	 */
	public User getUserInDBAtIndex(int userIndex) {
		String fileName = DB_URL + USER_DB_FILE;
		User userToReturn;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			rf.seek(userIndex * USER_SIZE);
			String userName = "";
			for (int j = 0; j < NAME_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					userName += charRead;
				}
			}

			String userForename = "";
			for (int j = 0; j < FORENAME_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					userForename += charRead;
				}
			}

			String userEmail = "";
			for (int j = 0; j < EMAIL_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					userEmail += charRead;
				}
			}

			String userPassword = "";
			for (int j = 0; j < PASSWORD_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					userPassword += charRead;
				}
			}

			String userSTATUS = "";
			for (int j = 0; j < STATUS_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					userSTATUS += charRead;
				}
			}

			int userID = rf.readInt();
			userToReturn = new User(userName, userForename, userEmail, userPassword, userSTATUS, userID);

			rf.close();

		} catch (IOException e) {
			userToReturn = new User(EMPTY_STATUS);
			e.printStackTrace();
		}
		return userToReturn;
	}
}
