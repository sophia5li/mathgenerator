package com.mathgenerator.controller;

import com.mathgenerator.view.GradeResultsView;
import com.mathgenerator.view.MathQuestionListView;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.Map;

@Path("/grade")
public class QuestionGradeController {
    private boolean checkAnswer(int num1, int num2, String opt, int answer){
        if(opt.equals("+")){
            return(num1 + num2 == answer);
        }
        if(opt.equals("-")){
            return(num1 - num2 == answer);
        }
        if(opt.equals("*")){
            return(num1 * num2 == answer);
        }
        if(opt.equals("/")){
            return(num1 / num2 == answer);
        }
        return false;
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void gradeQuestion(MultivaluedMap<String, String> formParams){
        int size = formParams.size() / 4;
        int[] num1 = new int[size];
        int[] num2 = new int[size];
        String[] opt = new String[size];
        int[] answer = new int[size];
        for(Map.Entry<String, List<String>> entry: formParams.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue().get(0);
            if(value.equals("")){
                value = "0";
            }
            String[] keys = key.split("_");
            if(keys.length == 2){
                String first = keys[0];
                int second = Integer.parseInt(keys[1]);
                if(first.equals("num1")){
                    num1[second] = Integer.valueOf(value);
                }
                else if(first.equals("num2")){
                    num2[second] = Integer.valueOf(value);
                }
                else if(first.equals("opt")){
                    opt[second] = value;
                }
                else{
                    answer[second] = Integer.valueOf(value);
                }
            }
            System.out.println(key + ":" + value);
        }
        int score = 0;
        for(int i = 0; i < size; i++){
            if(checkAnswer(num1[i], num2[i], opt[i], answer[i])){
                score++;
            }
        }
        System.out.println(score + "/" + size);

//        return new GradeResultsView("/views/gradeResults.mustache");
    }
//    public void gradeQuestion(@FormParam("answer_1") int answer1,
//                              @FormParam("answer_2") int answer2,
//                              @FormParam("num1") int num1,
//                              @FormParam("num2") int num2,
//                              @FormParam("opt") String opt){
//        System.out.println(num1 + opt + num2 + answer1);
//    }
}
