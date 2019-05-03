package com.exemple.mysecondapplication;

import android.graphics.Color;
import android.support.annotation.NonNull;

/**
 * Created by arsene on 25/02/2019.
 */

public class Student implements Comparable{

    public String name;
    public Status status;
    public int order = 0;

    @Override
    public int compareTo(@NonNull Object o) {

        if(order == 0)
        {
            return name.compareTo(((Student)o).name);
        }
        else
        {
            return ((Student)o).name.compareTo(name);
        }

    }

    public enum Status{UNSET, PRESENT, ABSENT, LATE}

    public Student(String p_name)
    {
        name = p_name;
        status = Status.UNSET;
    }

    public int getColor()
    {
        switch (status)
        {
            case PRESENT:
                return Color.GREEN;
            case ABSENT:
                return Color.RED;
            case LATE:
                return Color.YELLOW;

            default:return Color.GRAY;
        }
    }
}
