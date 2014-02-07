package util;

import java.io.PrintWriter;
import java.lang.reflect.*;

/**
 * a dynamic proxy that acts as a logger
 * @author Gil Mizrahi
 *
 */
public class LoggerDynamicProxy implements InvocationHandler {

    private Object obj;
    private static PrintWriter writer;
    private static Boolean isLogFileOpen = false;

    /**
     * returns a new instance of a dynamic proxy with the Object's interface
     * @param obj to reference
     * @return a new instance of a dynamic proxy with the Object's interface
     */
    public static Object newInstance(Object obj) {
    	synchronized (isLogFileOpen)
    	{
	    	if (!isLogFileOpen)
	    	{
	    		try { writer  = new PrintWriter("log.txt", "UTF-8"); isLogFileOpen = true; }
	    		catch (Exception e) 
	    			{ System.err.println("couldn't open log file: " + e.getMessage()); }
	    	}
    	}
    	
        return java.lang.reflect.Proxy.newProxyInstance(
            obj.getClass().getClassLoader(),
            obj.getClass().getInterfaces(),
            new LoggerDynamicProxy(obj));
    }

    /**
     * Constructor
     * @param obj to reference
     */
    private LoggerDynamicProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * called when a method is called. logs the method and invokes it
     */
    public Object invoke(Object proxy, Method m, Object[] args)
        throws Throwable
    {
        Object result;
        try {
        	log(m, args);
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
        writer.println("result: " + result);
        writer.flush();
        return result;
    }
    /**
     * logs the method 
     * @param m called method
     * @param args it's arguments
     */
    public void log(Method m, Object[] args)
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
