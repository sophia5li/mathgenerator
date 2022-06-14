package com.mathgenerator.view;

import com.mathgenerator.module.MathQuestion;
import io.dropwizard.views.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MathQuestionListView extends View {

    private List<MathQuestion> mathQuestionList;
    public MathQuestionListView(String templateName, List<MathQuestion> mathQuestionList){
        super(templateName);
        this.mathQuestionList = mathQuestionList;
    }

    public List<MathQuestion> getQuestionList(){
        return mathQuestionList;
    }

    public Set<Map.Entry<Integer, MathQuestion>> getQuestionList2(){
        Map<Integer, MathQuestion> map = new HashMap<>();
        for(int i = 0; i < mathQuestionList.size(); i++){
            map.put(i, mathQuestionList.get(i));
        }
        return map.entrySet();
    }
}
