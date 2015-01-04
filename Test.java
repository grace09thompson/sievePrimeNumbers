import java.util.*;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public static void main(String[] args)  {
        int[][] arr = new int[3][4];
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 4; col++) {
                arr[row][col] = row + 2 * col;
            }
        }
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(arr[2][3]);
        System.out.println(Arrays.deepToString(arr));
    }

}
