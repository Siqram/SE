package restaurantapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.paint.*;

public class TableLayoutController implements Initializable {

    @FXML AnchorPane menuScreenPane;
    @FXML Circle tableOneStatus, tableTwoStatus, tableThreeStatus, tableFourStatus;
    @FXML Button starterMenu, mainCourseMenu, drinkMenu, dessertMenu;
    @FXML Button tableOneSeatOne, tableOneSeatTwo, tableOneSeatThree, tableOneSeatFour;
    @FXML Button tableTwoSeatOne, tableTwoSeatTwo, tableTwoSeatThree, tableTwoSeatFour;
    @FXML Button tableThreeSeatOne, tableThreeSeatTwo, tableThreeSeatThree, tableThreeSeatFour;
    @FXML Button tableFourSeatOne, tableFourSeatTwo, tableFourSeatThree, tableFourSeatFour;
    @FXML TextArea tableOneSeatOneOrder, tableOneSeatTwoOrder, tableOneSeatThreeOrder, tableOneSeatFourOrder;
    @FXML TextArea tableTwoSeatOneOrder, tableTwoSeatTwoOrder, tableTwoSeatThreeOrder, tableTwoSeatFourOrder;
    @FXML TextArea tableThreeSeatOneOrder, tableThreeSeatTwoOrder, tableThreeSeatThreeOrder, tableThreeSeatFourOrder;
    @FXML TextArea tableFourSeatOneOrder, tableFourSeatTwoOrder, tableFourSeatThreeOrder, tableFourSeatFourOrder;
    @FXML TableView<MenuItems> menuTable = new TableView<MenuItems>();
    @FXML TableColumn<MenuItems, String> itemNameCol, descCol, priceCol;

    private final ObservableList<MenuItems> starterItems = FXCollections.observableArrayList(
            new MenuItems("Starter 1", "This is Starter 1", "1.99"),
            new MenuItems("Starter 2", "This is Starter 2", "2.99"),
            new MenuItems("Starter 3", "This is Starter 3", "3.99"));
    private final ObservableList<MenuItems> mainCourseItems = FXCollections.observableArrayList(
            new MenuItems("Main 1", "This is Main Course 1", "1.99"),
            new MenuItems("Main 2", "This is Main Course 2", "2.99"),
            new MenuItems("Main 3", "This is Main Course 3", "3.99"));
    private final ObservableList<MenuItems> drinkItems = FXCollections.observableArrayList(
            new MenuItems("Drink 1", "This is Drink 1", "1.99"),
            new MenuItems("Drink 2", "This is Drink 2", "2.99"),
            new MenuItems("Drink 3", "This is Drink 3", "3.99"));
    private final ObservableList<MenuItems> dessertItems = FXCollections.observableArrayList(
            new MenuItems("Dessert 1", "This is Dessert 1", "1.99"),
            new MenuItems("Dessert 2", "This is Dessert 2", "2.99"),
            new MenuItems("Dessert 3", "This is Dessert 3", "3.99"));

    private String fullOrder = "";
    private ActionEvent currentSeat;

    @FXML private void takeSeatOrder(ActionEvent e) throws IOException {
        currentSeat = e;
        menuScreenPane.setVisible(true);
    }

    @FXML private void showMenuItems(ActionEvent e) throws IOException {
        itemNameCol.setCellValueFactory(new PropertyValueFactory("itemName"));
        descCol.setCellValueFactory(new PropertyValueFactory("itemDesc"));
        priceCol.setCellValueFactory(new PropertyValueFactory("itemPrice"));
        if(e.getSource() == starterMenu)
            menuTable.setItems(starterItems);
        else if(e.getSource() == mainCourseMenu)
            menuTable.setItems(mainCourseItems);
        else if(e.getSource() == drinkMenu)
            menuTable.setItems(drinkItems);
        else if(e.getSource() == dessertMenu)
            menuTable.setItems(dessertItems);
        else {}
        menuTable.getColumns().setAll(itemNameCol, descCol, priceCol);
    }

    @FXML private void addItemToOrder(ActionEvent e) throws IOException {
        try {
            MenuItems selectedItem = menuTable.getSelectionModel().getSelectedItem();
            fullOrder = fullOrder + " " + selectedItem.getItemName() + " - " + selectedItem.getItemPrice() + "\n";
        } catch (NullPointerException ex) {
            System.out.println("no menu item chosen");
        }
    }

    @FXML private void finishOrder(ActionEvent e) throws IOException {
        if(fullOrder != "") {
            if (currentSeat.getSource() == tableOneSeatOne) { // table one
                tableOneSeatOneOrder.setText(fullOrder);
                tableOneStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableOneSeatTwo) {
                tableOneSeatTwoOrder.setText(fullOrder);
                tableOneStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableOneSeatThree) {
                tableOneSeatThreeOrder.setText(fullOrder);
                tableOneStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableOneSeatFour) {
                tableOneSeatFourOrder.setText(fullOrder);
                tableOneStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableTwoSeatOne) { // table two
                tableTwoSeatOneOrder.setText(fullOrder);
                tableTwoStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableTwoSeatTwo) {
                tableTwoSeatTwoOrder.setText(fullOrder);
                tableTwoStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableTwoSeatThree) {
                tableTwoSeatThreeOrder.setText(fullOrder);
                tableTwoStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableTwoSeatFour) {
                tableTwoSeatFourOrder.setText(fullOrder);
                tableTwoStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableThreeSeatOne) { // table three
                tableThreeSeatOneOrder.setText(fullOrder);
                tableThreeStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableThreeSeatTwo) {
                tableThreeSeatTwoOrder.setText(fullOrder);
                tableThreeStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableThreeSeatThree) {
                tableThreeSeatThreeOrder.setText(fullOrder);
                tableThreeStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableThreeSeatFour) {
                tableThreeSeatFourOrder.setText(fullOrder);
                tableThreeStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableFourSeatOne) { // table four
                tableFourSeatOneOrder.setText(fullOrder);
                tableFourStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableFourSeatTwo) {
                tableFourSeatTwoOrder.setText(fullOrder);
                tableFourStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableFourSeatThree) {
                tableFourSeatThreeOrder.setText(fullOrder);
                tableFourStatus.setFill(Color.YELLOW);
            } else if (currentSeat.getSource() == tableFourSeatFour) {
                tableFourSeatFourOrder.setText(fullOrder);
                tableFourStatus.setFill(Color.YELLOW);
            }

            fullOrder = "";
        } else { }

        menuScreenPane.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static class MenuItems {
        private final SimpleStringProperty itemName;
        private final SimpleStringProperty itemDesc;
        private final SimpleStringProperty itemPrice;

        private MenuItems(String iName, String iDesc, String iPrice) {
            this.itemName = new SimpleStringProperty(iName);
            this.itemDesc = new SimpleStringProperty(iDesc);
            this.itemPrice = new SimpleStringProperty(iPrice);
        }

        public void setItemName(String name) {
            itemName.set(name);
        }
        public String getItemName() {
            return itemName.get();
        }
        public void setItemDesc(String desc) {
            itemDesc.set(desc);
        }
        public String getItemDesc() {
            return itemDesc.get();
        }
        public void setItemPrice(String price) {
            itemPrice.set(price);
        }
        public String getItemPrice() {
            return itemPrice.get();
        }
    }
}
