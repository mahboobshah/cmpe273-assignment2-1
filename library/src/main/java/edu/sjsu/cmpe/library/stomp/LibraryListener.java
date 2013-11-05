package edu.sjsu.cmpe.library.stomp;

import javax.jms.Connection;
import org.eclipse.jetty.server.Server;

import com.yammer.dropwizard.lifecycle.ServerLifecycleListener;

public class LibraryListener implements ServerLifecycleListener {
	private static ApolloSTOMP apolloSTOMP; 
	 
	public LibraryListener(ApolloSTOMP apolloSTOMP) {
		this.apolloSTOMP=apolloSTOMP;
	}
	
	@Override
	public void serverStarted(Server server) {
		Connection connect;
		try {
			connect = apolloSTOMP.makeConnection();
	        apolloSTOMP.subscribeTopic(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
}