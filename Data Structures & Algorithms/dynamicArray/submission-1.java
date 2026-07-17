class DynamicArray {
    int[] list;
    int size = 0;
    int capacity = 0;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        list = new int[capacity];
    }

    public int get(int i) {
        return list[i];
    }

    public void set(int i, int n) {
        list[i] = n;
    }

    public void pushback(int n) {
        if(size >= capacity){
            resize();
        }

        list[size++] = n;
    }

    public int popback() {
        size--;
        return list[size];
    }

    private void resize() {
        capacity *= 2;
        int[] newList = new int[capacity];

        for(int i=0; i<size; ++i){
            newList[i] = list[i];
        }

        list = newList;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
