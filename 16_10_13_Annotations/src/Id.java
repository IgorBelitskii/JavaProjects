import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //На каком этапе аппликации будут использоваться аннотации . В данном случае в RunTime
// По у молчанию source
@Target(value=ElementType.FIELD)
public @interface Id {

	String value();

}
