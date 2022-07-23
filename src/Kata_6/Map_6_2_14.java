package Kata_6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Map_6_2_14 {
    public static Map<String, Long> getSalesMap(Reader reader) {
        HashMap<String, Long> manager = new HashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            String name = scanner.next();
            Long sum = scanner.nextLong();
            Long getSalesMap = manager.merge(name, sum, Long::sum);
        }
        System.out.println(manager);
        scanner.close();
        return manager;
    }

    public static void main(String[] args) {
//        try (FileReader reader = new FileReader("D:\\Cloud Mail.Ru\\JavaRush\\src\\Kata_6\\test.txt")){
        try (FileReader reader = new FileReader("D:\\Cloud Mail.Ru\\JavaRush\\src\\test")){
                getSalesMap(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(getSalesMap());
    }

} //End
// Работа метода getSalesMap должна удовлетворять условию
/*
HashMap
Scanner - внутри reader
Цикл(сканер)
две переменные
merge
return
Если взять из нашей задачи Антона , то получается что имя(Антон) это ключ (s),
а сумма продаж это значение(m) , в итоге Антон сначала продал на 3000 , потом еще на 8000,
а в общем получается 11000((oldm, newm) -> oldm + newm)/
 */