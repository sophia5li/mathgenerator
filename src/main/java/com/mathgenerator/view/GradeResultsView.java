package com.mathgenerator.view;

import com.mathgenerator.module.MathQuestion;
import io.dropwizard.views.View;

import java.util.List;

public class GradeResultsView extends View {
    private List<MathQuestion> mathQuestionList;
    public GradeResultsView(String templateName, List<MathQuestion> mathQuestionList){
        super(templateName);
        this.mathQuestionList = mathQuestionList;
    }

}
