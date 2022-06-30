import java.io.File;
import java.nio.file.Path;

public class NoStati {
    public static void main(String[] args) {
        System.out.println("fffh");
    }
    public class ColliderUtil {

        public void readDataFromCollider(Path pathToData) {
            byte[] colliderData = readByteData(pathToData);
            String[] textData = convertBytesToSymbols(colliderData);
            File fileWithData = saveToFile(textData);
            printColliderData(fileWithData);
        }

        private byte[] readByteData(Path pathToData) {

            // считывает данные в байтах
            return readByteData(pathToData);
        }

        private String[] convertBytesToSymbols(byte[] colliderDataInBytes) {
            // конвертирует байты в символы
            String[] String = new String[0];
            return String;
        }

        private File saveToFile(String[] colliderData) {

            // сохраняет считанные данные в файл
            File File = null;
            return File;
        }

        private void printColliderData(File fileWithColliderData) {

            // печатает данные из файла
        }
    }
}