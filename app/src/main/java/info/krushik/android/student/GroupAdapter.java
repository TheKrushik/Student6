package info.krushik.android.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class GroupAdapter extends ArrayAdapter<Group> {
    private Context mContext;//сохраняем переменные себе чтобы мы могли с ними работать
    private int mResource;
    private Group[] mGroups;
    private LayoutInflater mInflater;

    private int mPosition = -1;


    public GroupAdapter(Context context, int resource, Group[] objectGroups) {
        super(context, resource, objectGroups);

        mContext = context;//и сохраняем их себе
        mResource = resource;
        mGroups = objectGroups;

        mInflater = LayoutInflater.from(mContext);


    }
}
