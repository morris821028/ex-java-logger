package cp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CpExecLogger {
	protected static int mStackIndex = 0;

	@Before("execution(* *.*(..)) && @annotation(cp.Loggable)")
	public void enter(JoinPoint pjp) throws Throwable {
		mStackIndex++;
		if (mStackIndex != 1)
			return;
		StringBuilder cmd = new StringBuilder();
		cmd.append(String.format("%s.%s(", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName()));
		Object[] objs = pjp.getArgs();
		for (int i = 0; i < objs.length; i++) {
			if (i > 0)
				cmd.append(", ");
			if (objs[i] instanceof String)
				cmd.append(String.format("\"%s\"", objs[i]));
			else
				cmd.append(objs[i]);
		}
		cmd.append(String.format(");"));
		System.err.printf("[Log] %s\n", cmd);
	}

	@After("execution(* *.*(..)) && @annotation(cp.Loggable)")
	public void exit(JoinPoint pjp) throws Throwable {
		mStackIndex--;
	}
}
