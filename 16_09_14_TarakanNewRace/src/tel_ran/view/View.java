package tel_ran.view;

public  interface View {
 String getStringValue(String message);
 int getIntValue(String message,int min,int max) throws Exception;
 void display(String message);
}
