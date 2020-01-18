package com.example.secapp;

public class security {

    //secret key
    String key ="SECURITY";

    //encryption's methods
    public static Pair splitAndRearrange(String exp) { //split plaintext into 2 blocks (Even & odd)

        int counteven = 0;
        int countodd = 0;

        for (int i = 0; i < exp.length(); i++) { //counting how many even index and odd index

            if (i % 2 == 0) {
                ++counteven;
            } else {
                ++countodd;
            }
        }

        boolean isFixed = false;
        if(counteven != countodd){ //check fixed size
            countodd +=1;
            isFixed = true;
        }

        //initialize 2 blocks
        char[] arryEven = new char[counteven];
        char[] arryOdd = new char[countodd];

        for (int i = 0, j = 0, k = 0; i < exp.length(); i++) {//rearrange the characters depends on the indexes

            if (i % 2 == 0) {
                arryEven[k++] = exp.charAt(i);

            } else {

                arryOdd[j++] = exp.charAt(i);
            }

        }
        if(isFixed) //if arrayOdd block is not fixed , add X
        arryOdd[arryOdd.length-1]='X';

        Pair pair = new Pair(arryEven, arryOdd);
        return pair; // return the 2 blocks

    }

    public  char[] XOR(char[] text) { //XOR with the key

        char[] KeyArr = new char[key.length()];
        char[] cipherText = new char[text.length];
        int[] cipherTextInteger = new int[text.length];//cipherText to int


        for (int i = 0; i < key.length(); i++) { //fill the array with the key characters
            KeyArr[i] = key.charAt(i);
        }

        for (int i = 0, q = 0; i < text.length; i++, q++) {//perform XOR operation

            //convert each character to the corresponding number by using valueOf method
            int k = valueOf(KeyArr[i%KeyArr.length]);
            int x = valueOf(text[i]);

            cipherTextInteger[i] = (x ^ k);

        }
        //convert each number to the corresponding character by using charOf method
        for (int k = 0; k < cipherTextInteger.length; k++) {
            cipherText[k] = charOf(cipherTextInteger[k]);
        }

        return cipherText;//return the text after XOR operation

    }

    public  char[] swapAndMerge(Pair p) { //swap the 2 blocks and merge them

        char[] arrayEven = p.getFirst();
        char[] arrayOdd = p.getSecond();

        int size = arrayEven.length + arrayOdd.length;
        char[] merge = new char[size];

        int k = 0;
        for (; k < arrayOdd.length; k++) {//starting merge with arrayOdd
            merge[k] = arrayOdd[k];
        }

        for (int i = k, j = 0; j < arrayEven.length; i++, j++) {//then merge with arrayEven
            merge[i] = arrayEven[j];
        }

        return merge;//return cipher text

    }

    //decryption's methods
    public  Pair splitAndSwap(char[] cipher) {//spilt the 2 blocks and swap them

        int counteven = 0;
        int countodd = 0;

        for (int i = 0; i < cipher.length; i++) { //counting how many even index and odd index

            if (i % 2 == 0) {
                ++counteven;
            } else {
                ++countodd;
            }
        }
        //initialize 2 blocks
        char[] arrayEven = new char[counteven];
        char[] arrayOdd = new char[countodd];

        // split the cipher text into two blocks
        int k = 0;
        for (; k < countodd; k++) {

            arrayOdd[k] = cipher[k];
        }

        for (int i = 0; i < counteven; i++) {
            arrayEven[i] = cipher[k++];
        }
        //The cipher was starting with arrayOdd then the arrayEven so we apply the swap operation
        //the first parameter is arrayEven and the second one is arrayOdd
        Pair pair = new Pair(arrayEven, arrayOdd);

        return pair; //return the swapped blocks
    }

    //XOR Method same as encryption

    public  char[] rearrangeAndMerge(Pair pair) {//rearrange the two blocks and merge them

        char[] arrayEven = pair.getFirst();
        char[] arrayOdd = pair.getSecond();

        int size = arrayEven.length + arrayOdd.length;
        char[] marge = new char[size];

        for (int i = 0, j = 0, k = 0; i < size; i++) {//starting rearrange the two blocks and merge them
            if (i % 2 == 0) {
                marge[i] = arrayEven[j++];
            } else {
                marge[i] = arrayOdd[k++];
            }
        }

        return marge;//return plaintext
    }


