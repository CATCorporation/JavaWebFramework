package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import dao.DbUser;

public class Delete implements IMyAction {

	private final static String URI = "/JavaWebFramework/user/accueil";

	private Delete(){
		
	}
	
	public static Delete getInstance(){
		return deleteHolder.INSTANCE;
	}
	
	private static class deleteHolder{
		private static final Delete INSTANCE = new Delete();
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
		DbUser.deleteUser(DbUser.getUser(((String[]) context
				.getParameter("deleteUser"))[0]));

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
