package application;

import java.io.IOException;
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
    	
    	
    	return y;
    }
    
    double valoreNumeratore(double x)
    {
    	Double numeratore = null;
    	
    	for(int i = 0; i < MemoriaComune.zeri.size(); i++)
    	{
    		if(MemoriaComune.zeri.get(i) == 0)
    		{
    			numeratore = x;
    		}
    		else
    		{
    			
    		}
    	}
    	
    	
    	return numeratore;
    }
    
    double valoreDenominatore()
    {
    	double denominatore = 0;
    	
    	
    	return denominatore;
    }

}
