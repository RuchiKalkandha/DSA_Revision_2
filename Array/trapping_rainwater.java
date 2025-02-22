import java.util.*;

public class trapping_rainwater {
    // O(n) time complexity
    // O(n) space complexity
    public static int trapped_rain_water(int height[]){
        // calculate left max boundary of each bar in an array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        // Calculate right max boundary
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i>=0; i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }

        int trapped_water = 0;
        int width = 1;
        // loop
        for(int i = 0; i<height.length;i++){
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            trapped_water += ((waterLevel-height[i])*width);
        }

        return trapped_water;
    }


        public static void main (String args[]){
            int height[] = {4,2,0,6,3,2,5};
            int i =trapped_rain_water(height);
            System.out.println(i);
        }
    }
