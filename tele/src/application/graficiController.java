package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class graficiController {

	private Stage stage;
	
    @FXML
    private Button back;

    final NumberAxis asseX = new NumberAxis(Math.log10(1), Math.log10(100), 1);
	final NumberAxis asseY = new NumberAxis();

    @FXML
    private LineChart<?, ?> graficoFase = new LineChart<>(asseX, asseY);

    @FXML
    private LineChart<?, ?> graficoModulo = new LineChart<>(asseX, asseY);;


    @FXML
    void back(ActionEvent event) throws IOException 
    {
    
  	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  	  stage.close();

    }

}
