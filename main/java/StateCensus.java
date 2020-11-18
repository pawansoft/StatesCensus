import com.opencsv.bean.CsvBindByName;

public class StateCensus {
    @CsvBindByName(column = "State")
    private String state;
    @CsvBindByName(column = "Population")
    private String population;
    @CsvBindByName(column = "Area")
    private Long areaInSqKm;
    @CsvBindByName(column = "Density")
    private int densityPerSqKm;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Long getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(Long areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public int getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(int densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return "StateCensusService{" +
                "state='" + state + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }
}
