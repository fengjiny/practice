package test;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args) {
        String cityCOde_2018_12_07  = "010\n" +
                "021\n" +
                "0311\n" +
                "0531\n" +
                "0351\n" +
                "024\n" +
                "0551\n" +
                "0773\n" +
                "025\n" +
                "0571\n" +
                "0471\n" +
                "0472\n" +
                "0539\n" +
                "0537\n" +
                "0538\n" +
                "0536\n";
        test4(cityCOde_2018_12_07);

    }

    public static void test1() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        ScheduledFuture future = executor.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("60 seconds later");
                    }
                }, 60, TimeUnit.SECONDS);
        executor.shutdown();
    }


    public static void test2() {
        Hashtable hashtable = new Hashtable();
        HashMap hashMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        TreeMap treeMap = new TreeMap();

        hashtable.put(null, null);
        hashMap.put(null, null);
        concurrentHashMap.put(null, null);
        treeMap.put(null, null);
    }

    private static void test3(String citiCodeStr) {

        List<String> cityCodes = new ArrayList<>();
        Pattern p = Pattern.compile("(.*?)\\n");
        Matcher m = p.matcher(citiCodeStr);

        while (m.find()) {
            String res = m.group(1);
            cityCodes.add(res);
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");


        cityCodes.forEach(cityCode -> {
            sb.append('"');
            sb.append(cityCode);
            sb.append('"');
            sb.append(",");
            System.out.println(cityCode);
        });
        sb.deleteCharAt(sb.length() - 1);


        sb.append("]");
        List list = new LinkedList();
        System.out.println(sb.toString());
    }

    private static void test4(String cityCodeStr) {
        String[] cityCodeArray = cityCodeStr.split("\n");
        int lenth = cityCodeArray.length;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < lenth; ++i) {
            sb.append('"');
            sb.append(cityCodeArray[i]);
            sb.append('"');
            if (i < lenth - 1) {
                sb.append(",");
            }
            System.out.println(cityCodeArray[i]);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
