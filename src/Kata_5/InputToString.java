package Kata_5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class InputToString {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder str = new StringBuilder();
        int x = -1;
            InputStreamReader reader = new InputStreamReader(inputStream, charset);
            while (( x = reader.read()) != -1) {
                str.append((char) x);
        }
            reader.close();
            return str.toString();
    }






    public static void main(String[] args) {
        byte[] array = {48, 49, 50, 51};
        Charset charset = StandardCharsets.UTF_8;
        InputStream inputStream = new ByteArrayInputStream(array);
        try {
            System.out.println(readAsString(inputStream, charset)) ;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
