import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MakeReview{
	static FlexArray reviews;
	
	 public static class FlexArray{
		int numUsed;
		Review a[];
	
		FlexArray(){};
		FlexArray(int initLen){
			a = new Review[initLen];
		}
	
		void set(int i, Review r){
			a[i] = r;
		}
	
		void expand(){
			Review[] b = new Review[a.length*2];
			for (int i=0; i<a.length; i++) b[i] = a[i];
			a = b;
		}
	
		void insert(Review r){
			if (numUsed==a.length) {
				expand();
			}
			a[numUsed++]=r;
		}
	
		void delete(int i){
			a[i] = a[--numUsed];
		}
	
		Review getItem(int i){
			return a[i];
		}
	};
	
	public static class Review{
		private String reviewerName;
		private String reviewedName;
		private String type;
		//private Date reviewDate;
		private double reviewStars;
	
		Review(String name1, String name2, String t, double s){
			this.reviewerName=name1;
			this.reviewedName=name2;
			this.type=t;
			//this.reviewDate=d;
			this.reviewStars=s;
		}
	
		double getStars(){return this.reviewStars;}
		void setStars(double s) {this.reviewStars=s;}
	
		//Date getDate(){return this.reviewDate;}
		//void setDate(Date d){this.reviewDate=d;}
	
		String getType(){return this.type;}
		void setType(String t) {this.type=t;}
	
		String getReviewerName(){return this.reviewerName;}
		void setReviewerName(String name1) {this.reviewerName=name1;}
	
		String getReviewedName(){return this.reviewedName;}
		void setReviewedName(String name2) {this.reviewedName=name2;}
	
	};
		


/**
 * Determines which one is the most popular
 * @param reviews the FlexArray of data
 * @return either "hotel","restaurant" or "movie", depending on which one is the most popular.
 */
	public static String mostPopular(FlexArray reviews) {
		int a = 0;
		int b = 0;
		int c = 0;
		String[] types = {"hotel","restaurant","movie"};
		for (int i = 0; i < reviews.numUsed; i++) {
			if (reviews.getItem(i).type.equals(types[0])) {
				a++;
			}
			if (reviews.getItem(i).type.equals(types[1])) {
				b++;
			}
			if (reviews.getItem(i).type.equals(types[2])) {
				c++;
			}
		}
		if (a <= b) {
			if (b <= c) {
				return types[2];
			}
			return types[1];
		}
		return types[0];
	}

/**
 * This method deletes the reviews by username(reviews);
 * 
 * @param reviews
 * @param deletedName
 */
//public static void deleteByReviewer(FlexArray reviews, String deletedName){
//	int length = reviews.numUsed;
//	if (reviews.getItem(length-1).reviewerName.equalsIgnoreCase(deletedName)) {
//		reviews.set(length-1, reviews.getItem(length-2));
//	}
//	for (int i = 0; i < length; i ++) {
//		if (reviews.getItem(i).reviewerName.equalsIgnoreCase(deletedName)){
//			reviews.delete(i);
//		}
//	}
//}

	
	public static double avgHotelStars(FlexArray reviews) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < reviews.numUsed; i++) {
			if (reviews.getItem(i).getType().equals("hotel")) {
			sum += reviews.getItem(i).getStars();
			count++;
			}
		}
		double avg = sum/count;
		return avg;
	}



	public static void main(String[] args) throws IOException{
		String word;
		reviews = new FlexArray(1);
        String[] text = new String[4];
        int count = 0;
        Scanner sc = new Scanner(new File("reviews.txt"));
        while (sc.hasNext()){
            word = sc.nextLine();
        	text[count % 4] = word;
        	if (count % 4 == 3){
        		Review review = new Review(text[0], text[1], text[2],Double.parseDouble(text[3]));
        		reviews.insert(review);
        	}
        	count ++;
            
        } 
        sc.close();
        /*
         * 
         */
        //Print out the first and last item;
        System.out.println(reviews.getItem(0).toString());
        System.out.println(reviews.getItem(reviews.numUsed-1).toString());
        System.out.println("The most popular kind of review is "+ mostPopular(reviews));
        System.out.println("The average number of stars over all hotels is " + avgHotelStars(reviews));
//       //Delete Micheal;
//        deleteByReviewer(reviews,"Micheal");
//        System.out.println("The most popular kind of review is "+ mostPopular(reviews));
//        System.out.println("The average number of stars over all hotels is " + avgHotelStars(reviews));        
    }

}
		//Are hotels, restaurants or movies the most popular kind of review?
		//System.out.println("")
		//What is the average number of stars over all hotels?
        //Which review is the most recent for any of the categories?