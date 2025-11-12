/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MV.view;




import MV.model.BagOfWords;
import MV.model.BagOfWordsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import observer.Observer;

import java.util.Iterator;


/**
 *
 * @author Utilizador
 */
public class BagOfWordsGUI {
    
    private Button btnAdd, btnUndo;
    private ListView listWords;
    private TextField wordInput;
    private Label wordCount;
    private HBox buttonsPane;
    private VBox mainPane;
    private ObservableList<String> wordItems;
    private Scene scene;
    private BagOfWords model;

    public BagOfWordsGUI(BagOfWords model) {
        initComponents();
        scene= new Scene(mainPane,400,300);
        this.model=model;
    }

    public Scene getScene() {
        return scene;
    }

    private void initComponents() {
       //create Panes
       this.mainPane= new VBox(5);
       this.buttonsPane= new HBox(5);
       //create commponents
        this.buttonsPane.setAlignment(Pos.BOTTOM_CENTER);
        //create commponents
        btnAdd= new Button("Add");
        btnUndo=new Button("RemoveAll");
        wordCount = new Label("0");
        wordInput= new TextField("");
        this.buttonsPane.getChildren().addAll(wordInput,btnAdd,
                btnUndo,new Label ("Words Count:"),wordCount);
        setTriggers();
       //create ListView
       this.wordItems= FXCollections.observableArrayList();
       this.listWords= new ListView(wordItems);      
       this.mainPane.getChildren().addAll(buttonsPane,listWords);
    }
    
    
    private void setTriggers(){
        btnAdd.setOnAction(e->doAdd(wordInput.getText()));
        btnUndo.setOnAction(e->doRemoveAll());
    }

    public void updateAll(int wordCount, Iterator<String> itWords) {
         this.wordCount.setText(wordCount+"");
         this.wordItems.clear();
         while(itWords.hasNext())
            this.wordItems.add(itWords.next());
         this.wordInput.setText("");        
    }


    public void doAdd(String text) {
        if (!text.isEmpty()) {
           try {
               model.addWord(text);
           }
           catch(BagOfWordsException e){
               showError(e.getMessage());
               this.wordInput.setText("");
           }
        }

    }

    private void doRemoveAll() {

           model.removeAll();


       }



    public  void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait(); // bloqueia até o utilizador fechar
    }
}
