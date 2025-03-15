class SortingTechniques {
    // bubble sort
    public static void bubble(int arr[]){
        for(int turns = 0; turns<arr.length-1; turns++){
            for(int i = 0; i<=arr.length-2-turns; i++){
                if(arr[i]>arr[i+1]){
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
    // print function
    public static void print(int arr[]){
        for(int i = 0; i<arr.length; i++) System.out.print(arr[i] + " ");
    }
    // selection sort
    public static void selectionSort(int arr[]){
    for(int i = 0; i<arr.length-1; i++){
        int minPos = i;
        for(int j = i+1; j<arr.length;j++){
            if(arr[minPos]>arr[j]) minPos = j;
        }
        // swap
        if(minPos  != i){
        int temp = arr[minPos];
        arr[minPos] = arr[i];
        arr[i] = temp;
        }
    }
}
    public static void main(String args[]){
        int arr[] = {4,6,5,3,2,1};
        print(arr);
        // bubble(arr);
        selectionSort(arr);
        System.out.println();
        print(arr);
    }
}
