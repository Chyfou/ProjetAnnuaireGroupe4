package fr.isika.cda26.project1.groupe4.frontpackage.views;

import fr.isika.cda26.project1.groupe4.backpackage.person.Intern;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class UserTableView extends StackPane {

	private InternDirectory isika;
	private TableView<Intern> userInternTable;

	public UserTableView(InternDirectory isikaInterns) {
		this.isika = isikaInterns;
		this.userInternTable = new TableView<Intern>();

		userInternTable.setEditable(true);

		// **********Name column creation**********
		// Step 1 : creat column.
		TableColumn<Intern, String> nameColumn = new TableColumn<Intern, String>("Name");
		// Step 2 : give width to column.
		nameColumn.setMinWidth(100);
		// Step 3 : detail to how fill column.
		nameColumn.setCellValueFactory(new PropertyValueFactory<Intern, String>("name"));
		// Step 4 : add column to TableView.
		userInternTable.getColumns().add(nameColumn);
		
		// **********Forename column creation**********
				// Step 1 : creat column.
				TableColumn<Intern, String> foreNameColumn = new TableColumn<Intern, String>("Forename");
				// Step 2 : give width to column.
				foreNameColumn.setMinWidth(100);
				// Step 3 : detail to how fill column.
				foreNameColumn.setCellValueFactory(new PropertyValueFactory<Intern, String>("forename"));
				// Step 4 : add column to TableView.
				userInternTable.getColumns().add(foreNameColumn);
				
				// **********Location column creation**********
				// Step 1 : creat column.
				TableColumn<Intern, String> locationColumn = new TableColumn<Intern, String>("Location");
				// Step 2 : give width to column.
				locationColumn.setMinWidth(100);
				// Step 3 : detail to how fill column.
				locationColumn.setCellValueFactory(new PropertyValueFactory<Intern, String>("location"));
				// Step 4 : add column to TableView.
				userInternTable.getColumns().add(locationColumn);
				
				// **********Promotion column creation**********
				// Step 1 : creat column.
				TableColumn<Intern, String> promotionColumn = new TableColumn<Intern, String>("Promotion");
				// Step 2 : give width to column.
				promotionColumn.setMinWidth(100);
				// Step 3 : detail to how fill column.
				promotionColumn.setCellValueFactory(new PropertyValueFactory<Intern, String>("promotion"));
				// Step 4 : add column to TableView.
				userInternTable.getColumns().add(promotionColumn);
				
				// **********Year column creation**********
				// Step 1 : creat column.
				TableColumn<Intern, String> yearColumn = new TableColumn<Intern, String>("Year");
				// Step 2 : give width to column.
				yearColumn.setMinWidth(100);
				// Step 3 : detail to how fill column.
				yearColumn.setCellValueFactory(new PropertyValueFactory<Intern, String>("year"));
				// Step 4 : add column to TableView.
				userInternTable.getColumns().add(yearColumn);		
		
		//**************Observable list set up***************
		userInternTable.setItems(FXCollections.observableList(isika.isikaInterns));

		// **************HBox**************
		HBox titleUserInternTableHBox = new HBox(50);
		titleUserInternTableHBox.setAlignment(Pos.CENTER);
		Label UserInternTableLabel = new Label("Isika interns directory");
		UserInternTableLabel.setFont(new Font("Comic Sans MS", 40));
		UserInternTableLabel.setStyle("-fx-font-weight: bold");
		titleUserInternTableHBox.getChildren().add(UserInternTableLabel);

		// **************BorderPane**************
		BorderPane UserInternTableBorderPane = new BorderPane();
		UserInternTableBorderPane.setTop(titleUserInternTableHBox);
		UserInternTableBorderPane.setCenter(userInternTable);

		// **************StackPane**************
		StackPane UserInternTableStackPane = new StackPane();
		this.setStyle("-fx-background-color: MISTYROSE");
		this.getChildren().add(UserInternTableBorderPane);
	}
}
