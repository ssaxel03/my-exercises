package io.codeforall.fanSTATICs_;

public class Genie {

    private int limit;

    private int granted;

   public Genie(int limit){
       this.limit = limit;
       this.granted = 0;
   }

   public void grantWish(){
       if (this.granted < this.limit || this.limit == 0){
           System.out.println("Wish granted");
           this.granted++;
           return;
       }
       System.out.println("No more wishes left");
   }

     }

