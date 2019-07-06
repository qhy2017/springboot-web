package com.example.demo.controller.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DemoFXA extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5,5,5,5));

        Scene scene2 = new Scene(pane,800,700);
        Image image = new Image("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563011147&di=3bbbed2305be7cc7a2f65e2af3e05129&imgtype=jpg&er=1&src=http%3A%2F%2Fgss0.baidu.com%2F-fo3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3D2ed6dffd8418367aaddc77d91b43a7e2%2Fbba1cd11728b47102795ef18c1cec3fdfd0323af.jpg");
        pane.getChildren().add(new ImageView(image));

        Stage stage2 = new Stage();
        stage2.setTitle("show image example");
        stage2.setScene(scene2);
        stage2.show();


//        primaryStage.setTitle("hello");
//        primaryStage.show();
    }
}
