package tel_ran.application;

import tel_ran.security.Authenticater;

public class AplicationClass {
	private Authenticater authenticater;
	
	public Authenticater getAuthenticater() {
		return authenticater;
	}

	public void setAuthenticater(Authenticater authenticater) {
		this.authenticater = authenticater;
	}

	public boolean login(String role, String password) {

		return authenticater.authenticate(role, password, this);
	}
	
	@Authorized(roles={"Admin","User"})
	public void set1() {
		System.out.println("set1");
	}
	@Authorized(roles={"Admin"})
	public void set2() {
		System.out.println("set2");
	}

	public void get1() {
		System.out.println("get1");
	}

	/**
	 * +login(role:String,password:String):boolean //calls authenticate method
	 * of the authenticater +set1():void //syso("set1") +set2():void
	 * //syso("set2") +get1():void //syso("get1") //calls authenticate method of
	 * the authenticater +set1():void //syso("set1") +set2():void //syso("set2")
	 * +get1():void //syso("get1")
	 * 
	 */
}
