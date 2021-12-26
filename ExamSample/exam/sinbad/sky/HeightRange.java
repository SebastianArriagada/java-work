package exam.sinbad.sky;


public enum HeightRange {

   
    LOW(0,300),
    MEDIUM(301,600),
    HIGH(600,900),
    BEYOND;
    
    private final int min;
    private final int max;

    HeightRange(int min, int max){
        this.min = min;
        this.max = max;
    }
    HeightRange(){
        this(0,0);
    }

    public static HeightRange getHeightRange( int height ) {

        HeightRange[] heightRanges = values();

        for (HeightRange heightRange : heightRanges){
            int minRange = heightRange.min;
            int maxRange = heightRange.max;

            if (minRange == 0 && maxRange == 0){
                return heightRange;
            }

            if ( height >= minRange && height <= maxRange){
                return heightRange;
            }
        }


        return null;
    }
}
