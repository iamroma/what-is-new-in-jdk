package com.roma.jdk8.language;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by roma on 12/04/2017.
 */
public class LambdaExample {

    private static Person admin;
    private static List<Integer> integers;
    private static List<Person> personList;

    static {
        admin = new Person("Admin", Person.Sex.BOY, 24);
        integers = new ArrayList<>(5);
        integers.add(15);
        integers.add(12);
        integers.add(24);
        integers.add(13);
        integers.add(16);
        personList = new ArrayList<>();
        personList.add(new Person("cc", Person.Sex.GIRL, 12));
        personList.add(new Person("jj", Person.Sex.BOY, 15));
        personList.add(new Person("qq", Person.Sex.GIRL, 13));
        personList.add(new Person("yy", Person.Sex.BOY, 16));
    }

    private LambdaExample() {}

    /**
     * Test java.util.function.Consumer
     *
     * @param consumer
     */
    public static void testConsumer(Consumer<Person> consumer) {
        personList.forEach(p -> consumer.accept(p));
    }

    /**
     * Test java.util.function.Function
     *
     * @param function
     */
    public static String testFunction(Function<Person, String> function) {
        return function.apply(admin);
    }

    /**
     * Test java.util.function.Predicate
     *
     * @param predicate
     */
    public static boolean testPredicate(Predicate<Person> predicate) {
        return predicate.test(admin);
    }

    /**
     * Test java.util.function.Predicate
     *
     * @param supplier
     */
    public static Person testSupplier(Supplier<Person> supplier) {
        return supplier.get();
    }

    private static String getIntroduction(Person person) {
        return String.format("My name is " + person.getName() + ". I'm a " + person.getGender() + " and " + person.getAge() + " years old!");
    }

    public static void beforeJava8() {

        System.out.println("=========================Before Java8=========================");

        // 多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8 ");
            }
        }).start();

        // GUI
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("without lambda expression is boring");
            }
        });

        // 数组遍历
        List<String> features = Arrays.asList("Lambdas", "Default Method",
                "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // 集合排序
        System.out.println("排序前：" + integers);
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        System.out.println("排序后：" + integers);

        // ...
    }

    public static void afterJava8() {

        System.out.println("=========================After Java8=========================");

        // 多线程
        new Thread(() -> System.out.println("In Java8!"));

        // GUI
        JButton show = new JButton("Show");
        show.addActionListener((e) -> {
            System.out.println("Action !! Lambda expressions Rocks");
        });

        // 数组遍历
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(n -> System.out.println(n));

        // 集合排序
        System.out.println("排序前：" + integers);
        Collections.sort(integers, (a, b) -> Integer.compare(b, a));
        System.out.println("排序后：" + integers);

        // ...
    }

    public static void main(String[] args) throws Exception {

        // Consumer test
        LambdaExample.testConsumer(person -> System.out.println(getIntroduction(person)));

        // Function test
        String introduction = LambdaExample.testFunction(person -> getIntroduction(person));
        System.out.println(introduction);

        // Predicate test
        boolean predicate = LambdaExample.testPredicate(person -> person.getAge() > 22);
        System.out.println(predicate);

        // Supplier test
        Person uu = LambdaExample.testSupplier(() -> new Person("uu", Person.Sex.GIRL, 22));
        System.out.println(getIntroduction(uu));

        beforeJava8();
        afterJava8();
    }

}
