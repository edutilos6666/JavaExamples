package com.edutilos.main;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Stream;

/**
 * Created by edutilos on 18.06.17.
 */
public class CollectionsExample {
    public static void main(String[] args) {

    }



    private static void testArraysClass() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4});
        //...
    }

    private static void testCollectionsClass() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        TreeMap<String, String> treeMap = new TreeMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();


        int binarySearch = Collections.binarySearch(arrayList, "foo");
        Queue<String> lifoQueue = Collections.asLifoQueue(new ArrayDeque<String>());
        Collection<String> checkedCollection = Collections.checkedCollection(arrayList, String.class);
        List<String> checkedList = Collections.checkedList(arrayList, String.class);
        Map<String,String> checkedMap = Collections.checkedMap(hashMap, String.class, String.class);
        NavigableMap<String, String> checkedNavigableMap = Collections.checkedNavigableMap(treeMap, String.class, String.class);
        NavigableSet<String> checkedNavigableSet = Collections.checkedNavigableSet(treeSet, String.class);
        SortedMap<String, String> checkedSortedMap = Collections.checkedSortedMap(treeMap, String.class, String.class);
        SortedSet<String> checkedSortedSet = Collections.checkedSortedSet(treeSet, String.class);
        Queue<String> checkedQueue = Collections.checkedQueue(arrayBlockingQueue, String.class);
        Set<String> checkedSet = Collections.checkedSet(hashSet, String.class);

        Collections.emptyEnumeration();
        Collections.emptyIterator();
        Collections.emptyList();
        Collections.emptyListIterator();
        Collections.emptyMap();
        Collections.emptyNavigableMap();
        Collections.emptyNavigableSet();
        Collections.emptySet();
        Collections.emptySortedMap();
        Collections.emptySortedSet();

        Set<String> singleton = Collections.singleton("foo");
        List<String> singletonList = Collections.singletonList("foo");
        Map<Integer, String> singletonMap = Collections.singletonMap(1, "foo");

        Collections.synchronizedCollection(arrayList);
        Collections.synchronizedList(arrayList);
        Collections.synchronizedMap(hashMap);
        Collections.synchronizedNavigableMap(treeMap);
        Collections.synchronizedNavigableSet(treeSet);
    }
}
