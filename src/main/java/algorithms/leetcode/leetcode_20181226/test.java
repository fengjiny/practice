package algorithms.leetcode.leetcode_20181226;

public class test {
    private static final int INTERVAL_5000_8000 = 3000;
    private static final int INTERVAL_8000_20000 = 12000;

    private static void tax(double salary, double socialInsuranceBase , double threshold) {
        salary -= socialInsurance(socialInsuranceBase);
        if (salary <= threshold) return;
        salary -= threshold;
        Double t1 = salary  > INTERVAL_5000_8000 ? INTERVAL_5000_8000 * 0.03 : salary * 0.03;
        System.out.println("t1 : " + t1);
        if (salary <= INTERVAL_5000_8000) {
            return;
        }
        salary -= INTERVAL_5000_8000;
        Double t2 = salary > INTERVAL_8000_20000 ? INTERVAL_8000_20000 * 0.1 : salary * 0.1;
        System.out.println("t2 : " + String.format("%.2f", t2));
        System.out.println("The total tax is : " + String.format("%.2f", t1 + t2));
    }

    private static double socialInsurance(double socialInsuranceBase) {
        double gongjijin = socialInsuranceBase * 0.12;
        double yanglao = socialInsuranceBase * 0.08;
        double yiliao = socialInsuranceBase * 0.02;
        double shiye = socialInsuranceBase * 0.002;
        return gongjijin + yanglao + yiliao + shiye;
    }

    public static void main(String[] args) {


    }
}
