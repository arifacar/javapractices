package com.arifacar.test.arif.Abstract;

import com.arifacar.test.arif.Common.Employee;

/**
 * Created by arifacar on 1/12/16.
 */
public class AbstractDemo{

    public static void main(String[] args) {
        Employee salary = new Salary("Arif","Baku",123,123);
        System.out.println(salary.toString());

    }


}
