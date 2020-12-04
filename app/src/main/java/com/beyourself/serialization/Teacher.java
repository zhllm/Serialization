package com.beyourself.serialization;

import android.os.Parcel;
import android.os.Parcelable;

public class Teacher implements Parcelable {
    private String name;
    private int age;
    private Scores scores;


    protected Teacher(Parcel in) {
        name = in.readString();
        age = in.readInt();
        scores = in.readParcelable(Scores.class.getClassLoader());
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public Teacher(String name, int age, Scores scores) {
        this.name = name;
        this.age = age;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(scores, flags);
    }
}


class Scores implements Parcelable {
    private int math;
    private int english;

    protected Scores(Parcel in) {
        math = in.readInt();
        english = in.readInt();
    }

    public static final Creator<Scores> CREATOR = new Creator<Scores>() {
        @Override
        public Scores createFromParcel(Parcel in) {
            return new Scores(in);
        }

        @Override
        public Scores[] newArray(int size) {
            return new Scores[size];
        }
    };

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public Scores(int math, int english) {
        this.math = math;
        this.english = english;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(math);
        dest.writeInt(english);
    }
}