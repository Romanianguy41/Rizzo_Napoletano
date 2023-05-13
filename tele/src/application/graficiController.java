package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class graficiController {

	private Stage stage;
	
    @FXML
    private Button back;

    @FXML
    private LineChart<?, ?> graficoFase;

    @FXML
    private LineChart<?, ?> graficoModulo;

    @FXML
    void back(ActionEvent event) throws IOException {
    
  	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  	  stage.close();

    }
    
    double puntoY()
    {
    	double y = 0;
    	double x = 0;
    	y = Math.log(MemoriaComune.guadagno)*(valoreCalcolato(x, MemoriaComune.zeri)/ valoreCalcolato(x, MemoriaComune.poli));
    	
    	
    	
    	return y;
    }
    
    double valoreCalcolato(double x, ArrayList<Double> numeri)
    {
    	Double numeratore = null;
    	
    	numeratore = numeri.get(0);
    	
    	for(int i = 1; i < numeri.size(); i++)
    	{
    		if(numeri.get(i) == 0)
    		{
    			numeratore = numeratore * x;
    		}
    		else
    		{
    			numeratore = numeratore * calcolaReciproco(numeri.get(i), x);
    		}
    	}
    	return numeratore;
    }
    
    double calcolaReciproco(double valore, double x)
    {
    	Double reciproco = 1/valore;
    	return reciproco*x+1;
    }

}
