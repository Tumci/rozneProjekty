package obiektyZClasa.ankieterzy;

/**
 * Kolory w pytaniach które oznaczają konkretny rodzaj nagrody i jej wartości pieniężnej
 * @author Kamil
 */
public class Kolory {
    private final String PRZEDMIOT; //jaka nagroda za jaki wybrany kolor
    private final short WARTOSC; // wartość nagrody wyrażona kwotowo
    
    Kolory(String PRZEDMIOT, int WARTOSC){
        this.PRZEDMIOT = PRZEDMIOT;
        this.WARTOSC = (short)WARTOSC;
    }
    
    String getPRZEDMIOT(){
        return PRZEDMIOT;
    }
    short getWARTOSC(){
        return WARTOSC;
    }
}
