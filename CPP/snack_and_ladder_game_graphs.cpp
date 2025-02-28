#include <bits/stdc++.h>
using namespace std;

/* clang-format off */

/* TYPES  */
#define ll long long
#define pii pair<int, int>
#define pll pair<long long, long long>
#define vi vector<int>
#define vll vector<long long>
#define mii map<int, int>
#define si set<int>
#define sc set<char>




vector<vector<int>> adj;

int calc(int start){
	int level[101] , vis[101];
	memset(level , -1 , sizeof(level));
	
	queue<int> q;
	q.push(start);
	
	level[start] = 0;
	vis[start] = 1;
	
	while(!q.empty()){
		int node = q.front(); q.pop();
		int f = 0;
		for(auto child : adj[node]){
			if(!vis[child]){
				vis[child] = 1;
				level[child] = level[node];
				q->push(child);
			}
			f = 1;
		}
		
		if(f){
			continue;
		}
		for(int i = 1 ; i <= 6 ; i++){
			int dx = node + i;
			if(dx <= 100 and vis[dx] == 0){
				level[dx] = level[node] + 1;
				vis[dx] = 1;
				q->push(dx);
			}
		}
		
	}
	return level[100];
}





/*
import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {  // If such an element is found
            int j = n - 1;
            // Step 2: Find the next larger element to swap
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);  // Swap them
        }

        // Step 3: Reverse the remaining elements
        reverse(nums, i + 1, n - 1);
    }

    // Swap function
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse function
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));  // Output: [1, 3, 2]
    }
}







*/




int main(){

		
	
	
	
}










