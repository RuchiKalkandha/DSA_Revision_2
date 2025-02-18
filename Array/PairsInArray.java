// 16 feb 2025
public class PairsInArray {
    public static void pairs_in_array(int array[]){
        for(int i = 0; i<array.length-1;i++){
            for(int j = i+1; j<array.length;j++){
                System.out.print("(" +array[i] + " , " + array[j] + ")  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int array[] = {4,5,6,7,8};
        pairs_in_array(array);
    }
}

