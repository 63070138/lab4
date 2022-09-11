package com.example.lab04_05f;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "index")
public class Cal_view extends VerticalLayout {
    private TextField nf1, nf2, nf3;
    private Button plus, minus, multiply, divide, mod, max;
    private HorizontalLayout h1;

    private Calculator c;


    public Cal_view() {
        nf1 = new TextField();
        nf2 = new TextField();
        nf3 = new TextField();
        c = new Calculator();
        h1 = new HorizontalLayout();
        plus = new Button("+");
        minus = new Button("-");
        multiply = new Button("*");
        mod = new Button("mod");
        divide = new Button("/");
        max = new Button("max");
        h1.add(plus, minus, multiply, divide, mod, max);
        nf1.setLabel("Number 1");
        nf2.setLabel("Number2");
        nf3.setLabel("Answer");
        this.add(nf1, nf2, h1, nf3);

        plus.addClickListener(event -> {
            double ans;
            double num1 = Double.parseDouble(nf1.getValue());
            double num2 = Double.parseDouble(nf2.getValue());
            nf3.setValue(c.myPlus(num1, num2)+ "");
        });

        minus.addClickListener(event -> {
            double ans;
            double num1 = Double.parseDouble(nf1.getValue());
            double num2 = Double.parseDouble(nf2.getValue());
            nf3.setValue(c.myMinus(num1, num2)+ "");
        });

        multiply.addClickListener(event -> {
            double ans;
            double num1 = Double.parseDouble(nf1.getValue());
            double num2 = Double.parseDouble(nf2.getValue());
            nf3.setValue(c.myMulti(num1, num2)+ "");
        });

        divide.addClickListener(event -> {
            double ans;
            double num1 = Double.parseDouble(nf1.getValue());
            double num2 = Double.parseDouble(nf2.getValue());
            nf3.setValue(c.myDivide(num1, num2)+ "");
        });

        mod.addClickListener(event -> {
            double ans;
            double num1 = Double.parseDouble(nf1.getValue());
            double num2 = Double.parseDouble(nf2.getValue());
            nf3.setValue(c.myMod(num1, num2)+ "");
        });

        max.addClickListener(event -> {
            double ans;
            double num1 = Double.parseDouble(nf1.getValue());
            double num2 = Double.parseDouble(nf2.getValue());
            nf3.setValue(c.myMax(num1, num2)+ "");
        });
    }
}
