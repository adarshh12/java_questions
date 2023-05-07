import java.util.Stack;

class MinStack
{
    private Stack<Integer> s = new Stack<>();

    private int min;
    public void push(int val)
    {
        if (s.empty())
        {
            s.push(val);
            min = val;
        }
        else if (val > min) {
            s.push(val);
        }
        else {
            s.push(2*val - min);
            min = val;
        }
    }

    public void pop()
    {
        if (s.empty()) {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }

        int top = s.peek();
        if (top < min) {
            min = 2*min - top;
        }
        s.pop();
    }
    public int getMin() {
        return min;
    }
}

class Main
{
    public static void main (String[] args)
    {
        MinStack s = new MinStack();

        s.push(6);
        System.out.println(s.getMin());

        s.push(7);
        System.out.println(s.getMin());

        s.push(5);
        System.out.println(s.getMin());

        s.push(3);
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());
    }
}