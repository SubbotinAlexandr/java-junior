package genericdemo;

public class GenericQueue<T> {
    public void enqueue(T element) {

    }

    public T dequeue() {
        return null;
    }


    public static <P> P sort(P p) {
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        GenericQueue<String> queue = new GenericQueue(); // параметризуем тип
        //Если хотим работать с сырым типом без уточнения, используем:
        GenericQueue queue1 = new GenericQueue();
        //Как обеспечить обратную совместимость?
        GenericQueue<String> queue2 = new GenericQueue<String>();
            //Тогда скомпилированный код будет ждать при подаче на функции именно String
            //В гугле java generics faq

        //GenericQueue<Object> queue3 = new GenericQueue<Integer>(); //Такая запись не вкатит

        GenericQueue<? extends Object> queue3 = new GenericQueue<Integer>();
        GenericQueue<? super Integer> queue4 = new GenericQueue<Object>();
        //Такими вещами скорей всего заниматься не будем, но мало ли.
        GenericQueue.sort("");
    }
}

interface Queue<T> {
    void enqueue(T element);
}

class MyQueue1 implements Queue<String> {
    public void enqueue(String str) {

    }
}

class MyQueue2<T> implements Queue<T> {
    public void enqueue(T element) {

    }
}

class MyQueue3<String> implements Queue<Object> {
    public void enqueue(Object element) {

    }
}