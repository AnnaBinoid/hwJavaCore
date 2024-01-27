package hw02javaCore;

public class Main02 {
    public static void main(String[] args) {
        int[] numbers = {0, 8, 0, 5, 0, 9};
        //countEvens(numbers);
        //diffBetweenMinAndMaxEl(numbers);
        System.out.println("There are adjacent zeros in array: " + areAdjacentZeros(numbers));

    }
    public static void countEvens (int[] num){
        int count = 0;
        for (int i: num) {
            if (i % 2 == 0) {
                count += 1;
            }
        }
        System.out.println("Number of even elements in array is: " + count);
    }

    public static void diffBetweenMinAndMaxEl(int[] num){
        int min = num[0];
        int max = num[0];
        for (int i = 1; i < num.length; i++){
            if (num[i] < min) {
                min = num[i];
            }
            if (num[i] > max) {
                max = num[i];
            }
        }
        int dif = max - min;
        System.out.println("The difference between max and min elements is: " + dif);
    }

    public static boolean areAdjacentZeros (int[] num) {
        boolean itIs = false;
        for (int i = 0; i < num.length; i++) {
            if ((num[i] == 0) && (num[i + 1] == 0)) {
                itIs = true;
                break;
            }
        }
        return itIs;
    }

}
