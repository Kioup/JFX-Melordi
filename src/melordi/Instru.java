
package melordi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Instru {
    
    private Synthesizer synthetiseur;
    private MidiChannel canal;
    public int volume;
    //public IntegerProperty volume = new IntegerProperty(100);

    
    public Instru(){
        
    try {
            
        synthetiseur = MidiSystem.getSynthesizer();
        synthetiseur.open();
            
        } catch (MidiUnavailableException ex) {
            
            Logger.getLogger(Instru.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        canal = synthetiseur.getChannels()[0];
        canal.programChange(0);
    }
    
    public void note_on(int note){
        canal.noteOn(note, volume.get());
    }
    
    public void note_off(int note){
        canal.noteOff(note);
    }
    
    public void set_instrument(int instru){
        canal.programChange(instru);
    }
    
}
