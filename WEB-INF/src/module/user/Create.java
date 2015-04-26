package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import model.DbUser;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Create implements IMyAction {

	private final static String URI = "/JavaWebFramework/user/accueil";

	private Create(){
		
	}
	
	public static Create getInstance(){
		return createHolder.INSTANCE;
	}
	
	private static class createHolder{
		private static final Create INSTANCE = new Create();
	}
		
	@Override
	public void proceed(IContext context) {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		try {
			out = context._getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, String> user = new HashMap<String, String>();
		user.put("login", ((String[]) context.getParameter("login"))[0]);
		user.put("mdp", ((String[]) context.getParameter("mdp"))[0]);
		user.put("role", ((String[]) context.getParameter("role"))[0]);

		DbUser.addUser(user);
		
		try {
			context._getResponse().sendRedirect(URI);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int setPriority(int priority) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCredential(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean needsCredentials() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCredential(String[] roles) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IAction getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
