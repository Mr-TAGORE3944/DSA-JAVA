package practise;

public class container_with_most_water {


    public static int maxArea(int[] h){
        int left = 0 ,  right = h.length-1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(h[left], h[right]);

            int width = right - left;

            int area = height * width;

            maxArea = Math.max(maxArea, area);

            if (h[left] < h[right]) {
                left++;
            }else{
                right--;
            }
            // left++;
            // right--;
        }

        return maxArea;
    }
    

    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(h));
        System.out.println(Ans(h));
    }

    public static int Ans(int h[]){
        int left = 0 , right = h.length-1;
        int maxArea = 0 ;

        while (left < right) {
            int height = Math.min(h[left], h[right]);

            int width = right - left;

            int area = height * width;

            maxArea = Math.max(maxArea, area);

            if (h[left] < h[right]) {
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}
