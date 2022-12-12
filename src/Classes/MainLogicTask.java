package Classes;
//6. Дано двумерное поле из клеток, некоторые клетки пустые, некоторые - стена (на данные
//        клетки нельзя поставить фигуру). В какой-то пустой клетке находится шахматная фигура
//        конь. Найти все клетки, до которых можно добраться этой фигурой за N (или менее)
//        ходов.


import java.io.IOException;

public class MainLogicTask {

    /* -20000 - стена
    -10000 - пустая клетка
    0 - начальное положение коня
    n - его возможные месторасположения
     */
    public static int[][] getAnswer(int[][] array, int N) {
        if (N < 0) {
            return null;
        }
        if (N == 0) {
            return array;
        }
        if (N > 0) {
            for (int n = 1; n <= N; n++){
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        if (array[i][j] == n - 1) {
                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] == -10000 && array[i - 2][j] == -10000 && array[i - 2][j - 1] == -10000) {
                                array[i - 2][j - 1] = n;
                            }
                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] == -10000 && array[i - 2][j] == -10000 && array[i - 2][j + 1] == -10000) {
                                array[i - 2][j + 1] = n;
                            }
                            if (i - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] == -10000 && array[i - 1][j - 1] == -10000 && array[i - 2][j - 1] == -10000) {
                                array[i - 2][j - 1] = n;
                            }
                            if (i - 2 >= 0 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] == -10000 && array[i - 1][j + 1] == -10000 && array[i - 2][j + 1] == -10000) {
                                array[i - 2][j + 1] = n;
                            }
                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i][j - 1] == -10000 && array[i][j - 2] == -10000 && array[i - 1][j - 2] == -10000) {
                                array[i - 1][j - 2] = n;
                            }
                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i][j - 1] == -10000 && array[i][j - 2] == -10000 && array[i + 1][j - 2] == -10000) {
                                array[i + 1][j - 2] = n;
                            }
                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i][j + 1] == -10000 && array[i][j + 2] == -10000 && array[i - 1][j + 2] == -10000) {
                                array[i - 1][j + 2] = n;
                            }
                            if (i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && j + 2 <= array.length - 1 && array[i][j + 1] == -10000 && array[i][j + 2] == -10000 && array[i + 1][j + 2] == -10000) {
                                array[i + 1][j + 2] = n;
                            }
                            if (j - 2 >= 0 && i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j] == -10000 && array[i - 1][j - 1] == -10000 && array[i - 1][j - 2] == -10000) {
                                array[i - 1][j - 2] = n;
                            }
                            if (j + 2 <= array.length - 1 && i - 1 >= 0 && j + 1 <= array.length - 1 && array[i - 1][j] == -10000 && array[i - 1][j + 1] == -10000 && array[i - 1][j + 2] == -10000) {
                                array[i - 1][j + 2] = n;
                            }
                            if (j - 2 >= 0 && i + 1 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] == -10000 && array[i + 1][j - 1] == -10000 && array[i + 1][j - 2] == -10000) {
                                array[i + 1][j - 2] = n;
                            }
                            if (j + 2 <= array.length - 1 && i + 1 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] == -10000 && array[i + 1][j + 1] == -10000 && array[i + 1][j + 2] == -10000) {
                                array[i + 1][j + 2] = n;
                            }
                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j - 1 >= 0 && array[i + 1][j] == -10000 && array[i + 2][j] == -10000 && array[i + 2][j - 1] == -10000) {
                                array[i + 2][j - 1] = n;
                            }
                            if (i + 1 <= array.length - 1 && i + 2 <= array.length - 1 && j + 1 <= array.length - 1 && array[i + 1][j] == -10000 && array[i + 2][j] == -10000 && array[i + 2][j + 1] == -10000) {
                                array[i + 2][j + 1] = n;
                            }
                        }
                    }
                    }
                }
            return array;
        }
//        if (n > 1) {
//            return getAnswer(array, n - 1);
//        }
        return array;
    }

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
