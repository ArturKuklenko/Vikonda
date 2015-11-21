package vikonda;

import java.io.Serializable;
/**
 * Class Order.
 */
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final long SerialVersionUID = 1L;
	private String number;
	private String profile;
	private int sum;
	private String status;
	private String date;
	public Order(String number, String profile, int sum, String status, String date) {
		super();
		this.number = number;
		this.profile = profile;
		this.sum = sum;
		this.status = status;
		this.date = date;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
