package com.minja.interceptor.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Place this annotation above a method that is actually used to obtain a User.
 * That method should receive a single argument: string used to look for the user. 
 * That method should return the User object.
 * @author minja
 *
 * @see com.minja.interceptor.annotations.UserProvider
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UserProvider {

}
