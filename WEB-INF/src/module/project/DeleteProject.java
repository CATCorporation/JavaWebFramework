package module.project;

import interfaces.IMyAction;

import java.io.IOException;
import java.io.PrintWriter;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;

import dao.DbProject;

public class DeleteProject implements IMyAction {

	private DeleteProject() {
		System.err.println("DeleteNews singleton");
	}

	public static DeleteProject getInstance() {
		return deleteProjectHolder.INSTANCE;
	}

	private static class deleteProjectHolder {
		private static final DeleteProject INSTANCE = new DeleteProject();
	}

	private final static String URI = "/JavaWebFramework/projets";

	@Override
	public void proceed(IContext context) {PrintWriter out = null;
	try {
		out = context._getResponse().getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	int id = 0;
	for (String s : (String[]) context.getParameter("idProject")) {
		id = Integer.parseInt(s);
	}
	DbProject.deleteProject(id);
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
