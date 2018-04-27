/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Clavier extends Parent {
    
    private Touche[] touches;
    private Instru ins;
    
    public Clavier(Instru instrument){
        
        ins = instrument;
        Rectangle fond_clavier = new Rectangle();
        fond_clavier.setWidth(400);
        fond_clavier.setHeight(200);
        fond_clavier.setArcWidth(30);
        fond_clavier.setArcHeight(30);
        
        //degrade
        fond_clavier.setFill(
                new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                    new Stop[] {
                        new Stop(0, Color.web("#333333")),
                        new Stop(1, Color.web("#000000"))
                    }
                )
        );
        
        //reflection
        Reflection r = new Reflection();
        r.setFraction(0.25);
        r.setBottomOpacity(0);
        r.setTopOpacity(0.5);
        fond_clavier.setEffect(r);
        
        touches = new Touche[]{
            new Touche("A", 60, 50, 20, ins),
            new Touche("Z", 62, 128, 20, ins),
            new Touche("E", 64, 206, 20, ins),
            new Touche("R", 65, 284, 20, ins),
            new Touche("Q", 67, 75, 98, ins),
            new Touche("S", 69, 153, 98, ins),
            new Touche("D", 71, 231, 98, ins),
            new Touche("F", 72, 309, 98, ins)
        };
        
        this.setTranslateX(50);
        this.setTranslateY(250);        
        this.getChildren().add(fond_clavier);
        for (Touche touche: touches){
            this.getChildren().add(touche);
        }
        
         this.setOnKeyPressed(new EventHandler<KeyEvent>(){
             public void handle(KeyEvent ke){
                 for (Touche touche: touches){
                     if(touche.lettre.equals(ke.getText().toUpperCase()))
                         touche.appuyer();
                 }
                 //appuyer();
             }
         });
         
         this.setOnKeyReleased(new EventHandler<KeyEvent>(){
             public void handle(KeyEvent ke){
                for (Touche touche: touches){
                    if(touche.lettre.equals(ke.getText().toUpperCase()))
                         touche.relacher();
                 }
                 //relacher();
             }
         });


    }
    
}
