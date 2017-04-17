package com.llc.incrementalcreative.increment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by dustindertinger on 3/26/17.
 */

public class Idea extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.idea);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");


    }

    public void onSendIdeaName(View view) {

        EditText ideaNameET = (EditText)
                findViewById(R.id.idea_name_edit_text);

        String ideaName = String.valueOf(ideaNameET.getText());

        Intent goingBack = new Intent();

        goingBack.putExtra("IdeaName", ideaName);

        setResult(RESULT_OK, goingBack);

        finish();

    }
}
