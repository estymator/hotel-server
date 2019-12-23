package hotels.models;
import javax.persistence.*;

@Entity
@Table(name="dane_logowania")
public class DaneLogowania {
    @Id
    private String login;
    private String haslo;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login)
    {
        this.login=login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
