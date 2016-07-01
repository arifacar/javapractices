package com.test.arif.Dozer;

import com.sun.tools.internal.ws.resources.ModelerMessages;
import com.test.arif.Common.Employee;
import com.test.arif.Common.Person;
import com.test.arif.Common.Student;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by arifacar on 1/14/16.
 */
public class DozerMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dozerMapping.xml");

        Mapper mapper = new DozerBeanMapper(list);

        Student student = new Student("Ariff","Acar","1A","Middle");

        Person person = new Person("Arif","Tarif",28);


        Student destObject = mapper.map(student,Student.class,"a");

        System.out.println(destObject);

        System.out.println(person);

        System.out.println(student);

        Properties p = new Properties();
        p.put("a","b");
        p.put("b","c");


        System.out.println(p);


    }
}
