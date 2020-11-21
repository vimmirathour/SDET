package JavaActivity1_2;

public class Activity2 {

	public static void main(String[] args) {
		int[] numbers = {10, 77, 10, 54, -11, 10};
		int sum = 0;
		for (int i=0; i<6; i++) {
			if (numbers[i]==10) {
				sum += numbers[i];
			}
			else {
				sum = sum;
			}
		}
		if (sum==30) {
			System.out.println("Sum value is 30.");
		}
		else {
			System.out.println("Sum value is not 30.");
		}
	}

}