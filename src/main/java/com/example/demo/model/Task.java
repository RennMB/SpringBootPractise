package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_1")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "note", unique = true, nullable = false)
    private String note;
    @Column(name = "timeCreated", nullable = false)
    private String timeCreated;

    public Task(){
        this.timeCreated = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();

    }

    public Task(String time, String description, String note) {
        this.timeCreated = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
        this.time = time;
        this.description = description;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated){
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", timeCreated='" + timeCreated + '\'' +
                '}';
    }
}
