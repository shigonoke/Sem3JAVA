package ru.geekbrains.api.lesson3;

import java.util.ArrayList;
import java.util.Random;

import javax.print.attribute.standard.NumberUp;

public class Program{

    static ArrayList<ArrayList<String>> catalog = new ArrayList<>();

    public static void main(String[] args) {

        homework1();
        Person person1 = new Person();
        person1.age = 32;
        person1.name = "User";

        Person person2 = new Person();
        person2.age = 32;
        person2.name = "User";

        int a = 12;
        String s = "Hello!";
        boolean f = false;
        System.out.println(a + " " + s + " " + f + " " + person1);

        int x = 5;
        int y = 5;
        int z = -5;
        String str1 = new String("Hello!");
        String str2 = new String("Hello!");

        System.out.println(x == y);
        System.out.println(x == z);
        System.out.println(person1 == person2);
        System.out.println(person1.equals(person2));
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        task1();

        Object[] objArray = new Object[1000];
        MyList list = new MyList(objArray);
        list.add("Hello!");
        list.add(12);

        Person[] personArray = new Person[1000];
      
        MyList<Person> list2 = new MyList<Person>(personArray);
        list2.add(person2);
        list2.add(person1);

        task2();
    }

    /**
     * Создать список типа ArrayList<Object>. Поместить в него как строки,
     * так и целые числа. Пройти по списку, найти и удалить целые числа.
     */
    static void task1(){
        Person person1 = new Person();
        person1.age = 32;
        person1.name = "User";

        ArrayList array1 = new ArrayList();
        array1.add(person1);
        array1.add(false);
        array1.add(12);
        array1.add(15.24);
        array1.add("Hello!");

        for (Object object : array1) {
            if (object instanceof Person){
                System.out.println("Возраст: " + ((Person)object).age);
            }
           
        }
    }


    /**
     * Задача:
     * Каталог товаров книжного магазина сохранен в виде двумерного
     * списка ArrayList<ArrayList<String>> так, что на 0й позиции каждого внутреннего списка
     * содержится название жанра, а на остальных позициях - названия книг.
     * Напишите метод для заполнения данной структуры.
     */
    static void task2(){

        
        addBook("Поэма", "Книга #1");
        addBook("Поэма", "Книга #2");
    
        addBook("Поэма", "Книга #3");
        
        addBook("Пьеса", "Книга #1");

        printCatalog();
            
    }



    static void addBook(String genre, String bookName){
        for (ArrayList<String> books : catalog){
            if (books != null && books.size() > 0 && books.get(0).equals(genre)){
                books.add(bookName);
                return;
            }
        }
        ArrayList<String> books = new ArrayList<>();
        books.add(genre);
        books.add(bookName);
        catalog.add(books);
    }

    static void printCatalog()
    {
        int i = 0;
        boolean f = true;
        while(f){
            f = false;
            for (ArrayList<String> books : catalog){
                if (books != null && books.size() > i){
                    f = true;
                    System.out.printf("%s\t\t", books.get(i));
                }
            }
            System.out.println();
            i++;
        }
    }
    
    static Random random = new Random();

    // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа

    // 3  Задан целочисленный список ArrayList.
    //  Найти минимальное, максимальное и среднее из этого списка.
    static void homework1()
    {
        ArrayList<Integer> list = new ArrayList<>();
        int size = random.nextInt(10, 20);
        for (int i = 0; i < size; i++){
            list.add(random.nextInt(-9, 10));
        }
        System.out.println(list);
    }

}


/*class MyPersonList{
    private Person[] arr;
    int index = 0;
    public MyPersonList(Person[] arr){
        this.arr = arr;
    }

    public void add(Person obj){
        arr[index] = obj;
        index++;
    }

}*/

class MyList<E>{
    private E[] arr;
    int index = 0;
    public MyList(E[] arr){
        this.arr = arr;
    }

    public void add(E obj){
        arr[index] = obj;
        index++;
    }

}

class Person{

    String name;
    int age;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person){
           Person p = (Person)obj;
           if (age == p.age)
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" +  name + "; " + age +  "]";
        //return super.toString();
    }

}