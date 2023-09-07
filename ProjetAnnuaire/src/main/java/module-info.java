module fr.isika.cda26.grp4.projetAnnuaire {
    requires javafx.controls;
	requires javafx.graphics;
	requires itextpdf;
	
	opens fr.isika.cda26.project1.groupe4.backpackage.person to javafx.fxml;
	opens fr.isika.cda26.project1.groupe4.frontpackage.views.app to javafx.fxml;
    opens fr.isika.cda26.project1.groupe4.frontpackage.views.classes to javafx.fxml;
	
    exports fr.isika.cda26.project1.groupe4.backpackage.person;
    exports fr.isika.cda26.project1.groupe4.frontpackage.views.app;
    exports fr.isika.cda26.project1.groupe4.frontpackage.views.classes;
}
