package br.com.todolist.Model;

public enum PriorityRole {

    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private String priority;

    PriorityRole(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}

