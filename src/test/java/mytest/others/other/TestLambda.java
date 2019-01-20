package mytest.others.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-16 19:08
 */
public class TestLambda {
    public static void main(String[] args) {
        List<UserInfo> list = makeList();

//        List<Integer> userIdList = list.stream().map(UserInfo::getId).distinct().collect(Collectors.toList());
//
//        userIdList.forEach(System.out::println);

//        list.sort((UserInfo order1, UserInfo order2) -> order2.getId().compareTo(order1.getId()));
//
            list.sort(Comparator.comparing(UserInfo::getId, Comparator.nullsLast(Comparator.reverseOrder())));

        list.forEach(s -> System.out.println(s.getId()));
    }

    /**
     * 生成一个列表用于测试
     * @return
     */
    private static List<UserInfo> makeList() {
        List<UserInfo> list = new ArrayList<>();
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(9);
        userInfo1.setName("1");
        list.add(userInfo1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(6);
        userInfo2.setName("2");
        list.add(userInfo2);

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setId(13);
        userInfo3.setName("3");
        list.add(userInfo3);

        UserInfo userInfo4 = new UserInfo();
        userInfo4.setId(null);
        userInfo4.setName("4");
        list.add(userInfo4);

        return list;
    }
}
