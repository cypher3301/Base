package study.Streams;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        new Main().conversionOperations();
    }

    private void run() {
        int[] array = new int[]{1,2,3,45,5};
        IntStream integerStream = Arrays.stream(array);
        List<Integer> list = new ArrayList<>();
        long count = IntStream.of(-5,3,2,56,7,3).filter(w->w>0).count();
    }

    private void run2(){
        ArrayList<String> cities = new ArrayList<>();
        Collections.addAll(cities,"asdf","asdfasdf", "asdfasdf");
        cities.stream().filter(s -> s.length()>=6).forEach(System.out::println);

        Stream<String> stream = Arrays.stream(new String[]{"asdf","asdfasdf", "asdfasdf"});
        stream.forEach(System.out::println);

        IntStream intStream = Arrays.stream(new int[]{1,2,3,4,56});
        LongStream longStream = Arrays.stream(new long[]{1,2,34,5});
        DoubleStream doubleStream = Arrays.stream(new double[]{1,2,3,5,6});

        Stream<String> stringStream = Stream.of("asdf","asdfasdf", "asdfasdf");
        stringStream.forEach(s -> {
            if(s.length()>=4) {
                System.out.println(s);
            }
            else {
                s.concat(" City");
                System.out.println(s);
            }
        });

        String[] strings = {"asdfasdfasdfa","dsfagerfev","aefqewrf"};
        Stream<String> stringStream1 = Stream.of(strings);


        IntStream intStream1 = IntStream.of(new int[]{1,2,3,54,5});
        IntStream intStream3 = IntStream.of(new int[]{1,2,3,54,5});
        IntStream[] intStream2 = {intStream1,intStream3};
        Stream stream1 = Stream.of(intStream2);
        stream1.forEach(System.out::println);
        intStream3.forEach(i->Math.sin(Math.pow(i,2)));
//        intStream3.toArray();

    }

    void run3(){
        Stream<String> stringStream = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        stringStream.forEach(s -> System.out.println("г. " + s + " :"));

        Stream<String> stream = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        stream.filter(s -> s.length()>=6).filter(s -> s.toLowerCase().contains("и")).forEach(System.out::println);

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream.filter(phone -> phone.getPrice()<50000).forEach(phone -> System.out.println(phone.getName()));

        Stream<Phone> phoneStream2 = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream2.map(Phone::getName).forEach(System.out::println);
        Stream<Phone> phoneStream3 = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream3.map(phone -> "name: " + phone.getName()+" price: " + phone.getPrice()).forEach(System.out::println);
//        List<String> strings = phoneStream3.map(phone -> "name: " + phone.getName() + " price: " + phone.getPrice()).collect(Collectors.toList());


        System.out.println("\n");
        Stream<Phone> phoneStream4 = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream4.flatMap(phone -> Stream.of(
                String.format("Name: %s price without discount: %d", phone.getName(),phone.getPrice()),
                String.format("Name: %s price with discount: %d", phone.getName(),phone.getPrice()-(int)(phone.getPrice()*0.1)))
        ).forEach(System.out::println);

    }

    void run4(){
        List<String> phones = new ArrayList<String>();
        Collections.addAll(phones,"iPhone X", "Nokia 9", "Huawei Nexus 6P",
                "Samsung Galaxy S8", "LG G6", "Xiaomi MI6",
                "ASUS Zenfone 3", "Sony Xperia Z5", "Meizu Pro 6",
                "Pixel 2");
        phones.stream().filter(p->p.length()<12).sorted().forEach(System.out::println);

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Nokia 9", "HMD Global",150),
                new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.sorted(new PhoneComaparator())
                .forEach(p->System.out.printf("%s (%s) - %d \n", p.getName(),p.getCompany(), p.getPrice()));


    }

    void substream_cancatStreams(){
//        Stream<Integer> numbers = Stream.of(-1,-2,-4,-1,5,4,0);
//        numbers.takeWhile(n->n<0).forEach(System.out::println);
//        Stream<Integer> integerStream2 = Stream.of(-1,-2,-4,-1,5,4,0);
//        integerStream2.sorted().takeWhile(integer -> integer<0).forEach(System.out::println);
//
//        Stream<Integer> integerStream1 = Stream.of(1,4,6,7,4,3,7,-4,-5,-56);
//        integerStream1.sorted().dropWhile(integer -> integer<0).forEach(System.out::println);

        //cancat
        Stream<String> stream = Stream.of("Tom", "Bob", "Sam");
        Stream<String> stream2 = Stream.of("Alice", "Kate", "Sam");
        List<String> stringList = Stream.concat(stream, stream2).distinct().collect(Collectors.toList());
        stringList.forEach(System.out::println);


        //skip, limit
        Stream<String> stringStream = Stream.of("iPhone 6 S", "Lumia 950", "Samsung Galaxy S 6", "LG G 4", "Nexus 7");
        stringStream.skip(2).limit(2).forEach(System.out::println);
        //постраничную навигацию:
        System.out.println("\n\n");
        List<String> strings = new ArrayList<String>(Arrays.asList("iPhone 6 S", "Lumia 950", "Huawei Nexus 6P",
                "Samsung Galaxy S 6", "LG G 4", "Xiaomi MI 5",
                "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5",
                "Lenovo S 850"));
        int pageSize = 3;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter page number: ");
            int page = scanner.nextInt();
            if (page<1) break;
            strings.stream().skip((long) (page - 1) *pageSize).limit(pageSize).forEach(System.out::println);
        }
    }

    void conversionOperations(){
        //count
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("Tom", "Sam", "Bob", "Alice"));
        System.out.println(names.stream().count());
        System.out.println(names.stream().filter(n -> n.length() <= 3).count());

        //findFirst и findAny
        ArrayList<String> name = new ArrayList<String>(Arrays.asList("Tom", "Sam", "Bob", "Alice"));
        Optional<String> first = name.stream().findFirst();
        System.out.println(first.get());
        Optional<String> any = name.stream().findAny();
        System.out.println(any.get());

        //allMatch, anyMatch, noneMatch
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Tom", "Sam", "Bob", "Alice"));
        System.out.println(strings.stream().allMatch(n->n.length()>=3));
        System.out.println(strings.stream().anyMatch(n->n.length()==3));
        System.out.println(strings.stream().noneMatch(n->n.equals("Tom")));

        //min и max
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,4,5,6,8,9,9,0));
        System.out.println(arrayList.stream().min(Integer::compare));
        System.out.println(arrayList.stream().max(Integer::compare));

    }

}


class PhoneComaparator implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
