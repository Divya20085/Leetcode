import java.util.Stack;
class Solution {

    public int largestRectangleArea(int[] barHeights) {
        int maxRectangleArea = 0; // \U0001f31f To track the maximum rectangle area

        Stack<Integer> indexStack = new Stack<>(); // \U0001f5c2️ Stack to store indices of bars

        // Loop through all bars, including an extra iteration for edge case
        for (int currentIndex = 0; currentIndex <= barHeights.length; currentIndex++) {
            // \U0001f310 When stack is not empty and current bar is smaller than top of the stack
            while (!indexStack.isEmpty() && 
                  (currentIndex == barHeights.length || barHeights[indexStack.peek()] >= barHeights[currentIndex])) {

                // \U0001f522 Calculate height of the rectangle
                int height = barHeights[indexStack.pop()];

                // \U0001f4cf Calculate width of the rectangle
                int width;
                if (indexStack.isEmpty()) {
                    // \U0001f30d If stack is empty, width spans from 0 to the current index
                    width = currentIndex;
                } else {
                    // \U0001f517 If stack is not empty, width is between current index and the new top of stack
                    width = currentIndex - indexStack.peek() - 1;
                }

                // \U0001f31f Update the maximum area
                maxRectangleArea = Math.max(maxRectangleArea, width * height);
            }

            // \U0001f3d7️ Push the current index onto the stack
            indexStack.push(currentIndex);
        }

        return maxRectangleArea; // \U0001f31f Return the largest rectangle area
    }
}