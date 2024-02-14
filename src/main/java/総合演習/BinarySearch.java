public class BinarySearch {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();
        int[] arrayScode = {101,102,181,201,283,430,550,800};
        String[] arraySname = {"事務机A型","事務机B型","脇机","会議用机",
                               "折り畳み机","木製机","学生机","応接机"};
        int mid = 0;        //中央のインデックス
        int hi,lo;      //上限、下限のインデックス
        boolean found;  //探索フラグ
        int scode;      //入力する商品コード

        found = false;                                              //フラグ設定
        scode = Integer.parseInt(ki.readKey("商品コード"));    //商品コード入力
        lo = 0;                     //下限
        hi = arrayScode.length-1;   //上限
        while (lo <= hi){           //繰り返し条件
            mid = (lo + hi)/2;      //探索位置の算出
            if (scode == arrayScode[mid]) {
                found = true;       //探索成功
                break;              //ループを抜ける
            } else {
                if (scode < arrayScode[mid]) {
                    hi = mid - 1;     //前半を探索
                } else {
                    lo = mid + 1;     //後半を探索
                }
            }
        }
        /* 探索結果の判定と表示 */
        if (found == true){
            System.out.println(arraySname[mid]);
        } else {
            System.out.println("登録されていない商品コードです");
        }
    }
}
