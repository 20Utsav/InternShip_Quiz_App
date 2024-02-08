package com.example.to_do_list;

// MainActivity.java
// MainActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText todoEditText;
    private Button addTodoButton;
    private RecyclerView todoRecyclerView;
    private TodoAdapter todoAdapter;
    private List<TodoItem> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoEditText = findViewById(R.id.todoEditText);
        addTodoButton = findViewById(R.id.addTodoButton);
        todoRecyclerView = findViewById(R.id.todoRecyclerView);

        todoList = new ArrayList<>();
        todoAdapter = new TodoAdapter(todoList);

        todoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        todoRecyclerView.setAdapter(todoAdapter);

        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTodoItem();
            }
        });
    }

    private void addTodoItem() {
        String todoText = todoEditText.getText().toString().trim();
        if (!todoText.isEmpty()) {
            TodoItem newItem = new TodoItem(todoText, false);
            todoList.add(newItem);
            todoAdapter.notifyItemInserted(todoList.size() - 1);
            todoEditText.getText().clear();
        }
    }
}
