package fr.isika.cda26.project1.groupe4.frontpackage.views;

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
	
	//int TABLE_BORDERPANE_WIDTH= STAGE_WIDTH-LEFT_PANNEL_WIDTH-1;
	//int TABLE_BORDERPANE_HEIGHT= STAGE_HEIGHT-TOP_HBOX_HEIGHT;
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

}
