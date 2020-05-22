package com.wmj.lib_compiler;

import com.wmj.lib_annotations.RandomInt;

import java.util.Random;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeKind;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class AnnotateRandomInt extends AnnotatedRandomElement{
    private int minValue;
    private int maxValue;

    AnnotateRandomInt(Element element) {
        super(element);
        minValue = element.getAnnotation(RandomInt.class).minValue();
        maxValue = element.getAnnotation(RandomInt.class).maxValue();
    }

    @Override
    boolean isTypeValid(Elements elements, Types types) {
        return element.asType().getKind().equals(TypeKind.INT);
    }

    @Override
    String getRandomValue() {
        Random random = new Random();
        return ""+(minValue + random.nextInt(maxValue-minValue+1));
    }
}
