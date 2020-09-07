package com.minja.interceptor.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Place this annotation above a class that is used to obtain the User.
 * That class must have one method annotated with the <code>@UserGetter</code> annotation
 * that will be used to actually obtain the user.
 * @author minja
 *
 * @see com.minja.interceptor.annotations.UserGetter
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserGetter {

}
