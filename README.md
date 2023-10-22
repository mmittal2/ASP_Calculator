# ASP_Calculator
Second project for Advanced Software Projects


DESIGN DOC:
Authors: 
Aarna Chowdhary and Medha Mittal

Project Overview:
Create a user-friendly calculator that can perform basic math functions (such as PEMDAS) correctly!
  
  As time permits:
  - The user will have the ability to save customized mathematical functions and call them.
  - The user will have the ability to specify the number of times they wish to repeat a specific function/calculation rather than having to type it out multiple times.
  - Add a graphical UI to increase user convenience when using the calculator.


Architecture Description:
1. UI File:
      Purpose: Prompt user for input, sends input to Translation file, and displays calculation results. 
      Made using text input and output in the terminal. If time permits, change to graphical UI using Swing.
   
2. Translator File:
      Purpose: Understand intended calculation from user input, call approriate functions in the Engine file.      
   
3. Engine File:
      Purpose: Performs intended calculations and passes result to UI file.
   
     Methods:
     - Add
     - Subtract
     - Multiply
     - Divide
     - Exponent
       
   Methods (as time permits):
     - Root
     - Parentheses - Multistep Calculations
     - Trig - Sin, Cos, Tan
     - Log
     - History


Instructions to Run Code:
Run the SwingUI2.java file and press the 'Get Instructions' button to view the instructions.


Citations:
None! :)

