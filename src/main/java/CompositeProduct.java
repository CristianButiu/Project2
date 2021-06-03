
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {

    private List<MenuItem> lista = new ArrayList<>();

    public CompositeProduct(String title, ArrayList<MenuItem> listaMeniuri)
    {
        super(title);
        double rating = 0;
        int calories = 0;
        int protein = 0;
        int fat = 0;
        int sodium = 0;
        int price = 0;
        for(MenuItem produs:listaMeniuri)
        {
            rating += produs.getRating();
            calories += produs.getCalories();
            protein += produs.getProtein();
            fat += produs.getFat();
            sodium += produs.getSodium();
            price += produs.getPrice();
        }
        setRating(rating / listaMeniuri.size());
        setCalories(calories);
        setProtein(protein);
        setFat(fat);
        setSodium(sodium);

        this.lista = listaMeniuri;

    }
    public List<MenuItem> getLista()
    {
        return lista;
    }
    @Override
    public int computePrice() {
        int price = 0;
        for(MenuItem menu: lista)
            price += menu.getPrice();
        setPrice(price);
        return price;
    }
}
