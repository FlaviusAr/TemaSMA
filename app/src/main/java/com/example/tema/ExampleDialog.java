package com.example.tema;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;


public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextUsername;
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        builder.setView(view)
                .setTitle("Dialog")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(((Dialog) dialogInterface).getContext(), "CANCEL" , Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = editTextUsername.getText().toString();
                        openSecondActivity();
                    }
                });
        editTextUsername = view.findViewById(R.id.edit_username);
        EditText editText1 = (EditText) view.findViewById(R.id.edit_username);
        return builder.create();
    }

    public void openSecondActivity() {
        //EditText editText1 = (EditText) findViewById(R.id.edit_username);
        String text = editTextUsername.getText().toString();
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}



