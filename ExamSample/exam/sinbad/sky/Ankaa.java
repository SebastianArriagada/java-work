package exam.sinbad.sky;

import java.util.Objects;

public class Ankaa implements Bird{
    private String name;
    private int height;

    public Ankaa( String name, int height){
        this.name = name;
        this.height = height;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public String getName(){
        return this.name;
    }
    public int getHeight(){
        return this.height;
    }
    @Override
    public String toString(){
        String text = this.name+"[flying "+HeightRange.getHeightRange(this.height)+" at "+ this.height+" meters]";

        return text;
    }
    @Override
    public boolean isAtHeightRange(int height) {
        return  HeightRange.getHeightRange(this.height) == HeightRange.getHeightRange(height);

    }

    @Override
    public boolean equals(Object that){
        if (that == this){return true;}
        if ( that == null){ return false;}
        if ( that.getClass() != Ankaa.class){return false;}

        Ankaa other = (Ankaa)that;

        return Objects.equals(name, other.name) && 
                Objects.equals( HeightRange.getHeightRange(height), HeightRange.getHeightRange(other.height));
        }

    @Override
    public int hashCode(){
        return Objects.hash(name, HeightRange.getHeightRange(height));
    }
}
