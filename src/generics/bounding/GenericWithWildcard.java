package generics.bounding;

import generics.classes.GenericProduct;

import java.util.ArrayList;
import java.util.List;

//wildcard:joker, bilinmeyen data tipi: ?
public class GenericWithWildcard {
    public static void main(String[] args) {

        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        List<Object> objectList=new ArrayList<>();
        System.out.println("----------------alttan sınırlama----------------------------------------");

        addElements(integerList);
        System.out.println(integerList);
        //addElements(doubleList);
        //addElements(stringList);
        addElements(numberList);
        addElements(objectList);

        System.out.println("----------------üstten sınırlama----------------------------------------");
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        //multiplyByTwo(stringList);
        multiplyByTwo(numberList);
        //multiplyByTwo(objectList);

        System.out.println("----------------List<?>----------------------------------------");
        printElements(integerList);
        printElements(stringList);
        printElements(numberList);
        printElements(objectList);

        System.out.println("----------------List<Object>----------------------------------------");
        printElementsByObject(objectList);
        //printElementsByObject(stringList);//List<Object>--> List<String> in parentı değildir.

        //-------------------------------------------------------------------------------
        GenericProduct<? super Integer> product=new GenericProduct<>();
        //product.setCode("java");
        product.setCode(11);



    }

    //alttan sınırlama
    //Integer ve Integerın parentları ile oluşturulan
    // listeye 1 den 10 a kadar sayıları ekleyen bir metod yazalım
    //Integer,Number,Object
    public static void addElements(List<? super Integer> list){

        for (int i=1;i<=10;i++){
            list.add(i);
        }
    }

    //üstten sınırlama
    //? wildcard:read-only
    public static void multiplyByTwo(List<? extends Number> list){

        //list.add(11);
        //list.add("java");
        list.add(null);

        list.stream().map(t->2*t.intValue()).forEach(t-> System.out.print(t+" "));

    }

        //wildcard:data tipinden bağımsız metodlara izin verir. ex:remove,size

    public static void printElements(List<?> list){

        //list.stream().forEach(t-> System.out.print(t+" "));
        for (Object o:list){
            System.out.println(o);
        }

    }


        //NOT: List<T> ile List<?> birebir aynı değildir.

    public static void printElementsByObject(List<Object> list){

        list.add(11);
        list.add("java");

        //list.stream().forEach(t-> System.out.print(t+" "));
        for (Object o:list){
            System.out.println(o);
        }

    }




}