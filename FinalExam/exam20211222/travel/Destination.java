package exam20211222.travel;

public enum Destination {
    BERLIN ("01:34"), 
    ROME ("01:45"), 
    AMSTERDAM("02:05"), 
    PARIS("02:20"), 
    HELSINKI("02:43");
    private String time;
    
    Destination(String time){
        this.time = time;
    }

    public String getHour(){
        return this.time;
    }
    
}
