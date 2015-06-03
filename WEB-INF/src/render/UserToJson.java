package render;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.renderer.interfaces.IRenderer;

import dao.DbUser;

public class UserToJson implements IRenderer{

	private final static String URI = ".\\.";
	@Override
	public String render(IContext context) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
//		try {
////			mapper.writeValue(new File(URI), DbUser.listUser);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}

}
