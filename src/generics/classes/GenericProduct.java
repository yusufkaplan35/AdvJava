package generics.classes;
//generic olarak sadece PRIMITIVE data tipleri kullanılamaz
public class GenericProduct <T>{
    /*
        E --> Element, collection gibi yapılarda kullanılır
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V , vb --> 2., 3. ve 4. tipler için
         */

    private T code;

    private String name; // bütün fieldlar generic tipte olmak zorunda değil
    //getter-setter
    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }



}
