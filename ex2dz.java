// Пусть дан список сотрудников:Иван Иванов и т.д.
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.   v
import java.util.HashMap;
import java.util.Map;
import java.lang.Iterable;
import java.util.List;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.Scanner;

public class ex2dz{ 
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        Map<Integer, String> names = new HashMap<>();

        int call = 5; // Колличество человек в словаре)
        for (int i = 1; i < call; i++) {
            System.out.print("Введите имя и фамилию: ");
            String[] name = iScanner.nextLine().split(" ");
            names.put(i, name[1]);
        }

        int count = 1;

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> el : names.entrySet()) {
            if (result.containsKey(el.getValue())){
                count++;
                result.put(el.getValue(), count);
            }
            else{
                count = 1;
                result.put(  el.getValue(),count);
            }   
        
        }
        ArrayList arraylist = new ArrayList();         

        for (Map.Entry<String, Integer> el : result.entrySet()) {
            arraylist.add(el.getValue());
        }
        Collections.sort(arraylist);

        for ( Map.Entry<String, Integer> el : result.entrySet()) {
            for (Map.Entry<Integer, String> ge : names.entrySet()) {
                if (el.getValue() == ge.getKey()){
                    System.out.println(el);
                }
            }
        }
        iScanner.close();
    }
}