package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.util.ArrayList;
import java.util.List;
import fr.isika.cda26.project1.groupe4.backpackage.constants.BackConstants;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.InternsDirectoryTree;
import fr.isika.cda26.project1.groupe4.backpackage.person.User;
import fr.isika.cda26.project1.groupe4.backpackage.person.UsersTree;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Generate and fill TableView of interns for all concerned views.
 * 
 * @author Yoann FRANCOIS.
 *
 */

public class UserTableDisplay implements FrontConstants, BackConstants {

// ********************ATTRIBUTES********************
	private TableView<User> usersTable;
	private List<User> usersList;
	private User selectedUser;
	private TextField textFielddName;
	private TextField textFieldForename;
	private TextField textFieldEmail;
	private TextField textFieldSTATUS;

// ********************GETTERS & SETTERS********************
	public TextField getTextFielddName() {
		return textFielddName;
	}

	public TableView<User> getUsersTable() {
		return usersTable;
	}

	public void setUsersTable(TableView<User> usersTable) {
		this.usersTable = usersTable;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public void setTextFielddName(TextField textFielddName) {
		this.textFielddName = textFielddName;
	}

	public TextField getTextFieldForename() {
		return textFieldForename;
	}

	public void setTextFieldForename(TextField textFieldForename) {
		this.textFieldForename = textFieldForename;
	}

	public TextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(TextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public TextField getTextFieldSTATUS() {
		return textFieldSTATUS;
	}

	public void setTextFieldSTATUS(TextField textFieldSTATUS) {
		this.textFieldSTATUS = textFieldSTATUS;
	}

	// *******************CONSTRUCTOR**************************************
	/**
	 * Initialized constructor to generate and fill TableView.
	 */
	public UserTableDisplay() {
		this.usersTable = new TableView<User>();
		this.usersList = new ArrayList<User>();
		this.textFielddName = new TextField();
		this.textFieldForename = new TextField();
		this.textFieldEmail = new TextField();
		this.textFieldSTATUS = new TextField();

		UsersTree frontTree = new UsersTree();
		usersList = frontTree.getAllUsersInDB(usersList);
		usersTable.setEditable(true);
		TableColumn<User, String> colonneName = new TableColumn<User, String>(NAME_LABEL);
		colonneName.setMinWidth(100);
		colonneName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		usersTable.getColumns().add(colonneName);

		TableColumn<User, String> colonneForename = new TableColumn<User, String>(FORENAME_LABEL);
		colonneForename.setMinWidth(100);
		colonneForename.setCellValueFactory(new PropertyValueFactory<User, String>("forename"));
		usersTable.getColumns().add(colonneForename);
		TableColumn<User, String> colonneMail = new TableColumn<User, String>(EMAIL_LABEL);
		colonneMail.setMinWidth(100);
		colonneMail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		usersTable.getColumns().add(colonneMail);
		TableColumn<User, String> colonneStatus = new TableColumn<User, String>(STATUS_LABEL);
		colonneStatus.setMinWidth(100);
		colonneStatus.setCellValueFactory(new PropertyValueFactory<User, String>("STATUS"));
		usersTable.getColumns().add(colonneStatus);
		usersTable.setItems(FXCollections.observableList(usersList));

		this.usersTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
			@Override
			public void changed(ObservableValue<? extends User> observableValue, User oldValue, User newValue) {
				// On affiche les attributs du personnage sélectionné dans le label:
				UserTableDisplay.this.selectedUser = new User(newValue);
				textFielddName.setText(selectedUser.getName());
				textFieldForename.setText(selectedUser.getForename());
				textFieldEmail.setText(selectedUser.getEmail());
				textFieldSTATUS.setText(selectedUser.getSTATUS());
			}
		});

		usersTable.getSelectionModel().selectFirst();

	}

	// *******************GETTERS & SETTERS*******************
	public TableView<User> getInternsDirectoryTable() {
		return usersTable;
	}

	public void setInternsDirectoryTable(TableView<Intern> internsDirectoryTable) {
		this.usersTable = usersTable;
	}

}
