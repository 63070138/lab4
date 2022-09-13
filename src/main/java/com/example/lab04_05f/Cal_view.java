package com.example.lab04_05f;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

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
            String ans;
            String num1 = String.valueOf(nf1.getValue());
            String num2 = String.valueOf(nf2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/plus/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block());
            nf3.setValue(ans);
        });

        minus.addClickListener(event -> {
            String ans;
            String num1 = String.valueOf(nf1.getValue());
            String num2 = String.valueOf(nf2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/minus/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block());
            nf3.setValue(ans);
        });

        multiply.addClickListener(event -> {
            String ans;
            String num1 = String.valueOf(nf1.getValue());
            String num2 = String.valueOf(nf2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/multi/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block());
            nf3.setValue(ans);
        });

        divide.addClickListener(event -> {
            String ans;
            String num1 = String.valueOf(nf1.getValue());
            String num2 = String.valueOf(nf2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/divide/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block());
            nf3.setValue(ans);
        });

        mod.addClickListener(event -> {
            String ans;
            String num1 = String.valueOf(nf1.getValue());
            String num2 = String.valueOf(nf2.getValue());
            ans = String.valueOf(WebClient.create().get().uri("http://localhost:8080/mod/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block());
            nf3.setValue(ans);
        });

        max.addClickListener(event -> {
            String ans;
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("num1", nf1.getValue());
            formData.add("num2", nf2.getValue());
            ans = String.valueOf(WebClient.create().post().uri("http://localhost:8080/max").contentType(MediaType.APPLICATION_FORM_URLENCODED).body(BodyInserters.fromFormData(formData)).retrieve().bodyToMono(String.class).block());
            nf3.setValue(ans);
        });
    }
}
