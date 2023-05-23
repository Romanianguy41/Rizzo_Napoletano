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
    void back(ActionEvent event) throws IOException 
    {
    
  	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  	  stage.close();

    }

}
