package com.llc.incrementalcreative.increment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by dustindertinger on 3/26/17.
 */

public class Task extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.task);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
    }

    public void onSendTaskName(View view) {

        EditText taskNameET = (EditText)
                findViewById(R.id.task_name_edit_text);

        String taskName = String.valueOf(taskNameET.getText());

        Intent goingBack = new Intent();

        goingBack.putExtra("TaskName", taskName);

        setResult(RESULT_OK, goingBack);

        finish();

    }


}
