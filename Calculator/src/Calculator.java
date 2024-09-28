
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButttons = new JButton[10];
    JButton[] functionsButtons = new JButton[10];
    JPanel panel;
    JButton addButton, mulButton, divButton, subButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        subButton = new JButton("-");
        delButton = new JButton("Delete");
        equButton = new JButton("=");
        decButton = new JButton(".");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionsButtons[0] = addButton;
        functionsButtons[1] = mulButton;
        functionsButtons[2] = divButton;
        functionsButtons[3] = subButton;
        functionsButtons[4] = clrButton;
        functionsButtons[5] = delButton;
        functionsButtons[6] = equButton;
        functionsButtons[7] = decButton;
        functionsButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionsButtons[i].addActionListener(this);
            functionsButtons[i].setFont(myFont);
            functionsButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButttons[i] = new JButton(String.valueOf(i));
            numberButttons[i].addActionListener(this);
            numberButttons[i].setFont(myFont);
            numberButttons[i].setFocusable(false);
        }
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        // panel.setBackground(Color.GRAY);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.add(negButton);

        panel.add(numberButttons[1]);
        panel.add(numberButttons[2]);
        panel.add(numberButttons[3]);
        panel.add(numberButttons[4]);
        panel.add(numberButttons[5]);
        panel.add(numberButttons[6]);
        panel.add(numberButttons[7]);
        panel.add(numberButttons[8]);
        panel.add(numberButttons[9]);
        panel.add(numberButttons[0]);

        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(addButton);
        panel.add(divButton);
        panel.add(equButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButttons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            if (operator == '+')
                result = num1 + num2;
            else if (operator == '-')
                result = num1 - num2;
            else if (operator == '*')
                result = num1 * num2;
            else if (operator == '/')
                result = num1 / num2;

            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String str = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
