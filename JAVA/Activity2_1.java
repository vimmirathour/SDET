abstract class Book {
	    String title;
	    //Abstract method
	    abstract void setTitle(String s);
	    
	    //Concrete method
	    String getTitle() {
	        return title;
	    }
	}

	class MyBook extends Book {
	    //Define abstract method
	    public void setTitle(String s) {
	        title = s;
	    }
	}

	public class Activity2_1 {
	    
	    public static void main(String []args) {
	        //Initialize title of the book
	        String title = "Nice Car";
	        //Create object for MyBook
	        Book book = new MyBook();
	        //Set title
	        book.setTitle(title);
	        
	        //Print result
	        System.out.println("The title is: " + book.getTitle());
	    }
	}
