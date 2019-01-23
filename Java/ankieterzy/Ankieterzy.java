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
        //tablica z informacjami o dostepnych nagrodach i ich wartosci
        String [] kolor = {"zolty", "zielony", "czerwony", "bialy", "niebieski"};
        int x = 0; // do przejscia po tablicy kolor
        System.out.println("Lista przedmiotow do wygrania u ankieterow:");
        for(Kolory wygrana: tabKoloryAB){
            System.out.print("Po wybraniu odpowiedzi "+ kolor[x] +" respondent wygrywa "+ wygrana.getPRZEDMIOT());
            System.out.println(" o wartosci " + wygrana.getWARTOSC()+" zl");
            x++;
        }
        System.out.println(""); 
        
        System.out.println("(Ankieter pragnie dac jak najwiecej przedmiotow danemu respondentowi)");
        System.out.println("Ankieter A przeprowadzi ankiete w mastepujący sposob.");
        Ankieter.ankieterA();
        System.out.println("");
        
        System.out.println("(Ankieter pragnie dac jak najmniej przedmiotow danemu respondentowi)");
        System.out.println("Ankieter B przeprowadzi ankiete w mastepujący sposob.");
        Ankieter.ankieterB();
        System.out.println("");
        
        System.out.print("(Ankieter pragnie dac jak najwiecej przedmiotow");
        System.out.println(", ale konczy zadawac pytania jeeli wartosc nagrod przekroczy 2500 zl)");
        System.out.println("Ankieter C przeprowadzi ankiete w mastepujacy sposob.");
        Ankieter.ankieterC();
        System.out.println("");
        
        System.out.println("(Ankieter pragnie dac tylko albo zielony samochod albo dwie inne najbardziej warosciowe nagrody");
        System.out.println("Ankieter D przeprowadzi ankiete w mastępujący sposob.");
        Ankieter.ankieterD();
        System.out.println("");
    }
}