import javax.swing.*;
import java.awt.event.*;

public class BMICalculatorV1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");

        // Height Label & Field
        JLabel heightLabel = new JLabel("Height (cm):");
        heightLabel.setBounds(30, 30, 100, 20);
        frame.add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(130, 30, 100, 20);
        frame.add(heightField);

        // Weight Label & Field
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(30, 60, 100, 20);
        frame.add(weightLabel);

        JTextField weightField = new JTextField();
        weightField.setBounds(130, 60, 100, 20);
        frame.add(weightField);

        // Calculate Button
        JButton calcButton = new JButton("Calculate BMI");
        calcButton.setBounds(80, 100, 130, 30);
        frame.add(calcButton);

        // Result Label
        JLabel resultLabel = new JLabel("Your BMI will appear here.");
        resultLabel.setBounds(30, 140, 250, 20);
        frame.add(resultLabel);

        // Button Action (no error handling here)
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double height = Double.parseDouble(heightField.getText()) / 100;
                double weight = Double.parseDouble(weightField.getText());
                double bmi = weight / (height * height);
                resultLabel.setText("Your BMI is: " + String.format("%.2f", bmi));
            }
        });

        // Frame setup
        frame.setSize(320, 230);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
