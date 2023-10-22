import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;

public class SwingUI2 {

    static String[] expressions = new String[9];
    static int numOfExpressions = 0;
    static int currentExpression = 0;

    static String previousAnswer = "";

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(500, 600);


        JTextArea textInstructions = new JTextArea();
        textInstructions.setLineWrap(true);


        JPanel panelGroup = new JPanel();
        panelGroup.setLayout(new BoxLayout(panelGroup, BoxLayout.Y_AXIS));

        JPanel panelGroupHistory = new JPanel();
        panelGroupHistory.setLayout(new BoxLayout(panelGroupHistory, BoxLayout.Y_AXIS));

        JPanel panelGroupExpressions = new JPanel();
        panelGroupExpressions.setLayout(new BoxLayout(panelGroupExpressions, BoxLayout.Y_AXIS));

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(9, 3));

        JLabel textHistoryLabel = new JLabel("HISTORY");
        textHistoryLabel.setFont(new Font("Serif", Font.BOLD, 15));

        JPanel panelEquals = new JPanel();
        panelEquals.setLayout(new GridLayout(1, 1));

        JLabel textExpressionsLabel = new JLabel("STORED EXPRESSIONS");
        textExpressionsLabel.setFont(new Font("Serif", Font.BOLD, 15));

        JPanel panelExpressions = new JPanel();

        JTextArea textHistory = new JTextArea();

        JTextField textType = new JTextField();

        JTextArea textExpressions = new JTextArea();

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(1, 2));

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");

        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonEquals = new JButton("=");
        JButton buttonNeg = new JButton("[-]");
        JButton buttonOpenPar = new JButton("(");
        JButton buttonClosePar = new JButton(")");
        JButton buttonPower = new JButton("^");
        JButton buttonSquareRoot = new JButton("Root");
        JButton buttonSin = new JButton("Sin");
        JButton buttonCos = new JButton("Cos");
        JButton buttonTan = new JButton("Tan");
        JButton buttonLog = new JButton("Log");
        JButton buttonNaturalLog = new JButton("Ln");
        JButton buttonPi = new JButton("PI");

        JButton buttonClear = new JButton("Clear");
        JButton buttonDelete = new JButton("Del");

        JButton buttonStoreExpression = new JButton("Store Expression");
        JButton buttonX = new JButton("x");
        JButton buttonGetExpression = new JButton("Get Expression");

        JButton buttonXVal = new JButton("X Value");

        
        JButton buttonAnswer = new JButton("Ans");

        JButton buttonInstructions = new JButton("Get Instructions");

        button1.setBounds(10, 20, 30, 40);

        button1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "1";
                textType.setText(text);  
            }  
        });

        button2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "2";
                textType.setText(text);  
            }  
        });
       
        button3.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "3";
                textType.setText(text);  
            }  
        });
        button4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "4";
                textType.setText(text);  
            }  
        });
        button5.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "5";
                textType.setText(text);  
            }  
        });
        button6.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "6";
                textType.setText(text);  
            }  
        });
        button7.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "7";
                textType.setText(text);  
            }  
        });
        button8.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "8";
                textType.setText(text);  
            }  
        });
        button9.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "9";
                textType.setText(text);  
            }  
        });
        button0.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "0";
                textType.setText(text);  
            }  
        });

        buttonAnswer.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + previousAnswer;
                textType.setText(text);  
            }  
        });

        buttonX.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "x";
                textType.setText(text);  
            }  
        });
        buttonEquals.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Translator t = new Translator();


                String text = textType.getText();

                // String history_text = textHistory.getText() + "\n" + text;

                textHistory.append("\n" + text);

                

                // if(text.charAt(text.length() - 1) == ' '){
                //     text = text.substring(0, text.length() - 1);
                // }
                // System.out.println(text + ".");
                text = t.parsing(text);

                previousAnswer = text;

                previousAnswer = previousAnswer.replaceAll("\\s", "");

                textHistory.append("\n" + "   = " + text);
                textHistory.append("\n");
                textType.setText(text);  
            }  
        });

        buttonClear.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 

                String text = "";
                textType.setText(text);  
            }  
        });

        buttonDelete.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String curText = textType.getText();

                String text = curText.substring(0, curText.length() - 1);
                textType.setText(text);  
            }  
        });

        buttonPlus.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " + ";
                textType.setText(text);  
            }  
        });

        buttonMinus.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " - ";
                textType.setText(text);  
            }  
        });

        buttonMultiply.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " * ";
                textType.setText(text);  
            }  
        });

        buttonDivide.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " / ";
                textType.setText(text);  
            }  
        });

        buttonNeg.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " -";
                textType.setText(text);  
            }  
        });

        buttonOpenPar.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "( ";
                textType.setText(text);  
            }  
        });

        buttonClosePar.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " )";
                textType.setText(text);  
            }  
        });

        buttonPower.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " ^ ";
                textType.setText(text);  
            }  
        });

        buttonSquareRoot.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "R ";
                textType.setText(text);  
            }  
        });

        buttonSin.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "S ";
                textType.setText(text);  
            }  
        });

        buttonCos.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "C ";
                textType.setText(text);  
            }  
        });

        buttonTan.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "T ";
                textType.setText(text);  
            }  
        });

        buttonLog.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "L ";
                textType.setText(text);  
            }  
        });

        buttonNaturalLog.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "N ";
                textType.setText(text);  
            }  
        });

        buttonPi.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + "PI";
                textType.setText(text);  
            }  
        });

        buttonStoreExpression.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText();
                expressions[numOfExpressions] = text;
                numOfExpressions++;
                textType.setText("");

                textExpressions.append("\n" + String.valueOf(numOfExpressions) + ": y = " + text);

            }  
        });

        buttonGetExpression.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText();
                currentExpression = Integer.valueOf(text) - 1;
                textType.setText("x = ");
            }  
        });

        buttonXVal.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText();
                String expression = expressions[currentExpression];

                text = text.substring(4);

                Translator t = new Translator();
                
                expression = t.replaceVars(expression, text);
                text = t.parsing(expression);


                textType.setText(text);
            }  
        });

        buttonInstructions.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JFrame frameInstructions = new JFrame();
                frameInstructions.setSize(800, 270);

                JTextArea textInstructions = new JTextArea();
                textInstructions.setLineWrap(true);
                textInstructions.append("\nInstructions for how to use the calculator:");
                textInstructions.append("\n          1. After entering the calculation using the buttons, click the '=' button to get the result.");
                textInstructions.append("\n          2. Use the 'Root' button to take the square root of a number.");
                textInstructions.append("\n          3. For root, sin, cos, tan, log, and ln, first click the button then enter the number.");
                textInstructions.append("\n          4. Below are the steps for using stored expressions in the calculator:");
                textInstructions.append("\n                  - To store an expression, first enter it in the calculator (use the 'x' button) and then click the 'Store Expression' button.");
                textInstructions.append("\n                  - To evaluate an expression for a certain value of x, follow the steps below:");
                textInstructions.append("\n                          1. Enter the number of the stored expression (as shown by the panel on the right) and click the 'Get Expression' button.");
                textInstructions.append("\n                          2. Enter the value of x and click the 'X Value' button.");
                textInstructions.append("\n                          3. The result will be displayed in the calculator!");
                textInstructions.append("\n\nWe wish you well on your calculating adventures!!!!!");

                frameInstructions.add(textInstructions);
                frameInstructions.setVisible(true);
            }  
        });





        JButton[] buttonsList = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, 
            buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonNeg, buttonOpenPar, buttonClosePar, buttonPower, 
            buttonSquareRoot, buttonSin, buttonCos, buttonTan, buttonLog, buttonNaturalLog, buttonPi, buttonClear, buttonDelete};

        JButton[] buttonsList2 = new JButton[]{buttonAnswer, buttonX, buttonStoreExpression, buttonGetExpression, buttonXVal, buttonInstructions};

        for(int i = 0; i < buttonsList.length; i++){
            panelButtons.add(buttonsList[i]);
        }
    
        for(int i = 0; i < buttonsList2.length; i++){
            panelExpressions.add(buttonsList2[i]);
        }

        panelEquals.add(buttonEquals);


        panelGroup.add(textType);
        panelGroup.add(panelButtons);
        panelGroup.add(panelEquals);

        panelGroupHistory.add(textHistoryLabel);
        panelGroupHistory.add(textHistory);

        panelGroupExpressions.add(textExpressionsLabel);
        panelGroupExpressions.add(textExpressions);

        panelTop.add(panelGroup);
        panelTop.add(new JScrollPane(panelGroupHistory));

        panelBottom.add(panelExpressions);
        panelBottom.add(panelGroupExpressions);

        JSplitPane sp = new JSplitPane(SwingConstants.HORIZONTAL, panelTop, panelBottom);
        sp.setOrientation(SwingConstants.HORIZONTAL);

        frame.add(sp);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}