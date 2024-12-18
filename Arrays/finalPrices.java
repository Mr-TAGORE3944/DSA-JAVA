class Solution {
    public int[] finalPrices(int[] p) {
        int n = p.length;
        int[] result = p.clone();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && p[st.peek()] >= p[i]) {
                int idx = st.pop();
                result[idx] -= p[i];
            }
            st.push(i);
        }

        return result;
    }
}