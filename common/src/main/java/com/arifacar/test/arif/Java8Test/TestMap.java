package com.arifacar.test.arif.Java8Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arifacar on 1/20/16.
 */
public class TestMap {
    public static void main(String[] args) {

        List<Sample> samples = new ArrayList<>();

        Sample sample = new Sample();


        /*
        List<String> resultTypes = sample.sampleTypes.stream()
                .map(sampleType -> sampleType.resultTypes.stream()
                        .map(resultType -> resultType.name)).collect(Collectors.toList());
                        */

        /*
        List<ResultType> resultTypes = new ArrayList<>();
        sample.sampleTypes.stream()
                .map(a -> a.resultTypes)
                .flatMap(x -> x.stream()).collect(Collectors.toList()):
         */

        List<ResultType> resultTypes = new ArrayList<>();


        sample.sampleTypes.stream()
                .forEach(sampleType -> sampleType.resultTypes.stream()
                        .forEach(resultType -> resultTypes.add(resultType)));

    }


    public static class Sample {
        List<SampleType> sampleTypes = new ArrayList<>();
    }

    public class SampleType {
        List<ResultType> resultTypes = new ArrayList<>();
    }

    public class ResultType {
        String name;
    }


}


