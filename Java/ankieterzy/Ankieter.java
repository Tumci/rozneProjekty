package obiektyZClasa.ankieterzy;

import static obiektyZClasa.ankieterzy.Ankieterzy.tabKoloryAB;
import static obiektyZClasa.ankieterzy.Ankieterzy.tabKoloryC;
import static obiektyZClasa.ankieterzy.Ankieterzy.tabKoloryD;

/**
 * Każdy ankieter ma swój zbiór pytań ułożony wg niego
 * @author Kamil
 */
public class Ankieter{
    // Zmienne to zbiór pytań ankietera i odpowiedzi respondenta 
    private static final String pytanieZolty = "\n- Czy podoba się Panu/Pani kolor żółty?";
    private static final String pytanieZielony = "\n- Czy podoba się Panu/Pani kolor zielony?";
    private static final String pytanieCzerwony = "\n- Czy podoba się Panu/Pani kolor czerwony?";
    private static final String pytanieBialy = "\n- Czy podoba się Panu/Pani kolor biały?";
    private static final String pytanieNiebieski = "\n- Czy podoba się Panu/Pani kolor niebieski?";
    private static final String odpowiedzT = "- Tak, podoba się";
    private static final String odpowiedzN = "- Nie, nie podoba się mi";
    private static final String gratulacje = "- Gratulacje. Zatem dostaje Pan prezent ";
    //Lista(kolejność) pytań ankietera A i B
    private static String [] tabAB = {pytanieZolty, pytanieZielony, pytanieCzerwony, pytanieBialy, pytanieNiebieski}; 
    //Lista(kolejność) pytań ankietera C
    private static String [] tabC = {pytanieCzerwony, pytanieZolty, pytanieBialy,pytanieNiebieski,pytanieZielony};
    //Lista(kolejność) pytań ankietera D
    private static String [] tabD = {pytanieZielony, pytanieNiebieski, pytanieBialy, pytanieZolty, pytanieCzerwony};
    
    //Losuje odpowiedź respondenta, czy jest to tak, czy nie
    private static String odpowiedzRespondenta(){
        String odp = (int)(Math.random()*10)%2 == 0? "Tak" : "Nie";
        return odp;
    }
    
    //Ankieter A zadaje pytania wg swojego scenariuszatak, aby dać każdemu jak najwięcej
    static void ankieterA() {
        //int y = 0;
        //String [] nagrodyPrzedmiot = new String[y];
        int x = 0;
        for(String ankieta: tabAB){
            System.out.println(ankieta);
            if(odpowiedzRespondenta() == "Tak"){
                System.out.println(odpowiedzT);
                System.out.println(gratulacje + tabKoloryAB[x].getPRZEDMIOT() + " o wartości " + tabKoloryAB[x].getWARTOSC()+ " zł");
                //y++;
                //nagrodyPrzedmiot[y] = tabKoloryAB[x].getPRZEDMIOT();
                //System.out.println(nagrodyPrzedmiot[y]);
            }else
                System.out.println(odpowiedzN);
            x++;
        }
//        System.out.println("Podsumujmy. Wgrał Pan nagrody:");
//        for(String nagrody: nagrodyPrzedmiot){
//            System.out.print(nagrody + ", ");
    }
        
    //Ankieter B zadaje pytania wg swojego scenariuszatak by dać każdemu jak najmniej
    static void ankieterB() {
        int x = 0;
        for(String ankieta: tabAB){
            System.out.println(ankieta);
            if(odpowiedzRespondenta() == "Tak"){
                System.out.println(odpowiedzT);
                System.out.println(gratulacje + tabKoloryAB[x].getPRZEDMIOT() + " o wartości " + tabKoloryAB[x].getWARTOSC()+ " zł");
                break;
            }else
                System.out.println(odpowiedzN);
            x++;
        }
    }
    
    //Ankieter C zadaje pytania tak aby każdy dostał jak najwięcej prezentów,
    // ale kończy, gdy wartość upomików otrzymanych przez respondenta przekroczy 2500 zł 
    static void ankieterC() {
        int x = 0;
        for(int i = 0;i<tabC.length;i++){      
            System.out.println(tabC[i]);
            if(odpowiedzRespondenta() == "Tak"){
                System.out.println(odpowiedzT);
                System.out.println(gratulacje + tabKoloryC[x].getPRZEDMIOT() + " o wartości " + tabKoloryC[x].getWARTOSC()+ " zł");
                if(tabKoloryC[x].getWARTOSC() == 5_000)
                    break;
            }else{
                System.out.println(odpowiedzN);
            }
            x++;
        }
    }
    //Ankieter D zadaje pytania, gdy respondent wygra samochod lub zdobędzie dwie nagrody od razu kończy zadawanie pytań
    static void ankieterD() {
        byte ileNagrod = 0;
        int x = 0;
        for(int i = 0;i<tabD.length;i++){      
            System.out.println(tabD[i]);
            if(odpowiedzRespondenta() == "Tak"){
                System.out.println(odpowiedzT);
                System.out.println(gratulacje + tabKoloryD[x].getPRZEDMIOT() + " o wartości " + tabKoloryD[x].getWARTOSC()+ " zł");
                ileNagrod++;
                if(tabKoloryD[x].getWARTOSC() == 20_000)
                    break;
                if(ileNagrod == 2)
                    break;
            }else{
                System.out.println(odpowiedzN);
            }
            x++;
        }
    }
}
