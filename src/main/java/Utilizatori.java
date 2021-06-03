import java.util.ArrayList;
import java.util.List;

public class Utilizatori {

    private List<Persoana> listaUtilizatori = new ArrayList<>();
    public Utilizatori()
    {

        Persoana pAdmin = new Persoana("makai", "parola", 1);
        Persoana pClient = new Persoana("Andrei", "mancare", 2);
        Persoana pAngajat = new Persoana("Marcel", "lucrez", 3);
        Persoana pAdmin1 = new Persoana("Marian", "reusesc123", 1);
        Persoana pClient1 = new Persoana("Alexa", "ofDoamne", 2);
        listaUtilizatori.add(pAdmin);
        listaUtilizatori.add(pClient);
        listaUtilizatori.add(pAngajat);
        listaUtilizatori.add(pAdmin1);
        listaUtilizatori.add(pClient1);
    }
    public List<Persoana> getListaUtilizatori()
    {
        return this.listaUtilizatori;
    }
    public void adaugaUtilizator(Persoana p)
    {
        listaUtilizatori.add(p);
    }
    public void setListaUtilizatori(List<Persoana> lista)
    {
        listaUtilizatori = lista;
    }
}
