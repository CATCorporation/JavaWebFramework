package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import dao.DbUser;

public class Display implements IMyAction {

	private Display(){
		
	}
	
	public static Display getInstance(){
		return displayHolder.INSTANCE;
	}
	
	private static class displayHolder{
		private static final Display INSTANCE = new Display();
	}
	
	
	public void proceed(IContext context) {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		try {
			out = context._getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		HashMap<String, String> user = DbUser.getUser(((String[]) context
//				.getParameter("displayUser"))[0]);

//		out.println("<a href=\"accueil\">Accueil</a>");
//		out.println("<a href=\"logout\">Deconexion</a>");
//		out.println("<h2>" + user.get("login") + "</h2>");
//		out.println("<p>Id : " + user.get("id") + "</br>");
//		if (context.getSessionAttribute("role").equals("admin")) {
//			out.println("Mdp : " + user.get("mdp") + "</br>");
//		}
//		out.println("Role : " + user.get("role") + "</br>");
//
//		if (context.getSessionAttribute("role").equals("admin")) {
//			out.println("<a href='./rename?renameUser=" + user.get("id")
//					+ "'>Update</a>");
//			out.println("<a href='./delete?deleteUser=" + user.get("id")
//					+ "'>Delete</a>");
//		}

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
