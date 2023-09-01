package fr.isika.cda26.project1.groupe4.backpackage.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface BackConstants {
	
	// ********************************** PATHES*********************************************************
	String USER_DB_FILE = "user_db_file.bin";
	String DIRECTORY_DB_FILE = "internsDirectory_db_file.bin";
	List<String> FILES_LIST = new ArrayList<>(Arrays.asList(USER_DB_FILE, DIRECTORY_DB_FILE));	
	String DB_URL = "src/main/java/db_files/";
	String DON_DIR_URL = "C:/Users/";

	// ********************************** KEY-VALUES FOR DB*********************************************
	String FILLING_CHAR = "*";
	int STOP_VALUE = -1;
	int START_VALUE = 0;
	// ********************************** SIZES OF ATTRIBUTES FOR DB*********************************
	int NAME_SIZE = 25;
	int FORENAME_SIZE = 25;
	int LOCATION_SIZE = 2;
	int PROMOTION_SIZE = 15;
	int PROMOTION_YEAR_SIZE = 1;
	int PASSWORD = 12;
	int EMAIL = 25;
	int STATUS = 4;
	int ID = 1;

	// ********************************** SIZES OF OBJECTS*******************************************
	int INTERN_SIZE = NAME_SIZE + FORENAME_SIZE + LOCATION_SIZE + PROMOTION_SIZE + PROMOTION_YEAR_SIZE;
	int[] INTERN_DB_MASK = new int[] { 0, NAME_SIZE, NAME_SIZE + FORENAME_SIZE,
			NAME_SIZE + FORENAME_SIZE + LOCATION_SIZE, NAME_SIZE + FORENAME_SIZE + LOCATION_SIZE + PROMOTION_SIZE,
			NAME_SIZE + FORENAME_SIZE + LOCATION_SIZE + PROMOTION_SIZE + PROMOTION_YEAR_SIZE };
}
