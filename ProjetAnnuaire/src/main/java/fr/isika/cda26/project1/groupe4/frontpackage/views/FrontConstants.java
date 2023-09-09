package fr.isika.cda26.project1.groupe4.frontpackage.views;

/**
 * Generate constants for the front.
 * 
 * @author Sabrine SADEQ & Thibault SALGUES.
 *
 */

public interface FrontConstants {

	//******************* FONT ********************
	String FONT_TITLE_1 = "-fx-font: 16 arial;";
	String FONT_TITLE_2 = "-fx-font: 18 arial;";
	String FONT_TITLE_3 = "-fx-font: 20 arial;";
	String BUTTON_FONT_1 = "-fx-font: 24 arial;";
	String BUTTON_FONT_2 = "-fx-font: 28 arial;";

	//*******************SIZE**********************
	int STAGE_WIDTH = 1150;
	int STAGE_HEIGHT = 800;
	float PADDING_VALUE = 10;
	float PADDING_VALUE_2=100;
	int VGAP_VALUE = 20;
	int HGAP_VALUE = 40;
	int TOP_HBOX_HEIGHT = STAGE_HEIGHT / 9;
	int LEFT_PANNEL_WIDTH = STAGE_WIDTH / 5;
	int RIGHT_PANNEL_WIDTH= 550;
	int LEFT_PANNEL_HEIGHT = STAGE_HEIGHT * 1 / 2;
	int COLUMN_WIDTH= (STAGE_WIDTH-LEFT_PANNEL_WIDTH)/6;
	int VBOX_CENTER_WIDTH= STAGE_WIDTH*1/2;
	int HBOX_SPACING=7;
	int HBOX_WIDTH=200;
	int HBOX_HEIGHT=100;
	int BUTTON_WIDTH=150;
	int BUTTON_HEIGHT=15;
	int VBOX_SPACING=40;
	int TEXT_FIELDS_WIDTH=200;
	int TEXT_FIELDS_HEIGHT=30;	
	
	//*******************COLOR*********************
	String BACKGROUND_COLOR = "-fx-background-color: SEASHELL";
	String LIGHT_BUTTONS_COLOR = "-fx-background-color: navajowhite";
	String DARK_BUTTONS_COLOR = "-fx-background-color: navajowhite";
	String LEFT_PANNEL_COLOR = "-fx-background-color: salmon";
	String TOP_HBOX_COLOR = "-fx-background-color: navajowhite ";
	
	//*******************IMAGES*********************
	String HELP_LOGO = "Help_logo.png";
	String DOWNLOAD_LOGO =  "Download_logo.png";
	String SETTINGS_LOGO = "Settings_logo.png";
	String SIGN_OUT_LOGO = "Sign_out_logo.png";
	String BACK_LOGO = "Back_logo.png";
	String LOGIN_LOGO = "Log_in_logo.png";
	String INTERN_LOGO = "Intern_logo.png";
	String STAFF_LOGO = "Staff_logo.png";
	
	//*******************BUTTONS********************
	String SETTINGS_BUTTON = "Settings";
	String SIGN_OUT_BUTTON = "Sign out";
	String HELP_BUTTON = "Help";
	String DOWNLOAD_BUTTON = "Export";
	String SEARCH_BUTTON = "Search";
	String REFRESH_BUTTON = "Refresh";
	String DELETE_INTERN_BUTTON = "Remove selection";
	String CREATE_ACCOUNT_BUTTON = "Create account";
	String BACK_BUTTON = "Back home";
	String ADD_BUTTON = "Add";
	String LOGIN_BUTTON = "Log in";
	String INTERN_DIRECTORY_BUTTON = "Interns directory" ;
	String REMOVE_ACCOUNT_BUTTON = "Remove account";
	String UPDATE_ACCOUNT_BUTTON = "Update account";
	String NEW_INTERNS_FILE_BUTTON = "Add new interns file";
	String CLOSE_BUTTON = "Close";
	String CHANGE_NAME_BUTTON = "Change name";
	String CHANGE_FORENAME_BUTTON = "Change forename";
	String CHANGE_EMAIL_BUTTON = "Change E-mail";
	String CHANGE_PASSWORD_BUTTON = "Change password";
	String STAFF_LIST_BUTTON = "Staff list";
	String MANAGE_STAFF_BUTTON = "Manage staff";
	
	//*******************LABELS********************
	String NAME_LABEL = "Name";
	String FORENAME_LABEL = "Forename";
	String LOCATION_LABEL = "Location";
	String PROMOTION_LABEL = "Promotion";
	String PROMOTION_YEAR_LABEL = "Promotion year";
	String EMAIL_LABEL = "E-mail";
	String STATUS_LABEL = "Status";
	String PASSWORD_LABEL = "Password";
	String ID_LABEL = "ID";
	String WELCOME_LABEL = "Welcome !";
	String SETTINGS_LABEL = "Settings";
	
	//*******************URL********************
	String PRINT_INTERNS_DIRECTORY_PDF_URL = "/Downloads/MyInternsDirectoryExtraction.pdf";
	String DISPLAY_USE_DOC_LABEL = "src/main/java/files/Directory_app_use_doc.pdf";
	
}
