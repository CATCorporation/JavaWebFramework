package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Accueil implements IMyAction {

	private Accueil(){
		System.out.println("Singleton");
	}
	
	public static Accueil getInstance(){
		return accueilHolder.INSTANCE;
	}
	
	private static class accueilHolder{
		private static final Accueil INSTANCE = new Accueil();
	}
	
	
	public void proceed(IContext context) {
		
		PrintWriter out = null;
		try {
			out = context._getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("<h2>Connexion</h2>");
		out.println("<form action=\"./loginUser\" method=\"post\">"
				+ "<div>" + "<label for=\"login\">Login :</label>"
				+ "<input type=\"text\" name=\"login\" />" + "</div>" + "<div>"
				+ "<label for=\"mdp\">Mot de passe :</label>"
				+ "<input type=\"text\" name=\"mdp\" />" + "</div>"
				+ "<div class=\"button\">"
				+ "<input type=\"submit\" value=\"Envoyer\"></button>"
				+ "</div></form></br></br>");		
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
