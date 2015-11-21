package vikonda;

public class checkMain {

	public static void main(String[] args) {
		OrderList list = DeserializeClass.loadOrders();
		System.out.println(list.getOrdersArrayList().size());
		//DeserializeClass.saveInfo(12L);
		boolean check = DeserializeClass.checkLastModified();
		System.out.println(check);
	}

}
