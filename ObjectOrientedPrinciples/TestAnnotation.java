package com.ObjectOrientedPrinciples;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface TestAnnotation {
	public boolean enabled() default true;
	public enum Priority {
		   LOW, MEDIUM, HIGH
		}

	Priority priority() default Priority.MEDIUM;
		
	String[] tags() default "";
		
	String createdBy() default "Mkyong";

}
