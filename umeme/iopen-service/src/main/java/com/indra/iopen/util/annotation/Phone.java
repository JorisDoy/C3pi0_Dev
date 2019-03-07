package com.indra.iopen.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.indra.iopen.util.PhoneConstraintValidator;

@Documented
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

	Class<?>[]groups() default {};

	String message() default "{phone.valid}";

	Class<? extends Payload>[]payload() default {};

}
