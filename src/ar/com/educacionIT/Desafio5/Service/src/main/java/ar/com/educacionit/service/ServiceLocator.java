package ar.com.educacionit.service;

public class ServiceLocator {

	public static EntidadBaseService getService(Class clazz) {
		
		String name = clazz.getCanonicalName() + "Impl";
		
		try {						
			//API Reflection
			/*También podemos obtener una clase desde un nombre completamente cualificado (fully-quailified name); 
			esto es, el nombre del paquete donde está nuestra clase, seguido del nombre de la clase
			Class c = Class.forName("com.paquete.MiClase");*/
			return (EntidadBaseService)Class.forName(name).getConstructors()[0].newInstance();			
		} catch (Exception e) {			
			System.out.println(e.getLocalizedMessage().toUpperCase());
			throw new IllegalArgumentException(name);
		}
	}
}
