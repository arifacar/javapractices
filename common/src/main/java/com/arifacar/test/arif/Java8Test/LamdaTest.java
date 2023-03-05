package com.arifacar.test.arif.Java8Test;

import com.arifacar.test.arif.Common.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arifacar on 1/4/16.
 */

public class LamdaTest {

    public static void main(String[] args) {
        System.out.println(checkUser());
    }

    public static boolean checkUser(){
        List<Person> personList = new ArrayList<>();

        personList.add(0,new Person("Arif","Acar",29));
        personList.add(1,new Person("Mert","Nuhoglu",34));

        personList.stream().map(v->v.getName() + " " +v.getSurname()).forEach(System.out::println);


        for (Person p:personList){
            if (p.getName()=="Arif"){
                return true;
            }
        }

        //personList.stream()



        // return this.stepType.getInputs().stream().map(u -> variableTitle).collect();

        //if (!title.getUsers().isEmpty()) return CommonController.toStatusJson(CommonController.JSON_STATUS_FAIL, i
        // CommonController.JSON_MESSAGE_REMOVE_TITLE_REFERENCED,
        // title.getUsers().stream().limit(10).map(u -> u.getFirstName() + " " + u.getLastName()).collect(Collectors.toList()));

        //The lambda above is equivalent to this;
        /*
        int i = 0;
        List result = new LinkedList();
        for (LerisUser usre : title.getUsers()){
            if (i > 10) break;
            result.add(usre.getFirstName() + " " + usre.getLastName());
        }*/



        return false;
    }

}
