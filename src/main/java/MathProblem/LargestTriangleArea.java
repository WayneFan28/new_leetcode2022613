package MathProblem;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans=0;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                for (int k=j+1;k<N;k++){
                    ans = Math.max(ans, area(points[i],points[j],points[k]));
                }
            }
        }
        return ans;
    }
    public double area(int[] a,int[] b,int[] c){
        return 0.5*Math.abs(a[0]*b[1]+b[0]*c[1]+c[0]*a[1]-a[1]*b[0]-b[1]*c[0]-c[1]*a[0]);
    }
}
