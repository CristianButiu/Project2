import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IDDeliveryServiceProcessing {
    /**
     * @pre fileName not null
     * @post listaMenu not null
     */
    public void importProducts();

    /**
     *
     * @param product
     * @pre product not null
     * @post if isAdded is true listaMenu.size() += 1
     * @post if isAdded is false listaMenu.size() stays the same
     * @return
     */
    public boolean addProduct(MenuItem product);

    /**
     *
     * @param product
     * @pre product not null
     * @post if isDeleted true listaMenu.size() -= 1
     * @post if isDeleted is false listaMenu.size() stays the same
     * @return
     */
    public boolean deleteProduct(MenuItem product);

    /**
     *
     * @param title
     * @pre title not null
     * @pre product not null
     * @post if isFound is true where product.field != -1 to modify the product
     * @post if isFound is false product stays the same
     * @param product
     * @return
     */
    public boolean modifyProduct(String title, MenuItem product);

    /**
     *
     * @param newTitle
     * @pre newTitle not null
     * @pre listaProduse not null
     * @pre listaProduse.size() > 1
     * @post listaMenu.size() += 1
     * @param listaProduse
     */
    public void compoundProduct(String newTitle, ArrayList<MenuItem> listaProduse);

    /**
     *
     * @param order
     * @pre order not null
     * @pre listaOrder not null
     * @post orderList.size() += 1
     * @param listaOrder
     */
    public void createNewOrder(Order order, List<MenuItem> listaOrder);

    /**
     *
     * @param nrOftimes
     * @pre nrOftime != -1
     * @pre value != -1
     * @post
     * @return
     */
    public List<MenuItem> productOrdered(int nrOftimes);
    public void clientThatOrdered(int nrOftimes, int value);

    /**
     *
     * @param date
     * @pre date not null
     * @post listaProduseFiltrate not null
     * @return
     */
    public Map<MenuItem, Integer> productsOnDay(LocalDate date);

    /**
     *
     * @param startHour
     * @param endHour
     * @pre startHour not null
     * @pre endHour not null
     * @post listaOrderTime not null
     * @return
     */
    public List<Map.Entry<Order, List<MenuItem>>> timeInterval(LocalTime startHour, LocalTime endHour);

    /**
     *
     * @param keyword
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @pre keyword not null
     * @post produseFiltrate not null
     * @return
     */
    public List<MenuItem> searchingForProducts(String keyword, double rating, int calories, int protein, int fat, int sodium, int price);
}
