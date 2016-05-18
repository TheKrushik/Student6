package info.krushik.android.student;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;

public class Student  {

    public String FirstName;
    public String LastName;
    public int Age;

    public Student(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }


    @Override
    public String toString() {

        return String.format("%s %s, age: %s", FirstName, LastName, Age);
    }

}
