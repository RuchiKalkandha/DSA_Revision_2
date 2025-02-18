// 15 feb 2025
public class halfPyramid{

    public static void printing_half_pyramid(int n){
        for(int i =1; i<=n; i++){
            for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
       }
    }

    public static void inverted_half_pyramid_with_numbers(int n){
            for(int i = 0;i<n;i++){
                for(int j = 0; j<n-i; j++){
                    System.out.print(j+1 + " ");
                }
                System.out.println();
            }
    }

    public static void floyds_Traingle(int n){
        int a = 1;
        for(int i = 1; i<=n;i++){
            for(int j = 1; j<=i;j++){
                System.out.print(a + " ");
                a++;
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n){
        for(int i = 0; i<n;i++){
            for(int j =0; j<=i; j++){
                if((i+j)%2 == 0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n){
        // here n is number of rows
        // if n is even
        if(n%2==0){
            // this loop will cover the upper half
            for(int i = 1; i<=n/2;i++){
                for(int j = 1; j<=i; j++){
                    System.out.print("*");
                }
                for(int j = i+1; j<=n-i; j++){
                    System.out.print(" ");
                }
                for(int j =n-i+1; j <n+1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
            // this loop will cover the lower half
              for(int i = n/2; i>=1; i--){
                for(int j = 1; j<=i ;j++){
                    System.out.print("*");
                }
                for(int j = i+1; j<n-i; j++){
                    System.out.print(" ");
                }
                for(int j = n-i+1; j<n+1; j++){
                    System.out.print("*");
                }
                System.out.println();
              }
        }
    }

    public static void solid_rhombus(int side){
        for(int i = 1; i<=side; i++){
            for(int j = 1; j<= side - i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j<=side;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int side){
        for(int i = 1; i<=side; i++){
            for(int j = 0; j<= side-i; j++){
                System.out.print(" ");
            }

            for(int j = 1; j<=side; j++){
                if(i==1 || i==side || j==1 || j == side){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond_pattern(int n){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n; i>=1; i--){
            for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int m = 6;
        // printing_half_pyramid(m);
        // inverted_half_pyramid_with_numbers(m);
        // floyds_Traingle(m);
        // zero_one_triangle(m);
        // butterfly(m);
        // solid_rhombus(m);
        // hollow_rhombus(m);
        diamond_pattern(m);
      
    }
}
