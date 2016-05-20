package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GroupEditActivity extends AppCompatActivity {

    private EditText mEditTextGroupName;
    private Button mButtonGroupSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_edit);

        mEditTextGroupName = (EditText) findViewById(R.id.etGroupName);
        mButtonGroupSave = (Button) findViewById(R.id.btnGroupSave);

        mButtonGroupSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //передаем новую группу
                Intent ressultIntent = new Intent(GroupEditActivity.this, MainActivity.class);
                ressultIntent.putExtra(MainActivity.EXTRA_GROUP, mEditTextGroupName.getText().toString());
                startActivity(ressultIntent);

            }
        });
    }
}
