package router;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import error.JwfErrorHandler;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.router.interfaces.IDispatcher;

public class Dispatcher implements IDispatcher {
	
	/**
	 * Constructor.
	 */
	public Dispatcher() {
		System.out.println("new Dispatcher");
	}
	
	@Override
	public void dispatch(IContext context) {
		String className = context.getActionClass();
		Method m = null;
		System.out.println(className);
		if(className != null) {
			try {
				
				Class<?> c = Class.forName(className);
				m = c.getMethod("getInstance", null);
				IAction action = (IAction) m.invoke(null, null);
				action.proceed(context);
			} catch (IllegalAccessException e) {
				JwfErrorHandler.displayError(context, 500, "Could not access the class : " + className);
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				JwfErrorHandler.displayError(context, 500, "Could not find the class : " + className);
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				JwfErrorHandler.displayError(context, 500, "Could not invoke argument the method : " + m);
			} catch (InvocationTargetException e) {
				JwfErrorHandler.displayError(context, 500, "Could not invoke target the method : " + m);
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				JwfErrorHandler.displayError(context, 500, "Could not find the method : " + m);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				JwfErrorHandler.displayError(context, 500, "Could not invoke the method : " + m);
			}
		} else{ // Error 404
		
			JwfErrorHandler.displayError(context, 404, "Could not locate the page to load");
		}
	}

}
