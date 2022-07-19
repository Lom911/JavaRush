package Kata_5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputByte {
    public static int sumOfStream(InputStream inputStream) throws IOException {
        int x = -1;
        int sum = 0;
        while ((x = inputStream.read()) != -1){
            sum += (byte) x;
        }
        inputStream.close();
        return sum;
    }


    public static void main(String[] args) {
        byte[] bytes = {3, 5, 7, 10};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            System.out.println(sumOfStream(inputStream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
