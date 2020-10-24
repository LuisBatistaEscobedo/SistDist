package TCP;
import java.net.*;
import java.io.*;

public class JavaClient {
	public static void main(String[] args) throws IOException{
		Socket s = new Socket("localhost", 4999);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.print("This is a test");
		pr.flush();
		s.close();
	}

}
