import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1 task
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(12);
        numbersList.add(32);
        numbersList.add(22);
        numbersList.add(10);
        numbersList.add(1);
        numbersList.add(92);
        numbersList.add(12);
        numbersList.add(49);
        numbersList.add(102);

        List<Integer> testList1 = new ArrayList<>();

        List<Integer> testList2 = new ArrayList<>();
        testList2.add(3);

        Comparator<Integer> order = (Integer::compareTo);
        BiConsumer<Integer, Integer> minMaxConsumer = (min, max) -> System.out.println("min = " + min + ", max = " + max);

        Stream<Integer> numbers = numbersList.stream();
        findMinMax(numbers,order,minMaxConsumer);

        Stream<Integer> test1 = testList1.stream();
        findMinMax(test1,order,minMaxConsumer);

        Stream<Integer> test2 = testList2.stream();
        findMinMax(test2,order,minMaxConsumer);

        //task2

        evenNumberCount(numbersList);
        evenNumberCount(testList1);
        evenNumberCount(testList2);
    }

    public static <T> void findMinMax (
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        T min;
        T max;
        List<T> list = stream
                .sorted(order)
                .distinct()
                .collect(Collectors.toList());

        if (!list.isEmpty()){
            min = list.get(0);
            max = list.get(list.size() - 1);
        }
        else {
            min = null;
            max = null;
        }

        minMaxConsumer.accept(min, max);
    }

    public static void evenNumberCount (
            List<Integer> integerList
    ){
        System.out.println("number of even numbers = " + integerList.stream()
                .filter(i -> i % 2 == 0)
                .count());
    }
    }
