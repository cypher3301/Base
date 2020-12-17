package study.strings;

import java.util.Stack;

public class UndoableStringBuilder {
    private interface Action{
        void undo();
    }

    private class DeleteAction implements Action{
        private int size;


        public DeleteAction(int size){
            this.size=size;
        }

        @Override
        public void undo() {
            stringBuilder.delete(stringBuilder.length()-size, stringBuilder.length());
        }
    }

    private StringBuilder stringBuilder;

    private Stack<Action> actions = new Stack<>();

    public UndoableStringBuilder(){
        stringBuilder = new StringBuilder();
    }

    public UndoableStringBuilder reverse(){
        stringBuilder.reverse();

        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.reverse();
            }
        };
        actions.add(action);
        return this;
    }

    public UndoableStringBuilder append(String str){
        stringBuilder.append(str);

        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length()-str.length()-1, stringBuilder.length());
            }
        };
        actions.add(action);
        return this;
    }

    public UndoableStringBuilder insert(int offset, String str){
        stringBuilder.insert(offset, str);
        actions.add(()->stringBuilder.delete(offset, str.length()));
        return this;
    }

    public void undo(){
        if(!actions.isEmpty()){
            actions.pop().undo();
        }
    }

    public String toString(){
        return stringBuilder.toString();
    }
}
