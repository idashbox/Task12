package Classes;
//6. Дано двумерное поле из клеток, некоторые клетки пустые, некоторые - стена (на данные
//        клетки нельзя поставить фигуру). В какой-то пустой клетке находится шахматная фигура
//        конь. Найти все клетки, до которых можно добраться этой фигурой за N (или менее)
//        ходов.


import java.io.IOException;
import java.util.ArrayList;
    /* -20000 - стена
    -10000 - пустая клетка
    0 - начальное положение коня
    n - его возможные месторасположения
     */

//public class MainLogicTask {
//    public static int[][] getAnswer(int[][] array, int N) {
//        if (N < 0) {
//            return null;
//        }
//        if (N == 0) {
//            return array;
//        }
//        if (N > 0) {
//            for (int n = 1; n <= N; n++){
//                for (int i = 0; i < recursion(array, N).get(n-1).size(); i += 2) {
//                    if (array[recursion(array, N).get(n-1).get(i)][recursion(array, N).get(n-1).get(i+1)] == n-1) {
//                        for (int j = 0; j < recursion(array, N).get(n).size(); j += 2){
//                            array[recursion(array, N).get(n).get(j)][recursion(array, N).get(n).get(j+1)] = n;
//                        }
//
//                    }
//                }
//            }
//            return array;
//        }
//        return array;
//    }
//    public static ArrayList<ArrayList<Integer>> recursion (int[][] array, int N){
//        ArrayList<ArrayList<Integer>> answer = new ArrayList<>(N);
//        for(int i=0; i <= N; i++) {
//            answer.add(new ArrayList());
//        }
//        if (N < 0) {
//            return null;
//        }
//        if (N == 0) {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    if (array[i][j] == 0) {
//                        answer.get(0).add(i);
//                        answer.get(0).add(j);
//                    }
//                }
//
//            }
//        }
//        if (N > 0) {
//            for (int n = 1; n <= N; n++){
//                for (int i = 0; i < array.length; i++) {
//                    for (int j = 0; j < array.length; j++) {
//                        if (array[i][j] == n - 1) {
//                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] != -20000 && array[i - 2][j] != -20000 && array[i - 2][j - 1] != -20000) {
//                                array[i - 2][j - 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j-1);
//                            }
//                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] != -20000 && array[i - 2][j] != -20000 && array[i - 2][j + 1] != -20000) {
//                                array[i - 2][j + 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j+1);
//                            }
//                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i - 1][j - 1] != -20000 && array[i - 2][j - 1] != -20000) {
//                                array[i - 2][j - 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j-1);
//                            }
//                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] != -20000 && array[i - 1][j + 1] != -20000 && array[i - 2][j + 1] != -20000) {
//                                array[i - 2][j + 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j+1);
//                            }
//                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i][j - 2] != -20000 && array[i - 1][j - 2] != -20000) {
//                                array[i - 1][j - 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i][j - 2] != -20000 && array[i + 1][j - 2] != -20000) {
//                                array[i + 1][j - 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] != -20000 && array[i][j + 2] != -20000 && array[i - 1][j + 2] != -20000) {
//                                array[i - 1][j + 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && j + 2 <= array.length - 1 && array[i][j + 1] != -20000 && array[i][j + 2] != -20000 && array[i + 1][j + 2] != -20000) {
//                                array[i + 1][j + 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] != -20000 && array[i - 1][j - 1] != -20000 && array[i - 1][j - 2] != -20000) {
//                                array[i - 1][j - 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] != -20000 && array[i - 1][j + 1] != -20000 && array[i - 1][j + 2] != -20000) {
//                                array[i - 1][j + 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] != -20000 && array[i + 1][j - 1] != -20000 && array[i + 1][j - 2] != -20000) {
//                                array[i + 1][j - 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j + 2 <= array.length - 1 && i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] != -20000 && array[i + 1][j + 1] != -20000 && array[i + 1][j + 2] != -20000) {
//                                array[i + 1][j + 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] != -20000 && array[i + 2][j] != -20000 && array[i + 2][j - 1] != -20000) {
//                                array[i + 2][j - 1] = n;
//                                answer.get(n).add(i+2);
//                                answer.get(n).add(j-1);
//                            }
//                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] != -20000 && array[i + 2][j] != -20000 && array[i + 2][j + 1] != -20000) {
//                                array[i + 2][j + 1] = n;
//                                answer.get(n).add(i+2);
//                                answer.get(n).add(j+1);
//                            }
//                        }
//                    }
//                }
//            }
//            return answer;
//        }
//        return answer;
//    }
public class MainLogicTask {
    public static int[][] getAnswer(int[][] arr, int n) {
        if (n < 0) {
            return null;
        }
        if (n == 0) {
            return arr;
        }
        if (n > 0) {
            int [][] array = getAnswer(arr, n - 1);
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        if (array[i][j] == n - 1) {
                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] != -20000 && array[i - 2][j] != -20000 && array[i - 2][j - 1] != -20000) {
                                array[i - 2][j - 1] = n;
                            }
                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] != -20000 && array[i - 2][j] != -20000 && array[i - 2][j + 1] != -20000) {
                                array[i - 2][j + 1] = n;
                            }
                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i - 1][j - 1] != -20000 && array[i - 2][j - 1] != -20000) {
                                array[i - 2][j - 1] = n;
                            }
                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] != -20000 && array[i - 1][j + 1] != -20000 && array[i - 2][j + 1] != -20000) {
                                array[i - 2][j + 1] = n;
                            }
                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i][j - 2] != -20000 && array[i - 1][j - 2] != -20000) {
                                array[i - 1][j - 2] = n;
                            }
                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i][j - 2] != -20000 && array[i + 1][j - 2] != -20000) {
                                array[i + 1][j - 2] = n;
                            }
                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] != -20000 && array[i][j + 2] != -20000 && array[i - 1][j + 2] != -20000) {
                                array[i - 1][j + 2] = n;
                            }
                            if (i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && j + 2 <= array.length - 1 && array[i][j + 1] != -20000 && array[i][j + 2] != -20000 && array[i + 1][j + 2] != -20000) {
                                array[i + 1][j + 2] = n;
                            }
                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] != -20000 && array[i - 1][j - 1] != -20000 && array[i - 1][j - 2] != -20000) {
                                array[i - 1][j - 2] = n;
                            }
                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] != -20000 && array[i - 1][j + 1] != -20000 && array[i - 1][j + 2] != -20000) {
                                array[i - 1][j + 2] = n;
                            }
                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] != -20000 && array[i + 1][j - 1] != -20000 && array[i + 1][j - 2] != -20000) {
                                array[i + 1][j - 2] = n;
                            }
                            if (j + 2 <= array.length - 1 && i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] != -20000 && array[i + 1][j + 1] != -20000 && array[i + 1][j + 2] != -20000) {
                                array[i + 1][j + 2] = n;
                            }
                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] != -20000 && array[i + 2][j] != -20000 && array[i + 2][j - 1] != -20000) {
                                array[i + 2][j - 1] = n;
                            }
                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] != -20000 && array[i + 2][j] != -20000 && array[i + 2][j + 1] != -20000) {
                                array[i + 2][j + 1] = n;
                            }
                        }
                    }
                }
            return array;
            }
            return arr;
        }
