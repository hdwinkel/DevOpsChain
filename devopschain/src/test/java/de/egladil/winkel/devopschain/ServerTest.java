package de.egladil.winkel.devopschain;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ServerTest extends Server {

	private String input="Peace";
	
	Thread thread;
	
	@Before
	public void setUp() throws Exception {
		// start the telnet server
		// Server myserver = new Server();
        // myserver.connectToServer();
		
		thread = new Thread("ServerThread") {
			public void run() {
				Server myserver = new Server();
		        myserver.connectToServer();
			}
		};
		
		thread.start();
		System.out.println(thread.getName() + " started");
		
	}
	
	@After
	public void tearDown() {
		// stop thread
		if (thread.isAlive()) thread.stop();
	}

	//is a hack to connect to a local terminal server. Means: TCP must run locally
	@Test
	public void testConnectToServer() throws Exception {
		// try to connect to the server on localhost and port 9991
		
        //Create object of Socket

        Socket soc=new Socket("localhost",9991);

        //Create object of Input Stream to read from socket
        DataInputStream din=new DataInputStream(soc.getInputStream());    

        //Create object of Output Stream   to write on socket 
        DataOutputStream dout=new DataOutputStream(soc.getOutputStream());

        System.out.println("Telnet Client started");
        
        String ret=din.readLine(); //gets the response of server 

        System.out.println("Resp: " + ret);        
        
        dout.writeUTF(input);//sends command 'Peace' to server

        
        soc.close();  //close port  

        din.close();  //close input stream     

        dout.close();  //close output stream      

        assertEquals("Initial server response","Hello World! Enter Peace to exit1.",ret);
		
		
	}

}
