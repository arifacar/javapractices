package com.test.arif.Generics;

import com.test.arif.Common.Person;

import java.util.List;

/**
 * Created by arifacar on 1/8/16.
 */
public class GenericClasses<T> {
    private T t;

    public void set(T t){
        this.t=t;
    }

    public T get(){
        return this.t;
    }

    public static void main(String[] args) {

        GenericClasses<Integer> intValue= new GenericClasses<>();
        intValue.set(7);

        GenericClasses<String> stringValue = new GenericClasses<>();
        stringValue.set("Merhaba Generic Class");

        GenericClasses<Float> floatValue = new GenericClasses<>();
        floatValue.set((float) 3.5);

        GenericClasses<Person> listValues = new GenericClasses<>();
        listValues.set(new Person("Arif","Acar",25));

        System.out.println(intValue.get());

        System.out.println(stringValue.get());

        System.out.println(floatValue.get());

        System.out.println(listValues.get().toString());

    }

}
