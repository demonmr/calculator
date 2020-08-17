package javaTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator  {
    public static void main(String[] args) {
        //Создание обьекта для получения строки с консоли
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try {
            //бесконечный цикл для получения строки, пока не будет введена строка xit
            while (!(str=bufferedReader.readLine()).equals("exit")){
                Operations operations = new Operations(str);
                System.out.println(operations.performOperations());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
