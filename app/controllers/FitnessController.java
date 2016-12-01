package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import models.Exercise;
import java.util.*;
import play.data.Form;
import static play.data.Form.form;
import com.avaje.ebean.Ebean;
import play.db.ebean.Model;
import play.db.ebean.Transactional;

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

    public static Result initExercise(){
      Form<Exercise> exerciseForm = form(Exercise.class);
      return ok(views.html.createexercise.render(exerciseForm));
    }

    @Transactional
    public static Result createExercise(){
      Form<Exercise> filledInForm = form(Exercise.class).bindFromRequest();
      if(filledInForm.hasErrors()){
        return badRequest(views.html.createexercise.render(filledInForm));
      }
      Exercise exercise = filledInForm.get();
      Ebean.save(exercise);
      return ok(
      String.format("Received exercise for %s", filledInForm.get()));
    }

    @SuppressWarnings("unchecked")
    public static Result getList(){
      Model.Finder finder = new Model.Finder<Long, Exercise>(Long.class, Exercise.class);
      return ok(views.html.allexercises.render((List<Exercise>) finder.all()));
    }
}
