
package melordi;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ChangeInstru extends Parent {
    
    private RadioButton rb_piano;
    private RadioButton rb_guitare;
    private RadioButton rb_orgue;
    private Instru instrument;
    
    public ChangeInstru(Instru instru){
        instrument = instru;
        GridPane gridpane = new GridPane();
        
        ImageView piano = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("images/piano.png")));
        piano.setFitHeight(50);
        piano.setPreserveRatio(true);
        ImageView orgue = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("images/orgue.png")));
        orgue.setFitHeight(50);
        orgue.setPreserveRatio(true);
        ImageView guitare = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("images/guitare.png")));            
        guitare.setFitHeight(50);
        guitare.setPreserveRatio(true);
        
        ToggleGroup groupe = new ToggleGroup();
        
        rb_piano = new RadioButton();
        rb_guitare = new RadioButton();
        rb_orgue = new RadioButton();
        rb_piano.setToggleGroup(groupe);
        rb_guitare.setToggleGroup(groupe);
        rb_orgue.setToggleGroup(groupe);
        rb_piano.setFocusTraversable(false);
        rb_guitare.setFocusTraversable(false);
        rb_orgue.setFocusTraversable(false);
        rb_piano.setSelected(true);
        
        groupe.selectedToggleProperty().addListener(new ChangeListener(){
            public void changed(ObservableValue observable, Object oldValue, Object newValue){
                if(newValue.equals(rb_piano))
                    instrument.set_instrument(0);
                else if (newValue.equals(rb_guitare))
                    instrument.set_instrument(26);
                else
                    instrument.set_instrument(16);
            }
        });
        
        gridpane.add(rb_piano, 0, 0);
        gridpane.add(rb_guitare, 0, 1);
        gridpane.add(rb_orgue, 0, 2);
        gridpane.setHgap(20);
        
        gridpane.add(piano, 1, 0);
        gridpane.add(guitare, 1, 1);
        gridpane.add(orgue, 1, 2);
        gridpane.setVgap(15);
        
        this.getChildren().add(gridpane);
        this.setTranslateX(100);
        this.setTranslateY(30);
    }
}
