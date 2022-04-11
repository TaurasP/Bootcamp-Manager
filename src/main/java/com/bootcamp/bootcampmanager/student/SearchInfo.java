package com.bootcamp.bootcampmanager.student;

public class SearchInfo {

    private Long campId;
    private Long taskId;

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public SearchInfo() {
    }

    public SearchInfo(Long campId, Long taskId) {
        this.campId = campId;
        this.taskId = taskId;
    }
}
