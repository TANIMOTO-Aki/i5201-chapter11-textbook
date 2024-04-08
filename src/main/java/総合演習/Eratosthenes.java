public class Eratosthenes {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();         // キーボード入力クラス
        int i,j;                        // インデックス
        int count;                      // 個数

        int range = ki.readInt("いくつまで:");  // 素数を求める範囲
        while(range < 2){
            range = ki.readInt("2以上の整数を入力してください:");
        }
        int end = (int)(Math.sqrt(range));   // 判定の終端
        boolean[] arrayPrime = new boolean[range + 1];  // 配列の生成(初期値がfalseを利用)

        /* 初期値設定 */
        arrayPrime[2] = true;
        i = 3;
        while (i < arrayPrime.length) {
            arrayPrime[i] = true;
            i += 2;
        }

        /* n[添字]の倍数をfalseに設定 */
        i = 3;      // 3から開始
        while(i <= end){
            if(arrayPrime[i] == true){
                j = i * 2;
                while(j < arrayPrime.length){
                    arrayPrime[j] = false;
                    j += i;
                }
            }
            i += 2;
        }

        /* 素数の表示処理 */
        count = 0;        
        for(int k = 2; k < arrayPrime.length;k++){
            if(arrayPrime[k] == true){
                System.out.print(k + "\t");
                count++;
                if(count % 10 == 0)System.out.println();    // １０個ごとに改行
            }
        }
        System.out.println("\n" + count + "個");
    }
}
// コミットのテスト用