/*
 * 
 */
package vega;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * An attempt at a complete framework for VEGA
 * 
 * @author Rebeci & Mariafuu
 */
public class Vega extends Application {

    /**
     * @param args the command line arguments
     */
    public int stageWidth = 1200;
    public int stageHeight = 800;
    

    @Override
    public void start(Stage primaryStage) {
        
        Button visualFxGameLogBtn = new Button("Visual effects and game logic");
        Button flapperBtn = new Button("Flapper");
        Button pongBtn = new Button("Pong");
        Button ludoBtn = new Button("Ludo");
        Button alienWarsBtn = new Button("Space Invaders");
        Button mazeBtn = new Button("Maze");
        Button platformBtn = new Button("Platform");
        Button pinballBtn = new Button("Pinball");
        Button aboutBtn = new Button("About VEGA");
        
        visualFxGameLogBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This is the submenu for visual effects.");
            }
        });
        
        flapperBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This launches Flapper.");
            }
            
        });
  
        pongBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This launches Pong");
            }
            
        });
      
        ludoBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This launches Ludo");
            }
            
        });
        
        alienWarsBtn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This launches Alien Wars");
            }
            
        });
        
        mazeBtn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This launches Maze");
            }
            
        });
        
        platformBtn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This launches Platform");
            }
            
        });
        
        pinballBtn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This launches Pinball");
            }
            
        });
        
        aboutBtn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("A page about VEGA");
            }
            
        });
        
        //GridPane mainMenuGridPane = new GridPane();
        //mainMenuGridPane.setAlignment(Pos.CENTER);
        
        HBox menuHBoxLogo = new HBox();
        
        HBox menuHBox1 = new HBox();
        menuHBox1.getChildren().addAll(ludoBtn, pinballBtn, alienWarsBtn, pongBtn);
        
        HBox menuHBox2 = new HBox();
        menuHBox2.getChildren().addAll(platformBtn, flapperBtn, mazeBtn);
        
        HBox menuHBox3 = new HBox();
        menuHBox3.getChildren().addAll(visualFxGameLogBtn, aboutBtn);
        
        
        VBox mainMenuVBox = new VBox();
        mainMenuVBox.setPrefWidth(stageWidth);
        mainMenuVBox.setPrefHeight(stageHeight);
        mainMenuVBox.getChildren().addAll(menuHBoxLogo, menuHBox1, menuHBox2, menuHBox3);
        
        String styling = getClass().getResource("styling.css").toExternalForm();
        
        Scene mainScene = new Scene(mainMenuVBox, stageWidth, stageHeight);
        mainScene.getStylesheets().addAll(styling);
        
        primaryStage.setTitle("VEGA");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
