package com.example.lab04_05f;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "index2")
public class Cash_view extends VerticalLayout {
    private TextField ans, b1000, b500, b100, b20, b10, b5, b1;
    private Button cal;
    public Cash_view (){
        ans = new TextField();
        b1000 = new TextField();
        b500 = new TextField();
        b100 = new TextField();
        b20 = new TextField();
        b10 = new TextField();
        b5 = new TextField();
        b1 = new TextField();
        cal = new Button("คำนวนเงินทอน");
        ans.setLabel("เงินทอน");
        b1000.setPrefixComponent(new Span("$1000: "));
        b500.setPrefixComponent(new Span("$500: "));
        b100.setPrefixComponent(new Span("$100: "));
        b20.setPrefixComponent(new Span("$20: "));
        b10.setPrefixComponent(new Span("$10: "));
        b5.setPrefixComponent(new Span("$5: "));
        b1.setPrefixComponent(new Span("$1: "));
        this.add(ans, cal, b1000, b500, b100, b20, b10, b5, b1);
        cal.addClickListener(event -> {
            Cashier c1 = new Cashier();
            int a;
            a = Integer.parseInt(ans.getValue());
//            c1.getChange(Integer.parseInt(ans.getValue()));
            b1000.setValue(c1.getChange(a).getB1000() + "");
            b500.setValue(c1.getChange(a).getB500() + "");
            b100.setValue(c1.getChange(a).getB100() + "");
            b20.setValue(c1.getChange(a).getB20() + "");
            b10.setValue(c1.getChange(a).getB10() + "");
            b5.setValue(c1.getChange(a).getB5() + "");
            b1.setValue(c1.getChange(a).getB1() + "");

        });
    }
}
