package com.sambhav;

public class student {
    private int rollno;
    private String name;
    private String gender;
    private double totmarks;
    
    public int getRollno()
    {
        return rollno;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public double getTotmarks()
    {
        return totmarks;
    }
    
    public void setRollno(int rollno)
    {
        this.rollno= rollno;
    }
    
    public void setName(String name)
    {
        this.name= name;
    }
    
    public void setGender(String gender)
    {
        this.gender= gender;
    }
    
    public void setTotmarks(double totmarks)
    {
        this.totmarks= totmarks;
    }
}
