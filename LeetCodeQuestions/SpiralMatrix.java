import java.util.*;
class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0, bottom=n-1;
        int left=0, right=m-1;
        
        List<Integer> result=new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }top++;
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }right--;
            if (top <= bottom) {
                for(int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }bottom--;
            }
            if (left <= right) {
                for(int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }left++;
            }
        }return result;
        
    }
    public static void main(String[] args) {
        SpiralMatrix sol = new SpiralMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = sol.spiralOrder(matrix);
        System.out.println(result);
    }
}