package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String next = cryptogram;
        String prev;

        do {
            prev = next;
            next = prev.replaceAll(getPattern(prev), "");
        } while(!prev.equals(next));

        return next;
    }

    static String getPattern(String cryptogram){
        if (cryptogram.length() == 0) {
            return "";
        }
        List<String> tokenList = List.of(cryptogram.split(""));
        Set<String> tokenSet = new HashSet<>(tokenList);
        Stream<String> patternStream = tokenSet.stream().map(token -> token + "{2,}");

        List<String> patternList = patternStream.collect(Collectors.toList());
        String pattern = String.join("|", patternList);

        return pattern;
    }
}
