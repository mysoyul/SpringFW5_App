package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메서드의 signature 정보
		String methodName = joinPoint.getSignature().getName();		
		System.out.println(methodName + " 시작");
		//타겟 메서드이 argument 정보
		for(Object arg : joinPoint.getArgs()) {
			System.out.println(methodName + " 아규먼트 = " + arg);
		}
		//타겟 객체의 클래스명
		System.out.println("Target Class Name ="+ joinPoint.getTarget().getClass().getName());
		
		//타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();	
		
		try {
			//new Object[] {new String("dooly")}
			//타겟의 메서드 호출
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			
			System.out.println(methodName + " 종료");
			System.out.println(methodName + " 실행 시간 : " + 
			   (finish - start) + " ms");
		}
	}
}
