package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Hugo", 23, 10000));
        students.add(new Student("Lia", 43, 50000));
        students.add(new Student("Anna", 26, 9000));
        students.add(new Student("Salim", 27, 31000));

        students.stream().forEach(x -> {
            if (x.getMoney() > 20000) {
                x.setMoney(x.getMoney() + 10000);
            } else {
                x.setMoney(x.getMoney() + 20000);
            }
        });

        students.stream().forEach(x -> System.out.println(x.getName() + " - " + x.getMoney()));
        List<Student> listOfStudents = students.stream().sorted(Comparator.reverseOrder()).sorted().collect(Collectors.toList());
        List<Student> listOfStudents = students.stream().sorted(Comparator.reverseOrder()).sorted().collect(Collectors.toList());


//        List<String> names = new ArrayList<>();

//        names.add("sdgadg");
//        names.add("sdd");
//        names.add("sdddfgdfgeyeedgadg");
//        for (String name:names) {
//            System.out.println(name);
//        }

//        names.stream().forEach(x-> System.out.println(x));
//        names.stream().filter(x->x.length()>7).forEach(x-> System.out.println(x));
//        names.stream().map(x->)

    }
}
