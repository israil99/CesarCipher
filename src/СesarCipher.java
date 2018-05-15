import java.util.ArrayList;
import java.util.List;

public class СesarCipher {

    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static int shift =3;

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public void setShift(int shift) {
        this.shift = shift;

    }


    public static String encode(String plainText) {
        String cypherText = "";
        ArrayList<Character> arrayList = new ArrayList<>(); //
        for (int i = 0; i <alphabet.length ; i++) {
            arrayList.add(alphabet[i]);             //конвертировал массив в Arraylist
        }

        if(shift>26)                               //задаем условие на случай, если если shift будет > 26
            shift=shift%26;

        int length = plainText.length();          //длина исходного текста
        for (int i = 0; i < length; i++) {
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)&&arrayList.contains(ch)){           //проверяем содержит ли исходный тест символы с алфавита
                char c = (char)(ch + shift);                              //если содержит, то применяем шифр
                if (c > 'z') {
                    cypherText += (char) (ch - (26 - shift));       //  ....x,y,z ---> a,b,c... шифрование по кругу
                } else {
                    cypherText += c;
                }

            }else {                            //если не содержит, то шифр не применяем
                cypherText += ch;
            }
        }return cypherText;                 // возвращаем зашифрованный текст
    }


    public static void main(String[] args) {
        System.out.println(encode("The quick brown fox jumps over the lazy dog"));
    }

}