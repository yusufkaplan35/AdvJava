package enumtypes;

import java.lang.ref.PhantomReference;

import static enumtypes.PasswordStrengthConstant.*;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrength("LOW");
        printPasswordStrength("MEDIUM");
        printPasswordStrength("hıgh"); // mesaj yazılmadı, CTE yok, RTE yok
        System.out.println("-----------------------------");

        printMessageByEnum(PasswordStrengthEnum.LOW);
        printMessageByEnum(PasswordStrengthEnum.MEDIUM);
        printMessageByEnum(PasswordStrengthEnum.HIGH);

    }

    //şifrenin gücünü yazdıran method: static final sabit
    public static void printPasswordStrength(String strength){

        if (strength.equals(LOW)){
            System.out.println("Password gücünüz düşüktür!!!");
        } else if (strength.equals(MEDIUM)) {
            System.out.println("Password gücünüz orta seviyededir!!!");
        }else if (strength.equals(HIGH)) {
            System.out.println("Password gücünüz yüksektir...");
        }
    }

    //enumla method
    public static void printMessageByEnum(PasswordStrengthEnum strength){
        //if (strength.ordinal()==0) kullanılabilir ama readible değil .

        if (strength.equals(PasswordStrengthEnum.LOW)){
            System.out.println("Password gücünüz düşüktür!!!");
            System.out.println("Seviyesi: "+ strength.getLevel()); //10

        } else if (strength.equals(PasswordStrengthEnum.MEDIUM)) {
            System.out.println("Password gücünüz orta seviyededir!!!");

        } else if (strength.equals(PasswordStrengthEnum.HIGH)) {
            System.out.println("Password gücünüz yüksektir....");

        }
        System.out.println("Enum ismi: "+ strength.name());
        System.out.println("Enum sırası: " +strength.ordinal());
    }



}
