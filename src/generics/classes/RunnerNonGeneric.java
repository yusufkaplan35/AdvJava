package generics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {

        //2 farklı obje: book, laptop

        NonGenericProduct book = new NonGenericProduct();
        book.setCode("advjava"); //code değerini String ile set ettik

        NonGenericProduct laptop = new NonGenericProduct();
        laptop.setCode(123); //code değerini int ile set ettik

        String str = (String) book.getCode(); // CTE --> CAST problemi
        System.out.println(str);

        String str2 = (String) laptop.getCode();// CTE --> CAST problemi --> ClassCastException
        System.out.println(str2);




    }
}
