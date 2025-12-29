import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/problems/reverse-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-stack
 * Asked in Amazon, Swiggy, One97
 *
 * https://www.youtube.com/watch?v=aDQeF8Izv5I&list=PLpIkg8OmuX-IBcXsfITH5ql0Lqci1MYPM&index=6
 * TC: Call itself on n-1
 * An O(n) time operation (insert_at_bottom())
 * Some constant-time stuff
 * Thus, you can just sum these together. So I would argue it can be written as:
 *
 * T(n) = T(n-1) + n + c, where c is a constant.
 *      = {T((n-1) - 1) +n + c} +n + c
 *      = T(n-2) + 2n + 2c
 *      .
 *      .
 *      = T(n-k) + kn + kc
 *      = T(0) + n^2 + c^2 -> k == n; T(0) = 1 [Base case]
 *      = 1 + n^2 + c^2
 *      ~ O(n^2)
 * SC: O(n) -> recursive stack space; Auxiliary space = O(1) -> used temp stack
 */
public class InsertElementAtBottomOfStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(2);
        st.push(1);
        st.push(7);
        st.push(6);

        insertAtBottom(st, 9);
        System.out.println(st.toString());
    }

    public static void insertAtBottom(Stack<Integer> s, int el){
        if(s.isEmpty()){
            s.push(el);
            return;
        }

        //take out top element
        int top = s.peek();
        s.pop();
        insertAtBottom(s, el);

        //add the top element
        s.push(top);
    }
}
