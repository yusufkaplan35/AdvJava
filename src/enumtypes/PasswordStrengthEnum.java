package enumtypes;

public enum PasswordStrengthEnum {
    /*
    enum ile sınırlı sayıda sabit değişkenler tanımlarız.
    Değişken isimleri(genellikle büyük harflerle ) virgülle ayrılarak
    listelenir. Default olarak static ve finaldır. Değişken isimleri birlikte
    ayrıca özellik/ler eklemek istersek private final tipinde field tanımlayabiliriz.
    Bu fieldın değeri parametreli constructor ile set edilir. Bu fieldın okunabilmesi için
    getter metodu oluşturulur.
     */

    LOW(10),
    MEDIUM(30),
    HIGH(50);

    private final int level;

    public int getLevel() {
        return level;
    }

    PasswordStrengthEnum(int level) {
        this.level=level;

    }

}
