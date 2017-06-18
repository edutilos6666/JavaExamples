package com.edutilos.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by edutilos on 18.06.17.
 */
public class ReflectionExample {
    public static void main(String[] args) {
        Class<?> listClass = List.class;
        test3(listClass);
        System.out.println();
        test3(ArrayList.class);
        test3(Override.class);
        System.out.println();
        test4(listClass);
        test4(ArrayList.class);
        System.out.println();
        test5(listClass);
        System.out.println();
        test5(ArrayList.class);
    }

    private static final String newline = "\r\n";


    private static void test2(Class<?> listClass) {
        //Class<?> listClass = List.class ;
        String canonicalName = listClass.getCanonicalName();
        String name = listClass.getName();
        String simpleName = listClass.getSimpleName();
        String typeName = listClass.getTypeName();
        String packageName = listClass.getPackage().getName();

        StringBuilder sb = new StringBuilder();
        sb.append("canonicalName = ").append(canonicalName).append(newline)
                .append("name = ").append(name).append(newline)
                .append("simpleName = ").append(simpleName).append(newline)
                .append("typeName = ").append(typeName).append(newline)
                .append("packageName = ").append(packageName).append(newline);

        System.out.println(sb.toString());

    }


    private static void test3(Class<?> listClass) {
     //   Class<?> listClass = List.class;
        Method [] methods = listClass.getMethods();
        StringBuilder sb = new StringBuilder();
        sb.append("methods = ");
        for(Method method: methods) {
            sb.append(method.getName()).append(", ");
        }

        sb.append(newline);
        sb.append("Fields: ");
        Field[] fields = listClass.getFields();
        for(Field field: fields) {
            sb.append(field.getName()).append(", ");
        }
        sb.append(newline);
        sb.append("Classes: ");
        Class<?> [] classes = listClass.getClasses();
        for(Class c: classes) {
            sb.append(c.getName()).append(", ");
        }

        sb.append(newline);
        Annotation[] annotations = listClass.getAnnotations();
        sb.append("Annotations: ");
        for(Annotation annotation: annotations) {
            sb.append(annotation.getClass().getName()).append(", ");
        }

        sb.append(newline);
        Constructor<?> [] constructors = listClass.getConstructors();
        sb.append("Constructors: ");
        for(Constructor c: constructors) {
            sb.append(c.getName()).append(", ");
        }
        sb.append(newline);

        System.out.println(sb.toString());
    }



    private static void test4(Class<?> listClass) {
        Class<?> enclosingClass = listClass.getEnclosingClass();
        Field[] declaredFields = listClass.getDeclaredFields();
        Class<?> [] declaredClasses = listClass.getDeclaredClasses();
        Annotation[] declaredAnnotations = listClass.getDeclaredAnnotations();
        Constructor<?> [] declaredConstructors = listClass.getDeclaredConstructors();
        Method[] declaredMethods = listClass.getDeclaredMethods();

        StringBuilder sb = new StringBuilder();
        if(enclosingClass!= null)
        sb.append("enclosingClass = ").append(enclosingClass.getName()).append(newline);
        sb.append("declaredFields: ");
        for(Field field: declaredFields) {
            sb.append(field.getName()).append(", ");
        }

        sb.append(newline);
        sb.append("declaredClasses: ");
        for(Class c: declaredClasses) {
            sb.append(c.getName()).append(", ");
        }
        sb.append(newline);
        sb.append("declaredAnnotations: ");
        for(Annotation annotation: declaredAnnotations) {
            sb.append(annotation.getClass().getName()).append(", ");
        }

        sb.append(newline);
        sb.append("declaredConstructors: ");
        for(Constructor c: declaredConstructors) {
            sb.append(c.getName()).append(", ");
        }
        sb.append(newline);
        sb.append("declaredMethods: ");
        for(Method m: declaredMethods) {
            sb.append(m.getName()).append(", ");
        }
        sb.append(newline);
        System.out.println(sb.toString());

    }


