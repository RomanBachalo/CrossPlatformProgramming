package com.company;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GausApp {
    private JPanel content;
    private JPanel inputTablePanel;
    private JPanel outputTablePanel;
    private JPanel buttonPanel;
    private JPanel bottomPanel;
    private JButton applyButton;
    private JTable inputTable;
    private JTable outputTable;
    private JSpinner columnSpinner;
    private JButton updateButton;

    private void initComponents()
    {
        int defaultSize = 1;
        DefaultTableModel model1 = new DefaultTableModel(defaultSize,defaultSize + 1);
        DefaultTableModel model2 = new DefaultTableModel(defaultSize,defaultSize + 1);
        inputTable.setModel(model1);
        outputTable.setModel(model2);

        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(5,3,10,1);
        columnSpinner = new JSpinner(spinnerNumberModel);

    }

    public void updateTable(int size)
    {
        DefaultTableModel model = new DefaultTableModel(size,size + 1);
        inputTable.setModel(model);
        outputTable.setModel(model);

        JOptionPane.showMessageDialog(null, "updated with " + size);

    }

    public GausApp()
    {
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(columnSpinner.getValue());

            }
        });
    }


    public static void main(String[] args) {
        GausApp app = new GausApp();
        app.initComponents();

        JFrame frame = new JFrame("GausApp");
        frame.setContentPane(app.content);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        double[][] m = new double[][]{
                { 2, 1,-1, 8},
                {-3,-1, 2,-11},
                {-2, 1, 2,-3}};
        m = GausMethodRunnable.Calculate(m);

        for (int i = 0; i < m.length; ++i)
        {
            for (int j = 0; j < m[i].length; ++j)
                System.out.print(m[i][j] + "  ");
            System.out.println();
        }

    }
}
