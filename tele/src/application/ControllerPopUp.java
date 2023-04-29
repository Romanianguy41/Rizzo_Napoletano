package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerPopUp {

    @FXML
    private Button btnPeso;

    @FXML
    private TextField peso;
    
    @FXML
    private Text testo;

    @FXML
    void initialize()
    {
    	testo.setText("Inserisci il "+ MemoriaComune.numero + "° "+ MemoriaComune.chiamata );
    }
    
    /**
     * Metodo per recuperare il peso dal textField il peso ed assicurarsi che sia un numero
     * @param event
     */
    @FXML
    void aggiungiPeso(ActionEvent event) 
    {
    	if (peso.getText().isEmpty())
    	{
    		Alert errore = new Alert(Alert.AlertType.ERROR, "Inserire un valore");
    		errore.initStyle(StageStyle.TRANSPARENT);
    		errore.showAndWait();
    	}
    	else
    	{
    		try 
    		{
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	    	stage.close();
    		}
    		catch (Exception e) 
    		{
    			 Alert alert = new Alert(Alert.AlertType.ERROR, "Inserire un numero");
                 alert.showAndWait();
    		}
    	}
    }
    
    /**
     * Metodo per prende il valore del peso 
     * 
     * @return valore del peso scritto
     */
    public double getPeso() 
    {
        double peso = Double.parseDouble(this.peso.getText());
        return peso;
    }
}
