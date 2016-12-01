package models;

public class Exercise {
    public Exercise(){}
    
    public Exercise(String name, Integer minutes){
        this.name = name;
        this.minutes = minutes;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setMinutes(Integer minutes){
        this.minutes = minutes;
    }
    public Integer getMinutes(){
        return this.minutes;
    }
    
    @Override
    public boolean equals(Object object){
        return object instanceof Exercise && ((Exercise) object).name.equals(this.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() % 313;
    }
    
    @Override
    public String toString(){
        return String.format("Exercise{name=%s}", name);
    }
    
    private String name;
    private Integer minutes;
}