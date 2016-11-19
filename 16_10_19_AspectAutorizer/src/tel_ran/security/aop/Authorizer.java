package tel_ran.security.aop;

import java.util.Map;
import java.util.Set;
import org.aspectj.lang.ProceedingJoinPoint;

import tel_ran.security.Accounter;
import tel_ran.security.Authenticater;

public class Authorizer {
	Map <String, Set<String>> rulesMethods; //key - role name, value - array of the permitted method names 
	Authenticater authenticater;
	Accounter accounter;
	

	public Map<String, Set<String>> getRulesMethods() {
		return rulesMethods;
	}

	public void setRulesMethods(Map<String, Set<String>> rulesMethods) {
		this.rulesMethods = rulesMethods;
	}

	public Authorizer(Map<String, Set<String>> rulesMethods, Authenticater authenticater, Accounter accounter) {
		this.rulesMethods = rulesMethods;
		this.authenticater=authenticater;
		this.accounter=accounter;
	}

	public Authenticater getAuthenticater() {
		return authenticater;
	}

	public void setAuthenticater(Authenticater authenticater) {
		this.authenticater = authenticater;
	}

	Object authorize(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	//	System.out.println("Authorize started");
		Object object = proceedingJoinPoint.getTarget();
		String role=authenticater.getRole(object);
		if (role==null) {
			accounter.methodCallReject(proceedingJoinPoint.getSignature().getName(), true);
			throw new SecurityException("401 error");
		}
		Set<String> set= rulesMethods.get(role);
		String name = proceedingJoinPoint.getSignature().getName();
	//	System.out.println("name "+name);
		boolean accepted=false;
		for (String str: set) {
			if (name.equals(str)) accepted=true;
		}
		if (!accepted){
			accounter.methodCallReject(proceedingJoinPoint.getSignature().getName(), true);
			throw new SecurityException("403 Error Method "+name+" is not accepted to run");	
		}
		accounter.methodCallReject(proceedingJoinPoint.getSignature().getName(), false);
		return proceedingJoinPoint.proceed();
	}
/**
 * rulesMethods: Map<String, String[]> //key - role name, value - array of the permitted method names 
вместо массива лучше сделать Set
 */
	
/*** 
//joinPoint.getTarget() - reference to invocation object
//check what's role for the invocation object
//check if the invokated method is permitted
//if yes to proceed if no to throw SecurityException
//accounting call or reject
+authorize(joinPoint:ProceedingJoinPoint):Object 
	 */
}
