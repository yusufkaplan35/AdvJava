package generics.interfaces;
//1.SEÇENEK: GenericInterface i implemente eden class ta generic olmalı

public class GenericInterfaceImpl <T> implements GenericInterface <T>{


    @Override
    public void print(T value) {

    }

    @Override
    public T find() {
        return null;
    }

    @Override
    public String get(Integer x) {
        return null;
    }
}
