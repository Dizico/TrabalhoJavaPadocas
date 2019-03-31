package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
 
public class MainController implements Initializable {
 
   @FXML
   private Button btn_cadfunc;
   @FXML
   private Button btn_cadprod;
   @FXML
   private Button btn_cadfunclista;
   @FXML
   private Button btn_cadprodlista;
   @FXML
   private Button btn_saida;
   @FXML
   private Button btn_cobranca;
   @FXML
   private Button btn_relfat;
   @FXML
   private Button btn_fpagamento;
   @FXML
   private Pane contenedor;
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {}
 
   public void abreTelaCF(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaCadastroFuncionario/Visual_CadastroFuncionario.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void abreTelaCP(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaCadastroProduto/Visual_CadastroProduto.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void abreTelaCFLista(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaFuncionariosCadastrados/Visual_FuncionariosCadastrados.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void abreTelaCPLista(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaProdutosCadastrados/Visual_ProdutosCadastrados.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void abreTelaSaida(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaFinalizaRegistroItemComanda/Visual_FinalizaRegistroItemComanda.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void abreTelaCobranca(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaCobranca/Visual_Cobranca.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void abreTelaRF(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaRelatorio/Visual_Relatorio.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   public void abreTelaFPagamento(ActionEvent event) {
	   try {
			Pane tela = FXMLLoader.load(getClass().getResource("../application/telaFormaPagamento/Visual_FormaPagamento.fxml"));
			contenedor.getChildren().clear();
			contenedor.getChildren().add(tela);
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
  
}