package exam.sinbad;
import java.util.Arrays;

import exam.sinbad.sky.Ankaa;
import exam.sinbad.sky.Bird;
//import exam.sinbad.sky.HeightRange;

public class Adventure {


    protected int collectedDiamonds = 0;
    protected Bird[] birds = {};
    protected int day = 1;
    protected static int storedDiamonds = 0;

    public Adventure(){ 
        this(new Ankaa("BigBird", 700));               
    }

    public Adventure (Bird ... bird){

        if (bird.length > 3){
            throw new IllegalArgumentException("Is allowed a maximum of 3 birds");
        }
        else{

        for (Bird b : bird){
            birds = Arrays.copyOf(birds, birds.length + 1);
            birds[birds.length - 1] = b;
            System.out.println(b.getName());

        }
    }
 
    }

    public static void clearStoredDiamonds(){
        storedDiamonds = 0;
    }

    public void collectDiamons(int diamondCount){
        this.collectedDiamonds = this.collectedDiamonds + diamondCount;
    }

    protected static void storeDiamonds(int diamondCount){
        storedDiamonds = storedDiamonds + diamondCount;
    }

    public int getCollectedDiamonds(){
        return this.collectedDiamonds;
    }

    public Bird[] getBirds(){
        return this.birds;
    }

    public int getDay(){
        return this.day;
    }

    public static int getStoredDiamonds(){
        return storedDiamonds;
    }
    public int getBirdCount(){

        //System.out.println((this.birds).length);

        return (this.birds).length;

    }
    public boolean callBird (int height){
        for (Bird bird : birds){
            if (bird.isAtHeightRange(height)){
                doEscape(bird);
                return true;
            }
        }

        return false;
    }
    protected void doEscape(Bird bird){
        storeDiamonds(collectedDiamonds);
        collectedDiamonds = 0;
        ++day;
    }
}
