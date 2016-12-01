package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import models.Exercise;
import java.util.*;

public class FitnessController extends Controller{
    public static Result welcome(){
        return ok("Welcome to Borg Fitness! Time to assimilate into fitness!");
    }

    public static Result welcomeWithName(String name){
        return ok(
            String.format("Welcome to Borg Fitness, %s! Time to assimilate into fitness!", name));
    }

     public static Result exerciseOfTheDay(){
        return ok(views.html.exerciseoftheday.render(new Exercise("swimming", 60)));
    }

    public static Result workoutOfTheDay(){
        List<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Sprints", 10));
        exercises.add(new Exercise("Jogging", 50));
        exercises.add(new Exercise("Jumping Jacks", 30));
        exercises.add(new Exercise("Mountain Climbers", 20));
        exercises.add(new Exercise("Burpees", 40));

        return ok(views.html.workoutoftheday.render(exercises));
    }
}
