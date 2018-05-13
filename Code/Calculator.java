import java.awt.*;
/**
 * This class represent a calculator object.
 * Normally to initiate a calculator object a simple window needs to be passed to the contrcutor.
 * The constructor then generates all the neseccary elements for the calculator and attaches it to the given window.
 */

 public class Calculator {
    private double result;
    private String chosenAction;

    private double chosenNumber;
    private boolean enteringNumber;
    private boolean entertingDecimal;
    private boolean neutralElement;
    private boolean actionPerformed;

    private RATTextField resultField;

    /**
     * Contructor responsible for generating a calculator object.
     * @param calculatorWindow
     */
    public Calculator(SimpleWindow calculatorWindow){
        initNumberButtons(calculatorWindow);
        initActionButtons(calculatorWindow);

        addResultField(calculatorWindow);
        addDecimalAction(calculatorWindow);
        addResultAction(calculatorWindow);
        addCancelAction(calculatorWindow);
        addNegativeAction(calculatorWindow);

        setEnteringNumber(false);
        setEntertingDecimal(false);
        setChosenNumber(0);
        setActionPerformed(false);
        setNeutralElement(true);
        setChosenAction("+");
    }

    /**
     * Generates a button for 0,1,2,..,9
     * Next it attaches an action listener to the button,
     * which gets fired when the button is clicked
     * @param calculatorWindow
     */
    private void initNumberButtons(SimpleWindow calculatorWindow){
        calculatorWindow.setColor(Color.WHITE);
        // Init all integer buttons
        int [] integers = {0,1,2,3,4,5,6,7,8,9};
        for (int integer : integers) {
            // Create button
            RATButton integerButton = new RATButton(new Point((integer % 3) * 50,Math.floorDiv(integer,3) * 30 +100),
                    Integer.toString(integer),Color.BLUE,Color.WHITE,Color.WHITE);
            // Add button to widget
            integerButton.addActionListener((ae) -> {
                setActionPerformed(false);
                if (isEnteringNumber()){
                    int floorChosenNumber = (int) Math.floor(getChosenNumber());
                    if (isEntertingDecimal()){
                        setChosenNumber(Double.parseDouble(String.valueOf(floorChosenNumber) + "." +  integerButton.getText()));
                        setEntertingDecimal(false);
                    } else {
                        if (floorChosenNumber == getChosenNumber()){
                            setChosenNumber(Double.parseDouble(String.valueOf(floorChosenNumber) + integerButton.getText()));
                        } else {
                            setChosenNumber(Double.parseDouble(String.valueOf(getChosenNumber()) + integerButton.getText()));
                        }
                    }
                } else {
                    setChosenNumber(Integer.parseInt(integerButton.getText()));
                    setEnteringNumber(true);
                }
                displayNumber(getChosenNumber());
                System.out.println("Integer: " + integerButton.getText() + " pressed -- " + getChosenNumber());
            });
            calculatorWindow.addWidget(integerButton);
        }
    }

    /**
     * Generates a button for +,-,/,*
     * Next it attaches an action listener to the button,
     * which gets fired when the button is clicked.
     * @param calculatorWindow
     */
    private void initActionButtons(SimpleWindow calculatorWindow){
        // Init all mathematical actions
        String [] simpleActions = {"*","+","-","/","%"};
        String [] geoActions = {"cos","sin","tan"};
        String [] expActions = {"x^2","sqrt","log10"};
        String [] [] actions = {simpleActions,geoActions,expActions};
        for (int i = 0;i < actions.length;i++) {
            for (int iteration = 0;iteration < actions[i].length;iteration++) {
                RATButton actionButton;
                if (i == 0) {
                   actionButton = new RATButton(new Point(3 * 50,iteration * 30 + 100), 
                    actions[i][iteration],Color.GREEN,Color.WHITE,Color.black);
                } else if(i == 1){
                    actionButton = new RATButton(new Point(50 * iteration + 50,5*30 +100), 
                    actions[i][iteration],Color.ORANGE,Color.WHITE,Color.black);
                } else {
                    actionButton = new RATButton(new Point(50 * iteration + 50,6*30 +100), 
                    actions[i][iteration],Color.MAGENTA,Color.WHITE,Color.WHITE);
                }
                actionButton.addActionListener((ae) -> {
                    if (!isActionPerformed()) {
                        setActionPerformed(true);
                        setEnteringNumber(false);
                        setChosenAction(actionButton.getText());
                        setResult(calculateResult());
                        System.out.println("Action: " + actionButton.getText() + " performed.");   
                    } else {
                        System.out.println("Action: " + actionButton.getText() + " changed.");   
                    }

                    setChosenAction(actionButton.getText());

                    if (actionButton.getText() == "*" || actionButton.getText() == "+" || actionButton.getText() == "-" || 
                            actionButton.getText() == "/" || actionButton.getText() == "%") {
                        getResultField().setText(getResult() + actionButton.getText());
                    } else {
                        getResultField().setText(actionButton.getText() + " _ ");
                    }
                });
                calculatorWindow.addWidget(actionButton);
            }
        }
    }

    /**
     * Generates and shows the field resposible for showing the results
     * @param calculatorWindow
     */
    private void addResultField(SimpleWindow calculatorWindow){
        // Add field for displaying results
        setResultField(new RATTextField(new Point(40, 50),"",Color.WHITE, Color.CYAN, Color.BLACK));
        calculatorWindow.addWidget(getResultField());
    }

    /**
     * Allows the calculator to accept decimals as input and not only integers
     * @param calculatorWindow
     */
    private void addDecimalAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(1 * 50,3 * 30 +100),
                ".",Color.YELLOW,Color.WHITE,Color.black);
        actionButton.addActionListener((ae) -> {
            setEntertingDecimal(true);
            System.out.println("Action: " + actionButton.getText() + " performed.");
        });
        calculatorWindow.addWidget(actionButton);

    }

    /**
     * Adds the equal button to the window.
     * When the button is pressed the result is dispayed in the resultField afterwards.
     * @param calculatorWindow
     */
    private void addResultAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(2 * 50,3 * 30 +100),
                "=",Color.LIGHT_GRAY,Color.WHITE,Color.WHITE);
        actionButton.addActionListener((ae) -> {
            if (!isActionPerformed()) {
                setResult(calculateResult());
                displayNumber(getResult());
                setEnteringNumber(false);
                setNeutralElement(true);
                setChosenNumber(getResult());
                System.out.println("Action: " + actionButton.getText() + " performed. " + getResult());   
            }
        });
        calculatorWindow.addWidget(actionButton);
    };

    /**
     * Adds an AC button to the calculator which simply resets everything.
     * @param calculatorWindow
     */
    private void addCancelAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(0 * 50,4 * 30 +100),
                "AC",Color.RED,Color.WHITE,Color.WHITE);
        actionButton.addActionListener((ae) -> {
            setEnteringNumber(false);
            setEntertingDecimal(false);
            displayNumber(0);
            setResult(0);
            setChosenNumber(0);
            setNeutralElement(true);
            System.out.println("Action: " + actionButton.getText() + " performed.");
        });
        calculatorWindow.addWidget(actionButton);
    };

    /**
     * Allows the calculator to accept negative values
     * @param calculatorWindow
     */
    private void addNegativeAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(1 * 50,4 * 30 +100),
                " * (-1)",Color.WHITE,Color.BLACK,Color.BLACK);
        actionButton.addActionListener((ae) -> {
            if (isEnteringNumber() || isNeutralElement()){
                setChosenNumber(getChosenNumber() * -1);
                displayNumber(getChosenNumber());
            } else {
                setResult(getResult() * -1);
                displayNumber(getResult());
            }
            System.out.println("Action: " + actionButton.getText() + " performed.");
        });
        calculatorWindow.addWidget(actionButton);
    }


    /**
     * Resposible for calculating the result of the current mathematical equation.
     * @return result
     */
    private double calculateResult(){
        double result;
        if (isNeutralElement()) {
            setNeutralElement(false);
            return getChosenNumber();
        }
        switch (getChosenAction()){
            case "+":
                result = getResult() + getChosenNumber();
                break;
            case "-":
                result = getResult() - getChosenNumber();
                break;
            case "/":
                result = getResult() / getChosenNumber();
                break;
            case "%":
                result = getResult() % getChosenNumber();
                break;
            case "x^2":
                result = Math.pow(getChosenNumber(),2);
                break;
            case "sqrt":
                result = Math.sqrt(getChosenNumber());
                break;
            case "log10":
                result = Math.log10(getChosenNumber());
                break;
            case "tan":
                result = Math.tan(getChosenNumber());
                break;
            case "sin":
                result = Math.sin(getChosenNumber());
                break;
            case "cos":
                result = Math.cos(getChosenNumber());
                break;
            default:
                result = getResult() * getChosenNumber();
        }
        return result;
    }

    public void displayNumber(double number){
        getResultField().setText(Double.toString(number));
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


    public String getChosenAction() {
        return chosenAction;
    }

    public void setChosenAction(String chosenAction) {
        this.chosenAction = chosenAction;
    }

    public boolean isEnteringNumber() {
        return enteringNumber;
    }

    public void setEnteringNumber(boolean enteringNumber) {
        this.enteringNumber = enteringNumber;
    }

    public boolean isEntertingDecimal() {
        return entertingDecimal;
    }

    public void setEntertingDecimal(boolean entertingDecimal) {
        this.entertingDecimal = entertingDecimal;
    }

    public boolean isNeutralElement() {
        return neutralElement;
    }

    public void setNeutralElement(boolean neutralElement) {
        this.neutralElement = neutralElement;
    }

    public boolean isActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(boolean actionPerformed) {
        this.actionPerformed = actionPerformed;
    }


    public double getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(double chosenNumber) {
        this.chosenNumber = chosenNumber;
    }


    public RATTextField getResultField() {
        return resultField;
    }

    public void setResultField(RATTextField resultField) {
        this.resultField = resultField;
    }
}