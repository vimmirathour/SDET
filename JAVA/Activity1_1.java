public class Activity1_1 {

	public static void main(String[] args) {
		
		// creating object for Car
		
		        Car car = new Car();
		        car.make = 2014;
		        car.color = "Black";
		        car.transmission = "Manual";
		    
		        car.displayCharacterstics();
		        car.accelerate();
		        car.brake();
		    }

		}

 class Car {
   
    String color;
    int make;
    String transmission;
    int tyres;
    int doors;
   
    //using car as constructor
    Car() {
	tyres = 4;
	doors = 4;
    }

    public void displayCharacterstics(){
	System.out.println("Color of the Car: " + color);
	System.out.println("Make of the Car: " + make);
	System.out.println("Transmission of the Car: " + transmission);
	System.out.println("Number of doors on the car: " + doors);
    	System.out.println("Number of tyres on the car: " + tyres);
    }

    public void accelerate() {
	System.out.println("Car is moving forward.");
    }
	
    public void brake() {
	System.out.println("Car has stopped.");
    }
}