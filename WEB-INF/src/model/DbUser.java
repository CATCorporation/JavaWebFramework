package model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class DbUser {

	public static ArrayList<HashMap<String, String>> listUser = new ArrayList<HashMap<String, String>>();
	private static int lastId = 1;

	public static void initUser() {
		HashMap<String, String> marie = new HashMap<String, String>();
		marie.put("login", "Marie");
		marie.put("mdp", "marie");
		marie.put("role", "admin");
		HashMap<String, String> spyky = new HashMap<String, String>();
		spyky.put("login", "Spyky");
		spyky.put("mdp", "spyky");
		spyky.put("role", "user");
		HashMap<String, String> panda = new HashMap<String, String>();
		panda.put("login", "Panda");
		panda.put("mdp", "panda");
		panda.put("role", "user");
		DbUser.addUser(marie);
		DbUser.addUser(spyky);
		DbUser.addUser(panda);
	}

	public static void addUser(HashMap<String, String> user) {
		user.put("id", Integer.toString(lastId));
		if (listUser.add(user))
			lastId++;
	}

	public static HashMap<String, String> getUser(String id) {

		for (HashMap<String, String> user : listUser) {
			if (user.get("id").equals(id)) {
				return user;
			}
		}

		return null;
	}

	public static boolean deleteUser(HashMap<String, String> user) {

		for (HashMap<String, String> u : listUser) {
			if (u.get("id").equals(user.get("id")))
				return listUser.remove(user);
		}

		return false;
	}

	public static boolean updateUser(HashMap<String, String> user) {

		for (HashMap<String, String> u : listUser) {
			System.out.println(u.get("id").equals(user.get("id")));
			if (u.get("id").equals(user.get("id"))) {
				u.put("login", user.get("login"));
				u.put("mdp", user.get("mdp"));
				u.put("role", user.get("role"));
				System.out.println(user);
				System.out.println(u);

				return true;
			}
		}

		return false;
	}
}
