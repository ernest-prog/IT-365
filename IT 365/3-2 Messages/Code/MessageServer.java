/**
 * Message server.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */
 
import java.net.*;
import java.io.*;

public class MessageServer
{
	public static final int PORT = 6100;

	public static void main(String[] args) {
		Socket client = null;
		ServerSocket sock = null;
		BufferedReader reader = null;

		try {
			sock = new ServerSocket(PORT);
			/*After creating an object of ServerSocket, here we are using a while-loop and bufferedReader for reading every inputs from clients and storing in an object of MessageImpl class*/
			while (true) {
				client = sock.accept();

				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

				Message message = new MessageImpl(reader.readLine());

				/* Setting the number of characters and digits in the message */
				message.setCounts();

				/*Converting the java object to stream and writing it in the socket */
            ObjectOutputStream soos = new ObjectOutputStream(client.getOutputStream());
				soos.writeObject(message);
				System.out.println("wrote message to the socket");

				client.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
