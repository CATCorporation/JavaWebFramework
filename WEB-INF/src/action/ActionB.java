package action;

import java.io.IOException;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class ActionB implements IAction {

	
	public void proceed(IContext context) {
		try {
			context._getResponse().getWriter().println("Page B");
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
	
}