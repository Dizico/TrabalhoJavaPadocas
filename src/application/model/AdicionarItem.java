package application.model;





import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class AdicionarItem {
	
   @FXML
   private Button btn_calctotitem;
   @FXML
   private Button btn_concitem;

   public void initialize(URL location, ResourceBundle resources) {}
   
	public void acaoCalcular(ActionEvent event) {
    	Platform.exit();
    }
	
	public void acaoConcluir(ActionEvent event) {
    	Platform.exit();
    }

}
