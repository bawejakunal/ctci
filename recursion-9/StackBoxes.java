/**
 *
 * Prepare highest possible stack of boxes
 *
 **/

import java.util.*;

class Box {
    int depth;
    int width;
    int height;

    Box(int width, int depth, int height) {
        this.depth =  depth;
        this.width = width;
        this.height = height;
    }

    boolean canBeAbove(Box b) {
        return (this.depth < b.depth &&
                this.width < b.width &&
                this.height < b.height);
    }
}

public class StackBoxes {

    static int stackHeight(ArrayList<Box> stack) {
        int height = 0;
        if (stack != null) {
            for (Box b : stack) {
                height += b.height;
            }
        }
        return height;
    }

    static ArrayList<Box> largestStack(Box []boxes, Box bottom) {
        ArrayList<Box> maxStack = null;
        int maxHeight = 0;

        for (Box b : boxes) {
            if (b.canBeAbove(bottom)) {
                ArrayList<Box> stack = largestStack(boxes, b);
                int height = stackHeight(stack);
                if (maxStack == null || maxHeight < height) {
                    maxHeight = height;
                    maxStack = stack;
                }
            }
        }

        // smallest box
        if (maxStack == null)
            maxStack = new ArrayList<Box>();

        // add to bottom of stack
        if (bottom != null)
            maxStack.add(0, bottom);

        return maxStack;
    }

    static ArrayList<Box> largestStack(Box []boxes) {
        ArrayList<Box> maxStack = null;
        int maxHeight = 0;
        // repeated solutions
        for (Box bottom : boxes) {
            ArrayList<Box> stack = largestStack(boxes, bottom);
            int height = stackHeight(stack);
            if (maxStack == null || height > maxHeight) {
                maxHeight = height;
                maxStack = stack;
            }
        }
        return maxStack;
    }

    static ArrayList<Box> dpLargestStack(
            HashMap<Box, ArrayList<Box>> solutions, Box[] boxes, Box bottom) {
        
        // return caches solution
        if (solutions.containsKey(bottom))
            return (ArrayList<Box>) solutions.get(bottom).clone();
        
        ArrayList<Box> maxStack = null;
        int maxHeight = 0;

        for (Box b : boxes) {
            if (b.canBeAbove(bottom)) {
                ArrayList<Box> stack = dpLargestStack(solutions, boxes, b);
                int height = stackHeight(stack);
                if (maxStack == null || maxHeight < height) {
                    maxHeight = height;
                    maxStack = stack;
                }
            }
        }

        // smallest box
        if (maxStack == null)
            maxStack = new ArrayList<Box>();

        // add to bottom of stack
        if (bottom != null)
            maxStack.add(0, bottom);

        solutions.put(bottom, maxStack);    // add to solutions

        return maxStack;
    }

    static ArrayList<Box> dpLargestStack(Box []boxes) {
        ArrayList<Box> maxStack = null;
        int maxHeight = 0;
        HashMap<Box, ArrayList<Box>> solutions = 
                        new HashMap<Box, ArrayList<Box>>();
        for (Box bottom : boxes) {
            ArrayList<Box> stack = dpLargestStack(solutions, boxes, bottom);
            int height = stackHeight(stack);
            if (maxStack == null || height > maxHeight) {
                maxHeight = height;
                maxStack = stack;
            }
        }

        return maxStack;
    }

    public static void main(String[] args) {
        Box boxes[] = new Box[5];
        boxes[0] = new Box(1, 1, 1);
        boxes[1] = new Box(5, 6, 9);
        boxes[2] = new Box(3, 1, 2);
        boxes[3] = new Box(4, 5, 6);
        boxes[4] = new Box(1, 3, 2);

        // recursive
        ArrayList<Box> maxStack = dpLargestStack(boxes);

        for (Box b : maxStack)
            System.out.format("%d %d %d\n", b.width, b.depth, b.height);
    }
}