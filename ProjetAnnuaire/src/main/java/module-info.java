module fr.isika.cda26.grp4.projetAnnuaire {
    requires javafx.controls;
	requires javafx.graphics;
	requires itextpdf;
	requires java.desktop;
	requires javafx.base;
	
	opens fr.isika.cda26.project1.groupe4.backpackage.person to javafx.fxml;
	opens fr.isika.cda26.project1.groupe4.frontpackage.views to javafx.fxml;
	opens fr.isika.cda26.project1.groupe4.backpackage.internDirTree to javafx.fxml;
	
    exports fr.isika.cda26.project1.groupe4.backpackage.person;
    exports fr.isika.cda26.project1.groupe4.frontpackage.views;
    exports fr.isika.cda26.project1.groupe4.backpackage.internDirTree;
    exports fr.isika.cda26.project1.groupe4.backpackage.constants;
}
