package PieChart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class PieChart extends Application {
    @Override
    public void start(@NotNull Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("There is Pie chart ");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
