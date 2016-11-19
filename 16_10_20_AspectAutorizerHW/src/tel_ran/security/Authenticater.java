package tel_ran.security;

import java.util.HashMap;
import java.util.Map;

import tel_ran.account.dao.AccountMongoDB;

public class Authenticater {
	//private Map<String, String> rulesPasswords; //key - role, value-password
	private Map<Object, String> authObject; 
	AccountMongoDB accountMongoDB;//returns role for a given object or null
	/** Now it takes from Mongo DB configurations
	 * <constructor-arg type="java.util.Map" name="rulesPasswords">
			<map key-type="java.lang.String" value-type="java.lang.String">
				<entry key="Admin" value="admin5777" />
				<entry key="User" value="user5777" />
				<entry key="UserNew" value="user5777" />
			</map>
		</constructor-arg> */
	public Authenticater() {
		
		this.authObject = new HashMap<Object,String>();
	}
	

	public Authenticater(AccountMongoDB accountMongoDB) {
		super();
		this.accountMongoDB = accountMongoDB;
		this.authObject = new HashMap<Object,String>();
	}


	public boolean authenticate(String username, String password , Object object) {
		String role=accountMongoDB.getRole(username, password);
		if (role==null) return false; 
		System.out.println("Authentification accepted");
		authObject.put(object, role);
		return true;
		
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
