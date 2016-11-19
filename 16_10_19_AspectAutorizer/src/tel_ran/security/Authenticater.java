package tel_ran.security;

import java.util.HashMap;
import java.util.Map;

public class Authenticater {
	private Map<String, String> rulesPasswords; //key - role, value-password
	private Map<Object, String> authObject; //returns role for a given object or null
	
	public Authenticater(Map<String, String> rulesPasswords) {
		this.rulesPasswords = rulesPasswords;
		this.authObject = new HashMap<Object,String>();
	}

	public boolean authenticate(String role, String password , Object object) {
		
		String pass = rulesPasswords.get(role);
		if (password.equals(pass)) {
			authObject.put(object, role);
			System.out.println("Authentification accepted");
			return true;
		} else return false;
	}
		
	public String getRole(Object obj) {
		
	return authObject.get(obj);
		
	}
	
	/**
	 * //method authenticate puts to authObjects entry,containing Object and role for succesful authentication
+authenticate(role: String, password: String, object: Object):boolean //returns true if password matches role
+getRole(obj: Object):String //returns role for a given object or null

	 */
/***
 * rulesPasswords: Map<String, String>  
authObjects: Map<Object, String> //key - reference to object, value - role

 */
}
