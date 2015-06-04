package module;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import model.User;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import interfaces.IMyAction;

public class Accueil implements IMyAction {

	private Accueil(){
		System.err.println("Singleton Accueil Velocity");
	}
	
	public static Accueil getInstance(){
		return accueilHolder.INSTANCE;
	}
	
	private static class accueilHolder{
		private static final Accueil INSTANCE = new Accueil();
	}
	
	@Override
	public void proceed(IContext context) {

		
		VelocityEngine ve = new VelocityEngine();
	    ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, context._getRequest().getRealPath("/").replace("\\", "/")+"WEB-INF/template");
	    
	    ve.init();
		
		VelocityContext vcontext = new VelocityContext();
		vcontext.put("idUser", User.getInstance().getId());
		vcontext.put("idUserTest", User.getInstance().getId());

		Template t = null;

		try {
			StringWriter sw = new StringWriter();
			
			t = ve.getTemplate("actualites.vm");			
			t.merge(vcontext, sw);
			
			context._getResponse().getWriter().write(sw.toString());
		} catch(Exception e) {
			try {
				context._getResponse().getWriter().print( "error while writting response : " + e.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public IAction getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
