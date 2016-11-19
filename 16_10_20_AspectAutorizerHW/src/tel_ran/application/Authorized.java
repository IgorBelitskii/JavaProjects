package tel_ran.application;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Authorized {

	String[] roles() default {"Admin","User","UserNew"};

}
