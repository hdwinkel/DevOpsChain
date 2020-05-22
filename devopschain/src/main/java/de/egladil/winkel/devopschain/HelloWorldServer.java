package de.egladil.winkel.devopschain;

/**
* based on code of Martin Ombura Jr. <@martinomburajr>
*/

public class HelloWorldServer {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread("ServerThread") {
			public void run() {
				Server myserver = new Server();
		        myserver.connectToServer();
			}
		};
		
		thread.start();
		System.out.println(thread.getName() + " started");
		
    }
}
