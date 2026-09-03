class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String token: tokens) {
            switch (token) {
                case "+" -> st.push(st.pop() + st.pop());
                case "*" -> st.push(st.pop() * st.pop());
                case "-" -> {
                    int b = st.pop(), a = st.pop();
                    st.push(a - b);
                }
                case "/" -> {
                    int b = st.pop(), a = st.pop();
                    st.push(a / b);
                }

                default -> st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
 