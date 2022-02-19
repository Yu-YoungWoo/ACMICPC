package Collection_framework.List.Slist;

import Collection_framework.Interface_form.List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;


public class SLinkedList<E> implements List<E> {

    private Node<E> head;  // 노드의 첫 부분
    private Node<E> tail; // 노드의 마지막 부분
    private int size;  // 요소 개수

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head;  //head가 가리키는 노드(처음)부터 시작

        for(int i = 0; i < index; i++) {
            x = x.next;  // x노드의 다음 노드(x가 가리키는 노드)를 저장한다.
        }
        return x;
    }


    public void addFirst(E value) {
        Node<E> newNode = new Node<E>(value);  // 새로운 노드 생성
        newNode.next = head; //새로운 노드의 레퍼런스 안에 head노드 연결
        head = newNode; //head를 새로운 노드로 업데이트
        size++;

        /*
            다음에 가리킬 노드가 없는 경우(데이터가 새 노드밖에 없다면)
            그 노드가 head이자 tail
         */

        if(head.next == null) {
            tail = head;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<E>(value);

        if(size == 0) {  // 처음 넣는 노드일 경우 addFirst로 추가
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void add(int index, E value) {

        // 예외처리
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        // 추가하려는 index가 가장 앞이면 addFirst 호출
        if(index == 0) {
            addFirst(value);
            return;
        }

        // 추가하려는 index가 마지막 위치일 경우 addLast 호출
        if(index == size) {
            addLast(value);
        }

        Node<E> newNode = new Node<E>(value);

        Node<E> prev_Node = search(index - 1);  // 추가하려는 위치의 이전 노드
        Node<E> next_Node = prev_Node.next; // 추가하려는 위치의 노드


        /*
            이전 노드가 가리키는 노드를 끊은 뒤
            새로운 노드를 연결해 주고, 새 노드가 가리키는 노드는 next_Node로 설정
         */
        prev_Node.next = null;
        prev_Node.next = newNode;
        newNode.next = next_Node;
        size++;
    }

    public E remove() {

        Node<E> headNode = head;

        if(headNode == null) {
            throw new NoSuchElementException();
        }

        E element = headNode.data;

        Node<E> nextNode = head.next;

        head.data = null;
        head.next = null;

        head = nextNode;
        size--;

        if(size == 0) {
            tail = null;
        }
        return element;
    }

    @Override
    public E remove(int index) {

        if(index == 0) {
            remove();
        }

        if(index >= size || index < 0) {
            throw new NoSuchElementException();
        }

        Node<E> prev_Node = search(index - 1);
        Node<E> removedNode = prev_Node.next;
        Node<E> next_Node = removedNode.next;

        E element = removedNode.data;

        prev_Node.next = next_Node;

        removedNode.data = null;
        removedNode.next = null;
        size--;

        return element;
    }


    @Override
    public boolean remove(Object value) {

        Node<E> prevNode = head;
        boolean hasValue = false;
        Node<E> x = head;  //removedNode


        // x와 일치하는 노드를 찾는다.
        for(; x != null; x = x.next) {
            if(value.equals(x.data)) {
                hasValue = true;
                break;
            }
            prevNode = x;
        }

        if(x == null) {
            return false;
        }

        // 만약 삭제하려는 노드가 head라면 기존 remove() 호출
        if(x.equals(head)) {
            remove();
            return true;
        } else {
            // 이전 노드의 next를 삭제하려는 노드의 다음 노드로 연결
            prevNode.next = x.next;

            x.data = null;
            x.next = null;
            size--;
            return true;
        }
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> setNode = search(index);

        setNode.data = null;
        setNode.data = value;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;


        //head부터 끝까지 반복
        for(Node<E> x = head; x != null; x = x.next) {
            if(value.equals(x.data)) {
                return index;
            }
            index++;
        }

        // 찾고자 하는 value의 위치를 못찾으면 -1반환
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

        for(Node<E> x = head; x != null;) {
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x = nextNode;
        }

        head = tail = null;
        size = 0;
    }


    public Object[] toArray() {
        Object[] arr = new Object[size];
        int idx = 0;

        for(Node<E> x = head; x != null; x = x.next) {
            arr[idx++] =  (E) x.data;
        }

        return arr;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {

        if(a.length < size) {

            // Array.newInstance(컴포넌트 타입, 생성할 크기)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass()
                    .getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;  // 얕은 복사
        for(Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.data;
        }

        return a;
    }


    public void sort() {
        /*
            Comparator를 넘겨주지 않는 경우 해당 객체의 Comparable에 구현된
            정렬 방식을 사용한다.
            만약 구현되어있지 않으면 cannot be cast to class java.lang.Comparable
            에러가 발생
         */
        sort(null);
    }

    @SuppressWarnings({ "unchecked", "rawtypes"})
    public void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);

        int i = 0;

        for(Node<E> x = head; x != null; x = x.next, i++) {
            x.data = (E) a[i];
        }
    }

    public void printList() {
        System.out.print("[");

        for(Node<E> i = head; i != null; i = i.next) {
            System.out.print(i.data + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        SLinkedList<Integer> sl = new SLinkedList<>();

        System.out.println(sl.add(10));
        System.out.println(sl.add(13));
        System.out.println(sl.add(18));
        System.out.println(sl.add(9));
        sl.printList();

        sl.sort();
        sl.printList();

    }
}
