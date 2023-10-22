package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        //Generic yapılarda hangi data tipini kullanacağımıza sonradan karar verebiliriz.
        //Java 7den sonra sağ tarafta data tipini yazmaya gerek kalmadı.
        GenericProduct <String> book = new GenericProduct<>();
        book.setCode("advjava");
        String str = book.getCode(); //CTE vermedi, CAST problemi çözüldü.
                                     //ClassCastException hatası da engellendi.

        GenericProduct <Integer> laptop = new GenericProduct<>();
        laptop.setCode(123);

        Integer str2 = laptop.getCode();

        GenericProduct <String> phone = new GenericProduct<>();
//        phone.setCode(123); // generics tür güvenliği sağlar


//        GenericProduct <double> obj = new GenericProduct<>(); // sadece NON-PRIMITIVE

        ArrayList<String> list = new ArrayList<>();
       // list.add(123);

        HashMap<String,Integer> map = new HashMap<>();
        map.put("advjava",99);

        // ----------------------ÇOK PARAMETRELİ CLASS ---------------------

        GenericClassTwoParam <Integer,String> mymap = new GenericClassTwoParam<>(11,"generic");

        GenericClassTwoParam <Integer,Integer> mymap2 = new GenericClassTwoParam<>(11,99);













    }
}
