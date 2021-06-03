import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService implements IDDeliveryServiceProcessing{
        private List<MenuItem> listaMenu = new ArrayList<>();
        private Map<Order, List<MenuItem>> orderList = new HashMap<>();

    @Override
    public void importProducts() {
        String fileName = "products.csv";
        assert fileName != null;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<List<String>> values = lines.skip(1).distinct().map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());

            for(List<String> product:values) {
                boolean trebuieIntrodus = true;
                for(MenuItem newProduct:listaMenu)
                    if(product.get(0).equals(newProduct.getTitle()))
                        trebuieIntrodus = false;
                    if(trebuieIntrodus) {
                        listaMenu.add(new BaseProduct(product.get(0), Double.parseDouble(product.get(1)),
                                Integer.parseInt(product.get(2)), Integer.parseInt(product.get(3)), Integer.parseInt(product.get(4)),
                                Integer.parseInt(product.get(5)), Integer.parseInt(product.get(6))));
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    assert listaMenu != null;

    }

    @Override
    public boolean addProduct(MenuItem product) {
        boolean isAdded = true;
        assert product != null;
        for(MenuItem produs:listaMenu)
            if(produs.getPrice() == product.getPrice() && produs.getProtein() == product.getProtein() &&
            produs.getPrice() == product.getPrice() && produs.getSodium() == product.getSodium() &&
            produs.getFat() == product.getFat() && produs.getRating() == product.getRating() &&
            produs.getTitle().equals(product.getTitle()))
                isAdded = false;

    int sizeInitial = listaMenu.size();
        assert (isAdded == false && listaMenu.size() == sizeInitial);
        if(isAdded)
        listaMenu.add(product);
        assert(isAdded == true && listaMenu.size() == sizeInitial + 1);
        return isAdded;
    }

    @Override
    public boolean  deleteProduct(MenuItem product) {
        boolean isDeleted = false;
        assert product != null;
        int sizeInitial = listaMenu.size();
        for(int i = 0; i < listaMenu.size(); i++)
            if(product.getTitle().equals(listaMenu.get(i).getTitle()))
            {
                isDeleted = true;
                listaMenu.remove(i);
            }


        assert (isDeleted == true && (sizeInitial - 1) == listaMenu.size());
        assert (isDeleted == false && sizeInitial == listaMenu.size());
        return isDeleted;
    }

    @Override
    public boolean modifyProduct(String title, MenuItem product) {
       boolean isFound = false;
       MenuItem produs = new BaseProduct();
       assert title != null;
       assert product != null;
        for(MenuItem productiones:listaMenu)
           if(productiones.getTitle().equals(title))
           {
               produs = product;
               isFound = true;
               if(!product.getTitle().isEmpty())
                   productiones.setTitle(product.getTitle());
               if(product.getRating() != -1)
                   productiones.setRating(product.getRating());
               if(product.getCalories() != -1)
                   productiones.setCalories(product.getCalories());
               if(product.getProtein() != -1)
                   productiones.setProtein(product.getProtein());
               if(product.getFat() != -1)
                   productiones.setFat(product.getFat());
               if(product.getSodium() != -1)
                   productiones.setSodium(product.getSodium());
               if(product.getPrice() != -1)
                   productiones.setPrice(product.getPrice());
           }
        assert (isFound == true && produs == product);
           assert(isFound == false && produs != product);
        return isFound;
    }

    @Override
    public void compoundProduct(String newTitle, ArrayList<MenuItem> listaProduse) {
        assert(newTitle != null);
        assert  listaProduse != null;
        assert listaProduse.size() > 1;
        int size = listaMenu.size();
        CompositeProduct compProduct = new CompositeProduct(newTitle, listaProduse);
            listaMenu.add(compProduct);
          assert listaMenu.size() == size + 1;
    }


    @Override
    public void createNewOrder(Order order, List<MenuItem> listaOrder) {
        assert(order != null);
        assert listaOrder != null;
        int size = orderList.size();
        for(MenuItem m:listaOrder)
            orderList.computeIfAbsent(order, k-> new ArrayList<>()).add(m);
        System.out.println("Comanda cu numarul " + order.getOrderID() +" a fost plasata");
        assert orderList.size() == size + 1;
    }

    @Override
    public List<MenuItem> productOrdered(int nrOftimes) {
        assert nrOftimes !=-1;
        List<MenuItem> listaProduseFiltrate = new ArrayList<>();
       Map<MenuItem, Integer> listaProduse = new HashMap<>();
       orderList.entrySet().stream()
       .forEach(
                        order->
                        {
                            for(MenuItem produss:order.getValue()) {
                                if (listaProduse.containsKey(produss)) {
                                    listaProduse.put(produss, listaProduse.get(produss) + 1);
                                } else {
                                    listaProduse.put(produss, 1);
                                }
                            }

                        }
                        );
                listaProduse.entrySet().stream()
                        .forEach(order->
                        {
                            if(listaProduse.get(order.getKey()) >= nrOftimes)
                            {
                                listaProduseFiltrate.add(order.getKey());
                            }
                        });
               return listaProduseFiltrate;
    }

    @Override
    public void clientThatOrdered(int nrOftimes, int value) {
        assert nrOftimes != -1;
        assert value != -1;
        Map<Order, Integer> listaClienti = new HashMap<>();
        orderList.entrySet().stream()
                .forEach(c->
                {

                    if(listaClienti.containsKey(c.getKey()))
                    {
                       listaClienti.put(c.getKey(), listaClienti.get(c.getKey().getClientID()) + 1);
                    }
                    else
                    {
                        listaClienti.put(c.getKey(), 1);
                    }
                });

    }

    @Override
    public Map<MenuItem, Integer> productsOnDay(LocalDate date) {
        assert date != null;
        Map<MenuItem, Integer> listaProduseInZiua = new HashMap<>();
        orderList.entrySet().stream()
                .forEach(
                        order->
                        {
                            for(MenuItem produss:order.getValue()) {
                                if (listaProduseInZiua.containsKey(produss) && order.getKey().getNow().getDayOfYear() ==
                                date.getDayOfYear() && order.getKey().getNow().getYear() == date.getYear())
                                        {
                                    listaProduseInZiua.put(produss, listaProduseInZiua.get(produss) + 1);
                                } else {
                                    listaProduseInZiua.put(produss, 1);
                                }
                            }
                        }
                );
        for(Map.Entry<MenuItem, Integer>m:listaProduseInZiua.entrySet())
            System.out.println(m.getValue() + m.getKey().getTitle());
        assert listaProduseInZiua != null;
            return listaProduseInZiua;


    }

    @Override
    public List<Map.Entry<Order, List<MenuItem>>> timeInterval(LocalTime startHour, LocalTime endHour) {
       assert startHour != null;
       assert endHour != null;
        List<Map.Entry<Order, List<MenuItem>>> listaOrderTime = orderList.entrySet()
                .stream()
                .filter(k ->
                        k.getKey().getNow().getHour() >= startHour.getHour() && k.getKey().getNow().getHour() <=
                                endHour.getHour() &&  k.getKey().getNow().getMinute() >= startHour.getMinute() &&
                                k.getKey().getNow().getMinute() <= endHour.getMinute())
                .collect(Collectors.toList());
        assert  listaOrderTime != null;
        return listaOrderTime;
    }

    @Override
    public List<MenuItem> searchingForProducts(String keyword, double rating, int calories, int protein, int fat, int sodium, int price) {
       assert keyword != null;

        List<MenuItem> produseFiltrate =
                listaMenu.stream()
                .filter(p-> p.getTitle().contains(keyword) && (p.getRating() == rating || rating == -1) &&
                        (p.getCalories() == calories || calories == -1) && (p.getProtein() == protein ||
                        protein == -1) && (p.getFat() == fat || fat == -1) && (p.getSodium() == sodium ||
                        sodium == -1) && (p.getPrice() == price || price == -1))
                .collect(Collectors.toList());
        assert produseFiltrate != null;
        return produseFiltrate;

    }
    public List<MenuItem> getListaMenu()
    {
        return listaMenu;
    }
}
