import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
public class SwingUI {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(300, 500);

        //JPanel panel1 = new JPanel();

        JPanel panelButtons = new JPanel();

        JTextField textField =new JTextField();  

        textField.setBounds(10, 10, 50, 50);

        panelButtons.setLayout(new GridLayout(5, 3));
        

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

        

        button1.setBounds(10, 20, 30, 40);

        button1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "1";
                textField.setText(text);  
            }  
        });

        button2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "2";
                textField.setText(text);  
            }  
        });
       
        button3.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "3";
                textField.setText(text);  
            }  
        });
        button4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "4";
                textField.setText(text);  
            }  
        });
        button5.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "5";
                textField.setText(text);  
            }  
        });
        button6.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "6";
                textField.setText(text);  
            }  
        });
        button7.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "7";
                textField.setText(text);  
            }  
        });
        button8.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "8";
                textField.setText(text);  
            }  
        });
        button9.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "9";
                textField.setText(text);  
            }  
        });
        button0.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + "0";
                textField.setText(text);  
            }  
        });
        buttonEquals.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Translator t = new Translator();


                String text = textField.getText();

                text = t.parsing(text);
                textField.setText(text);  
            }  
        });

        buttonClear.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 

                String text = "";
                textField.setText(text);  
            }  
        });

        buttonDelete.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String curText = textField.getText();

                String text = curText.substring(0, curText.length() - 1);
                textField.setText(text);  
            }  
        });

        buttonPlus.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " + ";
                textField.setText(text);  
            }  
        });

        buttonMinus.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " - ";
                textField.setText(text);  
            }  
        });

        buttonMultiply.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " * ";
                textField.setText(text);  
            }  
        });

        buttonDivide.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " / ";
                textField.setText(text);  
            }  
        });

        buttonNeg.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " -";
                textField.setText(text);  
            }  
        });

        buttonOpenPar.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " ( ";
                textField.setText(text);  
            }  
        });

        buttonClosePar.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " ) ";
                textField.setText(text);  
            }  
        });

        buttonPower.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " ^ ";
                textField.setText(text);  
            }  
        });

        buttonSquareRoot.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " R ";
                textField.setText(text);  
            }  
        });

        buttonSin.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " S ";
                textField.setText(text);  
            }  
        });

        buttonCos.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " C ";
                textField.setText(text);  
            }  
        });

        buttonTan.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " T ";
                textField.setText(text);  
            }  
        });

        buttonLog.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " L ";
                textField.setText(text);  
            }  
        });

        buttonNaturalLog.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " N ";
                textField.setText(text);  
            }  
        });

        buttonPi.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String text = textField.getText() + " PI ";
                textField.setText(text);  
            }  
        });






        JButton[] buttonsList = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, 
            buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEquals, buttonNeg, buttonOpenPar, buttonClosePar, buttonPower, 
            buttonSquareRoot, buttonSin, buttonCos, buttonTan, buttonLog, buttonNaturalLog, buttonPi, buttonClear, buttonDelete};

        for(int i = 0; i < buttonsList.length; i++){
            panelButtons.add(buttonsList[i]);
        }
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

        frame.add(textField);
        frame.add(panelButtons);
        frame.setLayout(null);  
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}