import java.util.Stack;

public class StackExample
{
    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println("Is Present : " + st.search(2));
        System.out.println("Is Present : " + st.search(10));
        System.out.println();

        while(!st.empty())
        {
            System.out.println("Popping the Element : "+st.peek());
            st.pop();
        }
    }
}
