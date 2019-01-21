package com.example.effectivejava.common.reflect;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class ReflectionTest {
    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        String package1 = "com.example.effectivejava.common.reflect";
        ConfigurationBuilder configuration = new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(package1))
                .setScanners(new SubTypesScanner(), new MethodParameterScanner(), new MethodAnnotationsScanner(), new TypeAnnotationsScanner());
        Reflections reflections = new Reflections(configuration);

        Set<Class<? extends Parent>> set = reflections.getSubTypesOf(Parent.class);
        System.out.println(set);
        for (Class<? extends Parent> aClass : set) {
            Parent parent = aClass.newInstance();
            System.out.println(parent.name());
            Set<Method> methodsReturn = reflections.getMethodsAnnotatedWith(Override.class);
            System.out.println(methodsReturn);
        }

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(AnnotationCommon.class);
        System.out.println(annotated);
    }

    @Test
    public void test1() {
        String[] arrHash = new String[]{"java.util.HashSet", "b", "c", "a", "e", "d", "ook", "abc"};
        String[] arrTree = new String[]{"java.util.TreeSet", "b", "c", "a", "e", "d", "ook", "abc"};
        reflect(arrHash);
        reflect(arrTree);
    }

    private static void reflect(String[] args) {
        Class<?> cl = null;
        try {
            cl = Class.forName(args[0]);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Class not found.");
            System.exit(1);
        }

        Set<String> s = null;

        try {
            @SuppressWarnings("unchecked") Set<String> s1 = (Set<String>) cl.newInstance();
            s = s1;
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.err.println("Class not accessible.");
            System.exit(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.err.println("Class not instantiable.");
            System.exit(1);
        }

        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }
}
