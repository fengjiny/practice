package MJ_20190117;

import lombok.Data;

import java.util.*;

public class FindDuplicated{

    //查找两张表重复的IP
    public List<String> findDupIp(List<IpTable> list1, List<IpTable> list2) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet();
        list1.forEach(t -> {
            set.add(t.getIp());
        });
        list2.forEach(t -> {
            if (set.contains(t.getIp())) {
                res.add(t.getIp());
            }
        });
        return res;
    }

    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    //统计两张表重复的country，在各自表对应的IP数量
    public void countIpbyCountry(List<IpTable> list1, List<IpTable> list2) {
        HashMap<String, Integer> map = new HashMap();
        list1.forEach(t -> {
            map.put(t.getCountry(), map.getOrDefault(t.getCountry(), 0) + 1);
        });
        list2.forEach(t ->{
            //重复的country,记录两张表这个country有多少IP
            if (map.containsKey(t.getCountry())) {
                map1.put(t.getCountry(),map.get(t.getCountry()));
                map2.put(t.getCountry(),map1.getOrDefault(t.getCountry(), 0) + 1);
            }
        });
    }
}
@Data
class IpTable{
    private String port;
    private String ip;
    private String country;
    private Date date;
    private Integer hash;
}

