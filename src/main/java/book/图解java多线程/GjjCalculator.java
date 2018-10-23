package book.图解java多线程;

import java.text.DecimalFormat;

public class GjjCalculator {
    static DecimalFormat df = new DecimalFormat("#.00");
    public static void main(String[] args) {
        double total = 0;
        System.out.println("按照程序员普遍能达到的社保上限来算，每月公积金约等于6000，一年72000， 年利率4%。");
        for (int i = 1; i <= 12; ++i) {
            total += totalGjj(i, 72000, 1.04);
        }
        System.out.println("每年都取出来理财,最后总数：" + df.format(total));
        System.out.println("粗略估算，不考虑每年公积金调整，加息等因素");
    }
    private static double totalGjj(int year, double base, double rate) {

        rate = Math.pow(rate, year);
        double total = base * rate;
        System.out.println("存进银行" + year +"年：" + df.format(total));
        return total;
    }
}
