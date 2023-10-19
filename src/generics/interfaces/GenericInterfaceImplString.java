package generics.interfaces;
//2.SEÇENEK: GenericInterface i implemente ederken classın da generic olmasını istemiyorsak data tipine karar verilmeli
public class GenericInterfaceImplString implements GenericInterface <String>{


    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public String get(Integer x) {
        return null;
    }
}
