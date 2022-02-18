package Collection_framework.List.arrList;

import Collection_framework.Interface_form.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기
    private static final Object[] EMPTY_ARRAY = {}; // 빈 배열

    private int size;

    Object[] array;  // 요소를 담을 배열

    //생성자1 (초기 공간 할당 X)
    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    //생성자2 (초기 공간 할당 O)
    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        int array_capacity = array.length;


//      if array's capacity is 0
        if(Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

//      용량이 꽉 찰 경우
        if(size == array_capacity) {
            int new_capacity = array_capacity * 2;

            array = Arrays.copyOf(array, new_capacity);
            return;
        }

//      용량의 절반 미만으로 요소가 차지하고 있을 경우
        if(size < (array_capacity / 2)) {
            int new_capacity = array_capacity / 2;

            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }

    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {

        if(index > size || index < 0) {  // index에 범위를 벗어날 경우 또는 음수가 들어올 경우 예외
            throw new IndexOutOfBoundsException();
        }

        if(index == size) {
            addLast(value);
        } else {
            if(size == array.length) {  //꽉차있다면 사이즈 재할당
                resize();
            }

            // index 기준 후자에 있는 모든 요소를 한 칸씩 뒤로 밀기
            for(int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }

            array[index] = value;
            size++;
        }

    }

    public void addLast(E value) {

        // 꽉차있는 상태라면 용적 재할당
        if(size == array.length) {
            resize();
        }
        array[size] = value;  // 마지막 위치에 요소 추가
        size++; //사이즈 1 증가

    }

    public void addFirst(E value) {
        add(0, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if(index >= size || index < 0) { // 범위에 벗어나면 예외
            throw new IndexOutOfBoundsException();
        }

        // Object 타입에서 E 타입으로 캐스팅 후 반횐
        return (E) array[index];
    }

    @Override
    public void set(int index, E value) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            array[index] = value;
        }
    }

    @Override
    public int indexOf(Object value) {
        int i = 0;

        // value와 같은 객체(요소 값)일 경우 i(위치) 반환
        for(i = 0; i < size; i++) {
            if(array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object value) {
        for(int i = size-1; i >= 0; i--) {
            if(array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {

        if(indexOf(value) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if(index >= size || size < 0) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) array[index];  //삭제될 요소를 반환하기 위해 임시로 담아둘 변수
        array[index] = null;

        // 삭제한 요소의 뒤에 있는 모든 요소들을 한 칸씩 당겨옴
        for(int i = index; i < size; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        size--;
        resize();
        return element;
    }

    // 리스트안에 특정 요소가 여러개 있을 경우 가장 먼저 발견한 요소만 삭제
    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if(index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;  //size가 0이라면 비어있다는 의미
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }

    public int remainCapacity() {
        if(Arrays.equals(array, EMPTY_ARRAY)) {
            return DEFAULT_CAPACITY;
        }
        return array.length - size;
    }

    public void printList() {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "," + " ");

            if(i % 10 == 0 && i != 0) {
                System.out.println();
            }
        }
        System.out.print("]");
    }



    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(200);
        System.out.println(arr.add(10));
        System.out.println(arr.isEmpty());
        System.out.println(arr.size());
        System.out.println(arr.indexOf(10));
        System.out.println(arr.remainCapacity());

        System.out.println();
        ArrayList<Integer> arr2 = new ArrayList<>();
        System.out.println(arr2.remainCapacity());
        System.out.println(arr2.add(320));
        System.out.println(arr2.size());
        System.out.println(arr2.remainCapacity());

        arr.printList();
    }

}
