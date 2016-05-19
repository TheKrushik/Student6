package info.krushik.android.student;

import android.content.Context;
import android.widget.ArrayAdapter;

public class GroupAdapter extends ArrayAdapter<Student> {

    public GroupAdapter(Context context, int resource, Student[] objects) {
        super(context, resource, objects);
    }
}
