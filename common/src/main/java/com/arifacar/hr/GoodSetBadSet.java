package com.arifacar.hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * No Prefix Set
 */

class Result {
    public static void noPrefix(List<String> words) {

        boolean isBadSet = false;
        List<String> badStrList = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            if (badStrList.size() > 1) { // For performance
                break;
            }

            for (int j = 0; j < i; j++) {
                if (words.get(i).startsWith(words.get(j)) || words.get(j).startsWith(words.get(i))) {
                    isBadSet = true;
                    badStrList.add(words.get(i));
                    break;
                }
            }
        }

        if (isBadSet) {
            System.out.println("BAD SET");
            System.out.println(badStrList.get(0));
        } else {
            System.out.println("GOOD SET");
        }

    }


}

public class GoodSetBadSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
