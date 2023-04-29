package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class graficiController {

	private Stage stage;
    private Scene scene;
    private Parent root;
	
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

}
