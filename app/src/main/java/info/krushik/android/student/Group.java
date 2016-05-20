package info.krushik.android.student;

import android.os.Parcel;
import android.os.Parcelable;

public class Group implements Parcelable{
    public String Number;
    public  Student[] Students;

    public Group(String number, Student[] students) {
        Number = number;
        Students = students;
    }

    public Group() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Number);
        dest.writeTypedArray(this.Students, flags);
    }

    protected Group(Parcel in) {
        this.Number = in.readString();
        this.Students = in.createTypedArray(Student.CREATOR);
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel source) {
            return new Group(source);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };
}
