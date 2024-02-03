package hw05task2javaCore;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main052 {
    /**
     * Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
     * и представляют собой, например, состояния ячеек поля для игры в крестикинолики,
     * где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом,
     * 3 – резервное значение. Такое предположение позволит хранить в одном числе
     * типа int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.
     */

    public static void main(String[] args) {
        int[] ticTacToe = new int[]{1, 2, 1, 2, 1, 2, 2, 1, 1};
        String file = "C:\\Users\\User\\IdeaProjects\\java-project-13042023\\src\\hw05task2javaCore\\TTT.txt";
        try {
            Log.writer(ticTacToe, file);
            gameField(fileToArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] fileToArray(String file) throws IOException {
        try (BufferedInputStream inStream = new BufferedInputStream(Files.newInputStream(Path.of(file)))) {
            String text = new String(inStream.readAllBytes());
            int[] arr = new int[9];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = text.charAt(i) - '0';
            }
            return arr;
        }
    }


    public static void gameField(int[] field) {
        char[] symbols = {' ', 'x', 'o', '_'};
        for (int i = 0; i < field.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(symbols[field[i]]);
            System.out.print(' ');
        }
    }

}
