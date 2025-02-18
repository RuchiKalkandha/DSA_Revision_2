// 16 feb 2025
public class ReverseArray {
    public static void reverse_array(int array[]){
        for(int i = 0; i<(array.length/2); i++){
            int temp;
              temp = array[i];
              array[i] = array[(array.length)-i-1] ;
              array[(array.length) - i-1] = temp;
        }
    }

    public static void rev(int array[]){
        int first = 0, last = array.length-1;
        while(first<last){
            int temp = array[last];
            array[last] = array[first];
            array[first] = temp;
            first ++;
            last--;
        }
    }

    public static void print_array(int array[]){
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        // int a = 6;
        // System.out.print(a/2);
        int array[] = {45,46,47,48,49};
        int array2[] = {44,45,46,47,48,49};
        print_array(array);
        print_array(array2);
        reverse_array(array);
        reverse_array(array2);
        print_array(array);
        print_array(array2);
    }
}
