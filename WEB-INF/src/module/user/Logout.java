package module.user;

import interfaces.IMyAction;
import java.io.IOException;
import java.io.PrintWriter;
import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Logout implements IMyAction{

	private final static String URI = "/JavaWebFramework/user/accueil";

	private Logout(){
		
	}
	
	public static Logout getInstance(){
		return logoutHolder.INSTANCE;
	}
	
	private static class logoutHolder{
		private static final Logout INSTANCE = new Logout();
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
		context.resetSession();
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
