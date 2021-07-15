package PieChart;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainHandler implements Initializable {
    //먹는 파이를 생각하면 되겠습니다.
    //파이를 어떻게 나눠야 되겠냐 에서 시작 되었습니다.
    @FXML
    private PieChart pieChart;
    @FXML
    private Button b;

    @FXML
    private void selB(ActionEvent event) {
        pieChart.setData(FXCollections.observableArrayList(

                new PieChart.Data("1", 10),
                new PieChart.Data("2", 10),
                new PieChart.Data("3", 10),
                new PieChart.Data("4",10 ),
                new PieChart.Data("5", 10 ),
                new PieChart.Data("6", 10 ),
                new PieChart.Data("7", 10 ),
                new PieChart.Data("8", 10 ),
                new PieChart.Data("9", 10 ),
                new PieChart.Data("10", 10 )
        ));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
