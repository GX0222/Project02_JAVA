package tw.ken;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	
	public MyServer() {
		if(sessions == null) {
			sessions = new HashSet<Session>();
			users = new HashMap<String, Session>();
		}
	}//-----
	
	@OnOpen
	public void onOpen(Session sess) {
		System.out.println("onOpen: " + sess.getId());
		if(sessions.add(sess)) {
			users.put(sess.getId(), sess);
			sess.setMaxIdleTimeout(60*1000);
		}
		System.out.println("Count: " + sessions.size());
	}//-----
	
	@OnClose
	public void onClose(Session sess) {
		users.remove(sess.getId());
		sessions.remove(sess);
		System.out.println("Count: " + sessions.size());
	}//-----
	
	@OnMessage
	public void onMessage(String message, Session sess) {
		System.out.println(sess.getId() + ": " + message);
		
		for(Session session : sessions) {
			try {
				session.getBasicRemote().sendText(message);
				
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		//users.get(sess.getId()).getBasicRemote().sendText(message);
	}//-----
	
}
