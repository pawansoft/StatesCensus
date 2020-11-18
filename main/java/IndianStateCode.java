import com.opencsv.bean.CsvBindByName;

public class IndianStateCode {
    @CsvBindByName(column = "srNo")
    private String sNumber;
    @CsvBindByName(column = "StateName")
    private String state;
    @CsvBindByName(column = "TIN")
    private String tinCode;
    @CsvBindByName(column = "StateCode")
    private String stateCode;

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTinCode() {
        return tinCode;
    }

    public void setTinCode(String tinCode) {
        this.tinCode = tinCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "IndianStateCode{" +
                "sNumber='" + sNumber + '\'' +
                ", state='" + state + '\'' +
                ", tinCode='" + tinCode + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
