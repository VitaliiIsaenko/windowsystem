package windowsystem;

import windowsystem.coordinates.Point;
import windowsystem.rat.RATButton;
import windowsystem.rat.RATMouseListener;
import windowsystem.rat.RATTextField;

import java.awt.*;

public class Calculator {
    private double result;
    private RATTextField resultField;

    private double chosenNumber;
    private String chosenAction;


    public void calculate() {
        System.out.println("Calculate(): Action(" + getChosenAction() +  ") --- ChosenNumber(" + getChosenNumber() + ")" +
                " --- PriorResult(" + getResult() + ")");
        switch (this.getChosenAction()) {
            case "none":
                result = this.getChosenNumber();
                this.resultField.setText(Double.toString(this.getChosenNumber()));
                break;
            case "=":
                result = this.getChosenNumber();
                this.resultField.setText(Double.toString(result));
                this.setChosenAction("none");
                break;
            case "-":
                this.result -= this.getChosenNumber();
                this.resultField.setText(Double.toString(result));
                this.setChosenAction("none");
                break;
            case "*":
                this.result *= this.chosenNumber;
                this.resultField.setText(Double.toString(result));
                this.setChosenAction("none");
                break;
            case "/":
                this.result /= this.chosenNumber;
                this.resultField.setText(Double.toString(result));
                this.setChosenAction("none");
                break;
            case "+":
                this.result += this.chosenNumber;
                this.resultField.setText(Double.toString(result));
                this.setChosenAction("none");
        }
    }

    public Calculator(SimpleWindow calculatorWindow){
        // Init all integer buttons
        int [] integers = {0,1,2,3,4,5,6,7,8,9};
        for (int integer : integers) {
            // Create button
            RATButton integerButton = new RATButton(new Point((integer % 3) * 50,Math.floorDiv(integer,3) * 30 +50),
                    Integer.toString(integer),Color.LIGHT_GRAY,Color.WHITE,Color.black);
            // Add button to widget
            integerButton.addActionListener((ae) -> {
                if (this.getChosenAction() == "."){
                    this.setChosenNumber(this.getChosenNumber() + ((double) Integer.parseInt(integerButton.getText()) / 10));
                    this.setChosenAction("none");
                } else {
                    this.setChosenNumber(Integer.parseInt(integerButton.getText()));
                }
                this.calculate();
                System.out.println("Integer: " + integerButton.getText() + " pressed -- " + getChosenNumber());
            });
            calculatorWindow.addWidget(integerButton);
        }
        // Init all mathematical actions
        String [] actions = {"*","+","-","/","=","."};
        for(int iteration = 0;iteration < actions.length;iteration++){
            RATButton actionButton;
            if (actions[iteration] == ".") {
                actionButton =  new RATButton(new Point(1 * 50,3 * 30 +50),
                        actions[iteration],Color.LIGHT_GRAY,Color.WHITE,Color.black);
            } else if(actions[iteration] == "=") {
                actionButton =  new RATButton(new Point(2 * 50,3 * 30 + 50),
                        actions[iteration],Color.LIGHT_GRAY,Color.WHITE,Color.black);
            } else {
                actionButton = new RATButton(new Point(3 * 50,iteration * 30 + 50),
                        actions[iteration],Color.LIGHT_GRAY,Color.WHITE,Color.black);
            }
            actionButton.addActionListener((ae) -> {
                this.setChosenAction(actionButton.getText());
                System.out.println("Action: " + actionButton.getText() + " performed.");
            });
            calculatorWindow.addWidget(actionButton);
        }
        // Add field for displaying results
        this.resultField = new RATTextField(new Point(40, 10),"",Color.WHITE, Color.CYAN, Color.BLACK);
        calculatorWindow.addWidget(this.resultField);
        // Set chosen integer to 0
        this.chosenNumber = 0;
        this.chosenAction = "none";
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public RATTextField getResultField() {
        return resultField;
    }

    public void setResultField(RATTextField resultField) {
        this.resultField = resultField;
    }

    public double getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(double chosenNumber) {
        this.chosenNumber = chosenNumber;
    }

    public String getChosenAction() {
        return chosenAction;
    }

    public void setChosenAction(String chosenAction) {
        this.chosenAction = chosenAction;
    }
}
