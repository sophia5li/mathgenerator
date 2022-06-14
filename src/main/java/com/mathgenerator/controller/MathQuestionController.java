package com.mathgenerator.controller;

import com.mathgenerator.module.MathQuestion;
import com.mathgenerator.view.MathQuestionListView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/questionList")
public class MathQuestionController {

    @GET
    public View get(){
//        return new MathQuestionListView("/views/mathQuestionList.mustache", new MathQuestion(5,6,"+"));
        String opt = "";
        int num1;
        int num2;
        List<MathQuestion> mathQuestionList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            int temp = (int) (Math.random()*(4)) + 1;
            if(temp == 1){
                opt = "+";
            }
            if (temp == 2) {
                opt = "-";
            }
            if (temp == 3) {
                opt = "*";
            }
            if (temp == 4) {
                opt = "/";
                num2 = (int) (Math.random() * (50)) + 1;
                num1 = ((int) (Math.random() * (100/num2)) + 1) * num2;

            }
            else {
                num1 = (int) (Math.random() * (100)) + 1;
                num2 = (int) (Math.random() * (100)) + 1;
            }
            mathQuestionList.add(new MathQuestion(i, num1, num2, opt));
        }
        return new MathQuestionListView("/views/mathQuestionList.mustache", mathQuestionList);
    }
}

