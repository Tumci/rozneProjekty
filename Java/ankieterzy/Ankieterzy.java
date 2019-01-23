package obiektyZClasa.ankieterzy;
/**
 *Zadanie z podręcznika "Obiekty z klasą", aby przyporządkować odpowiednie akcje dla różnych ankieterów 
 * @author Kamil
 */
public class Ankieterzy {
    //Obiekty kolorów z pytań do których przypisana jest konkretna nagroda i jej wartość pieniężna
    static Kolory zolty = new Kolory("ołówek", 5);
    static Kolory zielony = new Kolory("zielony chamochód", 20_000);
    static Kolory czerwony = new Kolory("czerwone jabłko", 2);
    static Kolory bialy = new Kolory("gotówka", 2_000);
    static Kolory niebieski = new Kolory("roczny karnet do kina", 5_000);
    static Kolory [] tabKoloryAB = {zolty, zielony, czerwony, bialy, niebieski}; //Lista(kolejność) pytań ankietera A i B
    static Kolory [] tabKoloryC = {czerwony, zolty, bialy, niebieski, zielony}; //Lista(kolejność) pytań ankietera C
    static Kolory [] tabKoloryD = {zielony, niebieski, bialy, zolty, czerwony}; //Lista(kolejność) pytań ankietera D
    
    public static void main(String[] args){
        System.out.println("Ankieter A przeprowadzi ankietę w mastępujący sposób.");
        Ankieter.ankieterA();
        System.out.println("");
        
        System.out.println("Ankieter B przeprowadzi ankietę w mastępujący sposób.");
        Ankieter.ankieterB();
        System.out.println("");
        
        System.out.println("Ankieter C przeprowadzi ankietę w mastępujący sposób.");
        Ankieter.ankieterC();
        System.out.println("");
        
        System.out.println("Ankieter D przeprowadzi ankietę w mastępujący sposób.");
        Ankieter.ankieterD();
        System.out.println("");
    }
}