package tel_ran.aop.validation;

import java.lang.reflect.Array;

import org.aspectj.lang.ProceedingJoinPoint;

public class VulgarWordsValidation {
	String[] vulgars;
	boolean exception;
	String change;

	public VulgarWordsValidation(String[] vulgars, boolean exception, String change) {
		super();
		this.vulgars = vulgars;
		this.exception = exception;
		this.change = change;
	}

	public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		System.out.println(vulgars.length);
		System.out.println(exception);
		System.out.println(change);
		if (!(exception)) {
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof String) {
					String str = (String) args[i];
					for (int j = 0; j < vulgars.length; j++) {
						if (((String) args[i]).toLowerCase().contains(vulgars[j]))
							args[i] = str.replaceAll("(?i)" + vulgars[j], change);

					}

				}
			}
		} else {
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof String) {
					String str = (String) args[i];
					for (int j = 0; j < vulgars.length; j++) {
						if (((String) args[i]).toLowerCase().contains(vulgars[j]))
							throw new IllegalArgumentException("We are tired from 'vulgaris' "+vulgars[j]+" in "+args[i]);
					}

				}
			}
			
		}
		return joinPoint.proceed(args);
	}

}
