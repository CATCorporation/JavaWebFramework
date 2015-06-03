package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import dao.DbUser;

public class Login implements IMyAction {

	private Login(){
		
	}
	
	public static Login getInstance(){
		return loginHolder.INSTANCE;
	}
	
	private static class loginHolder{
		private static final Login INSTANCE = new Login();
	}
	
	private final static String URI = "/JavaWebFramework/user/accueil";

	
	public void proceed(IContext context) {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		try {
			out = context._getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String, String> user = null;
		String login = "", mdp = "";
		for (String s : (String[]) context.getParameter("login")) {
			login = s;
		}
		for (String s : (String[]) context.getParameter("mdp")) {
			mdp = s;
		}
//		for(HashMap<String, String> u : DbUser.listUser){
//			if(u.get("login").equals(login) && u.get("mdp").equals(mdp)){
//				user = u;
//			}
//		}
		if(user == null){
			out.println("<p>Login ou mdp incorrect !</p>");
		}else{
			context.setSessionAttribute("login", user.get("login"));
			context.setSessionAttribute("role", user.get("role"));
		}		
		
		try {
			context._getResponse().sendRedirect(URI);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public int setPriority(int priority) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void addCredential(String role) {
		// TODO Auto-generated method stub

	}

	
	public boolean needsCredentials() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean hasCredential(String[] roles) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public IAction getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
