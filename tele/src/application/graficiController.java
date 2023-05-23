package application;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class graficiController {

	private Stage stage;
	
    @FXML
    private Button back;

    final NumberAxis asseX = new NumberAxis(Math.log10(1), Math.log10(100), 1);
	final NumberAxis asseY = new NumberAxis();
	XYChart.Series serie1;
    @FXML
    private LineChart<?, ?> graficoFase = new LineChart<>(asseX, asseY);

    @FXML
    private LineChart<?, ?> graficoModulo = new LineChart<>(asseX, asseY);
    
    @FXML
    private Button btnCalcola;

    
    @FXML
    void initialize()
    {
    	serie1 = new XYChart.Series();
    }
    @FXML
    void back(ActionEvent event) throws IOException 
    {
    
  	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  	  stage.close();

    }
    
    @FXML
    void calcola(ActionEvent event) throws IOException 
    {
    	/*for(int i = 0; i < 50000; i++)
    	{
    		double pippo = puntoY((double)i);
    		System.out.println(i);
    		
    		serie1.getData().add(new XYChart.Data(Integer.toString(i), pippo));
    	}*/
    	serie1.getData().add(new XYChart.Data(X:"1", Y:3));
    	serie1.getData().add(new XYChart.Data(X:"2", Y:2));
    	serie1.getData().add(new XYChart.Data(X:"3", Y:1));
    	
    	graficoModulo.getData().addAll(serie1);
    }
    
    double puntoY(double x)
    {
    	double y = 0;
    	y = Math.log(MemoriaComune.guadagno)*(valoreCalcolato(x, MemoriaComune.zeri) 
    			/ valoreCalcolato(x, MemoriaComune.poli));
    	return y;
    }
    
    double valoreCalcolato(double x, ArrayList<Double> numeri)
    {
    	Double numeratore = null;
    	numeratore = calcolaReciproco(numeri.get(0), x);
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
    
   Double calcolaReciproco(double valore, double x)
   {
	   Double reciproco = 1/valore;
	   return reciproco*x+1;
   }
}
