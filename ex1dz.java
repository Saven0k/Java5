// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class ex1dz{
    
    public static Map<String, List> phoonebook = new HashMap<>();
    public static void main(String[] args){
        
        
        Scanner iScanner = new Scanner(System.in);
        while(true){
            System.out.print("Выберете что вы хотите сделать\n1 - Просмотреть контакты\n2 - Записать новый контакт\n3 - Удалить контакт(дорабатывается)\n0 - Выйти\n:");
            int variant = iScanner.nextInt();
            if (variant == 1){
                View();
                log("Пользователь выбрал Просмотреть контакты ");
            }
            else if (variant == 2){
                log("Пользователь выбрал  Записать новый контакт");
                WR();
            }
            else if (variant == 3){
                log("Пользователь выбрал  Удалить контакт ");
                System.out.print("Человека с какой фамилией вы хотите удалить из своих контактов?\n:");
                String scn = iScanner.nextLine();
                Delete(scn);
            }
            else if (variant == 0){
                break;
            }
        }
        iScanner.close();  
    }
    public static void View(){

        try(FileReader tfr = new FileReader("phonebook.txt"))
        {   
            char[] buffer = new char[8096];     
     
            int chars = tfr.read(buffer);
            while (chars != -1) {
                chars = tfr.read(buffer);
                System.out.println(chars);
            }
        }
        catch(IOException ex){  
             
            System.out.println(ex.getMessage());
        }
    }
    public static void WR(){
        
        try(FileWriter fw = new FileWriter("phonebook.txt"))
        {   
            Scanner iScanner = new Scanner(System.in);
            
            System.out.println("Введите фамилию:");
            String secondname = iScanner.nextLine();

            System.out.println("Введите номер(пример -- 79876543221(7-999-999-99-99)):");
            String kaif = iScanner.nextLine();
            List<String> number = new ArrayList<>();
            number.add(kaif);

            System.out.println("У него будет один номер?(1 - да/ 2 - нет):");
            
            Integer answer = iScanner.nextInt();

                if (answer == 1){
                    phoonebook.put(secondname, number);
                    String res = number.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));
                    fw.write(secondname + res);
                    fw.append('\n');
                    log("Пользователь решил вводить один номер");
                }
                else if (answer == 2){
                    System.out.print("Сколько номеров мы будем записывать?\n:");
                    int callnumbers = iScanner.nextInt();

                    log("Пользователь решил вводить есколько номеров("+callnumbers+")");
                    System.out.print("Вводите:\n ");

                    for (int i = 0; i < callnumbers; i++) {
                        number.add(iScanner.nextLine());
                    }
                    phoonebook.put(secondname, number);
                    fw.write(secondname + number + "\n");
                }
            iScanner.nextLine();
            
            fw.flush(); 
        }
        catch(IOException ex){  
            System.out.println(ex.getMessage());
        }
       
    }
    public static void log(String args){
        try(FileWriter fw = new FileWriter("log.txt", true))
        {   
            fw.write(args);
            fw.append('\n');
            fw.close();
        }
        catch(IOException ex){  
             
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static void Delete(String args){

    }
}
