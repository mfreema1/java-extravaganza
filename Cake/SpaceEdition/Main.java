//question: https://www.interviewcake.com/question/java/find-duplicate-optimize-for-space

public class Main {

    public static void main(String[] args) {
        int[] nums = {
            1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10
        };

        System.out.println(findDuplicateNoSpace(nums));
    }

    //find the first duplicate number in O(1) space and O(Nlg(N)) time while keeping the input intact (no in-place merge-sort)
    public static int findDuplicateNoSpace(int[] nums) {
        int front = 0;
        int back = nums.length - 1;

        while(front < back) {

            int midpoint = (front + back) / 2;

            //we know that a duplicate must appear if the difference between two numbers is smaller than the indices between them by the pigeonhole principle
            if(nums[front] == nums[midpoint])
                return nums[front];
            if(nums[back] == nums[midpoint])
                return nums[back];
            if(midpoint - front > nums[midpoint] - nums[front]) {
                //go to the front half
                back = midpoint - 1;
            }
            else {
                front = midpoint + 1;
            }
        }
        return -1;
    }
}