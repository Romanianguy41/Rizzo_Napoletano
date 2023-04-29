package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SchermataPrincipaleController 
{
	@FXML
	TextField guadagno;
	@FXML
	TextField numeroZeri;
	@FXML
	TextField numeroPoli;
	@FXML
	TextField valoreMassimo;
	@FXML
	Button btnCalcola;

	@FXML
	void initialize() 
	{

	}

	@FXML
	void calcola(ActionEvent event) throws IOException
	{
		//double pesoCollegamento = apriPopUp();
		MemoriaComune.guadagno = getNumeroDouble(this.guadagno);
		MemoriaComune.valoreMassimo = getNumeroDouble(this.valoreMassimo);
		int numeroZeri = getNumeroInteger(this.numeroZeri);
		int numeroPoli = getNumeroInteger(this.numeroPoli);
		for (int i = 0; i < numeroZeri; i++)
		{
			MemoriaComune.zeri.add(apriPopUp());
		}
		for (int i = 0; i < numeroPoli; i++)
		{
			MemoriaComune.poli.add(apriPopUp());
		}
		apriGrafici(event);
	}

	double getNumeroDouble(TextField testoDaEstrarre) 
	{
		double numero = 0.4141;
		boolean inserito = true;	
		//do {
			try
			{
				numero = Double.parseDouble(testoDaEstrarre.getText());
				inserito = false;
			} 
			catch (Exception e) 
			{
				Alert alert = new Alert(Alert.AlertType.ERROR, "Inserire un numero");
				alert.showAndWait();
				testoDaEstrarre.clear();
			}
		//}while(inserito);
		
		return numero;
	}

	int getNumeroInteger(TextField testoDaEstrarre) 
	{
		int numero = -1;
		do {
			try
			{
				numero = Integer.parseInt(testoDaEstrarre.getText());
			} 
			catch (Exception e) 
			{
				Alert alert = new Alert(Alert.AlertType.ERROR, "Inserire un valore lecito");
				alert.showAndWait();
				testoDaEstrarre.clear();
			}
		} while (numero < 0);
		return numero;
	}
	
	Double apriPopUp() throws IOException 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("popUp.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(new Scene(root));
		stage.showAndWait();
		double pesoCollegamento = ((ControllerPopUp) loader.getController()).getPeso();
		return pesoCollegamento;
	}
	
	void apriGrafici(Event event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("grafici.fxml"));
    	AnchorPane root = (AnchorPane)loader.load();
    	Stage stage = new Stage();
    	stage.initStyle(StageStyle.TRANSPARENT);
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.setScene(new Scene(root));
    	stage.showAndWait();
	}
}
