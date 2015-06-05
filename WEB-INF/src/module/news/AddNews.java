package module.news;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;

import model.User;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import dao.DbNews;

public class AddNews implements IMyAction{

	private AddNews(){
		System.err.println("AddNews singleton");
	}
	
	public static AddNews getInstance(){
		return addNewsHolder.INSTANCE;
	}
	
	private static class addNewsHolder{
		private static final AddNews INSTANCE = new AddNews();
	}
	
	private final static String URI = "/JavaWebFramework/";

	@Override
	public void proceed(IContext context) {PrintWriter out = null;

	String title = new String();
	String text = new String();
	
	for(String s : (String[]) context.getParameter("title")){
		title = s;
	}
	
	for (String s : (String[]) context.getParameter("text")) {
		text = s;
	}
	
	
	
    User user = new User((String) context.getSessionAttribute("user"));
    
    DbNews.addNews(title, text, user);

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
