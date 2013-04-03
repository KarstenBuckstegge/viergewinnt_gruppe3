package connect;
import java.io.*;

public class WriteFile {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws IOException
	
	{
			System.out.println("WriteFile aufgerufen!");
		 	FileWriter fw = new FileWriter();
		    BufferedWriter bw = new BufferedWriter(fw);
		    
		    bw.write(String.valueOf(Connect.move));
		    bw.close();
		   
	}

}
