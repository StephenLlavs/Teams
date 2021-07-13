package com.company;

import java.util.ArrayList;

// Storing Athletes Information
public class Athlete {
    Athlete(String first_name, String last_name, int id,
            ArrayList<Integer> scores)
    {
        m_first_name = first_name;
        m_last_name = last_name;
        m_id = id;
        m_scores = scores;
    }

    // Computing the Average Score that was inputted
    public double compute_average_score()
    {
        if (m_scores.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int score : m_scores)
        {
            sum += score;
        }
        return sum/m_scores.size();
    }

    //Displaying results
    public void display_results()
    {
        System.out.printf("%-20s%.2f%n", m_first_name + " " + m_last_name,
                compute_average_score());
    }

    private String m_first_name;
    private String m_last_name;
    private int m_id;
    private ArrayList<Integer> m_scores;
}
