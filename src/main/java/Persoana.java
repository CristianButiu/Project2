import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Persoana {

    private String username;
    private String password;
    private int mod; // 1 pentru admin, 2 pentru client si 3 pentru angajat
    public Persoana()
    {

    }
    public Persoana(String username, String password, int mod)
    {
        this.username = username;
        this.password = password;
        this.mod = mod;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getUsername()
    {
        return this.username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }
    public void setMod(int mod)
    {
        this.mod = mod;
    }

    public int getMod()
    {

        return this.mod;
    }


}
