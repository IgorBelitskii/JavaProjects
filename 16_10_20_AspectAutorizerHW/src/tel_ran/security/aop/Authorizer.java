package tel_ran.security.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.aspectj.lang.ProceedingJoinPoint;

import tel_ran.application.Authorized;
import tel_ran.security.Accounter;
import tel_ran.security.Authenticater;

public class Authorizer {
	Map<String, Set<String>> rulesMethods = new HashMap<>(); // afuh key - method,.value - set of
											// role names;
	HashSet<String> freeMethods = new HashSet<>();
	
	Authenticater authenticater;
	Accounter accounter;

	public Map<String, Set<String>> getRulesMethods() {
		return rulesMethods;
	}

	public void setRulesMethods(Map<String, Set<String>> rulesMethods) {
		this.rulesMethods = rulesMethods;
	}

	public Authorizer(Authenticater authenticater, Accounter accounter) {
		this.authenticater = authenticater;
		this.accounter = accounter;
	}

	public Authenticater getAuthenticater() {
		return authenticater;
	}

	public void setAuthenticater(Authenticater authenticater) {
		this.authenticater = authenticater;
	}

	Object authorize(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// System.out.println("Authorize started");

		CreateMapRulesMethods(proceedingJoinPoint);

		Object object = proceedingJoinPoint.getTarget();
		String role = authenticater.getRole(object);
		String name = proceedingJoinPoint.getSignature().getName(); // метод

		if (role == null) {
			accounter.methodCallReject(proceedingJoinPoint.getSignature().getName(), true);
			throw new SecurityException("401 error");
		} else if (freeMethods.contains(name)) {
			accounter.methodCallReject(proceedingJoinPoint.getSignature().getName(), false);
			return proceedingJoinPoint.proceed();
		} else {
			Set<String> setRoles = rulesMethods.get(name);
		//	System.out.println("name " + name + "set" + setRoles);
			// System.out.println("name "+name);
			if (!setRoles.contains(role)) {
				accounter.methodCallReject(proceedingJoinPoint.getSignature().getName(), true);
				throw new SecurityException("403 Error Method " + name + " is not accepted to run");
			}
		}
		accounter.methodCallReject(proceedingJoinPoint.getSignature().getName(), false);
		return proceedingJoinPoint.proceed();

	}

	private void CreateMapRulesMethods(ProceedingJoinPoint proceedingJoinPoint) {
		rulesMethods = new HashMap<String, Set<String>>();
		Method[] methods = proceedingJoinPoint.getTarget().getClass().getDeclaredMethods();
		for (Method method : methods) {
			HashSet<String> set = new HashSet<>();
			if (method.isAnnotationPresent(Authorized.class)) {
				String roles[] = method.getAnnotation(Authorized.class).roles();
				for (String string : roles) {			
					set.add(string);
				}
				rulesMethods.put(method.getName(), set);
			} else {
				freeMethods.add(method.getName());
		//		System.out.println("Method added to free:" + method.getName());
			}
		}
	}

	/***
	 * //joinPoint.getTarget() - reference to invocation object //check what's
	 * role for the invocation object //check if the invokated method is
	 * permitted //if yes to proceed if no to throw SecurityException
	 * //accounting call or reject
	 * +authorize(joinPoint:ProceedingJoinPoint):Object
	 */
}
