public class GuardSearch {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();
        int[] arrayScode = {102,800,201,101,283,430,181,550,-1};
        String[] arraySname = {"事務机B型","応接机","会議用机","事務机A型",
                               "折り畳み机","木製机","脇机","学生机",""};
        int idx;
        int scode;

        scode = Integer.parseInt(ki.readKey("商品コード"));     //商品コード入力
        arrayScode[arrayScode.length-1] = scode;                    //番兵設定

        /* 探索ループ */
        idx = 0;
        while (scode != arrayScode[idx]) {
            idx++;
        }

        if(idx < arrayScode.length-1) {             //探索結果の判定
            System.out.println(arraySname[idx]);    //成功
        } else {
            System.out.println("登録されていない商品コードです");   //失敗
        }
    }
}
