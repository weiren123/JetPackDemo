package com.wmj.lib_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface RandomInt {
    int minValue() default 0;

    int maxValue() default 65535;
}
