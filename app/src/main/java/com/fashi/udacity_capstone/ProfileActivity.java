package com.fashi.udacity_capstone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fashi.udacity_capstone.database.AppDatabase;
import com.fashi.udacity_capstone.database.ProfileEntry;
import com.google.android.material.textfield.TextInputEditText;

public class ProfileActivity extends AppCompatActivity {

    // Extra for the task ID to be received in the intent
    public static final String EXTRA_TASK_ID = "extraTaskId";
    // Extra for the task ID to be received after rotation
    public static final String INSTANCE_TASK_ID = "instanceTaskId";
    // Constants for priority
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final int PRIORITY_LOW = 3;
    // Constant for default task id to be used when not in update mode
    private static final int DEFAULT_TASK_ID = -1;
    // Constant for logging
    private static final String TAG = ProfileActivity.class.getSimpleName();
    // Fields for views

    private int mTaskId = DEFAULT_TASK_ID;
    // Member variable for the Database
    private AppDatabase mDb;
    Button mButton;
    // Field for Views

    TextInputEditText firstName, lastName, contact, topLength, chest, belly, shoulder, sleeveLength,
            roundSleeve, wrist, neck, trouserLength, waist, hip, lap, kneel, down;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();

        mDb = AppDatabase.getInstance(getApplicationContext());

        if (savedInstanceState != null && savedInstanceState.containsKey(INSTANCE_TASK_ID)) {
            mTaskId = savedInstanceState.getInt(INSTANCE_TASK_ID, DEFAULT_TASK_ID);
        }


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_TASK_ID)) {
            mButton.setText(R.string.update_button);
            if (mTaskId == DEFAULT_TASK_ID) {
                // populate the UI
                mTaskId = intent.getIntExtra(EXTRA_TASK_ID, DEFAULT_TASK_ID);

                // COMPLETED (9) Remove the logging and the call to loadTaskById, this is done in the ViewModel now
                // COMPLETED (10) Declare a AddTaskViewModelFactory using mDb and mTaskId
                ProfileActivityViewModelFactory factory = new ProfileActivityViewModelFactory(mDb, mTaskId);
                // COMPLETED (11) Declare a AddTaskViewModel variable and initialize it by calling ViewModelProviders.of
                // for that use the factory created above AddTaskViewModel
                final ProfileActivityViewModel viewModel
                        = ViewModelProviders.of(this, factory).get(ProfileActivityViewModel.class);

                // COMPLETED (12) Observe the LiveData object in the ViewModel. Use it also when removing the observer
                viewModel.getTask().observe(this, new Observer<ProfileEntry>() {
                    @Override
                    public void onChanged(@Nullable ProfileEntry profileEntry) {
                        viewModel.getTask().removeObserver(this);
                        populateUI(profileEntry);
                    }
                });
            }
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(INSTANCE_TASK_ID, mTaskId);
        super.onSaveInstanceState(outState);
    }


    private void populateUI(ProfileEntry profileEntry) {
        if (profileEntry == null) {
            return;
        }


        firstName.setText(profileEntry.getFirstName());
        lastName.setText(profileEntry.getLastName());
        contact.setText(profileEntry.getContact());
        topLength.setText(profileEntry.getTopLength());
        chest.setText(profileEntry.getChest());
        belly.setText(profileEntry.getBelly());
        shoulder.setText(profileEntry.getShoulder());
        sleeveLength.setText(profileEntry.getSleeveLength());
        roundSleeve.setText(profileEntry.getRoundSleeve());
        wrist.setText(profileEntry.getWrist());
        neck.setText(profileEntry.getNeck());
        trouserLength.setText(profileEntry.getTrouserLength());
        waist.setText(profileEntry.getWaist());
        hip.setText(profileEntry.getHip());
        lap.setText(profileEntry.getLap());
        kneel.setText(profileEntry.getKneel());
        down.setText(profileEntry.getDown());


    }

    private void initViews() {
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        contact = findViewById(R.id.contactEditText);

        topLength = findViewById(R.id.topLengthEditText);
        chest = findViewById(R.id.chestEditText);
        belly = findViewById(R.id.bellyEditText);
        shoulder = findViewById(R.id.shoulderEditText);
        sleeveLength = findViewById(R.id.sleeveLengthEditText);
        roundSleeve = findViewById(R.id.roundSleeve_editText);
        wrist = findViewById(R.id.wristEditText);
        neck = findViewById(R.id.neckEditText);
        trouserLength = findViewById(R.id.trouserLengthEditText);
        waist = findViewById(R.id.waistEditText);
        hip = findViewById(R.id.hipEditText);
        lap = findViewById(R.id.lapEditText);
        kneel = findViewById(R.id.kneelEditText);
        down = findViewById(R.id.downEditText);


//        mEditText = findViewById(R.id.editTextTaskDescription);
//        mRadioGroup = findViewById(R.id.radioGroup);

        mButton = findViewById(R.id.saveButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveButtonClicked();
            }
        });
    }

    private void onSaveButtonClicked() {
        String firstName1 = firstName.getText().toString();
        String lastName2 = lastName.getText().toString();
        String contact2 = contact.getText().toString();

        String topLength2 = topLength.getText().toString();
        String chest2 = chest.getText().toString();
        String belly2 = belly.getText().toString();
        String shoulder2 = shoulder.getText().toString();
        String sleeveLength2 = sleeveLength.getText().toString();
        String roundSleeve2 = roundSleeve.getText().toString();
        String wrist2 = wrist.getText().toString();
        String neck2 = neck.getText().toString();
        String trouserLength2 = trouserLength.getText().toString();
        String hip2 = hip.getText().toString();
        String waist2 = waist.getText().toString();
        String lap2 = lap.getText().toString();
        String kneel2 = kneel.getText().toString();
        String down2 = down.getText().toString();


        final ProfileEntry task = new ProfileEntry(firstName1, lastName2, contact2, topLength2, chest2, belly2, shoulder2, sleeveLength2, roundSleeve2, wrist2, neck2, trouserLength2, hip2, waist2, lap2, kneel2, down2);
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (mTaskId == DEFAULT_TASK_ID) {
                    // insert new task
                    mDb.profileDao().insertTask(task);
                } else {
                    //update task
                    task.setId(mTaskId);
                    mDb.profileDao().updateTask(task);
                }
                finish();
            }
        });

    }
}
