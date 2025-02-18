// 16 feb 2025
public class binarySearch {

    public static int binary_search(int array[], int key){
        int start = 0;
        int end = array.length -1;

        while(start<=end){
            int mid = (end + start)/2;
            if (array[mid] == key){
                return key;
            }
            else if(array[mid] < key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int array[] = {2,4,6,8,10,12,14};
        int array2[] = {2,4,6,8,10,12,14,16};

        System.out.println("Searching in array1: ");
        System.out.println(binary_search(array, 12));
        System.out.println(binary_search(array, 14));
        System.out.println(binary_search(array, 10));
        System.out.println(binary_search(array, 8));
        System.out.println(binary_search(array, 6));
        System.out.println(binary_search(array, 4));
        System.out.println(binary_search(array, 2));
        System.out.println(binary_search(array, 1));
        System.out.println(binary_search(array, 0));
        System.out.println("sEARCHING in array 2");
        System.out.println(binary_search(array2, 12));
        System.out.println(binary_search(array2, 14));
        System.out.println(binary_search(array2, 10));
        System.out.println(binary_search(array2, 8));
        System.out.println(binary_search(array2, 6));
        System.out.println(binary_search(array2, 4));
        System.out.println(binary_search(array2, 2));
        System.out.println(binary_search(array2, 16));
        System.out.println(binary_search(array2, 0));



    }
}
