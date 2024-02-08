package com.example.to_do_list;

// TodoAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<TodoItem> todoItems;

    public TodoAdapter(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView todoText;
        public CheckBox todoCheckBox;

        public ViewHolder(View itemView) {
            super(itemView);
            todoText = itemView.findViewById(R.id.todoText);
            todoCheckBox = itemView.findViewById(R.id.todoCheckBox);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TodoItem item = todoItems.get(position);
        holder.todoText.setText(item.getText());
        holder.todoCheckBox.setChecked(item.isCompleted());
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }
}
