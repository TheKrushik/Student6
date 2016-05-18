package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "info.krushik.android.student.extra.STUDENT";
    private static final int REQUEST_CODE_ACTIVITY3_ADD = 1;
    private static final int REQUEST_CODE_ACTIVITY4_EDITING = 2;

    ArrayList<Student> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = new ArrayList<>(); //вывод студентов в ListView через Custom Array Adapter
        arr.add(new Student("Ivan0", "Ivanov0", 20));
        arr.add(new Student("Ivan1", "Ivanov1", 21));
        arr.add(new Student("Ivan2", "Ivanov2", 22));

        final StudentAdapter adapter = new StudentAdapter(
                this,
                R.layout.list_item,
                arr
        );

        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

// обработка короткого клика конкретного элеметна списка, а не всего ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
//нам приходит( Adapter, View вся на кот. мы нажали, position - конкретный элемент(0,1,2), id-нашего ListView)
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = arr.get(position);

                Intent intent = new Intent(MainActivity.this, Activity2Review.class);
                intent.putExtra(EXTRA_STUDENT, student);
                startActivity(intent);
            }
        });

//        adapter.setStudentListener(new StudentAdapter.StudentListener() {
//            @Override
//            public void onDeleteClick(Student student) {
//                Toast.makeText(MainActivity.this, student.toString(), Toast.LENGTH_SHORT).show();
//                arr.remove(student);
//                adapter.notifyDataSetChanged();
//            }
//        });

// обработка длинного клика конкретного элеметна списка, а не всего ListView
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final Student student = arr.get(position);

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, listView);//как вывести Popup возле указанного студента по LongClickу???
                popupMenu.inflate(R.menu.menu_long_item_click);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem){

                        switch (menuItem.getItemId()) {
                            case R.id.menu_editing://как передать на редактирование строки указзанного студента???
//                                Student student = new Student();
                                student.FirstName = arr.get(position).FirstName;
                                student.LastName = arr.get(position).LastName;
                                student.Age = arr.get(position).Age;

                                Intent intent3 = new Intent(MainActivity.this, Activity4Editing.class);
                                intent3.putExtra(EXTRA_STUDENT, student);
                                startActivityForResult(intent3, REQUEST_CODE_ACTIVITY4_EDITING);

                                break;
                            case R.id.menu_delete:
                                arr.remove(student);
                                adapter.notifyDataSetChanged();

                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
                return true;
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
        }
        return super.onOptionsItemSelected(item);
    }

}
