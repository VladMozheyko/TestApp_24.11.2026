package com.unionprogers.testapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.unionprogers.testapplication.model.Human;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Создаем переменные для связи с версткой
    private EditText edtName;
    private EditText edtAge;
    private EditText edtWeight;
    private Button btnAdd;
    private Button btnShow;
    private TextView txt_show;
    private ArrayList<Human> humans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   // Загружаем верстку
        // Привязываем переменные к вертске
        initViews();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHuman();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHumans();
            }
        });

    }

    /**
     * Метод для вывода людей на экран
     */
    private void showHumans() {
        String str = "";//Строка для вывода
        for (int i = 0; i < humans.size(); i++) { // Перебираем массив людей

            str += "Имя: " + humans.get(i).getName() + " Возраст: " + humans.get(i).getAge() + " Вес: " + humans.get(i).getWeight() + "\n";

        }

        txt_show.setText(str);
        Log.d("Текст: ", str);
    }

    /**
     * Метод для добавления людей в список
     */
    private void addHuman() {
        //Получаем данные из представления
        String name = edtName.getText().toString(); // Получаем строку из поля ввода
        int age = Integer.parseInt(edtAge.getText().toString());  // Получаем int из поля ввода
        double weight = Double.parseDouble(edtWeight.getText().toString()); // Получаем double из поля ввода
        Human human = new Human(name, age, weight);
        humans.add(human);
    }

    /**
     * Метод для инициализации представления(View)
     */
    private void initViews() {
        // Инициализируем поля ввода
        edtName = findViewById(R.id.edt_name);
        edtAge = findViewById(R.id.edt_age);
        edtWeight = findViewById(R.id.edt_weight);
        // Инициализируем кнопки
        btnAdd = findViewById(R.id.btn_add_human);
        btnShow = findViewById(R.id.btn_show_humans);
        // Инициализируем поля текста
        txt_show = findViewById(R.id.txt_show_humans);
    }
}