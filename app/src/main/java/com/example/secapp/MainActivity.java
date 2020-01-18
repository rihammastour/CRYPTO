package com.example.secapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {
    EditText plain, cypher;
    private Button buttonEnc, ButtonDec;
    private TextView outputEnc;
    private TextView outputDec;
    private security enc;
    private security dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerOnButton2();

    }

    public void addListenerOnButton() {
        plain = (EditText) findViewById(R.id.plain_text_input);
        buttonEnc = (Button) findViewById(R.id.encryptButton);
        outputEnc = (TextView) findViewById(R.id.textView);
        enc = new security();

        buttonEnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String exp = plain.getText().toString();
                String cipher = "";

                for (int j = 0; j <3; j++) { //3 rounds
                    char[] swap = null;
                    cipher = "";

                    Pair pair = enc.splitAndRearrange(exp);
                    pair.setFirst(enc.XOR(pair.getFirst()));
                    pair.setSecond(enc.XOR(pair.getSecond()));
                    swap = enc.swapAndMerge(pair);

                    for (int i = 0; i < swap.length; i++) {
                        cipher += swap[i];
                    }
                    exp = cipher;
                }


                String plainInput = plain.getText().toString();

                if(TextUtils.isEmpty(plainInput)) {// if the user entrs empty text [1]
                    plain.setError("Please enter the text to encrypt!");
                    return;
                }

                outputEnc.setText(cipher);//output
                ((EditText) findViewById(R.id.plain_text_input)).getText().clear(); //clear input box [3]


            }
        });

    } //encryption button

    public void addListenerOnButton2() {
        cypher = (EditText) findViewById(R.id.cypher_text_input);
        ButtonDec = (Button) findViewById(R.id.decryptButton);
        outputDec = (TextView) findViewById(R.id.textView);
        dec = new security();

        ButtonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               char[] plain = null;
                String str = cypher.getText().toString();
                char[] charArray = str.toCharArray();


                for (int j = 0; j <3; j++) { // 3 rounds

                    plain = null;
                    Pair pair = dec.splitAndSwap(charArray);
                    pair.setFirst(dec.XOR(pair.getFirst()));
                    pair.setSecond(dec.XOR(pair.getSecond()));
                    plain = dec.rearrangeAndMerge(pair);


                    charArray = plain;
                }

                String s = "";
                for (int i = 0; i < plain.length; i++) {
                    s += plain[i];
                }

                String cipherInput = cypher.getText().toString();
                if(TextUtils.isEmpty(cipherInput)) {// if the user entrs empty text
                    cypher.setError("Please enter the text to decrypt!");
                    return;
                }
                outputDec.setText(s);
                ((EditText) findViewById(R.id.cypher_text_input)).getText().clear();//clear input box
            }
        });

    } //decryption button

}

/*
[1] field, T. and Shan, H. (2019). TextUtils setError() displays in wrong EditText field. [online] Stack Overflow. Available at: https://stackoverflow.com/questions/40227948/textutils-seterror-displays-in-wrong-edittext-field [Accessed 18 Nov. 2019].
[2] How can restrict my EditText input to some special character like backslash(/), t., Zalavadia, B., Bisht, H. and Bhatiya, A. (2019). How can restrict my EditText input to some special character like backslash(/),tild(~) etc by soft keyboard in android programmatically. [online] Stack Overflow. Available at: https://stackoverflow.com/questions/21828323/how-can-restrict-my-edittext-input-to-some-special-character-like-backslash-t [Accessed 18 Nov. 2019].
[3] setText(&ldquo;&rdquo;);, H. and Shr, N. (2019). How to empty edittext without setText("");. [online] Stack Overflow. Available at: https://stackoverflow.com/questions/17967404/how-to-empty-edittext-without-settext [Accessed 18 Nov. 2019].
 */
