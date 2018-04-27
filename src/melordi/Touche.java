
package melordi;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Touche extends Parent {
    
        private int positionX;
        private int positionY;
        public String lettre;
        private int note = 0;
        
        Rectangle fond_touche;
        Text lettre_touche;
        
        private Instru ins;
        
    public Touche(String l,  int n, int posX, int posY, Instru instrument){
        
        this.lettre = new String(l);
        this.positionX = posX;
        this.positionY = posY;
        this.note = n;
        ins = instrument;
        
        // rectangle de la touche
        
        fond_touche = new Rectangle(75, 75, Color.WHITE);
        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        
        //eclairage
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-30.0);
        Lighting li = new Lighting();
        li.setLight(light);
        fond_touche.setEffect(li);
        
        this.getChildren().add(fond_touche);
        
        // lettre de la touche
        
        lettre_touche = new Text(lettre);
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.BLACK);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche);
        
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
           public void handle(MouseEvent me){
               fond_touche.setFill(Color.LIGHTGRAY);
           } 
        });
        
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
           public void handle(MouseEvent me){
               fond_touche.setFill(Color.WHITE);
           } 
        });
        
        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                appuyer();
            }
        });
        
         this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
        
    }
    
    public void appuyer(){
        fond_touche.setFill(Color.DARKGRAY);
        this.setTranslateY(positionY+2);
        ins.note_on(note);
    }
    
    public void relacher(){
        fond_touche.setFill(Color.WHITE);
        this.setTranslateY(positionY);
        ins.note_off(note);
    }
    
}
