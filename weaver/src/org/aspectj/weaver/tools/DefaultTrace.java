/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Matthew Webster - initial implementation
 *******************************************************************************/
package org.aspectj.weaver.tools;

public class DefaultTrace extends AbstractTrace {
	
	private boolean traceEnabled = false; 
	
	public DefaultTrace (Class clazz) {
		super(clazz);
	}
	
	public boolean isTraceEnabled () {
		return traceEnabled;
	}
	
	public void setTraceEnabled (boolean b) {
		traceEnabled = b;
	}
	
	public void enter (String methodName, Object thiz, Object[] args) {
		if (traceEnabled) {
			println(formatMessage(">",tracedClass.getName(),methodName,thiz, args));
		}
	}
	
	public void enter (String methodName, Object thiz) {
		if (traceEnabled) {
			println(formatMessage(">",tracedClass.getName(),methodName,thiz, null));
		}
	}

	public void exit (String methodName, Object ret) {
		if (traceEnabled) {
			println(formatMessage("<",tracedClass.getName(),methodName,ret, null));
		}
	}

	public void exit (String methodName) {
		if (traceEnabled) {
			println(formatMessage("<",tracedClass.getName(),methodName,null, null));
		}
	}

	public void exit(String methodName, Throwable th) {
		if (traceEnabled) {
			println(formatMessage("<",tracedClass.getName(),methodName,th, null));
		}
	}

	/**
	 * Template method that allows choice of destination for output
	 * 
	 * @param s message to be traced
	 */
	protected void println (String s) {
		System.err.println(s);
	}

//	private static boolean isTracingEnabled = getBoolean("org.aspectj.weaver.tools.tracing",false);
//
//	private static boolean getBoolean (String name, boolean def) {
//		String defaultValue = String.valueOf(def);
//		String value = System.getProperty(name,defaultValue);
//		return Boolean.valueOf(value).booleanValue();
//	}

}