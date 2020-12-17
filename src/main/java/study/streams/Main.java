package study.Streams;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        new Main().groiping();
    }

    private void run() {
        int[] array = new int[]{1, 2, 3, 45, 5};
        IntStream integerStream = Arrays.stream(array);
        List<Integer> list = new ArrayList<>();
        long count = IntStream.of(-5, 3, 2, 56, 7, 3).filter(w -> w > 0).count();
    }

    private void run2() {
        ArrayList<String> cities = new ArrayList<>();
        Collections.addAll(cities, "asdf", "asdfasdf", "asdfasdf");
        cities.stream().filter(s -> s.length() >= 6).forEach(System.out::println);

        Stream<String> stream = Arrays.stream(new String[]{"asdf", "asdfasdf", "asdfasdf"});
        stream.forEach(System.out::println);

        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 56});
        LongStream longStream = Arrays.stream(new long[]{1, 2, 34, 5});
        DoubleStream doubleStream = Arrays.stream(new double[]{1, 2, 3, 5, 6});

        Stream<String> stringStream = Stream.of("asdf", "asdfasdf", "asdfasdf");
        stringStream.forEach(s -> {
            if (s.length() >= 4) {
                System.out.println(s);
            } else {
                s.concat(" City");
                System.out.println(s);
            }
        });

        String[] strings = {"asdfasdfasdfa", "dsfagerfev", "aefqewrf"};
        Stream<String> stringStream1 = Stream.of(strings);


        IntStream intStream1 = IntStream.of(new int[]{1, 2, 3, 54, 5});
        IntStream intStream3 = IntStream.of(new int[]{1, 2, 3, 54, 5});
        IntStream[] intStream2 = {intStream1, intStream3};
        Stream stream1 = Stream.of(intStream2);
        stream1.forEach(System.out::println);
        intStream3.forEach(i -> Math.sin(Math.pow(i, 2)));
//        intStream3.toArray();

    }

    void run3() {
        Stream<String> stringStream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");
        stringStream.forEach(s -> System.out.println("г. " + s + " :"));

        Stream<String> stream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");
        stream.filter(s -> s.length() >= 6).filter(s -> s.toLowerCase().contains("и")).forEach(System.out::println);

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream.filter(phone -> phone.getPrice() < 50000).forEach(phone -> System.out.println(phone.getName()));

        Stream<Phone> phoneStream2 = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream2.map(Phone::getName).forEach(System.out::println);
        Stream<Phone> phoneStream3 = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream3.map(phone -> "name: " + phone.getName() + " price: " + phone.getPrice()).forEach(System.out::println);
//        List<String> strings = phoneStream3.map(phone -> "name: " + phone.getName() + " price: " + phone.getPrice()).collect(Collectors.toList());


        System.out.println("\n");
        Stream<Phone> phoneStream4 = Stream.of(
                new Phone("iphone 6s", 54000),
                new Phone("lumia 940", 45000),
                new Phone("Sumsung Galaxy s 6", 40000));
        phoneStream4.flatMap(phone -> Stream.of(
                String.format("Name: %s price without discount: %d", phone.getName(), phone.getPrice()),
                String.format("Name: %s price with discount: %d", phone.getName(), phone.getPrice() - (int) (phone.getPrice() * 0.1)))
        ).forEach(System.out::println);

    }

    void run4() {
        List<String> phones = new ArrayList<String>();
        Collections.addAll(phones, "iPhone X", "Nokia 9", "Huawei Nexus 6P",
                "Samsung Galaxy S8", "LG G6", "Xiaomi MI6",
                "ASUS Zenfone 3", "Sony Xperia Z5", "Meizu Pro 6",
                "Pixel 2");
        phones.stream().filter(p -> p.length() < 12).sorted().forEach(System.out::println);

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Nokia 9", "HMD Global", 150),
                new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.sorted(new PhoneComaparator())
                .forEach(p -> System.out.printf("%s (%s) - %d \n", p.getName(), p.getCompany(), p.getPrice()));


    }

    void substream_cancatStreams() {
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
        while (true) {
            System.out.println("Enter page number: ");
            int page = scanner.nextInt();
            if (page < 1) break;
            strings.stream().skip((long) (page - 1) * pageSize).limit(pageSize).forEach(System.out::println);
        }
    }

    void conversionOperations() {
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
        System.out.println(strings.stream().allMatch(n -> n.length() >= 3));
        System.out.println(strings.stream().anyMatch(n -> n.length() == 3));
        System.out.println(strings.stream().noneMatch(n -> n.equals("Tom")));

        //min и max
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 8, 9, 9, 0));
        System.out.println(arrayList.stream().min(Integer::compare).get());
        System.out.println(arrayList.stream().max(Integer::compare).get());

        ArrayList<Phone> phones = new ArrayList<>(Arrays.asList(
                new Phone("iPhone 8", 52000),
                new Phone("Nokia 9", 35000),
                new Phone("Samsung Galaxy S9", 48000),
                new Phone("HTC U12", 36000)));
        System.out.println(phones.stream().min(Phone::compare).get().toString());
        System.out.println(phones.stream().max(Phone::compare).get().toString());

    }

    void reduce() {
        Stream<Integer> integerStream = Stream.of(1, 2, 4, 5, 6, 7);
        Optional<Integer> res = integerStream.reduce((x, y) -> x * y);
        System.out.println(res.get());

        Stream<String> stringStream = Stream.of("мама", "мыла", "раму");
        Optional<String> optionalS = stringStream.reduce((x, y) -> x + " " + y);
        System.out.println(optionalS.get());

        Stream<Integer> integerStream1 = Stream.of(1, 2, 4, 5, 6, 7, 8, 9);
        int identity = 5;
        int result = integerStream1.reduce(identity, (x, y) -> x * y);
        System.out.println(result);

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000),
                new Phone("LG G 4", 32000));
        int sum = phoneStream.reduce(0, (x, y) -> {
            if (y.getPrice() < 50000)
                return x + y.getPrice();
            else
                return x;
        }, Integer::sum);
        System.out.println(sum);
    }

    void optional(){
        //Тип Optional
        //Ряд операций сведения, такие как min, max, reduce, возвращают объект Optional<T>. Этот объект фактически обертывает результат операции. После выполнения операции с помощью метода get() объекта Optional мы можем получить его значение:
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(5, 4, 3, 4, 5, 6, 7, 7, 8, 9, 9));
        Optional<Integer> min = integers.stream().min(Integer::compare);//
        Optional<Integer> min2 = integers.stream().min(Comparator.comparingInt(x -> x));
        Optional<Integer> min3 = integers.stream().min((x,y)->Integer.compare(x,y));
        System.out.println(min.get());
        System.out.println(min2.get());
        System.out.println(min3.get());

        //orElse
        //Метод orElse() позволяет определить альтернативное значение, которое будет возвращаться, если Optional не получит из потока какого-нибудь значения:
        ArrayList<Integer> integers1 = new ArrayList<>();
        Optional<Integer> minn = integers1.stream().min(Integer::compare);
        if (minn.isPresent()){
            System.out.println(minn.get());
        }
        ArrayList<Integer> integers12 = new ArrayList<>();
        Optional<Integer> minn2 = integers12.stream().min(Integer::compare);
        System.out.println(minn2.orElse(-1));
        System.out.println(integers.stream().min(Integer::compare).orElse(-1));

        //orElseGet
        //Метод orElseGet() позволяет задать функцию, которая будет возвращать значение по умолчанию:
        ArrayList<Integer> nums = new ArrayList<>();
        Optional<Integer> min5 = nums.stream().min(Integer::compare);
        Random random = new Random();
        System.out.println(min.orElseGet(()->random.nextInt(100)));

        //orElseThrow
        //Еще один метод - orElseThrow позволяет сгенерировать исключение, если Optional не содержит значения:
        ArrayList<Integer> numbers = new ArrayList<>();
        Optional<Integer> min6 = numbers.stream().min(Integer::compare);
        try {
            System.out.println(min6.orElseThrow(IllegalStateException::new));
        }catch (IllegalStateException e){
            System.out.println(e);
        }

        //Обработка полученного значения
        //Метод ifPresent() определяет действия со значением в Optional, если значение имеется:
        ArrayList<Integer> integers2 = new ArrayList<>(Arrays.asList(4,5,6,67,78,8));
        Optional<Integer> optional = integers2.stream().findAny();
        optional.ifPresent(System.out::println);

        //Метод ifPresentOrElse() позволяет определить альтернативную логику на случай, если значение в Optional отсутствует:
        ArrayList<Integer> integers3 = new ArrayList<>();
        Optional<Integer> optional1 = integers3.stream().min(Integer::compare);
