public class SectionSearch {
    public static void main(String[] args) {
        KeyIn ki = new KeyIn();
        int[] arrayWeight = {50,75,100,150,200,250,500,750,1000,2000,3000,4000};
        int[] charge = {120,140,160,200,240,270,390,580,700,950,1150,1350};
        final int WEIGHT_LIMIT = 4000;
        final int WEIGHT_MINIMUM = 1;
        int weight;
        int i =0;

        weight = Integer.parseInt(ki.readKey("重量"));
        if (weight > WEIGHT_LIMIT || weight < WEIGHT_MINIMUM) {
            System.out.println("取り扱いできません");
        } else {
            while (weight > arrayWeight[i]) {
                i++;
            }
            System.out.println(charge[i] + "円");
        }
    }
}
