package fr.isika.cda26.project1.groupe4.frontpackage.views.classes;

import javafx.event.ActionEvent;

public interface FrontConstants {

//******************* FONT ********************

	String FONT_TITLE_1 = "-fx-font: 16 arial;";
	String FONT_TITLE_2 = "-fx-font: 18 arial;";
	String FONT_TITLE_3 = "-fx-font: 20 arial;";
	

//*******************SIZE**********************
	int STAGE_WIDTH = 1100;
	int STAGE_HEIGHT = 800;
	float PADDING_VALUE = 10;
	float PADDING_VALUE_2=100;
	int VGAP_VALUE = 20;
	int HGAP_VALUE = 40;
	int TOP_HBOX_HEIGHT = STAGE_HEIGHT / 8;
	int LEFT_PANNEL_WIDTH = STAGE_WIDTH / 5;
	int RIGHT_PANNEL_WIDTH= 550;
	int LEFT_PANNEL_HEIGHT = STAGE_HEIGHT * 1 / 2;
	int COLUMN_WIDTH= (STAGE_WIDTH-LEFT_PANNEL_WIDTH)/5;
	int VBOX_CENTER_WIDTH= STAGE_WIDTH*1/2;
	int HBOX_ICON_SPACING=7;
//*******************COLOR*********************
	String BACKGROUND_COLOR = "-fx-background-color: SEASHELL";
	String LIGHT_BUTTONS_COLOR = "-fx-background-color: navajowhite";
	String DARK_BUTTONS_COLOR = "-fx-background-color: navajowhite";
	String BUTTON_FONT_1 = "-fx-font: 24 arial;";
	String BUTTON_FONT_2 = "-fx-font: 28 arial;";
	String LEFT_PANNEL_COLOR = "-fx-background-color: salmon";
	String TOP_HBOX_COLOR = "-fx-background-color: navajowhite ";

}
