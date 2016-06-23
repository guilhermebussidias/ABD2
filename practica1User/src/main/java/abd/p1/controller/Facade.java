package abd.p1.controller;

import org.hibernate.SessionFactory;

public class Facade {
	
	private static Facade instance = null;
	private static SessionFactory sessionFactory = null;
	
	private UsuarioController usuarioController;

	private Facade() {
		usuarioController = new UsuarioController(sessionFactory);
	}
	
	public static Facade getInstance() {
		if (instance == null)
			instance = new Facade();
		return instance;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		Facade.sessionFactory = sessionFactory;
	}

	public UsuarioController getUsuarioController() {
		return usuarioController;
	}
	
}
