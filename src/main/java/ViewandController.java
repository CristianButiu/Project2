import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewandController
{

    private Utilizatori ListaPersoana = new Utilizatori();
    DeliveryService service = new DeliveryService();
    public ViewandController() {

        JFrame logFrame = new JFrame("Log in window");
        JPanel panelUsername = new JPanel();
        JPanel panelPassword = new JPanel();
        JPanel panelLog = new JPanel();
        JLabel labelUsername = new JLabel("Username: ");
        JTextField textUsername = new JTextField();
        JLabel labelPassword = new JLabel("Password: ");
        JPasswordField textPassword  = new JPasswordField();
        JPanel panelLogIn = new JPanel();
        JButton buttonLogIn = new JButton("Log in");
        panelLogIn.add(buttonLogIn);
        textUsername.setColumns(20);
        textPassword.setColumns(20);
        JPanel panelTitle = new JPanel();
        JLabel labelTitle = new JLabel("Food delivery log in");
        labelTitle.setFont(new Font("Food delivery log in", Font.PLAIN, 30));
        panelTitle.add(labelTitle);
        JLabel labelNotLog = new JLabel("Don't have an account?");
        JButton registerButton = new JButton("Register now");
        JPanel panelnotLog = new JPanel();
        panelnotLog.setLayout(new BoxLayout(panelnotLog, BoxLayout.Y_AXIS));
        panelnotLog.add(labelNotLog);
        panelnotLog.add(registerButton);
        panelUsername.add(labelUsername);
        panelUsername.add(textUsername);
        panelPassword.add(labelPassword);
        panelPassword.add(textPassword);
        panelLog.add(panelTitle);
        panelLog.add(panelUsername);
        panelLog.add(panelPassword);
        panelLog.add(panelLogIn);
        panelLog.add(panelnotLog);

        panelLog.setLayout(new BoxLayout(panelLog, BoxLayout.PAGE_AXIS));
        logFrame.add(panelLog);
        logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logFrame.setSize(500, 500);
        logFrame.setVisible(true);
        registerButton.addActionListener(eRegister->
        {
            JFrame frameRegister = new JFrame("Register");
            JLabel labelNewUsername = new JLabel("New Username: ");
            JTextField textNewUsername = new JTextField();
            JLabel labelNewPassword = new JLabel("New Password: ");
            JPasswordField textNewPassword  = new JPasswordField();
            textNewUsername.setColumns(20);
            textNewPassword.setColumns(20);
            JPanel panelRegUs = new JPanel();
            JPanel panelRegP = new JPanel();
            JPanel panelReg = new JPanel();
            JButton buttonReg = new JButton("Register");
            panelRegUs.add(labelNewUsername);
            panelRegUs.add(textNewUsername);
            panelRegP.add(labelNewPassword);
            panelRegP.add(textNewPassword);
            panelReg.add(panelRegUs);
            panelReg.add(panelRegP);
            panelReg.add(buttonReg);
            panelReg.setLayout(new BoxLayout(panelReg, BoxLayout.PAGE_AXIS));
            frameRegister.add(panelReg);
            frameRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameRegister.setSize(500, 500);
            frameRegister.setVisible(true);
            buttonReg.addActionListener(eButtonReg->
            {
                String newUser = textNewUsername.getText();
                String newPass = new String(textNewPassword.getPassword());

                ListaPersoana.adaugaUtilizator(new Persoana(newUser, newPass, 2));


            });
        });
        buttonLogIn.addActionListener(e ->
        {
              String username = textUsername.getText();
              String password = new String(textPassword.getPassword());
              List<Persoana> lista = ListaPersoana.getListaUtilizatori();
            int rol = 0;
            for(Persoana persoana:lista)
                if(persoana.getUsername().equals(username) && persoana.getPassword().equals(password)) {
                    rol = persoana.getMod();
                }
                    if(rol == 0)
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    else if(rol == 1)
                    {
                     JFrame adminFrame = new JFrame("Admin operations");
                     JPanel panelAdmin = new JPanel();
                     JPanel panelImport = new JPanel();
                     JButton buttonImport = new JButton("Import the products");
                     panelImport.add(buttonImport);
                     JPanel panelManage = new JPanel();
                     JButton buttonManage = new JButton("Manage the products");
                     panelManage.add(buttonManage);
                     JButton buttonGenerate = new JButton("Generate reports");
                     JPanel panelGenerate = new JPanel();
                     panelGenerate.add(buttonGenerate);
                     panelAdmin.add(panelImport);
                     panelAdmin.add(panelManage);
                     panelAdmin.add(panelGenerate);
                     panelAdmin.setLayout(new BoxLayout(panelAdmin, BoxLayout.PAGE_AXIS));
                     adminFrame.add(panelAdmin);
                     adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     adminFrame.setSize(500, 500);
                     adminFrame.setVisible(true);
                     buttonImport.addActionListener(e1->
                     {
                         service.importProducts();
                     });
                     buttonManage.addActionListener(e2 ->
                     {
                         JFrame manageFrame = new JFrame("Manage products");
                         JPanel panelMan = new JPanel();
                         JLabel labelTitle1 = new JLabel("Title:");
                         JTextField textTitle1 = new JTextField();
                         JLabel labelNewTitle = new JLabel("New title for modify:");
                         JTextField textNewTitle = new JTextField();
                         JLabel labelRating = new JLabel("Rating:");
                         JTextField textRating = new JTextField();
                         JLabel labelCalories = new JLabel("Calories:");
                         JTextField textCalories = new JTextField();
                         JLabel labelProteins = new JLabel("Protein:");
                         JTextField textProteins = new JTextField();
                         JLabel labelFats = new JLabel("Fat:");
                         JTextField textFats = new JTextField();
                         JLabel labelSodium = new JLabel("Sodium:");
                         JTextField textSodium = new JTextField();
                         JLabel labelPrice = new JLabel("Price:");
                         JTextField textPrice = new JTextField();
                         JButton buttonAdd = new JButton("Add product");
                         JButton buttonDelete = new JButton("Delete product");
                         JButton buttonModify = new JButton("Modify product");
                         JButton buttonCreate = new JButton("Create compound product");
                         panelMan.add(labelTitle1);
                         panelMan.add(textTitle1);
                         panelMan.add(labelNewTitle);
                         panelMan.add(textNewTitle);
                         panelMan.add(labelRating);
                         panelMan.add(textRating);
                         panelMan.add(labelCalories);
                         panelMan.add(textCalories);
                         panelMan.add(labelProteins);
                         panelMan.add(textProteins);
                         panelMan.add(labelFats);
                         panelMan.add(textFats);
                         panelMan.add(labelSodium);
                         panelMan.add(textSodium);
                         panelMan.add(labelPrice);
                         panelMan.add(textPrice);
                         panelMan.add(buttonAdd);
                         panelMan.add(buttonDelete);
                         panelMan.add(buttonModify);
                         panelMan.add(buttonCreate);
                         panelMan.setLayout(new GridLayout(0, 2));
                         manageFrame.add(panelMan);
                         manageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                         manageFrame.setSize(500, 500);
                         manageFrame.setVisible(true);
                         buttonAdd.addActionListener(eAdd->
                         {
                             String title = textTitle1.getText();
                             double rating = Double.parseDouble(textRating.getText());
                             int calories = Integer.parseInt(textCalories.getText());
                             int protein = Integer.parseInt(textProteins.getText());
                             int fat = Integer.parseInt(textFats.getText());
                             int sodium = Integer.parseInt(textSodium.getText());
                             int price = Integer.parseInt(textPrice.getText());
                             BaseProduct produs = new BaseProduct(title, rating, calories, protein,
                                     fat, sodium, price);
                             boolean added = service.addProduct(produs);
                             if(added == true)
                             JOptionPane.showMessageDialog(null, "Product added");
                             else
                                 JOptionPane.showMessageDialog(null, "Product already exists");
                         });
                         buttonDelete.addActionListener(eDelete ->
                         {
                             String title = textTitle1.getText();
                             double rating = Double.parseDouble(textRating.getText());
                             int calories = Integer.parseInt(textCalories.getText());
                             int protein = Integer.parseInt(textProteins.getText());
                             int fat = Integer.parseInt(textFats.getText());
                             int sodium = Integer.parseInt(textSodium.getText());
                             int price = Integer.parseInt(textPrice.getText());
                             BaseProduct produs = new BaseProduct(title, rating, calories, protein,
                                     fat, sodium, price);
                             boolean deleted = service.deleteProduct(produs);
                             if(deleted == false)
                                 JOptionPane.showMessageDialog(null, "Product not found");
                             else
                                 JOptionPane.showMessageDialog(null, "Product deleted");

                         });
                         buttonModify.addActionListener(eModify->
                         {
                             String title = textTitle1.getText();
                             String newTitle = textNewTitle.getText();
                             String textR = textRating.getText();
                             String textC = textCalories.getText();
                             String textPro = textProteins.getText();
                             String textF = textFats.getText();
                             String textS = textSodium.getText();
                             String textPri = textPrice.getText();
                             double newRating;
                             int newCalories;
                             int newProtein;
                             int newFat;
                             int newSodium;
                             int newPrice;
                             BaseProduct produsDeModificat = new BaseProduct();
                                 produsDeModificat.setTitle(newTitle);
                             if(!textR.isEmpty()) {
                                 newRating = Double.parseDouble(textR.trim());
                                 produsDeModificat.setRating(newRating);
                             }
                             else
                                 produsDeModificat.setRating(-1);
                             if(!textC.isEmpty()) {
                                 newCalories = Integer.parseInt(textC.trim());
                                 produsDeModificat.setCalories(newCalories);
                             }
                             else
                                 produsDeModificat.setCalories(-1);
                             if(!textPro.isEmpty()) {
                                 newProtein = Integer.parseInt(textPro.trim());
                                 produsDeModificat.setProtein(newProtein);
                             }
                             else
                                 produsDeModificat.setProtein(-1);
                             if(!textF.isEmpty()) {
                                 newFat = Integer.parseInt(textF.trim());
                                 produsDeModificat.setFat(newFat);
                             }
                             else
                                 produsDeModificat.setFat(-1);
                             if(!textS.isEmpty()) {
                                 newSodium = Integer.parseInt(textS.trim());
                                 produsDeModificat.setSodium(newSodium);
                             }
                             else
                                 produsDeModificat.setSodium(-1);
                             if(!textPri.isEmpty()) {
                                 newPrice = Integer.parseInt(textPri.trim());
                                 produsDeModificat.setPrice(newPrice);
                             }
                             else
                             produsDeModificat.setPrice(-1);
                            service.modifyProduct(title, produsDeModificat);


                         });
                         buttonCreate.addActionListener(eCreate->
                         {
                             ArrayList <MenuItem> listaCompound = new ArrayList<>();
                            JFrame frameCreate = new JFrame("Create composite product");
                            JPanel panelCreate = new JPanel();
                            JPanel panelTit = new JPanel();
                            JPanel panelCompTit = new JPanel();
                            JLabel labelTit = new JLabel("Title: ");
                            JTextField textTit = new JTextField();
                            textTit.setColumns(30);
                             JLabel labelCompTit = new JLabel("Title for compound product: ");
                             JTextField textCompTit = new JTextField();
                             textCompTit.setColumns(30);
                             panelTit.add(labelTit);
                             panelTit.add(textTit);
                             panelCompTit.add(labelCompTit);
                             panelCompTit.add(textCompTit);
                             panelCreate.add(panelTit);
                             panelCreate.add(panelCompTit);
                             JPanel panelBut = new JPanel();
                             JButton adaugaProdusButton = new JButton("Add product");
                             JButton adaugaLaMeniuButton = new JButton("Add compound product to menu");
                             panelBut.add(adaugaProdusButton);
                             panelBut.add(adaugaLaMeniuButton);
                             panelCreate.add(panelBut);
                             panelCreate.setLayout(new BoxLayout(panelCreate, BoxLayout.PAGE_AXIS));
                             frameCreate.add(panelCreate);
                            frameCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameCreate.setSize(500, 500);
                            frameCreate.setVisible(true);
                            adaugaProdusButton.addActionListener(eAdauga->
                            {
                                String textT = textTit.getText();
                                List<MenuItem> produsul = service.searchingForProducts(textT, -1, -1, -1, -1, -1, -1);
                                if(!produsul.isEmpty())
                                    listaCompound.add(produsul.get(0));
                                textTit.setText("");
                            });
                            adaugaLaMeniuButton.addActionListener(eMeniu->
                            {
                                String textComp = textCompTit.getText();
                                service.compoundProduct(textComp, listaCompound);
                            });

                         });


                     });
                        buttonGenerate.addActionListener(eGenerate->
                        {
                            JFrame frameGenerate = new JFrame("Generate");
                            JPanel panelSH = new JPanel();
                            JPanel panelEH = new JPanel();
                            JPanel panelF = new JPanel();
                            panelF.setLayout(new BoxLayout(panelF, BoxLayout.PAGE_AXIS));
                            JLabel labelSH = new JLabel("Start hour hh:mm:ss : ");
                            JTextField textSH = new JTextField();
                            textSH.setColumns(30);
                            JButton buttonP = new JButton("Generate the products");
                            JPanel panelButtonP = new JPanel();
                            panelButtonP.add(buttonP);
                            JButton buttonC = new JButton("Generate the clients");
                            JPanel panelButtonC = new JPanel();
                            panelButtonC.add(buttonC);
                            JLabel labelEH = new JLabel("End hour hh:mm:ss : ");
                            JButton buttonS = new JButton("Generate orders");
                            JPanel panelSTI = new JPanel();
                            panelSTI.add(buttonS);
                            JTextField textEH = new JTextField();
                            JPanel panelPO = new JPanel();
                            JLabel labelPO = new JLabel("Products orderer more than:");
                            JPanel panelCV = new JPanel();
                            JLabel labelCO = new JLabel("Clients that ordered more than:");
                            JTextField textCO = new JTextField();
                            textCO.setColumns(30);
                            JLabel labelV = new JLabel("Value of order higher than:");
                            JTextField textV = new JTextField();
                            textV.setColumns(30);
                            panelCV.add(labelCO);
                            panelCV.add(textCO);
                            panelCV.add(labelV);
                            panelCV.add(textV);
                            panelCV.setLayout(new GridLayout(0, 2));
                            JTextField textPO = new JTextField();
                            JPanel panelDay = new JPanel();
                            JLabel labelDay = new JLabel("Specify the date:y-m-d:");
                            JTextField textDay = new JTextField();
                            JButton buttonGP = new JButton("Generate the products");
                            JPanel panelGP = new JPanel();
                            panelGP.add(buttonGP);
                            textDay.setColumns(30);
                            panelDay.add(labelDay);
                            panelDay.add(textDay);
                            textPO.setColumns(30);
                            panelPO.add(labelPO);
                            panelPO.add(textPO);
                            textEH.setColumns(30);
                            panelSH.add(labelSH);
                            panelSH.add(textSH);
                            panelEH.add(labelEH);
                            panelEH.add(textEH);
                            panelF.add(panelSH);
                            panelF.add(panelEH);
                            panelF.add(panelSTI);
                            panelF.add(panelPO);
                            panelF.add(panelButtonP);
                            panelF.add(panelCV);
                            panelF.add(panelButtonC);
                            panelF.add(panelDay);
                            panelF.add(panelGP);
                            frameGenerate.add(panelF);
                            frameGenerate.setVisible(true);
                            frameGenerate.setSize(500, 500);
                            frameGenerate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            buttonS.addActionListener(eS->
                            {
                                String SS = textSH.getText();
                                String SE = textEH.getText();
                                LocalTime timeS = LocalTime.parse(SS);
                                LocalTime timeE = LocalTime.parse(SE);
                                List<Map.Entry<Order, List<MenuItem>>> listaInterval = service.timeInterval(timeS, timeE);
                                JFrame frameInterval = new JFrame();
                                frameInterval.setVisible(true);
                                frameInterval.setSize(500, 500);
                                String data[][] = new String[listaInterval.size()][3];
                                String column[] = new String[3];
                                column[0] = "ClientID";
                                column[1] = "Time";
                                column[2] = "OrderID";
                                for(int i = 0; i < listaInterval.size(); i++)
                                {
                                    data[i][0] = listaInterval.get(i).getKey().getClientID();
                                    data[i][1] = String.valueOf(listaInterval.get(i).getKey().getNow());
                                    data[i][2] = String.valueOf(listaInterval.get(i).getKey().getOrderID());
                                }
                                JTable tableMenu = new JTable(data, column);
                                JScrollPane scrollPane = new JScrollPane(tableMenu);
                                frameInterval.add(scrollPane);
                                frameInterval.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            });
                            buttonP.addActionListener(eP->
                            {
                                int nrOfTimes = Integer.parseInt(textPO.getText());
                               List<MenuItem> listaProduse =  service.productOrdered(nrOfTimes);
                                JFrame frameProdus = new JFrame();
                                frameProdus.setVisible(true);
                                frameProdus.setSize(500, 500);

                                String data[][] = new String[listaProduse.size()][1];
                                String column[] = new String[1];
                                column[0] = "Product title";
                                for(int i = 0; i < listaProduse.size(); i++)
                                {
                                    data[i][0] = listaProduse.get(i).getTitle();

                                }
                                JTable tableMenu = new JTable(data, column);
                                JScrollPane scrollPane = new JScrollPane(tableMenu);
                                frameProdus.add(scrollPane);
                                frameProdus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            });
                            buttonC.addActionListener(eC->
                            {
                                int nrOfTime = Integer.parseInt(textCO.getText());
                                int value = Integer.parseInt(textV.getText());
                                service.clientThatOrdered(nrOfTime, value);
                            });
                            buttonGP.addActionListener(eGP->
                            {
                                LocalDate date = LocalDate.parse(textDay.getText());
                                Map<MenuItem, Integer> listaProduse = service.productsOnDay(date);
                                JFrame frameGP = new JFrame();


                                    frameGP.setVisible(true);
                                frameGP.setSize(500, 500);

                                String data[][] = new String[listaProduse.size()][2];
                                String column[] = new String[2];
                                column[0] = "Product title";
                                column[1] = "Nr of aparitions";
                                final int[] i = {0};
                                 listaProduse.entrySet().stream()
                                         .forEach(order->
                                         {
                                             data[i[0]][0] = order.getKey().getTitle();
                                             data[i[0]][1] = String.valueOf(order.getValue());
                                             i[0]++;
                                         });

                                JTable tableMenu = new JTable(data, column);
                                JScrollPane scrollPane = new JScrollPane(tableMenu);
                                frameGP.add(scrollPane);
                                frameGP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            });
                        });
                    }
                    else if(rol == 2)
                    {
                        JFrame clientFrame = new JFrame("Client operations");
                        clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JPanel panelView = new JPanel();
                        JPanel panelClient = new JPanel();
                        JPanel panelSearch = new JPanel();
                        JLabel labelKeyword = new JLabel("Keyword:");
                        JTextField textKeyword = new JTextField();
                        JLabel labelRating = new JLabel("Rating:");
                        JTextField textRating = new JTextField();
                        JLabel labelCalories = new JLabel("Calories:");
                        JTextField textCalories = new JTextField();
                        JLabel labelProteins = new JLabel("Protein:");
                        JTextField textProteins = new JTextField();
                        JLabel labelFats = new JLabel("Fat:");
                        JTextField textFats = new JTextField();
                        JLabel labelSodium = new JLabel("Sodium:");
                        JTextField textSodium = new JTextField();
                        JLabel labelPrice = new JLabel("Price:");
                        JTextField textPrice = new JTextField();
                        JButton buttonSearch = new JButton("Search");
                        JPanel panelS = new JPanel();
                        panelS.add(buttonSearch);
                        panelSearch.add(labelKeyword);
                        panelSearch.add(textKeyword);
                        panelSearch.add(labelRating);
                        panelSearch.add(textRating);
                        panelSearch.add(labelCalories);
                        panelSearch.add(textCalories);
                        panelSearch.add(labelProteins);
                        panelSearch.add(textProteins);
                        panelSearch.add(labelFats);
                        panelSearch.add(textFats);
                        panelSearch.add(labelSodium);
                        panelSearch.add(textSodium);
                        panelSearch.add(labelPrice);
                        panelSearch.add(textPrice);
                        panelSearch.setLayout(new GridLayout(0, 2));
                        JButton buttonView = new JButton("View the menu");
                        panelView.add(buttonView);
                        JPanel panelOrder = new JPanel();
                        JButton buttonOrder = new JButton("Create new order");
                        panelOrder.add(buttonOrder);
                        panelClient.add(panelView);
                        panelClient.add(panelSearch);
                        panelClient.add(panelS);
                        panelClient.add(panelOrder);
                        panelClient.setLayout(new BoxLayout(panelClient, BoxLayout.PAGE_AXIS));
                        clientFrame.add(panelClient);
                        clientFrame.setSize(500, 500);
                        clientFrame.setVisible(true);
                        buttonView.addActionListener(e1 ->
                        {
                            String data[][] = new String[service.getListaMenu().size()][7];
                            String column[] = new String[7];
                            column[0] = "Title";
                            column[1] = "Rating";
                            column[3] = "Protein";
                            column[2] = "Calories";
                            column[4] = "Fat";
                            column[5] = "Sodium";
                            column[6] = "Price";
                            for(int i = 0; i < service.getListaMenu().size(); i++)
                            {
                                data[i][0] = service.getListaMenu().get(i).getTitle();
                                data[i][1] = String.valueOf(service.getListaMenu().get(i).getRating());
                                data[i][2] = String.valueOf(service.getListaMenu().get(i).getCalories());
                                data[i][3] = String.valueOf(service.getListaMenu().get(i).getProtein());
                                data[i][4] = String.valueOf(service.getListaMenu().get(i).getFat());
                                data[i][5] = String.valueOf(service.getListaMenu().get(i).getSodium());
                                data[i][6] = String.valueOf(service.getListaMenu().get(i).getPrice());
                            }
                            JTable tableMenu = new JTable(data, column);
                            JFrame frameViewMenu = new JFrame("Menu");
                            JScrollPane scrollPane = new JScrollPane(tableMenu);
                            frameViewMenu.add(scrollPane);
                            frameViewMenu.setSize(500, 500);
                            frameViewMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameViewMenu.setVisible(true);
                        });
                        buttonSearch.addActionListener(eSearch->
                        {
                            String keyword = textKeyword.getText();
                            String textR = textRating.getText();
                            String textPro = textProteins.getText();
                            String textF = textFats.getText();
                            String textC = textCalories.getText();
                            String textS = textSodium.getText();
                            String textPri = textPrice.getText();
                            double rating = -1;
                            int protein = -1;
                            int calories = -1;
                            int fat = -1;
                            int sodium = -1;
                            int price = -1;
                            if(!textR.isEmpty())
                                rating = Double.parseDouble(textR);
                            if(!textC.isEmpty())
                                calories = Integer.parseInt(textC);
                            if(!textF.isEmpty())
                                fat = Integer.parseInt(textF);
                            if(!textS.isEmpty())
                                sodium = Integer.parseInt(textS);
                            if(!textPro.isEmpty())
                                protein = Integer.parseInt(textPro);
                            if(!textPri.isEmpty())
                                price = Integer.parseInt(textPri);
                       List<MenuItem> listaMen = service.searchingForProducts(keyword, rating, calories, protein, fat, sodium, price);
                        JFrame frameSearching = new JFrame("Resulted products");
                            String data[][] = new String[service.getListaMenu().size()][7];
                            String column[] = new String[7];
                            column[0] = "Title";
                            column[1] = "Rating";
                            column[3] = "Protein";
                            column[2] = "Calories";
                            column[4] = "Fat";
                            column[5] = "Sodium";
                            column[6] = "Price";
                            for(int i = 0; i < listaMen.size(); i++)
                            {
                                data[i][0] = listaMen.get(i).getTitle();
                                data[i][1] = String.valueOf(listaMen.get(i).getRating());
                                data[i][2] = String.valueOf(listaMen.get(i).getCalories());
                                data[i][3] = String.valueOf(listaMen.get(i).getProtein());
                                data[i][4] = String.valueOf(listaMen.get(i).getFat());
                                data[i][5] = String.valueOf(listaMen.get(i).getSodium());
                                data[i][6] = String.valueOf(listaMen.get(i).getPrice());
                            }
                            JTable tableMenu = new JTable(data, column);
                            JScrollPane scrollPane = new JScrollPane(tableMenu);
                            frameSearching.add(scrollPane);
                            frameSearching.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameSearching.setSize(500, 500);
                            frameSearching.setVisible(true);
                        });
                        buttonOrder.addActionListener(eOrder ->
                        {
                            final int[] c = {1};
                            ArrayList <MenuItem> orderList = new ArrayList<>();
                            JFrame frameOrder = new JFrame("Order");
                            JLabel labelProdus = new JLabel("Product:");
                            JPanel panelProdus = new JPanel();
                            panelProdus.add(labelProdus);
                            JTextField textProdus = new JTextField();
                            textProdus.setColumns(30);
                            panelProdus.add(textProdus);
                            JPanel panelButtons = new JPanel();
                            JButton buttonAdd = new JButton("Add product");
                            JButton buttonFinalizare = new JButton("Order completion");
                            panelButtons.add(buttonAdd);
                            panelButtons.add(buttonFinalizare);
                            JPanel panelFinal = new JPanel();
                            panelFinal.add(panelProdus);
                            panelFinal.add(panelButtons);
                            panelFinal.setLayout(new BoxLayout(panelFinal, BoxLayout.PAGE_AXIS));
                            frameOrder.add(panelFinal);
                            AtomicInteger price = new AtomicInteger();
                            buttonAdd.addActionListener(eAdd->
                            {
                                String nume = textProdus.getText();
                                List <MenuItem> produsul = service.searchingForProducts(nume, -1, -1, -1, -1, -1, -1);
                                if(!produsul.isEmpty()) {
                                    price.addAndGet(produsul.get(0).computePrice());
                                    orderList.add(produsul.get(0));
                                }
                                    textProdus.setText("");
                            });
                            buttonFinalizare.addActionListener(eFinalizare->
                            {
                                int pri = price.incrementAndGet();
                                pri = pri - 1;
                                LocalDateTime data = LocalDateTime.now();
                                FileWriter writer = null;
                                try {
                                    writer = new FileWriter("Orders.txt");
                                    writer.write("Comanda numarul  " + c[0] + " a fost plasata" +
                                     " la data " +   data.toString() + " de " + textUsername.getText() + ".Clientul a comandat in valoare de: "
                                            + pri + "\r\n");
                                    for(MenuItem product:orderList)
                                        writer.write("* " + product.getTitle() + "\r\n");
                                    writer.close();

                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                                int f;
                                f = c[0];
                                c[0]++;
                                Order order = new Order(f, textUsername.getText(), data);
                                service.createNewOrder(order, orderList);
                                orderList.removeAll(orderList);
                                price.set(0);
                            });
                            frameOrder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameOrder.setSize(500, 500);
                            frameOrder.setVisible(true);

                        });
                    }
        });



    }

}
