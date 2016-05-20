package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "info.krushik.android.student.extra.STUDENT";
    public static final String EXTRA_GROUP = "Group";
    private static final int REQUEST_CODE_ACTIVITY_EDIT_GROUP = 1;
    private static final int REQUEST_CODE_ACTIVITY_EDIT_STUDENT = 2;

//    ArrayList<Student> arr;
    public TextView mTextViewGroupName;
    public ArrayList<Group> groups;
    public Group group;
    public ExpandableStudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groups = new ArrayList<>();

        group = new Group(
                "Number 1",
                new Student[]{
                        new Student("Ivan0", "Ivanov0", 20),
                        new Student("Ivan1", "Ivanov1", 21),
                        new Student("Ivan2", "Ivanov2", 22)
                });
        groups.add(group);

        group = new Group(
                "Number 2",
                new Student[0]);
        groups.add(group);

        group = new Group(
                "Number 3",
                new Student[]{
                        new Student("Ivan3", "Ivanov3", 23),
                        new Student("Ivan4", "Ivanov4", 24)
                });
        groups.add(group);

        adapter = new ExpandableStudentAdapter(
                this, R.layout.group_item, R.layout.child_iten, groups
        );

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
        //принимаем новую группу и заносим ее в массив групп
        mTextViewGroupName = (TextView) findViewById(R.id.textViewGroupName);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu1:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                intent = new Intent(this, GroupEditActivity.class);
//                intent.putExtra(EXTRA_STUDENT, group);
                startActivityForResult(intent, REQUEST_CODE_ACTIVITY_EDIT_GROUP);
                break;
            case R.id.menu3:
                intent = new Intent(this, StudentEditActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_ACTIVITY_EDIT_GROUP:
                    String mTextViewGroupName = data.getParcelableExtra(EXTRA_GROUP);
                    group = new Group(mTextViewGroupName, new Student[0]);
                    groups.add(group);


                case REQUEST_CODE_ACTIVITY_EDIT_STUDENT:
//                    mTextViewFirstName.setText(student.FirstName.toString());
//                    mTextViewLastName.setText(student.LastName.toString());
//                    mTextViewAge.setText(String.valueOf(student.Age));
//                    student.FirstName = arr.set(position)

            }
//
        }
    }

}
