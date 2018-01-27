package com.przemyslaw_kamil.todolist.domain;


public enum ColorProject {

    Red,
    Green,
    Blue,
    Yellow,
    Orange,
    none;

    @Override
    public String toString() {
        return this.name();
    }
}
