package generics.interfaces.example;

public class AccountRepo implements Repository<Account>{
    @Override
    public void save(Account object) {
        //DB ye bağlan
        //INSERT INTO

    }

    @Override
    public Account find() {
        return null;
    }
}