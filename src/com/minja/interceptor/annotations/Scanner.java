package com.minja.interceptor.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Place this annotation above any class that will be instantiated 
 * at the beginning of your web application execution.
 * Usually it is the class in which you start the Spark.
 * You need to instatiate that class.
 * The <code>value</code> attribute is mandatory and must contain 
 * package name that is at the root of the package hierarchy that 
 * will be scanned for other annotations.
 * 
 * @author minja
 *
 * @see com.minja.interceptor.annotations.JwtSecurity
 * @see com.minja.interceptor.annotations.JwtKey
 * @see com.minja.interceptor.annotations.UserProvider
 * @see com.minja.interceptor.annotations.UserGetter
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scanner {
	public String value(); 
}
