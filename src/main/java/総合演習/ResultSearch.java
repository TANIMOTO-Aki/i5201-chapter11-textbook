import java.util.StringTokenizer;

public class ResultSearch {
    FileIn fi = new FileIn();
    KeyIn ki = new KeyIn();

    final String STR_COMMA = ",";
    final String END_SEARCH = "";

    String[] arrayNumber;
    String[] arrayName;
    int[] arrayScore;

    String fileName;
    int count = 0;
    boolean check = false;

    public static void main(String[] args) {
        ResultSearch rs = new ResultSearch();

        /* ファイル名を入力、オープンし、レコード行数をカウントする */
        rs.recordCount();

        /* カウント数をもとに配列を生成する */
        rs.generateArray();

        /* 再度ファイルをオープンし、配列にデータを格納する */
        rs.dataStorage();

        /* 入力された学籍番号を検索し、対応するデータを表示する */
        rs.resultSearch();

    }

    /* レコード数をカウントし、カウント数を返すメソッド */
    private void recordCount(){
        String buf;

        fileName = ki.readKey("成績ファイル名:");
        fi.open(fileName);

        while (true){
            buf = fi.readLine();
            if(buf == null)break;
            count += 1;
        }

        fi.close();
        return;
    }

    /* カウント数を基に配列を生成するメソッド */
    private void generateArray(){
        arrayNumber = new String[count];
        arrayName = new String[count];
        arrayScore = new int[count];
        return;
    }

    /* 配列にレコードデータを格納するメソッド */
    private void dataStorage(){
        String buf;
        fi.open(fileName);
        for (int i = 0;i < count;i++){
            buf = fi.readLine();
            StringTokenizer tkn = new StringTokenizer(buf, STR_COMMA);
            arrayNumber[i] = tkn.nextToken();
            arrayName[i] = tkn.nextToken();
            arrayScore[i] = Integer.parseInt(tkn.nextToken());
        }
        fi.close();
        return;
    }

    /* 指定された学籍番号を検索し、該当する結果を表示するメソッド */
    private void resultSearch(){
        String searchNum;
        while(!(searchNum = ki.readKey("検索対象番号:")).equals("")){
            for(int i =0;i < count; i++){
                if(searchNum.equals(arrayNumber[i])){
                    System.out.println("学籍番号:" + arrayNumber[i] + "\n" + "氏名　　:" + arrayName[i] + "\n" + "点数　　:" + arrayScore[i]);
                    check = true;
                    break;
                }
            }
            if(check == false){
                System.out.println("指定した学籍番号のデータは見つかりませんでした");
            }else{
                check = false;
            }
        }
        return;
    }
}