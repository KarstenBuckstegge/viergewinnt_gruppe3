package connect;

import java.io.IOException;

public class testing {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//		
		Server_Connector connect = new Server_Connector();
		connect.setPlayerID(1);
//		
//		String directory = "/Users/Chris/Desktop";
//		connect.setTransferDirectory(directory);
		
		connect.startGame();

	}

}
