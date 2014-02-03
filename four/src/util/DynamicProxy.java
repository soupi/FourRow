package util;

import java.io.PrintWriter;
import java.lang.reflect.*;

public class DynamicProxy implements InvocationHandler {

    private Object obj;
    private static PrintWriter writer;
    private static boolean isLogFileOpen = false;

    public static Object newInstance(Object obj) {
    	if (!isLogFileOpen)
    	{
    		try { writer  = new PrintWriter("log.txt", "UTF-8"); isLogFileOpen = true; }
    		catch (Exception e) 
    			{ System.err.println("couldn't open log file: " + e.getMessage()); }
    	}
    	
        return java.lang.reflect.Proxy.newProxyInstance(
            obj.getClass().getClassLoader(),
            obj.getClass().getInterfaces(),
            new DynamicProxy(obj));
    }

    private DynamicProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
        throws Throwable
    {
        Object result;
        try {
        	log(proxy, m, args);
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                                       e.getMessage());
        }
        writer.println("result: " + result);
        writer.flush();
        return result;
    }
    public void log(Object proxy, Method m, Object[] args)
    {
    	if (!isLogFileOpen)
    		return;
    	synchronized (writer)
    	{
	    	writer.println("==================================");
	    	writer.println("Object: " + obj.getClass().getName());
	        writer.println("method " + m.getName());
	        if (args != null)
	        {
	        	writer.println("with args: ");
		        for (Object obj : args)
		        {
		        	writer.println("+ " + obj.getClass().getName() + " : " + obj.toString() );
		        }
	        }
	        writer.flush();
	    }
    }
}
