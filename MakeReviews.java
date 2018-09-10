import java.util.Arrays;
import java.util.Scanner;

public class MakeReviews{


class FlexArray{
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

class Review{
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
	
	public static void main(String[] args) throws IOExeption{
		String word;
        String[] text = new String[4];
        int count = 0;
        Scanner sc = new Scanner(new File("input.txt"));
        while (sc.hasNext()){
        	
        	if (sc.next instanceof String) {
            word = sc.next();
        		}
        	else {
        		word = "" + sc.next();
        	}
        	text[count % 4] = word;
        	if (count % 4 == 3){
        		Review review = Review(text[0], text[1], text[2],Double.parsedouble(text[4]))
        	}
        	count ++;
            System.out.println(word); // echo check for debugging
            // put word in list
            /* NOTE line above does not check to ensure nWords < array length */
        } 
        sc.close();
        /*
         * 
         */
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
		//Are hotels, restaurants or movies the most popular kind of review?
		//System.out.println("")
		//What is the average number of stars over all hotels?
        //Which review is the most recent for any of the categories?