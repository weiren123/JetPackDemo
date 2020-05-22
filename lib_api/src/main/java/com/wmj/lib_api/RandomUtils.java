package com.wmj.lib_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RandomUtils {
    private RandomUtils() {

    }
    public static void inject(Object object){
        try {
            Class bindingClass = Class.forName(object.getClass().getCanonicalName() + "_Random");
            Constructor constructor = bindingClass.getConstructor(object.getClass());
            constructor.newInstance(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
