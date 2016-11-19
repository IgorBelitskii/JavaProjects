import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationsTestAppl {

	public static void main(String[] args) {
		X x;
		Class clazz  = X.class;
	/*	Annotation ann = clazz.getAnnotation(Id.class);
		System.out.println(ann);*/
		Field[] fields=clazz.getDeclaredFields();//getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class)){
					System.out.print(field.getName());
				String path = field.getAnnotation(Id.class).value();
					System.out.println(", ID - " +path);
			} 
			if (field.isAnnotationPresent(Index.class)) {
					System.out.print(field.getName());
					String pp = field.getAnnotation(Index.class).unique();
					String p2 = field.getAnnotation(Index.class).value();
				System.out.println(", INDEX unique - " +pp+ ", value - "+p2);
				}
		}

	}

}
