// 16 feb 2025


// java m array as reference pass hoti h,
//  mtlb use function m pass krke kuch changes krenge
// to vo changes actual array m bhi reflect honge
// jbki koi single variable ko agr hm pass krte h
// to vo call by value se pass hota h , yani usme jo
//  changes function k andr honge vo function k andr bne variable
// k rup m vsi block tk rhjaenge
// agr function se bhr hm us variable ki value dubara  dekhenge
// to without any changes same dikhegi bina function vali
public class passArrayAsArg {

    public static void print_array(int array[]){
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }

    public static void update_array(int array[]){
        for(int i = 0; i<array.length; i++){
            array[i] = array[i]*2;
        }
    }

    public static void linear_search(int array[], int key){
        int flag = 0;
        for(int i = 0; i<array.length;i++){
            if(array[i] == key){
                flag = 1;
                System.out.println(key + " found at index " + i + " in the array");
            }
        }
        if(flag == 0){
            System.out.println(key + " not in the array");
        }
    }

    public static int largest_element(int array[]){
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i<array.length; i++){
            if(array[i] > largest){
                largest = array[i];
            }
        }
        return largest;
    }

    public static void main(String[] args){
        
        int marks[] = {50, 70, 90, 78, 900, 67, 56, 4};
        print_array(marks);
        update_array(marks);
        print_array(marks);
        linear_search(marks, 112);
        linear_search(marks, 0);
        System.out.println(largest_element(marks));

    }
}
