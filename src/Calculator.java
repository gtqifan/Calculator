import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.security.Key;
import java.util.ArrayList;

public class Calculator extends Application{
    private int onScreenInt;
    private int lastOnScreenInt;
    private String lastOperator;
    private ArrayList<String> oprations = new ArrayList<>();
    private boolean clear = false;
    private boolean answer = false;
    private boolean repeat = false;
    private Button decimalBtn = new Button(".");
    private Button additionBtn = new Button("+");
    private Button subtractionBtn = new Button("-");
    private Button multiplicationBtn = new Button("×");
    private Button divisionBtn = new Button("÷");
    private Button percentBtn = new Button("%");
    private Button ACBtn = new Button("AC");
    private Button negationBtn = new Button("±");
    private Button resultBtn = new Button("=");
    private Button num0 = new Button("0");
    private Button num1 = new Button("1");
    private Button num2 = new Button("2");
    private Button num3 = new Button("3");
    private Button num4 = new Button("4");
    private Button num5 = new Button("5");
    private Button num6 = new Button("6");
    private Button num7 = new Button("7");
    private Button num8 = new Button("8");
    private Button num9 = new Button("9");
    private TextField text = new TextField();

    @Override
    public void start(Stage primaryStage) {
        additionBtn.setMinSize(100, 100);
        additionBtn.setStyle("-fx-font-size:40");
        subtractionBtn.setMinSize(100, 100);
        subtractionBtn.setStyle("-fx-font-size:40");
        multiplicationBtn.setMinSize(100, 100);
        multiplicationBtn.setStyle("-fx-font-size:40");
        divisionBtn.setMinSize(100, 100);
        divisionBtn.setStyle("-fx-font-size:40");
        ACBtn.setMinSize(100, 100);
        ACBtn.setStyle("-fx-font-size:30");
        negationBtn.setMinSize(100, 100);
        negationBtn.setStyle("-fx-font-size:40");
        percentBtn.setMinSize(100, 100);
        percentBtn.setStyle("-fx-font-size:40");
        resultBtn.setMinSize(100, 100);
        resultBtn.setStyle("-fx-font-size:40");
        decimalBtn.setMinSize(100, 100);
        decimalBtn.setStyle("-fx-font-size:40");
        num0.setMinSize(205.5, 100);
        num0.setStyle("-fx-font-size:40");
        num1.setMinSize(100, 100);
        num1.setStyle("-fx-font-size:40");
        num2.setMinSize(100, 100);
        num2.setStyle("-fx-font-size:40");
        num3.setMinSize(100, 100);
        num3.setStyle("-fx-font-size:40");
        num4.setMinSize(100, 100);
        num4.setStyle("-fx-font-size:40");
        num5.setMinSize(100, 100);
        num5.setStyle("-fx-font-size:40");
        num6.setMinSize(100, 100);
        num6.setStyle("-fx-font-size:40");
        num7.setMinSize(100, 100);
        num7.setStyle("-fx-font-size:40");
        num8.setMinSize(100, 100);
        num8.setStyle("-fx-font-size:40");
        num9.setMinSize(100, 100);
        num9.setStyle("-fx-font-size:40");
        text.setMinSize(416.5, 100);
        text.setStyle("-fx-font-size:30");
        text.setAlignment(Pos.CENTER_RIGHT);
        text.setEditable(false);


        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(ACBtn, 0, 1);
        pane.add(negationBtn, 1, 1);
        pane.add(percentBtn, 2, 1);
        pane.add(additionBtn, 3, 4);
        pane.add(subtractionBtn, 3, 3);
        pane.add(multiplicationBtn, 3, 2);
        pane.add(divisionBtn, 3, 1);
        pane.add(num0, 0, 5, 3, 1);
        pane.add(num1, 0, 4);
        pane.add(num2, 1, 4);
        pane.add(num3, 2, 4);
        pane.add(num4, 0, 3);
        pane.add(num5, 1, 3);
        pane.add(num6, 2, 3);
        pane.add(num7, 0, 2);
        pane.add(num8, 1, 2);
        pane.add(num9, 2, 2);
        pane.add(decimalBtn, 2, 5);
        pane.add(resultBtn, 3, 5);
        pane.add(text, 0, 0, 4, 1);

        num0.setOnAction(e -> change(0));
        num1.setOnAction(e -> change(1));
        num2.setOnAction(e -> change(2));
        num3.setOnAction(e -> change(3));
        num4.setOnAction(e -> change(4));
        num5.setOnAction(e -> change(5));
        num6.setOnAction(e -> change(6));
        num7.setOnAction(e -> change(7));
        num8.setOnAction(e -> change(8));
        num9.setOnAction(e -> change(9));
        additionBtn.setOnAction(e -> addition());
        subtractionBtn.setOnAction(e -> subtraction());
        multiplicationBtn.setOnAction(e -> multiplication());
        divisionBtn.setOnAction(e -> division());
        percentBtn.setOnAction(e -> percent());
        resultBtn.setOnAction(e -> operate());
        ACBtn.setOnAction(e -> AC());
        negationBtn.setOnAction(e -> negation());

        Scene scene = new Scene(pane);

        refreshScreen();
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshScreen() {
        text.setText(String.format("%d", onScreenInt));
    }

    private void change(int num) {
        repeat = false;
        if (clear) {
            onScreenInt = num;
            refreshScreen();
            clear = false;
        } else {
            onScreenInt = onScreenInt * 10 + num;
            refreshScreen();
        }
    }

    private void addition() {
        repeat = false;
        if (oprations.size() == 0) {
            oprations.add(String.format("%d", onScreenInt));
            oprations.add("+");
        } else {
            if (!answer) {
                operate();
            }
            oprations.add("+");
            answer = false;
        }
        clear = true;
    }

    private void subtraction() {
        repeat = false;
        if (oprations.size() == 0) {
            oprations.add(String.format("%d", onScreenInt));
            oprations.add("-");
        } else {
            if (!answer) {
                operate();
            }
            oprations.add("-");
            answer = false;
        }
        clear = true;
    }

    private void multiplication() {
        repeat = false;
        if (oprations.size() == 0) {
            oprations.add(String.format("%d", onScreenInt));
            oprations.add("*");
        } else {
            if (!answer) {
                operate();
            }
            oprations.add("*");
            answer = false;
        }
        clear = true;
    }

    private void division() {
        repeat = false;
        if (oprations.size() == 0) {
            oprations.add(String.format("%d", onScreenInt));
            oprations.add("/");
        } else {
            if (!answer) {
                operate();
            }
            oprations.add("/");
            answer = false;
        }
        clear = true;
    }

    private void percent() {
        repeat = false;
        onScreenInt /= 100;
        refreshScreen();
    }

    private void operate() {
        int result = 0;
        if (repeat) {
            onScreenInt = lastOnScreenInt;
            oprations.add(lastOperator);
        } else {
            lastOnScreenInt = onScreenInt;
            lastOperator = oprations.get(oprations.size() - 1);
        }
        switch (oprations.get(oprations.size() - 1)) {
            case "+":
                result = Integer.parseInt(oprations.get(0)) + onScreenInt;
            case "-":
                result = Integer.parseInt(oprations.get(0)) - onScreenInt;
            case "*":
                result = Integer.parseInt(oprations.get(0)) * onScreenInt;
            case "/":
                result = (Integer.parseInt(oprations.get(0)) / onScreenInt);
        }
        oprations.clear();
        oprations.add(String.format("%d", result));
        onScreenInt = result;
        refreshScreen();
        answer = true;
        repeat = true;
    }

    private void negation() {
        if (oprations.size() != 0) {
            oprations.set(0, String.format("%d", Integer.parseInt(oprations.get(0)) * -1));
        }
        onScreenInt *= -1;
        refreshScreen();
    }

    private void AC() {
        oprations.clear();
        onScreenInt = 0;
        refreshScreen();
        clear = false;
        answer = false;
        repeat = false;
    }
}
