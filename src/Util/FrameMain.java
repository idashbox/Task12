package Util;

import Classes.ClassesForInAndOut;
import Classes.InputArgs;
import Classes.MainLogicTask;
import Classes.Test;

import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
    private JTextField textField2;
    private JTable table2;
    private JTextField textField1;


    static InputArgs inputArgs = new InputArgs();
    private static Color getColor(int n, int N) {
        if (n == N) {
            return Color.GREEN;
        }
            else{
                return Color.WHITE;
        }

    }


    public FrameMain() throws IOException {


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
                        table2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                            @Override
                            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                                TableModel tableModel = table2.getModel();
                                for (int r = 0; r < row; r++) {
                                    for (int s = 0; s < column; s++) {
                                        Object obj = tableModel.getValueAt(r, s);
                                        if (Integer.parseInt(obj.toString()) == N) {
                                            c.setBackground(getColor(Integer.parseInt(value.toString()), N));
                                        }
                                    }
                                }
                                return c;
                            }
                        });
                        JTableUtils.writeArrayToJTable(table2, result);
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
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}