//        optional1.ifPresentOrElse({
//                v-> System.out.println(v),
//                ()-> System.out.println("Value not found")
//        });java 9
    }

    void collect(){
        //Метод collect
        List<String> phones = new ArrayList<>(Arrays.asList("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850"));
        List<String> filtered = phones.stream().filter(s -> s.length()<10).collect(Collectors.toList());
        filtered.forEach(System.out::println);
        for (String s : filtered) {
            System.out.println(s);
        }
        //Использование метода toSet() аналогично.
        Set<String> strings = phones.stream().filter(s -> s.length()<10).collect(Collectors.toSet());
        strings.forEach(System.out::println);
        //Теперь применим метод toMap():
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));
        Map<String, Integer> phones1 = phoneStream.collect(Collectors.toMap(Phone::getName, Phone::getPrice));
        phones1.forEach((k,v)-> System.out.println(k+" "+v));

        //Если нам надо создать какой-то определенный тип коллекции, например, HashSet, то мы можем использовать специальные функции, которые определены в классах-коллекций. Например, получим объект HashSet:
        Stream<String> phones3 = Stream.of(
                "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");
        HashSet<String> stringHashSet = phones3.collect(Collectors.toCollection(HashSet::new));
        stringHashSet.forEach(System.out::println);
//        ArrayList<String> stringArrayList = phones3.collect(Collectors.toCollection(ArrayList::new));
        //Вторая форма метода collect имеет три параметра:
        Stream<String> stringStream = Stream.of(
                "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");
//        ArrayList<String> arrayList = stringStream.filter(s -> s.length()<12).collect(
//                ()->new ArrayList<String>(),
//                (list,item)->list.add(item),
//                (list1,item2)->list1.addAll(item2));
        ArrayList<String> arrayList = stringStream.filter(s -> s.length()<12).collect(
                ArrayList::new,
                ArrayList::add,
                ArrayList::addAll);
        arrayList.forEach(System.out::println);


    }

    void groiping(){
        //Группировка
    }

}


class PhoneComaparator implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
