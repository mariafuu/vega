/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vega_interface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Rebecca
 */
public class mainClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Button button1 = new Button("Visual Effects");
        Button button2 = new Button("Game Logic");
        Button button3 = new Button("About");
        Button button4 = new Button("Example games");
        Button button5 = new Button("Quick Ex 1: Rain");
        Button button6 = new Button("Quick Ex 2: Dice throw");
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This is the submenu for visual effects.");
            }
        });
     
        button2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This is the submenu for game logic.");
            }
            
        });
  
        button3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Learn more about VEGA!");
            }
            
        });
      
        button4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Here are some example games.");
            }
            
        });
        
        button5.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("It's raining");
            }
            
        });
        
        button6.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Roll the dice!");
            }
            
        });
        
        /*StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(btn2);*/
        
        
        
        
        
        GridPane gridPane = new GridPane();
        
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);
        
        Scene scene = new Scene(gridPane, 600, 500);
        
        primaryStage.setTitle("VEGA");
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
