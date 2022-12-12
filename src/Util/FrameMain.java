package Util;

import Classes.ClassesForInAndOut;
import Classes.InputArgs;
import Classes.MainLogicTask;
import Classes.Test;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Arrays;

import static Classes.MainLogicTask.printSuccessMessage;
import static Classes.MainLogicTask.readAndWriteMethod;


public class FrameMain extends JFrame {
    private JTable table1;
    private JButton readFileBtn;
    private JButton writeFileBtn;


    private JPanel panelMain;
    private JTextArea textArea1;
    private JTextField textField2;
    private JTable table2;
    private JTextField textField1;


    static InputArgs inputArgs = new InputArgs();

//    public static void runTest() throws IOException {
//        Test test = new Test();
//        //первый тест
//        String[] pathsTest1 = {test.testPath1In, test.testPath1Out};
//        runSolutionTest(pathsTest1, 1);
//
//        //второй тест
//        String[] pathsTest2 = {test.testPath2In, test.testPath2Out};
//        runSolutionTest(pathsTest2, 2);
//
//        //третий тест
//        String[] pathsTest3 = {test.testPath3In, test.testPath3Out};
//        runSolutionTest(pathsTest3, 3);
//
//        //четвёртый тест
//        String[] pathsTest4 = {test.testPath4In, test.testPath4Out};
//        runSolutionTest(pathsTest4, 4);
//
//        //пятый тест
//        String[] pathsTest5 = {test.testPath5In, test.testPath5Out};
//        runSolutionTest(pathsTest5, 5);
//    }
//
//    public static void runSolutionTest(String[] pathArgs, int num) throws IOException {
//        inputArgs.setInputFile(pathArgs[0]);
//        inputArgs.setOutputFile(pathArgs[1]);
//        readAndWriteMethod(inputArgs);
//        printSuccessMessage(num);
//    }

    public FrameMain() throws IOException {

//        runTest();

        this.setTitle("Основная программа");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();

        JFileChooser fileChooserOpen;
        JFileChooser fileChooserSave;

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JTableUtils.initJTableForArray(table1, 40, false, false, true, true);
        JTableUtils.initJTableForArray(table2, 40, false, false, true, true);

        JFileChooser finalFileChooserOpen = fileChooserOpen;
        readFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (finalFileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ArrayUtils.readIntArray2FromFile(finalFileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(table1, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        JFileChooser finalFileChooserSave = fileChooserOpen;
        writeFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (finalFileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = JTableUtils.readIntMatrixFromJTable(table1);
                        int N = Integer.parseInt(textField2.getText());
                        int[][] result = MainLogicTask.getAnswer(arr, N);
                        JTableUtils.writeArrayToJTable(table2, result);
//                        String answer = " ";
//                        textField1.setText("Диагональные координаты верного прямоугольника:");
//                        textField2.setText(answer);
                        String path = finalFileChooserSave.getSelectedFile().getPath();
                        File file = new File(path);
                        PrintWriter pw = new PrintWriter(file);
                        pw.println(MainLogicTask.massivVStroki(JTableUtils.readIntMatrixFromJTable(table2)));
                        pw.close();
                    }
                } catch (Exception ex) {
                    SwingUtils.showErrorMessageBox(ex);
                }
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
//        textArea1.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                super.componentResized(e);
//            }
//        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}