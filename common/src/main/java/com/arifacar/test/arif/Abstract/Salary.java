package com.arifacar.test.arif.Abstract;

import com.arifacar.test.arif.Common.Employee;

/**
 * Created by arifacar on 1/12/16.
 */
public class Salary extends Employee {
    private double salary;

    public Salary(String name, String address, Integer number, double salary) {
        super(name, address, number);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary=" + salary +
                '}';
    }
}
