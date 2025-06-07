package com.example.app_todolist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_todolist.databinding.ActivityMainBinding;
import com.example.app_todolist.model.Task;
import com.example.app_todolist.recyclerview.adapter.TaskAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private TextInputEditText inputTitle, inputDescription;
    private Button btnSave;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inputTitle = binding.textInputField1;
        inputDescription = binding.textInputField2;
        btnSave = binding.textButton;
        recyclerView = binding.recyclerView;

        taskList = new ArrayList<>();
        adapter = new TaskAdapter(taskList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnSave.setOnClickListener(v -> {
            String title = inputTitle.getText().toString().trim();
            String descricao = inputDescription.getText().toString().trim();

            if (title.isEmpty()) {
                Toast.makeText(this, "Insira o título", Toast.LENGTH_SHORT).show();
                return;
            }

            Task novaTask = descricao.isEmpty()
                    ? new Task(title, null)
                    : new Task(title, descricao);

            taskList.add(novaTask);
            adapter.notifyItemInserted(taskList.size() - 1);
            recyclerView.scrollToPosition(taskList.size() - 1);

            inputTitle.setText("");
            inputDescription.setText("");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}