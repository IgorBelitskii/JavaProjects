package tel_ran.aop.benchmarking;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerfomanceTest {
	
public Object watchPerfomance(ProceedingJoinPoint joinPoint) throws Throwable {

		Signature signature = joinPoint.getSignature();
		String name=signature.getName();
		System.out.println("method invoked is "+name);
		long time1=System.currentTimeMillis();
		Object res = joinPoint.proceed();
		long time2=System.currentTimeMillis();
		System.out.println("time of running method "+name+" is "+(time2-
		time1));
		
		
	return res;
	
}

}
