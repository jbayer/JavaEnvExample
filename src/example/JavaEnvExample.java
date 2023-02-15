package example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaEnvExample {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Gracefully shutting down JavaEnvExample");
            }
        });

        Map<String, String> env = System.getenv();

        LinkedHashMap<String, String> collect = env.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new));

        collect.forEach((k, v) -> System.out.println(k + "=" + v));

        Scanner s = new Scanner(System.in);
        System.out.println("Press enter to exit");
        s.nextLine();
        s.close();

    }
}