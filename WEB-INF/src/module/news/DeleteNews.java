package module.news;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

public class DeleteNews implements IMyAction{

	private DeleteNews(){
		System.err.println("DeleteNews singleton");
	}
	
	public static DeleteNews getInstance(){
		return deleteNewsHolder.INSTANCE;
	}
	
	private static class deleteNewsHolder{
		private static final DeleteNews INSTANCE = new DeleteNews();
	}
	
	private final static String URI = "/JavaWebFramework/";

	@Override
	public void proceed(IContext context) {PrintWriter out = null;
	try {
		out = context._getResponse().getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	for (String s : (String[]) context.getParameter("idNews")) {
		System.err.println(s);
	}

	System.err.println("panda");
	try {
		context._getResponse().sendRedirect(URI);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public IAction getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
