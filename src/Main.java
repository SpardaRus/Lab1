import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        MyList<BigInteger> mi=new MyList<>();

        mi.add(new BigInteger("54984984984984984899841"));
        mi.add(new BigInteger("5498498498498234234324534253425342549848998422222222222222222"));
        mi.add(new BigInteger("55756867777777777777594984984984984984899843"));
        mi.add(new BigInteger("54089707890789087908790984984984984984899845555"));
        mi.add(new BigInteger("54984989999999999999999999999999999999999999999998498498489984"));

        System.out.println(mi);
        System.out.println(" * "+mi.remove(2));
        System.out.println(mi);






    }
}
