package hw05task2javaCore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Log {
    public static void writer(int[] arr, String name) throws IOException {
        Path path = Paths.get(name);

        String ourText = Arrays.stream(arr).mapToObj(String::valueOf).reduce((x, y) -> x + y).get();

        try {
            Files.write(path,
                    ourText.getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error in writing in file!");
        }

    }
}
