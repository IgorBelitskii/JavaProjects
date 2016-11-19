import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //�� ����� ����� ���������� ����� �������������� ��������� . � ������ ������ � RunTime
// �� � �������� source
@Target(value=ElementType.FIELD)
public @interface Id {

	String value();

}
