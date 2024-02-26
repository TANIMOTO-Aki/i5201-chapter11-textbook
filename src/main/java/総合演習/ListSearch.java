public class ListSearch {
    public static void main(String[] args) {
        final int END_OF_LIST = -1;         //リストの終端
        KeyIn ki = new KeyIn();             //キーボード入力クラス
        int[] arrayNum =    {20,40,10, 0,30, 0, 0, 0};  //配列番号
        int[] arrayScore =  {22,44,11, 0,33, 0, 0, 0};  //配列点数
        int[] arrayNext =   { 4,-1, 0, 5, 1, 6, 7,-1};  //配列次ポインタ
        int idx = 0;            //インデックス
        int lip = 2;        //リストの先頭を表すポインタ
        int eip = 3;        //空きリストの先頭を示すポインタ
        int num;            //入力する番号
        int kind;

        System.out.println("実行する機能を選択してください");
        while(0 <= (kind = ki.readInt("0:リスト表示,1:探索,2:追加,3:更新,4:削除(終了= -1 ):"))){
            switch (kind) {
            case 0:

            case 1:
            while(0<(num = ki.readInt("番号(戻る=0):"))){
                /* リスト探索 */
                idx = lip;
                while((idx != END_OF_LIST)&&(num != arrayNum[idx])){
                    idx = arrayNext[idx];
                }
            }
            /* 探索結果の表示 */
            if (idx != END_OF_LIST){
                System.out.println(arrayScore[idx]);           //成功
            }else{
                System.out.println("見つかりませんでした");     //失敗
            }
                break;

            case 2:

            case 3:

            case 4:
                    

            default:    //識別エラー
                System.out.println("識別の入力エラーです");
                break;
            }
        }
        System.out.println("---- プログラム終了 ----");
    }
}
