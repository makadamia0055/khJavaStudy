package weekend_homework4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args){

//	    TestClass testClass = new TestClass();
//
//	    System.out.println("getName()      : " + testClass.getClass().getName());
//	    System.out.println("getSimpleName()  : " + testClass.getClass().getSimpleName());
//	    System.out.println("===========getMethods()===========");
//	    for(Method method : testClass.getClass().getMethods()){
//	        System.out.println("method          : " + method.getName());
//	    }
//	    System.out.println("===========getFields()===========");
//	    for(Field field : testClass.getClass().getFields()){
//	        System.out.println("field           : " + field.getName());
//	    }
//	    
	    
	    String str = makeInsertStr(new Student(), "insert into ?(");
	    System.out.println(str);
	    
	    
	    }
	
	public static <T> String makeInsertStr(T t, String str) {
		int count = t.getClass().getDeclaredFields().length;
		for(int i = 0; i<count-1; i++) {
			str = str.concat("?,");
		}
		str = str.concat("?) value(");
		for(int i = 0; i<count-1; i++) {
			str = str.concat("?,");
		}
		str = str.concat("?)");
		
		return str;
	}

}
