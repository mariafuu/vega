/*
 * Main class of Ludo. Shows a start Scene where players can start the game.
 */
package ludo;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;


/**
 *
 * @author maria
 */
public class Ludo extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    @Override
    public void start (Stage startStage) {
        startStage.setTitle("Ludo");
        
        Group root = new Group();
        Scene startScene = new Scene(root);
        startStage.setScene(startScene);
        
        Canvas startCanvas = new Canvas(400, 200);
        root.getChildren().add(startCanvas);
        
        GraphicsContext gc = startCanvas.getGraphicsContext2D();
        
        startStage.show();
    }
    
}
