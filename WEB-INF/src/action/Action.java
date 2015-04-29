package action;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class Action implements IAction {

	@Override
	public void proceed(IContext context) {
		// TODO Auto-generated method stub

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
