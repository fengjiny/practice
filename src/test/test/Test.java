package test;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args) {
//        HashMap hashMap = new HashMap();
//
//        for (int i = 0; i < 12; ++i) {
//            hashMap.put(i, i + "");
//        }
//        hashMap.put(1,11);
//        hashMap.put(1,12);
//        hashMap.put(1,13);
//        hashMap.put(1,14);
//        System.out.println(hashMap);
//        test2();
        test3();
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

    private static void test3() {
        String s = "027\n" +
                "0378\n" +
                "0393\n" +
                "0715\n" +
                "0724\n" +
                "028\n" +
                "0931\n" +
                "0838\n" +
                "1833\n" +
                "0816\n" +
                "0951\n" +
                "0831\n" +
                "0833\n" +
                "0817\n" +
                "0991\n" +
                "0875\n" +
                "0835\n" +
                "1994\n" +
                "020\n" +
                "0755\n" +
                "0592\n" +
                "0771\n" +
                "0754\n" +
                "0898\n" +
                "0756\n" +
                "0899\n" +
                "0595\n" +
                "0763\n" +
                "1754\n" +
                "0577\n" +
                "0551\n" +
                "0574\n" +
                "0510\n" +
                "0515\n" +
                "0519\n" +
                "0514\n" +
                "0517\n" +
                "0315\n" +
                "0531\n" +
                "0534\n" +
                "0312\n" +
                "0532\n" +
                "0411\n" +
                "0354\n" +
                "0536\n" +
                "0357\n" +
                "0472\n" +
                "0478\n" +
                "0543\n" +
                "0349\n";
        List<String> cityCodes = new ArrayList<>();
        Pattern p = Pattern.compile("(.*?)\\n");
        Matcher m = p.matcher(s);

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
}
