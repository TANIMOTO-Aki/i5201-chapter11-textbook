public class BinarySearchTree {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();
        final int END_OF_TREE = -1;
        int[] arrayNum =    { 5, 2, 7, 9, 1, 3, 0, 0};  //学籍番号
        int[] arrayScore =  {50,20,70,90,10,30, 0, 0};  //点数
        int[] arrayLeft =   { 1, 4,-1,-1,-1,-1,-1,-1};  //左ポインタ部
        int[] arrayRight =  { 2, 5, 3,-1,-1,-1,-1,-1};  //右ポインタ部
        int pt = 0;                                     //先頭要素のポインタ
        int idx;                                        //インデックス
        int num;                                        //番号

        while(0 != (num = ki.readInt("学籍番号(終了=0):"))){
            /* 二分探索木の探索 */
            idx = pt;
            while(idx != END_OF_TREE && arrayNum[idx] != num){
                if(arrayNum[idx] < num){
                    idx = arrayRight[idx];
                }else{
                    idx = arrayLeft[idx];
                }
            }
            if(idx != END_OF_TREE){
                System.out.println("点数=" + arrayScore[idx]);
            }else{
                System.out.println("見つかりませんでした");
            }
        }
        System.out.println("---- プログラム終了 ----");
    }
}
