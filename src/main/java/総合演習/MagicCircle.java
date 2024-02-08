public class MagicCircle {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();         //キーボード入力クラス
        int degree;                     //何行何列の魔法陣か指定する
        int i,j;                          //インデックス

        /* 魔法陣の次数入力 */
        degree = Integer.parseInt(ki.readKey("奇数の魔法陣"));
        if ((degree < 0)||(degree % 2 == 0)) {
            System.out.println("１より小さいまたは偶数は使用できません:" + degree);
            System.exit(1);         //１より小さいOR偶数はエラー
        }else {
            /* 魔法陣作成 */
            int[][] circle = new int[degree][degree];   //配列魔法陣の生成
            i = 0;                              //ルール(a)「スタート位置」
            j = degree / 2;                     //（最上位の中央）
            circle[i][j] = 1;
            int k = 2;
            while (k <= degree*degree) {        //最終値は次数の2乗
                if (k % degree == 1) {          //ルール(d)(f)「下へ」
                    i++;                        //(次数の倍数は「下」になる)
                } else {
                    if (i == 0) {               //ルール(b)「配列の上側」
                        i = degree-1;           //(右側の最下位行へ)
                        j++;
                    } else {
                        if (j == degree-1) {    //ルール(c)「配列の右」
                            i--;                //（上の行の最左(先頭)列）
                            j = 0;
                        } else {
                            i--;                //ルール(e)「右上」
                            j++;                //（右斜め上の列へ）
                        }
                    }
                }
                circle[i][j] = k;
                k++;
            }
            /* 魔法陣の表示 */
            int sum = 0;
            for ( i = 0; i < degree; i++ ) {
                for ( j = 0; j < degree; j++ ){
                    System.out.print(circle[i][j] + "\t");
                    sum += circle[i][j];
                }
                System.out.println();
            }
            System.out.println("要素の和=" + sum/degree);
        }
    }
}

/* 
 * 魔法陣の作成方法「ド・ラ・ルーブルの法則」
 * １   最上位行の中央列に１を入れる(a)
 * ２   次の数字を右斜め上に入れる(e)
 *      このとき
 * ３   その位置が配列の上側であれば、配列の最下位列に入れる(b)
 * ４   その位置が配列の右であれば、配列の左端（先頭）に入れる(c)
 * ５   入れようとした場所に既に値（０以外）がある場合は、今入れた数字の下に入れる(d)(f)
 *      これは次数の倍数のときに発生するので「次数の倍数のとき下へ」とルール付けする
 * ６   以下、２へ戻り同じ要領で全要素を埋める
 */