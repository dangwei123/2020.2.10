public class MyArrayList<E > {
    private static final int DEFAULT=10;
    private static final int MAX_ARR_SIZE=Integer.MAX_VALUE-8;
    private static final Object[] DEFAULT_Arr={};
    private Object[] elementData;
    private int size;

    public MyArrayList(){
        this(10);
    }
    public MyArrayList(int initCapacity){
        if(initCapacity<0){
            throw new IllegalArgumentException("illegal:"+initCapacity);
        }else if(initCapacity==0){
            this.elementData=DEFAULT_Arr;
        }else{
            this.elementData=new Object[initCapacity];
        }
    }

    public boolean add(E e){
        enSureCapacity(size+1);
        elementData[size++]=e;
        return true;
    }
    private void enSureCapacity(int capacity){
        if(capacity-elementData.length>0){
            int oldCapacity=elementData.length;
            int newCapacity=oldCapacity+oldCapacity>>>1;
            if(newCapacity-capacity<0){
                newCapacity=capacity;
            }
            if(newCapacity-MAX_ARR_SIZE>0){
                newCapacity=Integer.MAX_VALUE;
            }
            elementData=Arrays.copyOf(elementData,newCapacity);
        }
    }

    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("illegal:"+index);
        }
        enSureCapacity(size+1);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index]=e;
        size++;
    }

    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("illegal:"+index);
        }
        E oldelement=(E)elementData[index];
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        elementData[--size]=null;
        return oldelement;
    }

    public boolean remove(E e){
        if(e==null){
            for(int i=0;i<size;i++){
                if(elementData[i]==null){
                    System.arraycopy(elementData,i+1,elementData,i,size-i-1);
                    return true;
                }
            }
        }else{
            for(int i=0;i<size;i++){
                if(e.equals(elementData[i])){
                    System.arraycopy(elementData,i+1,elementData,i,size-i-1);
                    return true;
                }
            }
        }
        return false;
    }

    public E set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("illegal:"+index);
        }
        E oldElement=(E)elementData[index];
        elementData[index]=e;
        return oldElement;
    }

    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("illegal:"+index);
        }
        return (E)elementData[index];
    }

    public boolean contains(E e){
        return index(e)>-1;
    }

    public int index(E e){
        if(e==null){
            for(int i=0;i<size;i++){
                if(elementData[i]==null){
                    return i;
                }
            }
        }else{
            for(int i=0;i<size;i++){
                if(e.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return 0==size;
    }

    public int size(){
        return size;
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
