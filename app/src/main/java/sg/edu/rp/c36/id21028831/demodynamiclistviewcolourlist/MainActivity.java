package sg.edu.rp.c36.id21028831.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText addElementColour;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    EditText chooseIndex;
    ListView lvColour;

    ArrayList<String> alColour;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addElementColour=findViewById(R.id.editTextColour);
        btnAdd=findViewById(R.id.buttonAddItem);
        btnRemove=findViewById(R.id.btnRemove);
        btnUpdate=findViewById(R.id.btnUpdate);
        chooseIndex=findViewById(R.id.editTextIndex );
        lvColour=findViewById(R.id.listViewColour);

        alColour=new ArrayList<>();
        alColour.add("Red");
        alColour.add("Orange");

        aaColour=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColour);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addedColour=addElementColour.getText().toString();
                String index=chooseIndex.getText().toString();
                int indexNum=Integer.parseInt(index);

                alColour.add(indexNum,addedColour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String colour = alColour.get(position);
                Toast.makeText(MainActivity.this,colour,Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String index=chooseIndex.getText().toString();
                int indexNum=Integer.parseInt(index);

                alColour.remove(indexNum);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editColour=addElementColour.getText().toString();
                String index=chooseIndex.getText().toString();
                int indexNum=Integer.parseInt(index);

                alColour.set(indexNum,editColour);
                aaColour.notifyDataSetChanged();
            }
        });

    }
}