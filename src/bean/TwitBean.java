package bean;

public class TwitBean {
    TwitBean() {

    }

    private int id;
    private String twit;

    public TwitBean(int id, String twit) {
        this.id = id;
        this.twit = twit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTwit() {
        return twit;
    }

    public void setTwit(String twit) {
        this.twit = twit;
    }

}
