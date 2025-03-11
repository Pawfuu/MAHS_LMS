package raven.utils;

import java.util.Iterator;
import java.util.Stack;

// UndoRedo class provides a simple undo-redo mechanism using two stacks.
// It allows tracking of changes and supports navigating through previous (undo) 
// and next (redo) states.
// 
// @param <E> The type of elements stored in the undo-redo system.
public class UndoRedo<E> implements Iterable<E> {

    // Stack to store the performed actions (undo history)
    private final Stack<E> stack1;
    
    // Stack to store the undone actions (redo history)
    private final Stack<E> stack2;

    
    /**
     * Constructor initializes two stacks:
     * - stack1 stores the history of actions.
     * - stack2 stores the undone actions for redo functionality.
     */
    public UndoRedo() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Adds a new item to the undo stack and clears the redo stack.
     * Adding a new item means we are starting fresh, so previous redo actions become invalid.
     *
     * @param item The item to add.
     */
    public void add(E item) {
        stack1.push(item);
        stack2.clear(); // Clear redo stack since new actions invalidate redo history.

    }

      /**
     * Performs an undo operation:
     * - Moves the latest action from the undo stack to the redo stack.
     * - Returns the new current item after undoing.
     *
     * @return The item before the last action (new current state) or null if not possible.
     */
    public E undo() {
        if (stack1.size() > 1) { // Ensure there is something to undo
            stack2.push(stack1.pop());  // Move the last action to redo stack
            return stack1.get(stack1.size() - 1); // Return the new current state
        } else {
            return null; // Cannot undo further
        }
    }

      /**
     * Performs a redo operation:
     * - Moves an item from the redo stack back to the undo stack.
     * - Returns the restored item.
     *
     * @return The restored item or null if redo is not possible.
     */
    public E redo() {
        if (!stack2.isEmpty()) { // Maek sure  there is something to redo
            E item = stack2.pop(); // Retrieve the last undone action
            stack1.push(item); // Move it back to the undo stack
            return item; 
        } else {
            return null; // Cannot redo
        }
    }

      /**
     * Gets the current item (latest action in the undo stack).
     *
     * @return The most recent item or null if there are no items.
     */
    public E getCurrent() {
        if (stack1.isEmpty()) {
            return null;
        } else {
            return stack1.get(stack1.size() - 1); // Return top of undo stack
        }
    }

     /**
     * Checks if an undo operation is possible.
     *
     * @return True if there are at least two items in the undo stack, false otherwise.
     */
    public boolean isUndoAble() {
        return stack1.size() > 1;
    }

     /**
     * Checks if a redo operation is possible.
     *
     * @return True if there are items in the redo stack, false otherwise.
     */
    public boolean isRedoAble() {
        return !stack2.empty();
    }

     /**
     * Clears both the undo and redo stacks, resetting the state.
     */
    public void clear() {
        stack1.clear();
        stack2.clear();
    }

    /**
     * Clears only the redo stack, keeping the undo history.
     */
    public void clearRedo() {
        stack2.clear();
    }

    /**
     * Returns an iterator to traverse through all stored items.
     *
     * @return An iterator for UndoRedo history.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    //  Custom iterator to iterate over the undo and redo stacks.
    private class MyIterator implements Iterator<E> {

        private int index = 0; // Index to track position in iteration

        @Override
        public boolean hasNext() {
             // Check if there are more elements in either undo (stack1) or redo (stack2) stack
            if (index < stack1.size()) {
                return true;
            } else if (index < stack1.size() + stack2.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            // Iterate through stack1 first, then stack2
            if (index < stack1.size()) {
                return stack1.elementAt(index++);
            } else {
                return stack2.elementAt((index++) - stack1.size());
            }
        }
    }
}