    //our tables that convert the character to number and vice versa.
    public  int valueOf(char ch) { //convert the character to integer
        int returnX = 0;
        switch (ch) {

            case 'A':
                returnX = 0;
                break;

            case 'B':
                returnX = 1;
                break;

            case 'C':
                returnX = 2;
                break;

            case 'D':
                returnX = 3;
                break;

            case 'E':
                returnX = 4;
                break;

            case 'F':
                returnX = 5;
                break;

            case 'G':
                returnX = 6;
                break;

            case 'H':
                returnX = 7;
                break;

            case 'I':
                returnX = 8;
                break;
            case 'J':
                returnX = 9;
                break;

            case 'K':
                returnX = 10;
                break;

            case 'L':
                returnX = 11;
                break;

            case 'M':
                returnX = 12;
                break;

            case 'N':
                returnX = 13;
                break;

            case 'O':
                returnX = 14;
                break;

            case 'P':
                returnX = 15;
                break;

            case 'Q':
                returnX = 16;
                break;

            case 'R':
                returnX = 17;
                break;

            case 'S':
                returnX = 18;
                break;

            case 'T':
                returnX = 19;
                break;

            case 'U':
                returnX = 20;
                break;

            case 'V':
                returnX = 21;
                break;

            case 'W':
                returnX = 22;
                break;

            case 'X':
                returnX = 23;
                break;

            case 'Y':
                returnX = 24;
                break;

            case 'Z':
                returnX = 25;
                break;
            case '0':
                returnX = 26;
                break;

            case '1':
                returnX = 27;
                break;

            case '2':
                returnX = 28;
                break;

            case '3':
                returnX = 29;
                break;

            case '4':
                returnX = 30;
                break;

            case '5':
                returnX = 31;
                break;

            case '6':
                returnX = 32;
                break;

            case '7':
                returnX = 33;
                break;

            case '8':
                returnX = 34;
                break;

            case '9':
                returnX = 35;
                break;

        }

        return returnX;
    }

    public  char charOf(int ch) { //convert the integer to character
        char returnX = ' ';

        switch (ch) {

            case 0:
                returnX = 'A';
                break;

            case 1:
                returnX = 'B';
                break;

            case 2:
                returnX = 'C';
                break;

            case 3:
                returnX = 'D';
                break;

            case 4:
                returnX = 'E';
                break;

            case 5:
                returnX = 'F';
                break;

            case 6:
                returnX = 'G';
                break;

            case 7:
                returnX = 'H';
                break;

            case 8:
                returnX = 'I';
                break;
            case 9:
                returnX = 'J';
                break;

            case 10:
                returnX = 'K';
                break;

            case 11:
                returnX = 'L';
                break;

            case 12:
                returnX = 'M';
                break;

            case 13:
                returnX = 'N';
                break;

            case 14:
                returnX = 'O';
                break;

            case 15:
                returnX = 'P';
                break;

            case 16:
                returnX = 'Q';
                break;

            case 17:
                returnX = 'R';
                break;

            case 18:
                returnX = 'S';
                break;

            case 19:
                returnX = 'T';
                break;

            case 20:
                returnX = 'U';
                break;

            case 21:
                returnX = 'V';
                break;

            case 22:
                returnX = 'W';
                break;

            case 23:
                returnX = 'X';
                break;

            case 24:
                returnX = 'Y';
                break;

            case 25:
                returnX = 'Z';
                break;
            case 26:
                returnX = '0';
                break;

            case 27:
                returnX = '1';
                break;

            case 28:
                returnX = '2';
                break;

            case 29:
                returnX = '3';
                break;

            case 30:
                returnX = '4';
                break;

            case 31:
                returnX = '5';
                break;

            case 32:
                returnX = '6';
                break;

            case 33:
                returnX = '7';
                break;

            case 34:
                returnX = '8';
                break;

            case 35:
                returnX = '9';
                break;

        }

        return returnX;
    }
}







