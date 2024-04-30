package task14;

import java.util.LinkedList;

public class TaskQueue {
    private final LinkedList<Task> taskQueue;

    public TaskQueue(){
        this.taskQueue = new LinkedList<>();
    }

    public synchronized void addTask(Task task){
        taskQueue.addLast(task);
    }

    public synchronized Task getTask(){
        if(taskQueue.isEmpty()) return null;
        return taskQueue.removeFirst();
    }

    public synchronized boolean isEmpty(){
        return taskQueue.isEmpty();
    }
}
