package vikonda;

import java.io.Serializable;

public class SaveFileInfo implements Serializable{
	public static final long serialVersionUID = 3L;
	long timeStampPrevios = 0;
	
	public SaveFileInfo(long timeStampLast){
		this.timeStampPrevios = timeStampLast;
	}

	public long getTimeStampPrevios() {
		return timeStampPrevios;
	}

	public void setTimeStampPrevios(long timeStampPrevios) {
		this.timeStampPrevios = timeStampPrevios;
	}
	
}
