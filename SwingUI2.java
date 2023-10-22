import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;

import javafx.geometry.VerticalDirection;
public class SwingUI2 {

    static String[] expressions = new String[9];
    static int numOfExpressions = 0;
    static int currentExpression = 0;

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(500, 600);

        JFrame frameInstructions = new JFrame();
        frameInstructions.setSize(500, 500);

        JTextArea textInstructions = new JTextArea();
        textInstructions.setLineWrap(true);
        textInstructions.append("Instructions for how to use the calculator:");
        textInstructions.append("\n\t2. The calculator can perform the following functions: subtract, add, multiply, divide, and powers.");
        textInstructions.append("\n\t3. Type a space between all numbers and operators (ex: 23 * 4).");
        textInstructions.append("\n  These are the symbols that represent each calculation:");
        textInstructions.append("\n\t- subtract: -");
        textInstructions.append("\n\t- add: +");
        textInstructions.append("\n\t- multiply: *");
        textInstructions.append("\n\t- divide: /");
        textInstructions.append("\n\t- power: ^");
        textInstructions.append("\n\t- square root: R");
        textInstructions.append("\n\t- sin: S");
        textInstructions.append("\n\t- cos: C");
        textInstructions.append("\n\t- tan: T");
        textInstructions.append("\n\t- log: L");
        textInstructions.append("\n\t- ln: N");
        textInstructions.append("\n\t- pi: PI\n");
        textInstructions.append("\nTo close the calculator, simply hit enter again.\n");

        // JPanel panelUltimate = new JPanel();
        // panelUltimate.setLayout(new GridLayout(2, 2));

        JPanel panelGroup = new JPanel();
        // panelGroup.setLayout(new GridLayout(3, 1));
        panelGroup.setLayout(new BoxLayout(panelGroup, BoxLayout.Y_AXIS));

        //JPanel panel1 = new JPanel();

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(9, 3));

        JPanel panelEquals = new JPanel();
        panelEquals.setLayout(new GridLayout(1, 1));

        JPanel panelExpressions = new JPanel();

        JTextField textHistory = new JTextField();

        JTextField textType = new JTextField();

        JTextField textExpressions = new JTextField();

        // textField.setBounds(10, 10, 50, 50);

        textExpressions.setText("Expressions go here!");
        textHistory.setText("HISTORY");

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
        JButton buttonSquareRoot = new JButton("R");
        JButton buttonSin = new JButton("S");
        JButton buttonCos = new JButton("C");
        JButton buttonTan = new JButton("T");
        JButton buttonLog = new JButton("L");
        JButton buttonNaturalLog = new JButton("N");
        JButton buttonPi = new JButton("PI");

        JButton buttonClear = new JButton("Clear");
        JButton buttonDelete = new JButton("Del");

        JButton buttonStoreExpression = new JButton("Store Expression");
        JButton buttonX = new JButton("x");
        JButton buttonGetExpression = new JButton("Get Expression");

        JButton buttonXVal = new JButton("X Value");

        

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

                // if(text.charAt(text.length() - 1) == ' '){
                //     text = text.substring(0, text.length() - 1);
                // }
                // System.out.println(text + ".");
                text = t.parsing(text);
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
                String text = textType.getText() + " R ";
                textType.setText(text);  
            }  
        });

        buttonSin.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " S ";
                textType.setText(text);  
            }  
        });

        buttonCos.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " C ";
                textType.setText(text);  
            }  
        });

        buttonTan.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " T ";
                textType.setText(text);  
            }  
        });

        buttonLog.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " L ";
                textType.setText(text);  
            }  
        });

        buttonNaturalLog.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " N ";
                textType.setText(text);  
            }  
        });

        buttonPi.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText() + " PI ";
                textType.setText(text);  
            }  
        });

        buttonStoreExpression.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText();
                expressions[numOfExpressions] = text;
                numOfExpressions++;
                textType.setText("");
            }  
        });

        buttonGetExpression.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText();
                currentExpression = Integer.valueOf(text) - 1;
                textType.setText("");
            }  
        });

        buttonXVal.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textType.getText();
                String expression = expressions[currentExpression];

                Translator t = new Translator();
                
                expression = t.replaceVars(expression, text);
                text = t.parsing(expression);


                textType.setText(text);
            }  
        });




        JButton[] buttonsList = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, 
            buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonNeg, buttonOpenPar, buttonClosePar, buttonPower, 
            buttonSquareRoot, buttonSin, buttonCos, buttonTan, buttonLog, buttonNaturalLog, buttonPi, buttonClear, buttonDelete};

        JButton[] buttonsList2 = new JButton[]{buttonX, buttonStoreExpression, buttonGetExpression, buttonXVal};

        for(int i = 0; i < buttonsList.length; i++){
            panelButtons.add(buttonsList[i]);
        }
    
        for(int i = 0; i < buttonsList2.length; i++){
            panelExpressions.add(buttonsList2[i]);
        }

        panelEquals.add(buttonEquals);
        // panel1.add(button1);
        // panel1.add(button2);
        // panel1.add(button3);
        // panel1.add(button4);
        // panel1.add(button5);
        // panel1.add(button6);
        // panel1.add(button7);
        // panel1.add(button8);
        // panel1.add(button9);
        // panel1.add(button0);
        // panel1.add(buttonPlus);

        // frame.add(textHistory);


        panelGroup.add(textType);
        panelGroup.add(panelButtons);
        panelGroup.add(panelEquals);

        panelTop.add(panelGroup);
        panelTop.add(textHistory);

        panelBottom.add(panelExpressions);
        panelBottom.add(textExpressions);

        JSplitPane sp = new JSplitPane(SwingConstants.HORIZONTAL, panelTop, panelBottom);
        sp.setOrientation(SwingConstants.HORIZONTAL);

        frame.add(sp);
        frameInstructions.add(textInstructions);

        //frame.setLayout(new GridLayout(2, 2));
        // frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frameInstructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInstructions.setVisible(true);

    }
}