import java.util.List;

public class Series {

    public Series(){}

    public Series(List<Serie> Series){
        this.Series = Series;
    }
    
    private List<Serie> Series;

    public List<Serie> getSeries(){
        return Series;
    }

    public void setSeries(List<Serie> Series){
        this.Series = Series;
    }

    @Override
    public String toString() {
        return this.Series.toString();
    }

}