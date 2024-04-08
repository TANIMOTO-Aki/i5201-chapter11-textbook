public class Euclid {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();     // キーボード入力クラス
        int div;                    // 除数
        int rem;                    // 剰余
        int gcd;                    // 最大公約数
        int lcm;                    // 最小公倍数
        final int MAXIMUM = 40000;
        final int MINIMUM = 0;

        /* 最大公約数と最小公倍数を求める2つの数値を入力する */
        try{
            int a = ki.readInt("a:");   // aの入力
            int b = ki.readInt("b:");   // bの入力
            while((a <= MINIMUM || a >= MAXIMUM) || (b <= MINIMUM || b >= MAXIMUM)){
                System.out.println("1~39999までの値を入力してください");
                a = ki.readInt("a:");
                b = ki.readInt("b:");
            }
            gcd = a;
            div = b;

            while(0 < div){
                rem = gcd % div;
                gcd = div;
                div = rem;
            }
            lcm = (a * b) / gcd;
            System.out.println("GCD = " + gcd);
            System.out.println("LCM = " + lcm);
        }catch (ArithmeticException e){
            System.out.println("0:" + e);
            System.exit(1);
        }
    }
}