package java21;
/**t
 *
 * @author Kamil
 */
public class taskDay4_Calender {
    public static void main(String[] args) {
        int yearIn = 2016;
        
        // Sprawdzanie, czy program przekazuje argumenty wiersza polececeń
        if(args.length>0)
            yearIn = Integer.parseInt(args[0]);
        String [][]date = countDays(yearIn);
        
        // Wypisanie informacji na ekranie
        System.out.println("W "+ yearIn + " dni w roku.");
        for(int i = 0;i<date[0].length;i++){ // petla miesiecy
            for(int x = 0;x<date.length;x++){ // petla dni
                if(date[x][i] == null)
                    continue;
                System.out.println(date[x][i]);
            }
        }
    }
    static String [][]countDays(int year){
        int count = 1;
        final byte MONTHIN = 12;
        byte dayIn = 31;
        String [][] date = new String [dayIn][MONTHIN];
        
        //Pętla dla miesięcy oraz wylicza ile dany miesiąc ma dni
        for(byte month = 1;month<13;month++){
            switch(month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    count = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    count = 30;
                    break;
                case 2:
                    if((year %100 == 0) && (year % 400 != 0)){
                        count = 28;
                        break;
                    }else if(year %4 == 0){
                        count = 29;
                        break;
                    }else
                        count =29;
                        break;
            }
            byte x = 0;
            byte day = 1;
            
            //Pętla dla dni
            for(int i = 0;i<count;i++){
                // wpisuje w zero w cyfry jedno znakowe by ladnie wygladalo
                String days = Integer.toString(day);
                if(day <10)
                    days = "0"+day;
                // wpisuje w zero w cyfry jedno znakowe by ladnie wygladalo
                String months = Integer.toString(month);
                if(month <10)
                    months = "0"+month;
                // wpisuje daty do koncowej tablicy
                date [x][month-1] = days+"/"+ months +"/" + year;
                x++;
                day++;
            }
        }
        return date;
    }
}