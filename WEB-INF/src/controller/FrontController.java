package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.core.interfaces.IFrontController;
import org.esgi.web.framework.router.interfaces.IDispatcher;
import org.esgi.web.framework.router.interfaces.IRewriter;

import router.Dispatcher;
import router.RewriteRule;
import router.Rewriter;
import context.Context;

public class FrontController extends HttpServlet implements IFrontController {

	private static final long serialVersionUID = 1L;

	public static String URIRoot = "/JavaWebFramework/";
	public static String URIFile = "/JavaWebFramework/explorer";
	public static String URIUser = "/JavaWebFramework/user";

	private IRewriter rewriter;
	private IDispatcher dispatcher;
	private Context c;

	public void init() {
		//DbUser.initUser();
		rewriter = new Rewriter();
		dispatcher = new Dispatcher();

		rewriter.addRule(new RewriteRule(URIFile + "(.*)",
				"action.ActionUploadFile", new String[] { "path" }) {

			@Override
			protected boolean checkContext(IContext context) {
				if (context.getUploadedFiles().length > 0) {
					String[] param = (String[]) context.getParameter("path");

					if (param != null && param.length > 0) {
						File f = new File(Context.root.getPath() + param[0]);

						return f.exists() && f.isDirectory();
					}
				}

				return false;
			}

		});

		rewriter.addRule(new RewriteRule(URIFile + "(.*)",
				"action.ActionDisplayFolder", new String[] { "path" }) {

			@Override
			protected boolean checkContext(IContext context) {
				String[] param = (String[]) context.getParameter("path");

				if (param != null && param.length > 0) {
					File f = new File(Context.root.getPath() + param[0]);

					return f.exists() && f.isDirectory();
				}

				return false;
			}

		});

		rewriter.addRule(new RewriteRule(URIFile + "(.*)",
				"action.ActionDownloadFile", new String[] { "path" }) {

			@Override
			protected boolean checkContext(IContext context) {
				String[] param = (String[]) context.getParameter("path");

				if (param != null && param.length > 0) {
					System.out.println(param[0]);

					File f = new File(Context.root.getPath() + param[0]);
					System.out.println(f.getAbsolutePath());

					return f.exists() && f.isFile();
				}

				return false;
			}

		});
			
		// renderer velocity

		rewriter.addRule(new RewriteRule(URIRoot + "$",
				"module.Accueil", new String[] { "path" }) {

			@Override
			protected boolean checkContext(IContext context) {
				String[] param = (String[]) context.getParameter("path");

				return true;			}

		});
			
		rewriter.addRule(new RewriteRule(URIUser + "/velocity",
						"render.VelocityRenderer", new String[] { "path" }){
					@Override
					protected boolean checkContext(IContext context) {
						if (context.getSessionAttribute("login") == null) {

							return true;
						}
						return true;
					}
				});

		// Affiche un utilisateur s�lectionn�
		rewriter.addRule(new RewriteRule(URIUser + "/display?(.+)",
				"module.user.Display", new String[] { "path" }) {
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {
					System.out.println("test");
					return false;
				}
				return true;
			}
		});

		// Permet d'accueil quand nous ne somme pas connect�
		rewriter.addRule(new RewriteRule(URIUser + "/accueil",
				"module.user.Accueil", new String[] { "path" }) {
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {
					return true;
				}
				return false;
			}
		});
		
		// Page d'accueil une fois connect�
		rewriter.addRule(new RewriteRule(URIUser + "/accueil",
				"module.user.Menu", new String[] { "path" }) {
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {

					return false;
				}
				return true;
			}
		});

		// list des utilisateur
		rewriter.addRule(new RewriteRule(URIUser + "/userList",
				"module.user.UserList", new String[] { "path" }) {
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {

					return false;
				}
				return true;
			}
		});

		// list des utilisateur
		rewriter.addRule(new RewriteRule(URIUser + "/searchUser",
				"module.user.Search", new String[] { "path" }) {
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {

					return false;
				}
				return true;
			}
		});
		
		// Permet de cr�er un utilisateur
		rewriter.addRule(new RewriteRule(URIUser + "/createUser",
				"module.user.Create", new String[] { "path" }) {
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {

					return false;
				}
				return true;
			}
		});

		// Permet � un utilisateur de se connecter
		rewriter.addRule(new RewriteRule(URIRoot + "loginUser",
				"module.user.Login", new String[] { "path" }));

		// Permet � un utilisateur de se d�connecter
		rewriter.addRule(new RewriteRule(URIRoot + "logout",
				"module.user.Logout", new String[] { "path" }));

		// Permet � l'administrateur de modifier les informations d'un
		// utilisateur
		rewriter.addRule(new RewriteRule(URIUser + "/rename?(.+)",
				"module.user.Rename", new String[] { "path" }){
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {

					return false;
				}
				return true;
			}
		});

		// Modifier les informations d'un utilisateur
		rewriter.addRule(new RewriteRule(URIUser + "/updateUser",
				"module.user.Update", new String[] { "path" }){
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {

					return false;
				}
				return true;
			}
		});
		
		
		// Permet � l'administrateur de supprimer un utilisateur
		rewriter.addRule(new RewriteRule(URIUser + "/delete?(.+)",
				"module.user.Delete", new String[] { "path" }){
			@Override
			protected boolean checkContext(IContext context) {
				if (context.getSessionAttribute("login") == null) {
					try {
						context._getResponse().sendRedirect(URIUser+"/accueil");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
				return true;
			}
		});

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {
		handle(request, response);
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		try {
			c = new Context(request, response);
			// Do operations
			rewriter.rewrite(c);
			dispatcher.dispatch(c);

			// c.printDebugInfos();

			c.removeUploadedFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
