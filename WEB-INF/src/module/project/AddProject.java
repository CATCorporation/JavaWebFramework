package module.project;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;

import model.Project;
import model.User;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import dao.DbProject;

public class AddProject implements IMyAction{

	private AddProject(){
		System.err.println("AddProject singleton");
	}
	
	public static AddProject getInstance(){
		return addProjectHolder.INSTANCE;
	}
	
	private static class addProjectHolder{
		private static final AddProject INSTANCE = new AddProject();
	}
	
	private final static String URI = "/JavaWebFramework/";

	@Override
	public void proceed(IContext context) {PrintWriter out = null;

	String title = new String();
	String text = new String();
	String picture = new String();
	Integer userId = new Integer(0);
	User user = new User();
	
	for(String s : (String[]) context.getParameter("title")){
		title = s;
	}
	
	for (String s : (String[]) context.getParameter("text")) {
		text = s;
	}
	
	for(String s : (String[]) context.getParameter("picture")){
		picture = s;
	}
	
	if(context.getSessionAttribute("user") != null){
    	user = new User((String) context.getSessionAttribute("user"));
    }
	
	
    Project project = new Project();
    project.setTitle(title);
    project.setText(text);
    project.setUser(user);
    
    DbProject.addProject(project);

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
