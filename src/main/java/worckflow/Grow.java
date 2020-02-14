package worckflow;

import spring.core.beans.Client;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Grow {
    public static void somePrint(Serializable a) {
        System.out.println(a);
    }


    static void cdf(List<Client> cutList, int id) {

      //  return cutList.stream().filter(c -> c.getId() == id).findFirst().get().getName();
    }

    public static void main(String[] args) {
        File file = new File("logi.txt");
        try {
            file.createNewFile();
            System.out.println(file.canWrite());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  Integer integer = new Integer(5);
        String s1 = "ForWithMuchWisdomComesMuchSorrowTheMoreKnowledgeTheMoreGrief";
        String s2 = "BeNotHastyInThySpiritToBeAngryForAngerRestethInTheBosomOfFools";
        List<String> list = new ArrayList<>();
        for(char c : s1.toCharArray()) { list.add(String.valueOf(c)); }
        List<String> list1 = new ArrayList<>();
        for(char c : s2.toCharArray()) { list1.add(String.valueOf(c)); }
        List<String> sameLetters = list.stream().filter(x -> list1.stream().anyMatch(y -> y.equalsIgnoreCase(x))).collect(Collectors.toList());
        sameLetters.forEach(System.out::print);
        String s = null;
        Predicate<Boolean> isDisplayed = i -> {if(Boolean.TRUE.equals(i)){
            System.out.println("5");
           return true;
        }else {
            System.out.println("7");}
            return false;
        };

        String test =" is it any updates ";
        System.out.println(new StringBuffer(test).reverse());




//Client customer = new Client(1, "ww");
//        System.out.println(customer.Test("Ave", "Caesar"));
//        Map<Integer,Integer> map = new HashMap<>();
//        asList(1,2,3,4,5,7,8,1,5,44,4,2,2,3,3,3,7).forEach(e1-> map.put(e1, map.getOrDefault(e1, 0) + 1));
//        System.out.println(map);


//        List<Spring.Customer> cust = new ArrayList<>();
//        cust.add(new Spring.Customer(1,"aaaa"));
//        cust.add(new Spring.Customer(2,"bbb"));
//        cust.stream().forEach(System.out::println);
//
//        Function<String, String> f1 = s -> s + "1";
//        Function<String, String> f2 = s -> s + "2";
//        Function<String, String> f3 = s -> s + "3";
//        Function<String, String> f4 = s -> s + "4";
//        System.out.println(f1.compose(f2).compose(f3).compose(f4).apply("Compose"));
//        System.out.println(f1.andThen(f2).andThen(f3).apply("AndThen"));e
//
//        Function<String, String> f = Function.identity();
//        System.out.println(f.apply("Some Value"));
//
//      //  System.out.println((worckflow.Grow.cdf(cust,4)));

    }
}
