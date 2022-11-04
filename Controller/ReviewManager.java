package Controller;

import java.util.*;
import java.text.*;
import java.io.*;

import Model.*;
import Controller.*;

public class ReviewManager {
    
    public void addReview(ArrayList<Review> reviewDB, String movieReview, String customerName, String movieTitle, int movieRating){
        Review review=new Review(movieReview, customerName, movieTitle, movieRating);
        int i=0;
        boolean exists=false;
        for (i=0; i<reviewDB.size(); i++) {
            if(reviewDB.get(i).getCustomerName().equals(customerName) && reviewDB.get(i).getMovieTitle().equals(movieTitle)){
                exists=true;
                System.out.println("You have already left a review previously.");
                break;
            }
        }
        if(!exists){
            reviewDB.add(review);
            System.out.println("Review successfully created!");
        }

    }

    public void updateReview(ArrayList<Review> reviewDB, String movieReview, String customerName, String movieTitle, int movieRating){
        int i=0;
        boolean exists=false;
        for (i=0; i<reviewDB.size(); i++) {
            if(reviewDB.get(i).getCustomerName().equals(customerName) && reviewDB.get(i).getMovieTitle().equals(movieTitle)){
                exists=true;
                break;
            }
        }
        if(exists){
            reviewDB.get(i).setMovieTitle(movieTitle);
            reviewDB.get(i).setMovieRating(movieRating);
            System.out.println("Review successfully updated!");
        }
        else
            System.out.println("Review does not exist!");
    }

    public void removeReview(ArrayList<Review> reviewDB, String movieTitle, String customerName){
        int i=0;
        boolean exists=false;
        for (i=0; i<reviewDB.size(); i++) {
            if(reviewDB.get(i).getCustomerName().equals(customerName) && reviewDB.get(i).getMovieTitle().equals(movieTitle)){
                exists=true;
                break;
            }
        }
        if(exists){
            reviewDB.remove(i);
            System.out.println("Review successfully removed!");
        }
        else
            System.out.println("Review does not exist!");
    }

    public void saveReviews(String fileName, ArrayList<Review>reviewDB)throws IOException{
        DatabaseManager.writeSerializedObject(fileName, reviewDB);
    }

    public ArrayList<Review> loadReviews(String fileName)throws IOException, SecurityException, ClassNotFoundException{
        return DatabaseManager.readSerializedObject(fileName);
    }

    public void listMovieReviews(ArrayList<Review> reviewDB, String movieTitle){
        boolean exists=false;
        for(int i=0; i<reviewDB.size(); i++){
            if(reviewDB.get(i).getMovieTitle().equals(movieTitle)){
                System.out.printf("Rating: %d/5\n", reviewDB.get(i).getMovieRating());
                System.out.printf("Review by %s:\n", reviewDB.get(i).getCustomerName());
                System.out.println(reviewDB.get(i).getMovieReview()+"\n");
                exists=true;
            }
        }
        if(!exists)
            System.out.println("No reviews have been made yet.");
    }

    public void listCustomerReviews(ArrayList<Review> reviewDB, String customerName){
        boolean exists=false;
        for(int i=0; i<reviewDB.size(); i++){
            if(reviewDB.get(i).getCustomerName().equals(customerName)){
                System.out.printf("Rating: %d/5\n", reviewDB.get(i).getMovieRating());
                System.out.printf("Movie Title: %s\n", reviewDB.get(i).getMovieTitle());
                System.out.println(reviewDB.get(i).getMovieReview()+"\n");
                exists=true;
            }
        }
        if(!exists)
            System.out.println("No reviews have been made yet.");
    }

    public double movieOverallRating(ArrayList<Review> reviewDB, String movieTitle){
        double overallRating=0;
        int count=0;
        for(int i=0; i<reviewDB.size(); i++){
            if(reviewDB.get(i).getMovieTitle().equals(movieTitle)){
                overallRating+=reviewDB.get(i).getMovieRating();
                count++;
            }
        }
        if(count>0){
            overallRating/=count;
            return overallRating;
        }
        else{
            System.out.println("No reviews have been made yet.");
            return -1;
        }
    }


}