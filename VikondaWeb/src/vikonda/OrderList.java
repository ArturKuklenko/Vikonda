package vikonda;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class OrderList made for serializing ArrayList of Order.
 * It converts ArrayList to ObservableList and vice versa.
 */
public class OrderList implements Serializable{
	public static final long serialVersionUID = 2;
	ArrayList<Order> ListOfOrders = new ArrayList<Order>();

	public OrderList(ObservableList<Order> listOfOrders) {
		super();
		for(Order e : listOfOrders){
			ListOfOrders.add(e);	
		}
		
	}
	public ObservableList<Order> getListOfOrders(){
		ObservableList<Order> ListOfOrdersObserv = FXCollections.observableArrayList();
		for(Order e : ListOfOrders){
			ListOfOrdersObserv.add(e);	
		}
		return ListOfOrdersObserv;	
	}
	public ArrayList<Order> getOrdersArrayList() {
		return ListOfOrders;
	}
	
}

