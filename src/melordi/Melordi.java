
package melordi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Melordi extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);

        Instru mon_instru = new Instru();
        
        ChangeInstru mes_instruments = new ChangeInstru(mon_instru);
        root.getChildren().add(mes_instruments);
        Clavier mon_clavier = new Clavier(mon_instru);
        root.getChildren().add(mon_clavier);
        Son mon_son = new Son();
        root.getChildren().add(mon_son);
        mon_instru.volume.bind(mon_son.slider.valueProperty());
        
        //mon_instru.note_on(65);
        primaryStage.setScene(scene);
        mon_clavier.requestFocus();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
