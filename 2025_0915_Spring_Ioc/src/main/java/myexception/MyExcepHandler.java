package myexception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class MyExcepHandler extends Exception {

	public void process(JoinPoint thisJoinPoint, Exception exception) throws Exception {
		//System.out.println("---MyException process()--- : " + exception.getMessage());
		Signature sign = thisJoinPoint.getSignature();
		String message = exception.getMessage();
		System.out.printf("---[Exception:%s] %s:%s\n", 
				                      message,
				                      sign.getDeclaringTypeName() ,
				                      sign.getName() 
				                      );
		//System.out.println("          --[내용]:" + exception.getMessage());
		
		
	}
}
