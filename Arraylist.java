
public class Arraylist implements MyList {

    Object[] arr;
    int index = 0;
    int diff = 0;

    public Arraylist() {
        arr = new Object[2];
    }

    public static void printArray(Object[] arr) {

        System.out.print("\nArray: ");
        System.out.print("[ ");

        boolean firstElement = true;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != null) {

                if (!firstElement) {
                    System.out.print(", ");
                }

                System.out.print(arr[i]);

                firstElement = false;
            }
        }

        System.out.print(" ]\n");
    }

    public Object[] createNewArray(Object[] arr) {
        int len = arr.length;
        int newlen = ((len * 3) / 2) + 1;
        diff = newlen - len;
        Object[] newarray = new Object[newlen];

        for (int i = 0; i < arr.length; i++) {
            newarray[i] = arr[i];
        }
        return newarray;
    }

    public void checkExtra() {
        int len = arr.length;
        int nullCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == null) {
                nullCount++;
                if (nullCount == diff) {
                    arr = removeExtra();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public Object[] removeExtra() {
        Object[] arr1 = new Object[arr.length - diff];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }

        return arr1;
    }

    @Override
    public void add(Object x) {
        if (index >= arr.length) {
            arr = createNewArray(arr);
            add(x);
            return;
        }
        if (arr[index] != null) {
            index++;
            add(x);
            return;
        }
        arr[index++] = x;
        printArray(arr);
    }

    @Override
    public void add(int index1, Object x) {
        if (index1 >= arr.length) {
            arr = createNewArray(arr);
            add(index1, x);
            return;
        }
        if (arr[index1] != null) {
            System.out.println("Cant add to index that is already having an element!!");
            return;
        }
        arr[index1] = x;
        printArray(arr);
    }

    @Override
    public Object get(int index2) {
        if (index2 >= arr.length) {
            System.err.println("Index out of bound exception");
            return null;
        } else {
            return arr[index2];
        }
    }

    @Override
    public void set(int index3, Object x) {
        if (index3 >= arr.length) {
            System.err.println("Index out of bound exception");
        }

        arr[index3] = x;
        printArray(arr);
    }

    public int size() {
        int arrayLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                arrayLength++;
            }
        }

        return arrayLength;
    }

    public void clear() {
        arr = new Object[2];
        index = 0;
        printArray(arr);
    }

    @Override
    public boolean contains(Object x) {

        boolean isPresent = false;
        for (Object o : arr) {
            if (o != null && o.equals(x)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;

    }

    @Override
    public void remove(Object x) {
        int elementIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(x)) {
                arr[i] = null;
                index--;
                elementIndex = i;
                break;
            }
        }

        if (elementIndex >= 0) {
            if (elementIndex != arr.length - 1) {
                int first = elementIndex;
                int second = elementIndex + 1;
                while (second <= arr.length - 1) {
                    Object temp = arr[first];
                    arr[first] = arr[second];
                    arr[second] = temp;
                    first++;
                    second++;
                }
            }
            checkExtra();
        } else {
            System.out.println(
                    "Element " + x + " not present in the array. \nCan't remove an element which is not in the array.");
        }
        printArray(arr);
    }

    @Override
    public void remove(int index) {
        if (index < arr.length) {
            arr[index] = null;
            index--;
        } else {
            System.out.println("Index out of bound exception");
        }

        int first = index;
        int second = index + 1;
        while (second <= arr.length - 1) {
            Object temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
            first++;
            second++;
        }

        checkExtra();
        printArray(arr);
    }

    @Override
    public void sort() {
        int n = size();
        if (n > 1) {
            compact();
            if (n > 1) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - 1 - i; j++) {
                        Comparable a = (Comparable) arr[j];
                        Comparable b = (Comparable) arr[j + 1];

                        if (a.compareTo(b) > 0) {
                            Object temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }

                    }
                }
            }
        }
        printArray(arr);
    }

    @Override
    public void reverse() {

        int n = size();
        compact();

        if (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                Object temp = arr[i];
                arr[i] = arr[n - 1 - i];
                arr[n - 1 - i] = temp;
            }
        }

        printArray(arr);
    }

    private void compact() {
        int ind = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                arr[ind++] = arr[i];
            }
        }

        while (ind < arr.length) {
            arr[ind++] = null;
        }
    }

}
