package module.user;

import interfaces.IMyAction;

import java.io.IOException;
import java.util.HashMap;
import model.DbUser;
import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Update implements IMyAction {

	private final static String URI = "/JavaWebFramework/user/accueil";

	private Update(){
		
	}
	
	public static Update getInstance(){
		return updateHolder.INSTANCE;
	}
	
	private static class updateHolder{
		private static final Update INSTANCE = new Update();
	}
	
	@Override
	public void proceed(IContext context) {
		// TODO Auto-generated method stub
		HashMap<String, String> user = new HashMap<String, String>();
		user.put("id", ((String[]) context.getParameter("id"))[0]);
		user.put("login", ((String[]) context.getParameter("login"))[0]);
		user.put("mdp", ((String[]) context.getParameter("mdp"))[0]);
		user.put("role", ((String[]) context.getParameter("role"))[0]);
		
		DbUser.updateUser(user);

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
