package prem.dev.voting1;

public class Vote {

    private String email;
    private String id;
    private String name;
    private String voted;
    private String Cvoted;
    public Vote(){

    }

    public String getCvoted() {
        return Cvoted;
    }

    public void setCvoted(String cvoted) {
        Cvoted = cvoted;
    }

    public Vote(String email, String id, String name, String voted) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.voted = voted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoted() {
        return voted;
    }

    public void setVoted(String voted) {
        this.voted = voted;
    }
}
