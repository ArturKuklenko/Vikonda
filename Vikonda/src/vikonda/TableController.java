package vikonda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * This class is the controller of table.fxml.
 */
public class TableController implements Initializable {
	public static String number = null;
	@FXML
	Button changeRowButton;
	@FXML
	DatePicker date;
	@FXML
	ComboBox<String> profileBox;
    @FXML
    ComboBox<String> statusBox;
    @FXML
    TextField orderText;
    @FXML
    TextField sumText;
    @FXML
    Label labelInfo2;
    @FXML
    TableColumn<Order, Integer> orderNumber;
    @FXML
    TableColumn<Order, String> orderProfile;
    @FXML
    TableColumn<Order, Integer> orderSum;
    @FXML
    TableColumn<Order, String> orderStatus;
    @FXML
    TableColumn<Order, String> orderDate;
    @FXML
    TableView<Order> OrderTable;
    ObservableList<String> profileBoxList = FXCollections.observableArrayList("deceuninck","WDS 505", "WDS 8");
    ObservableList<String> statusBoxList = FXCollections.observableArrayList("������� � ������","�������", "�����������", "�����");
    
    ObservableList<Order> OrderTableList = FXCollections.observableArrayList(
    		new Order("0", "dec", 100, "start", "10 december")
    		);
    
    /**
     * Method initialize calls when table.fxml change previous scene.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	changeRowButton.setDisable(true);
    	changeRowButton.setVisible(false);
        profileBox.setItems(profileBoxList);
        statusBox.setItems(statusBoxList);
        
        orderNumber.setCellValueFactory(new PropertyValueFactory<Order, Integer>("number"));
        orderProfile.setCellValueFactory(new PropertyValueFactory<Order, String>("profile"));
        orderSum.setCellValueFactory(new PropertyValueFactory<Order, Integer>("sum"));
        orderStatus.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
        orderDate.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        //OrderTable.getColumns().addAll( orderNumber, orderProfile, orderSum, orderStatus, orderDate);
        OrderTable.setItems(OrderTableList);
    }
    /**
     * Method addOrder calls when Button "add" clicked. It add order to table.
     */
    public void addOrder(){
    	labelInfo2.setText("added");
    	String number = null;
    	String profile = null;
    	String status = null; 
    	String dateDeliver =null;
    	int sum = 0;
    	try{
    	number = orderText.getText();
    	profile = profileBox.getValue().toString();
    	sum = Integer.parseInt(sumText.getText());
    	status = statusBox.getValue().toString();
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    	dateDeliver = dateFormatter.format(date.getValue());
    	}catch(NullPointerException e){
    		labelInfo2.setText("please fill fields");
    	}catch(NumberFormatException e2){
    		labelInfo2.setText("please fill fields, NumberFormatException");
    	}
    	if(number!=null&profile!=null&status!=null&dateDeliver!=null){
    		Order order = new Order(number, profile, sum, status, dateDeliver);
        	OrderTable.getItems().addAll(order);
    	} 	    	
    }
    /**
     * Method addOrder calls when Button "change" clicked.
     * It is made for confirm current Order number and number of Order which was selected before.
     * The Confirming process validates in method changeRow();
     */
    public void addOrder(String OrderN){
    	labelInfo2.setText("added");
    	String number = null;
    	String profile = null;
    	String status = null; 
    	String dateDeliver =null;
    	int sum = 0;
    	try{
    	number = orderText.getText();
    	profile = profileBox.getValue().toString();
    	sum = Integer.parseInt(sumText.getText());
    	status = statusBox.getValue().toString();
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    	dateDeliver = dateFormatter.format(date.getValue());
    	}catch(NullPointerException e){
    		labelInfo2.setText("please fill fields");
    	}catch(NumberFormatException e2){
    		labelInfo2.setText("please fill fields, NumberFormatException");
    	}
    	if(number!=null&profile!=null&status!=null&dateDeliver!=null){
    		Order order = new Order(number, profile, sum, status, dateDeliver);
        	OrderTable.getItems().addAll(order);
    	}
    	
    	
    }
    /**
     * Method deleteOrder just delete selected row.
     */
    public void deleteOrder(){
    	ObservableList<Order> productSelected, allProducts;
        allProducts = OrderTable.getItems();
        productSelected = OrderTable.getSelectionModel().getSelectedItems();

        productSelected.forEach((Order o) -> allProducts.remove(o));
        labelInfo2.setText("deleted");
    }
    /**
     * Method setRow select row. Also remember Order number the Row you've selected.
     */
    public void setRow(){
    	labelInfo2.setText("Choose current changes to order");
    	try{
    	ObservableList<Order> productSelected = OrderTable.getSelectionModel().getSelectedItems();
    	Order toChange = productSelected.get(0);
    	orderText.setText(toChange.getNumber());
    	profileBox.getSelectionModel().select(toChange.getProfile());
    	String sum = ""+toChange.getSum();
    	sumText.setText(sum);
    	statusBox.getSelectionModel().select(toChange.getStatus());

    	String[] datestr = toChange.getDate().split("\\.");
    	int year = Integer.parseInt(datestr[2]);
    	int month = Integer.parseInt(datestr[1]);
    	int day = Integer.parseInt(datestr[0]);

    	date.setValue(LocalDate.of(year,month,day));
    	
    	changeRowButton.setDisable(false);
    	changeRowButton.setVisible(true);
    	
        number = orderText.getText();
    	} catch(Exception e){
    		labelInfo2.setText("The Row haven't selected,enter Order number please");
    	}
    	
    }
    /**
     * Method changeRow() create new Order,
     * and delete Order if "selected number row" and "saved number row" are equals.
     */
    public void changeRow(){
    changeRowButton.setDisable(true);
	changeRowButton.setVisible(false);
	String OrderN = null;
	try{
		OrderN = orderText.getText();
	} catch(Exception e){
		labelInfo2.setText("enter Order number please");
	}
	if(OrderN.equals(number)){
		deleteOrder();
		addOrder(number);
		labelInfo2.setText("The Row changed");
	} else {
		labelInfo2.setText("The Order's numbers must being equals");
	}

    }
    /**
     * Method saveOrders() serialize Object into file.
     */
    public void saveOrders(){
    	OrderList forSerialize = new OrderList(OrderTable.getItems());
    	
    	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\AppendixA\\OrderList.ser"))){
    		out.writeObject(forSerialize);
    		labelInfo2.setText("saved");
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
    		labelInfo2.setText("FileNotFound create the folder C:\\AppendixA\\ ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			labelInfo2.setText("IOException");
		}
    }
    /**
     * Method loadOrders() Deserialize Object from file.
     */
    public void loadOrders() {
    	OrderList DeserializeList = null; 
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\AppendixA\\OrderList.ser"))){
    		DeserializeList = (OrderList) in.readObject();
    		labelInfo2.setText("loaded");
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
    		labelInfo2.setText("ClassNotFoundException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			labelInfo2.setText("IOException file should be C:\\AppendixA\\OrderList.ser");
		}
    	OrderTable.getItems().clear();
    	try{
    	OrderTableList = DeserializeList.getListOfOrders();
    	OrderTable.setItems(OrderTableList);
    	} catch (RuntimeException e) {
			labelInfo2.setText("file should be in C:\\AppendixA\\OrderList.ser");
		}
    }

}