    private static void test5(Class<?> listClass) {
        boolean isAnnotation = listClass.isAnnotation();
        boolean isOverrideAnnotationPresent = listClass.isAnnotationPresent(Override.class);
        boolean isAnonymousClass = listClass.isAnonymousClass();
        boolean isArray = listClass.isArray();
        boolean isEnum = listClass.isEnum();
        boolean isPrimitive = listClass.isPrimitive();
        boolean isLocalClass = listClass.isLocalClass();
        boolean isInterface = listClass.isInterface();
        boolean isMemberClass = listClass.isMemberClass();
        boolean isSynthetic = listClass.isSynthetic();

        Class<?> superClass = listClass.getSuperclass();
        AnnotatedType annotatedSuperclass = listClass.getAnnotatedSuperclass();
        Type genericSuperclass = listClass.getGenericSuperclass();

        Object[] signers = listClass.getSigners();

        StringBuilder sb = new StringBuilder();
        sb.append("isAnnotation? ").append(isAnnotation).append(newline)
                .append("isOverrideAnnotationPresent? ").append(isOverrideAnnotationPresent)
                .append(newline)
                .append("isAnonymousClass? ").append(isAnonymousClass).append(newline)
                .append("isArray? ").append(isArray).append(newline)
                .append("isEnum? ").append(isEnum).append(newline)
                .append("isPrimitive? ").append(isPrimitive).append(newline)
                .append("isLocalClass? ").append(isLocalClass).append(newline)
                .append("isInterface? ").append(isInterface).append(newline)
                .append("isMemberClass? ").append(isMemberClass).append(newline)
                .append("isSynthetic? ").append(isSynthetic).append(newline)
                .append("signers = ").append(join(signers)).append(newline);
               if(superClass!= null)
                  sb.append("superClass = ").append(superClass.getName()).append(newline);
               if(annotatedSuperclass != null)
                  sb.append("annotatedSuperclass = ").append(annotatedSuperclass.getType().getTypeName());
               if(genericSuperclass!= null)
                  sb.append("genericSuperclass = ").append(genericSuperclass.getTypeName()).append(newline);


        System.out.println(sb.toString());
    }


    private static String join(Object[] arr) {
        if(arr == null) return "";
        StringBuilder ret = new StringBuilder();
        for(Object obj: arr) {
            if(obj == null) continue;
            ret.append(obj.toString()).append(", ");
        }
        return ret.toString();
    }


    private static void test1() {
        Class<?> listClass = java.util.List.class;
        String canonicalName = listClass.getCanonicalName();
        listClass.getName();
        listClass.getSimpleName();
        listClass.getTypeName();
        Package pack = listClass.getPackage();

        Method [] methods = listClass.getMethods();
        Field[] fields = listClass.getFields();
        Class<?> [] classes = listClass.getClasses();
        Annotation[] annotations = listClass.getAnnotations();
        Constructor<?> [] constructors =listClass.getConstructors();

        Class<?> enclosingClass = listClass.getEnclosingClass();

        Field[] declaredFields = listClass.getDeclaredFields();
        Class<?> [] declaredClasses = listClass.getDeclaredClasses();
        Annotation[] declaredAnnotations = listClass.getDeclaredAnnotations();
        Constructor<?> [] declaredConstructors = listClass.getDeclaredConstructors();
        Method[] declaredMethods = listClass.getDeclaredMethods();


        listClass.isAnnotation();
        listClass.isAnnotationPresent(Override.class);
        listClass.isAnonymousClass();
        listClass.isArray();
        listClass.isEnum();
        listClass.isPrimitive();
        listClass.isLocalClass();
        listClass.isInterface();
        listClass.isMemberClass();
        listClass.isSynthetic();

        Class<?> superClass = listClass.getSuperclass();
        AnnotatedType annotatedSuperclass = listClass.getAnnotatedSuperclass();
        Type genericSuperclass = listClass.getGenericSuperclass();

        Object[] signers = listClass.getSigners();
    }





}
