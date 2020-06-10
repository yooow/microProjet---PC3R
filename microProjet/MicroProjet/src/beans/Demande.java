package beans;

public class Demande{
    private String temps;
    private float temperature;
    private String ville;

    public void setTemps( String temps ){
        this.temps = temps;
    }

    public String getTemps(){
        return temps;
    }

    public void setTemperature( float temperature ){
        this.temperature = temperature;
    }

    public float getTemperature(){
        return temperature;
    }

    public String getVille(){
        return ville;
    }

    public void setVille( String ville ){
        this.ville = ville;
    }
}