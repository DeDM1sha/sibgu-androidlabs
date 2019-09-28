package com.example.androidlabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Fragment_Lab1 Fragment_Lab1;
    private Fragment_Lab2 Fragment_Lab2;
    private Fragment_Lab3 Fragment_Lab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Инициализируем все фрагменты
        Fragment_Lab1 = new Fragment_Lab1();
        Fragment_Lab2 = new Fragment_Lab2();
        Fragment_Lab3 = new Fragment_Lab3();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Фрагменты работают по следующему принципу. Должно быть какое-то место, куда они будут вставляться
        // и каждый раз при нажатии кнопки в меню, один фрагмент заменяет другой.
        // Твоя ошибка была в том что ты не создал место куда они будут вставлсятья, загляни в activity_main.xml,
        // там я создал LinearLayout, а в него поместил меню и FrameLayout. FrameLayout это как раз то, куда
        // вставляются фрагменты, метод replace принимает парамерты, перый из них это куда вставить фрагмент,
        // а второй какой вставить фрагмент. Соответсвенно у FrameLayout, я задал id=content, и теперь он зменяет
        // содержимое FrameLayout на фрагмент, который укажешь в параметрах, если что у меня на гитхабе есть пример как работать с этим
        switch (item.getItemId()) {

            case R.id.action_launch_lab_1:
                ft.replace(R.id.content, Fragment_Lab1);
                ft.commit();
                return true;

            case R.id.action_launch_lab_2:
                ft.replace(R.id.content, Fragment_Lab2);
                ft.commit();
                return true;

            case R.id.action_launch_lab_3:
                ft.replace(R.id.content, Fragment_Lab3);
                ft.commit();
                return true;

            case R.id.action_exit:
                finish ();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
