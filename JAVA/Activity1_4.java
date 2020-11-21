import java.util.Arrays;

		public class Activity1_4 {
			// TODO Auto-generated method stub
			
		    static void ascendingSort(int array[]) {
		        int s = array.length, i;
		        
		        for (i = 1; i < s; i++) {
		            int n = array[i];
		            int j = i - 1;
		            
		            while (j >= 0 && n < array[j]) {
		                array[j + 1] = array[j];
		                --j;
		            }
		            array[j + 1] = n;
		        }
		    }
		    
		    public static void main(String args[]) {
		        int[] nums = { 20, 6, 65, 41, 54 };
		        ascendingSort(nums);
		        System.out.println("Sorted Array in Ascending Order: ");
		        System.out.println(Arrays.toString(nums));
		    }
		}