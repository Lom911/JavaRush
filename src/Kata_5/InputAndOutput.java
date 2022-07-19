package Kata_5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class InputAndOutput {
    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int x = -1;
        while ((x = inputStream.read()) != -1) {

            if (x % 2 == 0) {
                outputStream.write(x);
                outputStream.flush();

            }
        }
        inputStream.close();
        outputStream.close();
    }
    public static void main(String[] args) {
        byte[] bytes = {3, 5, -7, 10};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.out.println(Arrays.toString(bytes));
    }


}//End
