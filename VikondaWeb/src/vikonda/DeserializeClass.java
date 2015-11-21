package vikonda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class DeserializeClass {
	
	
	public static OrderList loadOrders() {
    	OrderList DeserializeList = null; 
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\AppendixA\\OrderList.ser"))){
    		DeserializeList = (OrderList) in.readObject();
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.out.println("ClassNotFoundException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
		}
    	return DeserializeList;
    }
	
	
	public static boolean checkLastModified(){
	File file = new File("C:\\AppendixA\\OrderList.ser");
	long timeStampLast = file.lastModified();
	SaveFileInfo info =null;
	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\AppendixA\\LastModified.ser"))){
		info = (SaveFileInfo) in.readObject();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("ClassNotFoundException");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("IOException");
	}
	long previosModified = info.getTimeStampPrevios();
	if(previosModified==timeStampLast){
		//Date date = new Date(timeStampLast);
		//System.out.println(date);
		return false;
	}else{
		//Date date = new Date(timeStampLast);
		//System.out.println(date);
		saveInfo(timeStampLast);
		return true;
	}
	}
	
	
	public static void saveInfo(long timeStampLast) {
		SaveFileInfo info = new SaveFileInfo(timeStampLast);
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\AppendixA\\LastModified.ser"))){
			out.writeObject(info);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
		}
	}
}
