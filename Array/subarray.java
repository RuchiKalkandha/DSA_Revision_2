public class subarray {
    public static void print_all_subrray(int array[]){
        for(int i = 0; i< array.length ;i++){
            for(int j=i;j<array.length;j++){
                for(int k =i;k<=j;k++){
                    System.out.print(" "+array[k]+" ");
                }
                System.out.println();
            }
            // System.out.println();
        }
    }

    // Brute Force Maximum subarray sum         //time complexity O(n cube)
    //  Calculate sum of all subarrays and find max
    public static int brute_force_approach_max_sum_subarray(int array[]){
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i<array.length; i++){
            for(int j = i; j<array.length; j++){
                int curr_sum = 0;
                for(int k = i; k<=j; k++){
                    curr_sum = curr_sum+array[k];
                }
                if(curr_sum > max_sum){
                    max_sum = curr_sum;
                }
            }
        }
        return max_sum;
    }

    // using Prefix sum array for finding maximum sum subarray
    // we will eliminate the last loop by using prefix sum array
    // we will write sum of all elements upto index i on ith index of the prefix subarray
    // the sum from ith to jth that we calculated using the third loop k 
    // can now be calculated simpy by substractiong index numbers before i from prefix sum
    //  time complexity O(n square)
    // space complexity O(n)
    public static int max_sum_subarray_using_prefix_sum(int array[]){
        int[] prefix_array = new int[array.length];
        prefix_array[0] = array[0];
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i =1; i<array.length; i++){
            prefix_array[i] = prefix_array[i-1] + array[i];
        }

        for(int i = 0; i<array.length; i++){
            for(int j = i; j<array.length; j++){
               curr_sum = i == 0 ? prefix_array[j] : prefix_array[j] - prefix_array[i-1];
               if(max_sum < curr_sum) {max_sum = curr_sum;}
            }
        }
        return max_sum;
    }


    // the third and final way is to use kadan's algorithm
    // we calculate the sum till we get a non negative number
    // whenever we get a negative sum, we put the current sum as zero and start calculating the curr sum again
    // in case of all non positive numbers, it will give the sum as zero, in that case we will have to return the largest number.
    // if there is zero, then zero otherwise if all numbers negative then the largest number will be the smallest negative number.

    public static int max_sum_subarray_using_kadanes(int array[]){
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i<array.length; i++){
            curr_sum = curr_sum + array[i];
            // this will return the largest max sum subarray
            // if we want it to return smallest max sum subarray, put <= 0 in curr_Sum below
            if(curr_sum <0 ){
                curr_sum = 0;
            }
            max_sum = Math.max(curr_sum, max_sum);
        }
        // if all numbers are either negative or includes zero
        if(curr_sum == 0){
            max_sum = Integer.MIN_VALUE;
            for(int i = 0; i<array.length; i++){
                max_sum = Math.max(max_sum, array[i]);
            }
        }

        return max_sum;
    }

    public static void main(String[] args){
        int array[] = {-1,-2,10,-4,-10};
        print_all_subrray(array);
        System.out.println(brute_force_approach_max_sum_subarray(array));
        System.out.println(max_sum_subarray_using_prefix_sum(array));
        System.out.println(max_sum_subarray_using_kadanes(array));
    }
}
