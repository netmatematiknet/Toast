package com.nuri.toastresimmesaji;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button Btn1,Btn2,Btn3,Btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn1= findViewById(R.id.button1);
        Btn2= findViewById(R.id.button2);
        Btn3= findViewById(R.id.button3);
        Btn4= findViewById(R.id.button4);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),"Bu bir NORMAL Tost Mesajıdır",Toast.LENGTH_LONG).show();
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v)
              {
                  ImageView resim=new ImageView(getApplicationContext());
                  resim.setImageResource(R.drawable.reklam);
                  Toast toast=new Toast(getApplicationContext());
                  toast.setView(resim); //setView yani özel toast kullanımdan kaldırıldı. Bunun yerine SnackBar kullan
                  toast.setDuration(Toast.LENGTH_LONG);
                  toast.show();
              }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Baslik = "DENEME";
                String mesajim = "Bu bir RESİMLİ Toast MESAJI";
                gosterTOAST(mesajim,Baslik);
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sureliTOAST("Bu bir Toast MESAJI",6000);
            }
        });

    }


    public void gosterTOAST(String Baslik, String msg)
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_ekrani,
                (ViewGroup) findViewById(R.id.relativeLayout1));
        TextView baslikText = layout.findViewById(R.id.toast_baslik);
        TextView textMesaj = layout.findViewById(R.id.toast_mesaj);
        baslikText.setText(Baslik);
        textMesaj.setText(msg);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);  //setView yani özel toast kullanımdan kaldırıldı. Bunun yerine SnackBar kullan
        toast.show();
    }

    public void sureliTOAST(String msg, int millisec) {
        Handler handler = null;
        final Toast[] toast_sureli = new Toast[1];
        for(int i = 0; i < millisec; i+=2000) {
            toast_sureli[0] = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
            toast_sureli[0].show();
            if(handler == null) {
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast_sureli[0].cancel();
                    }
                }, millisec);
            }
        }
    }
}
