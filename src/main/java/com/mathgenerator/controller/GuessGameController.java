package com.mathgenerator.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/guess")
public class GuessGameController {

    private int randomNum;

    public GuessGameController(){
        startNewGame();
    }

    private void startNewGame(){
        randomNum = (int)(Math.random() * 100 + 1);
    }


    @GET
    public String getView(){
        return "<html>" +
                "<body>" +
                "<form action=/guess method='post'> Please input a number: " +
                "<input name='number' type='text'> " +
                "<input type='submit' value='submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @POST
    public String post(@FormParam("number") String value){
        int number = Integer.parseInt(value);
        if(number < randomNum){
            return "<html>" +
                    "<body>" +
                    "<form action=/guess method='post'> Please input a number: " +
                    "<input name='number' type='text'> " +
                    "<input type='submit' value='submit'>" +
                    "<p>Too small</p>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }
        if(number > randomNum){
            return "<html>" +
                    "<body>" +
                    "<form action=/guess method='post'> Please input a number: " +
                    "<input name='number' type='text'> " +
                    "<input type='submit' value='submit'>" +
                    "<p>Too large</p>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }
        return "<html>" +
                "<body>" +
                "You got it!" +
                "<button onclick=\"location.reload();\">Restart</button>" +
                "</body>" +
                "</html>";
    }
}
