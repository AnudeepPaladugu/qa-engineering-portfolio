package com.anudeep.qa.support;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CaseId { String value(); String priority() default "High"; }
