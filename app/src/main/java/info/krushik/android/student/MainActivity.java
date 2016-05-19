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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "info.krushik.android.student.extra.STUDENT";
    private static final int REQUEST_CODE_ACTIVITY_EDIT_GROUP = 1;
    private static final int REQUEST_CODE_ACTIVITY_EDIT_STUDENT = 2;

    ArrayList<Student> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Group> groups = new ArrayList<>();

        Group group = new Group(
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

        ExpandableStudentAdapter adapter = new ExpandableStudentAdapter(
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
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu1:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent(this, GroupEditActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent(this, StudentEditActivity.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
