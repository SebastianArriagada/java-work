package exam.sinbad;

import exam.sinbad.sky.Ankaa;
import exam.sinbad.sky.HeightRange;

public class Main {
    public static void main(String[] args) {
        Ankaa bird1 = new Ankaa(null, 0);
        Ankaa bird2 = new Ankaa(null, 0);

        Adventure test1 = new Adventure(bird1,bird2,bird2);
        Adventure test2 = new Adventure();
        
        //int hola = test.getBurdCount();
        System.out.println("Bird count1: " + test1.getBirdCount() + " Bird count2: "+ test2.getBirdCount() );

        
        System.out.println("Height test: " + HeightRange.getHeightRange(0) + 
                            ", " + HeightRange.getHeightRange(299) + 
                            ", " + HeightRange.getHeightRange(300) + 
                            ", " + HeightRange.getHeightRange(301) + 
                            ", " + HeightRange.getHeightRange(600) + 
                            ", " + HeightRange.getHeightRange(601) + 
                            ", " + HeightRange.getHeightRange(900) +
                            ", " + HeightRange.getHeightRange(901)  
                            );

        Ankaa ankaa = new Ankaa(null, 0);
        ankaa.setHeight(200);
        System.out.println("Ankaa test: " + ankaa.toString());
    }
    
}
