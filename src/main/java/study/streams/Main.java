package study.streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        new Main().parallelArrays();
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

    void subStreamConcatStreams() {
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

    void grouping(){
        //Группировка
        //Чтобы сгруппировать данные по какому-нибудь признаку, нам надо использовать в связке метод collect() объекта Stream и метод Collectors.groupingBy(). Допустим, у нас есть следующий класс:
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));
        Map<String, List<Phone>> stringListMap = phoneStream.collect(Collectors.groupingBy(Phone::getCompany));
        for (Map.Entry<String,List<Phone>> item : stringListMap.entrySet()){
            System.out.println(item.getKey());
            for (Phone phone : item.getValue()){
                System.out.println(phone.getName());
            }
        }
        System.out.println("\n");

        //Метод Collectors.partitioningBy
        //Метод Collectors.partitioningBy() имеет похожее действие, только он делит элементы на группы по принципу, соответствует ли элемент определенному условию. Например:
        Stream<Phone> stream = getStream(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));
        Map<Boolean, List<Phone>> booleanListMap = stream.collect(Collectors.partitioningBy(phone -> phone.getCompany().equals("Apple")));
        for (Map.Entry<Boolean,List<Phone>> item : booleanListMap.entrySet()){
            System.out.println(item.getKey());
            for (Phone phone:item.getValue()){
                System.out.println(phone);
            }
        }
        System.out.println("\n");

        //Метод Coollectors.counting
        //Метод Collectors.counting применяется в Collectors.groupingBy() для вычисления количества элементов в каждой группе:
        Stream<Phone> stream1 = dataToStream();
        Map<String, Long> phonesByCompany = stream1.collect(Collectors.groupingBy(Phone::getCompany,Collectors.counting()));
        for (Map.Entry<String, Long> item : phonesByCompany.entrySet()){
            System.out.println(item.getKey()+" - " + item.getValue());
        }
        System.out.println();

        //Метод Collectors.summing
        //Метод Collectors.summing применяется для подсчета суммы. В зависимости от типа данных, к которым применяется метод, он имеет следующие формы: summingInt(), summingLong(), summingDouble(). Применим этот метод для подсчета стоимости всех смартфонов по компаниям
        Map<String,Integer> stringIntegerMap = dataToStream().collect(Collectors.groupingBy(Phone::getCompany,Collectors.summingInt(Phone::getPrice)));
        showData(stringIntegerMap);

        //Методы maxBy и minBy
        Map<String, Optional<Phone>> stringOptionalMap = dataToStream().collect(Collectors.groupingBy(Phone::getCompany,Collectors.minBy(Comparator.comparing(Phone::getPrice))));
        for(Map.Entry<String, Optional<Phone>> item: stringOptionalMap.entrySet()){
            System.out.println(item.getKey()+" - " + item.getValue().get().getName());
        }
        System.out.println();

        //Метод summarizing
        //Методы summarizingInt() / summarizingLong() / summarizingDouble() позволяют объединить в набор значения соответствующих типов:
        Map<String, IntSummaryStatistics> priceSummary=dataToStream().collect(Collectors.groupingBy(Phone::getCompany, Collectors.summarizingInt((Phone::getPrice))));
        for (Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue().getSum());
        }
        //Метод Collectors.summarizingInt(Phone::getPrice)) создает набор, в который помещаются цены для всех телефонов каждой из групп. Данный набор инкапсулируется в объекте IntSummaryStatistics. Соответственно если бы мы применяли методы summarizingLong() или summarizingDouble(), то соответственно бы получали объекты LongSummaryStatistics или DoubleSummaryStatistics.
        //У этих объектов есть ряд методов, который позволяют выполнить различные атомарные операции над набором:
        //getAverage(): возвращает среднее значение
        //getCount(): возвращает количество элементов в наборе
        //getMax(): возвращает максимальное значение
        //getMin(): возвращает минимальное значение
        //getSum(): возвращает сумму элементов
        //accept(): добавляет в набор новый элемент
        System.out.println();

        //Метод mapping
        //Метод mapping позволяет дополнительно обработать данные и задать функцию отображения объектов из потока на какой-нибудь другой тип данных. Например:
        Map<String, List<String>> stringListMap1 = dataToStream().collect(Collectors.groupingBy(Phone::getCompany,Collectors.mapping(Phone::getName, Collectors.toList())));
        for (Map.Entry<String, List<String>> item : stringListMap1.entrySet()){
            System.out.println(item.getKey());
            Stream.of(item).forEach(i-> System.out.println(i.getValue()));
        }
        System.out.println();
    }

    void parallelStreams(){
        //Параллельные потоки
        //Чтобы сделать обычный последовательный поток параллельным, надо вызвать у объекта Stream метод parallel. Кроме того, можно также использовать метод parallelStream() интерфейса Collection для создания параллельного потока из коллекции.
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        Optional<Integer> res = stream.parallel().reduce((x,y)->x*y);
        System.out.println(res.get());
        //Однако не все функции можно без ущерба для точности вычисления перенести с последовательных потоков на параллельные. Прежде всего такие функции должны быть без сохранения состояния и ассоциативными, то есть при выполнении слева направо давать тот же результат, что и при выполнении справа налево, как в случае с произведением чисел. Например:
        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        String sentence = wordsStream.parallel().reduce("Result:", (x,y)->x+" "+y);
        System.out.println(sentence);
        //Данный вывод не является правильным. Если же мы не уверены, что на каком-то этапе работы с параллельным потоком он адекватно сможет выполнить какую-нибудь операцию, то мы можем преобразовать этот поток в последовательный посредством вызова метода sequential():
        Stream<String> stringStream = Stream.of("мама", "мыла", "раму", "hello world");
        String s = stringStream.parallel().filter(s1 -> s1.length()<10).sequential().reduce("Result:", (x,y)->x+" "+y);
        System.out.println(s);
        Stream<Integer> integerStream = Stream.of(1,2,4,5,6,7);
        Integer result = integerStream.parallel().reduce(1,(x,y)->x*y);
        System.out.println(result);
        /*
        Вопросы производительности в параллельных операциях
        Фактически применение параллельных потоков сводится к тому, что данные в потоке будут разделены на части, каждая часть обрабатывается на отдельном ядре процессора, и в конце эти части соединяются, и над ними выполняются финальные операции. Рассмотрим некоторые критерии, которые могут повлиять на производительность в параллельных потоках:
        Размер данных. Чем больше данных, тем сложнее сначала разделять данные, а потом их соединять.
        Количество ядер процессора. Теоретически, чем больше ядер в компьютере, тем быстрее программа будет работать. Если на машине одно ядро, нет смысла применять параллельные потоки.
        Чем проще структура данных, с которой работает поток, тем быстрее будут происходить операции. Например, данные из ArrayList легко использовать, так как структура данной коллекции предполагает последовательность несвязанных данных. А вот коллекция типа LinkedList - не лучший вариант, так как в последовательном списке все элементы связаны с предыдущими/последующими. И такие данные трудно распараллелить.
        Над данными примитивных типов операции будут производиться быстрее, чем над объектами классов
        */
        /*
        Упорядоченность в параллельных потоках
        Как правило, элементы передаются в поток в том же порядке, в котором они определены в источнике данных. При работе с параллельными потоками система сохраняет порядок следования элементов. Исключение составляет метод forEach(), который может выводить элементы в произвольном порядке. И чтобы сохранить порядок следования, необходимо применять метод forEachOrdered:
        */
        Stream<Phone> phoneStream= dataToStream();
        phoneStream.parallel().sorted(new PhoneComaparator()).forEachOrdered(System.out::println);
        /*Сохранение порядка в параллельных потоках увеличивает издержки при выполнении. Но если нам порядок не важен, то мы можем отключить его сохранение и тем самым увеличить производительность, использовав метод unordered:*/
        Stream<Phone> phoneStream2= dataToStream();
        phoneStream2.parallel().sorted(new PhoneComaparator()).unordered().forEach(System.out::println);
    }

    void parallelArrays(){
        //Параллельные операции над массивами
        //В JDK 8 к классу Arrays было добавлено ряд методов, которые позволяют в параллельном режиме совершать обработку элементов массива. И хотя данные методы формально не входят в Stream API, но реализуют схожую функциональность, что и параллельные потоки:
        //parallelPrefix(): вычисляет некоторое значение для элементов массива (например, сумму элементов)
        //parallelSetAll(): устанавливает элементы массива с помощью лямбда-выражения
        //parallelSort(): сортирует массив
        //Используем метод parallelSetAll() для установки элементов массива:
        int[] ints = initializeArray(6);
        for (int i : ints) {
            System.out.println(i);
        }
        Arrays.stream(ints).forEach(System.out::println);
        //Рассмотрим более сложный пример.
        Phone[] phones = new Phone[]{new Phone("iPhone 8", 54000),
                new Phone("Pixel 2", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("Nokia 9", 32000)};
        Arrays.parallelSetAll(phones, i->{
            phones[i].setPrice(phones[i].getPrice()-10000);
            return phones[i];
        });
        for (Phone phone : phones) {
            System.out.printf("%s - %d \n", phone.getName(),phone.getPrice());
        }

        //Сортировка
        int[] nums = {1,3,5,78,90,5,3,6,8,9,45,4};
        Arrays.parallelSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        Arrays.parallelSort(phones, new PhoneComaparator());
        for (Phone phone : phones) {
            System.out.println(phone.getName());
        }

        //Метод parallelPrefix
        //Метод parallelPrefix() походит для тех случаев, когда надо получить элемент массива или объект того же типа, что и элементы массива, который обладает некоторыми признаками. Например, в массиве чисел это может быть максимальное, минимальное значения и т.д. Например, найдем произведение чисел:
        Arrays.parallelPrefix(nums,(x,y)->x*y);
        for (int num : nums) {
            System.out.println(num);
        }
        //То есть, как мы видим из консольного вывода, лямбда-выражение из Arrays.parallelPrefix, которое представляет бинарную функцию, получает два элемента и выполняет над ними операцию. Результат операции сохраняется и передается в следующий вызов бинарной функции.
    }

    public static int[] initializeArray(int size){
        int[] values = new int[size];
        Arrays.parallelSetAll(values,i->i*10);
        return values;
    }


    private static <T,J> void showData(Map<T, J> phonesByCompany){
        for (Map.Entry<T, J> item : phonesByCompany.entrySet()){
            System.out.println(item.getKey()+" - " + item.getValue());
        }
        System.out.println();
    }

    private static Stream<Phone> dataToStream(){
        return getStream(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));
    }

    //from help package
    @SafeVarargs
    private static  <T> Stream<T> getStream(T... vals){
        return Stream.of(vals);
    }

}


class PhoneComaparator implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
