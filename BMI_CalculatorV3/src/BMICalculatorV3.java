import javax.swing.*;
import java.awt.event.*;

public class BMICalculatorV3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator - Version 3");

        // Height
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setBounds(30, 30, 100, 20);
        frame.add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(130, 30, 100, 20);
        frame.add(heightField);

        // Weight
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setBounds(30, 60, 100, 20);
        frame.add(weightLabel);

        JTextField weightField = new JTextField();
        weightField.setBounds(130, 60, 100, 20);
        frame.add(weightField);

        // Unit Selection
        JRadioButton metricBtn = new JRadioButton("Metric (cm/kg)", true);
        metricBtn.setBounds(30, 90, 120, 20);
        JRadioButton imperialBtn = new JRadioButton("Imperial (in/lb)");
        imperialBtn.setBounds(160, 90, 130, 20);

        ButtonGroup unitGroup = new ButtonGroup();
        unitGroup.add(metricBtn);
        unitGroup.add(imperialBtn);

        frame.add(metricBtn);
        frame.add(imperialBtn);

        // Calculate Button
        JButton calcButton = new JButton("Calculate BMI");
        calcButton.setBounds(80, 120, 130, 30);
        frame.add(calcButton);

        // Result Label
        JLabel resultLabel = new JLabel("Your BMI will appear here.");
        resultLabel.setBounds(30, 160, 280, 20);
        frame.add(resultLabel);

        // Category Label
        JLabel categoryLabel = new JLabel(""); // empty initially
        categoryLabel.setBounds(30, 185, 280, 20);
        frame.add(categoryLabel);

        // Button Action (unit logic + category)
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());
                double bmi;

                if (metricBtn.isSelected()) {
                    double heightM = height / 100;
                    bmi = weight / (heightM * heightM);
                } else {
                    bmi = (weight / (height * height)) * 703;
                }

                resultLabel.setText("Your BMI is: " + String.format("%.2f", bmi));
                
                // Determine category
                String category;
                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi < 25) {
                    category = "Normal";
                } else if (bmi < 30) {
                    category = "Overweight";
                } else {
                    category = "Obese";
                }

                categoryLabel.setText("Category: " + category);
            }
        });

        // Frame setup
        frame.setSize(340, 270);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
