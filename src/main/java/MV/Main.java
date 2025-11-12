package MV;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MV.model.BagOfWords;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author brunomnsilva
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BagOfWords model = new BagOfWords("Nicole");
        Scene scene = FactoryMVBagGUI.create(model).getScene();

        primaryStage.setTitle("Bag Of Words");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
