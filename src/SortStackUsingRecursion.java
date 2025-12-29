import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-a-stack
 * Time Complexity: O(N*N)
 * Space Complexity: O(N) recursive.
 */
public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(11);
        st.push(2);
        st.push(32);
        st.push(3);
        st.push(41);

        System.out.println(st);
        sort(st);
        System.out.println(st.toString());
    }

    public static void sort(Stack<Integer> st){

        if(st.isEmpty() || st.size() == 1) return;

        int top = st.pop();
        sort(st);

        //insert top element at correct position
        insertElement(st, top);
    }

    public static void insertElement(Stack<Integer> st, int el){
        //sort in descending order
        if(st.isEmpty() || st.peek() <= el){
            st.push(el);
            return;
        }

        int curr_top_el = st.pop();
        insertElement(st, el);

        st.push(curr_top_el);
    }
}