//    public static ArrayList<ArrayList<Integer>> recursion (int[][] array, int N){
//        ArrayList<ArrayList<Integer>> answer = new ArrayList<>(N);
//        for(int i=0; i <= N; i++) {
//            answer.add(new ArrayList());
//        }
//        if (N < 0) {
//            return null;
//        }
//        if (N == 0) {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    if (array[i][j] == 0) {
//                        answer.get(0).add(i);
//                        answer.get(0).add(j);
//                    }
//                }
//
//            }
//        }
//        if (N > 0) {
//            for (int n = 1; n <= N; n++){
//                for (int i = 0; i < array.length; i++) {
//                    for (int j = 0; j < array.length; j++) {
//                        if (array[i][j] == n - 1) {
//                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] != -20000 && array[i - 2][j] != -20000 && array[i - 2][j - 1] != -20000) {
//                                array[i - 2][j - 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j-1);
//                            }
//                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] != -20000 && array[i - 2][j] != -20000 && array[i - 2][j + 1] != -20000) {
//                                array[i - 2][j + 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j+1);
//                            }
//                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i - 1][j - 1] != -20000 && array[i - 2][j - 1] != -20000) {
//                                array[i - 2][j - 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j-1);
//                            }
//                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] != -20000 && array[i - 1][j + 1] != -20000 && array[i - 2][j + 1] != -20000) {
//                                array[i - 2][j + 1] = n;
//                                answer.get(n).add(i-2);
//                                answer.get(n).add(j+1);
//                            }
//                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i][j - 2] != -20000 && array[i - 1][j - 2] != -20000) {
//                                array[i - 1][j - 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i][j - 1] != -20000 && array[i][j - 2] != -20000 && array[i + 1][j - 2] != -20000) {
//                                array[i + 1][j - 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] != -20000 && array[i][j + 2] != -20000 && array[i - 1][j + 2] != -20000) {
//                                array[i - 1][j + 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && j + 2 <= array.length - 1 && array[i][j + 1] != -20000 && array[i][j + 2] != -20000 && array[i + 1][j + 2] != -20000) {
//                                array[i + 1][j + 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] != -20000 && array[i - 1][j - 1] != -20000 && array[i - 1][j - 2] != -20000) {
//                                array[i - 1][j - 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] != -20000 && array[i - 1][j + 1] != -20000 && array[i - 1][j + 2] != -20000) {
//                                array[i - 1][j + 2] = n;
//                                answer.get(n).add(i-1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] != -20000 && array[i + 1][j - 1] != -20000 && array[i + 1][j - 2] != -20000) {
//                                array[i + 1][j - 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j-2);
//                            }
//                            if (j + 2 <= array.length - 1 && i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] != -20000 && array[i + 1][j + 1] != -20000 && array[i + 1][j + 2] != -20000) {
//                                array[i + 1][j + 2] = n;
//                                answer.get(n).add(i+1);
//                                answer.get(n).add(j+2);
//                            }
//                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] != -20000 && array[i + 2][j] != -20000 && array[i + 2][j - 1] != -20000) {
//                                array[i + 2][j - 1] = n;
//                                answer.get(n).add(i+2);
//                                answer.get(n).add(j-1);
//                            }
//                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] != -20000 && array[i + 2][j] != -20000 && array[i + 2][j + 1] != -20000) {
//                                array[i + 2][j + 1] = n;
//                                answer.get(n).add(i+2);
//                                answer.get(n).add(j+1);
//                            }
//                        }
//                    }
//                }
//            }
//            return answer;
//        }
//        return answer;
//    }
    public static String massivVStroki(int [][] array){
        StringBuilder answer = new StringBuilder();
        for (int [] mas : array){
            for (int znach : mas){
                answer.append(znach);
                answer.append(" ");
            }
            answer.append("\n");

        }
        return answer.toString();
    }
//    .\input.txt .\output.txt
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        int[][] arr = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogicTask.massivVStroki(MainLogicTask.getAnswer(arr, 1));
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
    }
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("Основная программа выполнена.");
        }else{
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}
