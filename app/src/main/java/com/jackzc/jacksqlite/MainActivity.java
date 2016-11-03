package com.jackzc.jacksqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
// Declare references

    EditText userInput;
    TextView recordsTextView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.user_Input);
        recordsTextView = (TextView) findViewById(R.id.records_TextView);
        /* Can pass nulls because of the constants in the helper.
         * the 1 means version 1 so don't run update.
         */
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Print the database
    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        recordsTextView.setText(dbString);
        userInput.setText("");
    }

    //add your elements onclick methods.
    //Add a product to the database
    public void addButtonClicked(View view) {
        // dbHandler.add needs an object parameter.
        String product_name = userInput.getText().toString();
        if (product_name.length() > 0) {
            Product product = new Product(product_name);
            dbHandler.addProduct(product);
            printDatabase();
        } else {
            Toast.makeText(this, "Please type some fruit name", Toast.LENGTH_LONG).show();
        }
    }

    //Delete items
    public void deleteButtonClicked(View view) {
        // dbHandler delete needs string to find in the db
        String product_name = userInput.getText().toString();
        if (product_name.length() > 0) {
            dbHandler.deleteProduct(product_name);
            printDatabase();
        }else{
            Toast.makeText(this, "Please type something to delete", Toast.LENGTH_LONG).show();
        }
    }

}
