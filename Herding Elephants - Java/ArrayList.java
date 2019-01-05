//Written by bello067
//Borrowed code from insert.java for sort method
public class ArrayList<T extends Comparable <T>> implements List <T> {

    private T[] a;
    private boolean isSorted;
    private int numEl;

    public ArrayList(){//constructor for list
        a = (T[]) new Comparable[2];
        isSorted = true;
        numEl = 0;
    }

    public boolean add(T element) {//adds element to list
        if(element == null) {
            return false;
        }
        if (numEl == 0) { //if array is empty
            a[numEl]= element;
        } else if (numEl == a.length) {//if array is full
            T[] b = (T[]) new Comparable[(a.length * 2)];//make a new array and copy what was in a into b
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            b[numEl] = element;//add element to the end of the list
            a = b;
        } else {//if array is not full
            a[numEl] = element;
        }
        numEl = numEl + 1;
        isSorted = false;
        return true;
    }

    public boolean add(int index, T element){//add element at a specified spot in the list
        if(element == null || (0 > index && index >= a.length)){//if element is null or out of bounds
            return false;
        }
        if(numEl == a.length){//if array is full
            T[] b = (T[]) new Comparable[(a.length * 2)];//make a new array and copy what was in a into b
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            a = b;
            for(int i =0;i< (numEl - index);i++) {//moves all elements to the right of the specified spot
                a[numEl - i] = a[numEl - (i+ 1)];
            }
            a[index] = element;
        }
        if(numEl < a.length){//if array is not full
            if(a[index] == null){//if spot is empty
                a[index] = element;//add element
            }else {
                for (int i = 0; i < (numEl - index); i++) {//moves all elements to the right of specified spot
                    a[numEl - i] = a[numEl - (i + 1)];
                }
            }
            a[index] = element;
        }

        numEl = numEl + 1;
        isSorted = false;
        return true;
    }

    public void clear(){//clears all elements in the list and resets size of list to 2
        for(int i = 0; i < numEl;i++){
            a[i] = null;
        }
        numEl = 0;
        //reset length of array to 2
        T[] b = (T[]) new Comparable[2];
        a = b;
    }

    public boolean contains(T element){//checks if element is in list
        if(isSorted == false){//returns true if element is in list
            for(int i = 0; i<numEl;i++){
                if(a[i].equals(element)){
                    return true;
                }
            }
        }else{//isSorted is true so find element in a more efficient way using binary search
                int middle = (int) Math.floor(numEl/2);//if the middle element in list is equal to the element passed in return true
                if(element.compareTo(a[middle]) == 0){
                    return true;
                }
                else if(element.compareTo(a[middle]) < 0){//if element is less then the middle element in the list
                    // create an array containing the upper half of list
                    ArrayList upper = new ArrayList();
                    for(int j =0; j< middle;j++){
                        upper.add(j,a[j]);
                    }
                    // call and return contains on that array with the same element as before
                    return upper.contains(element);
                }
                else if(element.compareTo(a[middle]) > 0){//if element is greater then the middle element in the list
                    // create an array containing the lower half of list
                    ArrayList lower = new ArrayList();
                    for(int k = 0; k < numEl - middle;k++){
                        lower.add(k,a[middle + k]);
                    }
                    // call and return contains on that array with the same element as before
                    return lower.contains(element);
                }

            }
        return false;
    }

    public T get(int index){//get element located at specified index
        if(0 <= index && index < a.length){
            return a[index];
        }
        return null;
    }

    public int indexOf(T element) {//return index of the first occurrence of an element
        int j = 0;
        if (isSorted == false) {
            if(element == null){
                return -1;
            }else{//returns index of first occurrence of an element
                for (int i = 0; i < numEl; i++) {
                    if (a[i].equals(element)) {
                        return i;
                    }
                }
            }
        }else {//if isSorted is true use binary search to find first occurrence of an element
            if (element == null) {
                return -1;
            }else{
                int middle = (int) Math.floor(numEl / 2);//if the middle element in list is equal to the element passed in return the index
                if(element.compareTo(a[middle]) == 0){
                    for(j = middle; j >= 0  && (a[j].equals(element)); j--){//check if the element occurs earlier in the list
                    }
                    return j+ 1;
                }
                 else if (element.compareTo(a[middle]) < 0) {//if element is less then the middle element in the list
                    // create an array containing the upper half of list
                    ArrayList upper = new ArrayList();
                    for (int l = 0; j < middle; l++) {
                        upper.add(l, a[j]);
                    }
                    // call and return contains on that array with the same element as before
                    return upper.indexOf(element);
                } else if (element.compareTo(a[middle]) > 0) {//if element is greater then the middle element in the list
                    // create an array containing the lower half of list
                    ArrayList lower = new ArrayList();
                    for (int k = 0; k < numEl - (middle + 1); k++) {
                        lower.add(k, a[middle +(k+1)]);
                    }
                    // call and return contains on that array with the same element as before
                    return lower.indexOf(element) + (middle + 1);
                }
            }

        }
        return -1;
    }

    public boolean isEmpty () {//checks if list is empty
        if (numEl == 0) {
            return true;
        }
        return false;
    }

    public int lastIndexOf (T element){//returns index of the last occurrence of an element
        int j = 0;
        if (isSorted == false) {
            if (element == null) {
                return -1;
            }else{//returns index of last occurrence of an element
                for (int i = numEl - 1; i >= 0; i--) {
                    if (a[i].equals(element)) {
                        return i;
                    }
                }
            }
        }else {//if isSorted is true use binary search to find last occurrence of an element
            if (element == null) {
                return -1;
            }else {
                int middle = (int) Math.floor(numEl / 2);//if the middle element in list is equal to the element passed in return the index
                if (a[middle].equals(element)) {
                    for (j = middle; j < numEl && a[j].equals(element); j++) {//check if the element occurs later in the list
                    }
                    return j - 1;
                } else if (element.compareTo(a[middle]) > 0) {//if element is greater then the middle element in the list
                    // create an array containing the upper half of list
                    ArrayList upper = new ArrayList();
                    for (int l = 0; j < middle; l++) {
                        upper.add(l, a[j]);
                    }
                    // call and return contains on that array with the same element as before
                    return upper.indexOf(element);
                } else if (element.compareTo(a[middle]) < 0) {//if element is less then the middle element in the list
                    // create an array containing the lower half of list
                    ArrayList lower = new ArrayList();
                    for (int k = 0; k < numEl - (middle + 1); k++) {
                        lower.add(k, a[middle + (k + 1)]);
                    }
                    // call and return contains on that array with the same element as before
                    return lower.indexOf(element) + (middle + 1);
                }
            }
        }
        return -1;
    }

    public T set ( int index, T element){//set specified location in list to element given and return element previously located there
        T oldEl = a[index];
        if ((0 > index && index >= a.length) || element == null) {
            return null;
        }
        a[index] = element;
        isSorted =false;
        return oldEl;
    }

    public int size () {//returns number of elements in list
        return numEl;
    }

    public void sort ( boolean order){//sorts list alphabetically
        if (isSorted == true && order == true) {
            //sorting is not necessary
        } else if (order == true) {//sort in ascending order
            for (int i = 1; i < numEl; i++) {
                T temp = a[i];
                for (int j = i - 1; j >= 0 && temp.compareTo(a[j]) < 0; j--) {
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
            isSorted = true;
        } else {//sort in descending order
            for (int i = 1; i < numEl; i++) {
                T temp = a[i];
                for (int j = i - 1; j >= 0 && temp.compareTo(a[j]) > 0; j--) {
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

    }


    public boolean remove(T element){//remove element from list
        int index = 0;
        if(element != null){
            for(int i = 0; i < numEl;i++){
                if(a[i].equals(element)){
                    a[i] = null;
                    index = i;
                }
            }
            numEl = numEl - 1;
            for(int i =0;i< (numEl-index) ;i++) {//shift elements to the left
                a[index + i] = a[index + (i+ 1)];

            }
            //remove last element in list
            a[numEl] = null;
            return true;
        }
        return false;
    }

    public T remove(int index) {//remove element from specified location in list
        if (0 > index && index >= a.length) {
            return null;
        }
        T oldEl = null;
        for (int i = 0; i < numEl; i++) {//delete element at index
            oldEl = a[index];
            a[index] = null;
        }
        numEl = numEl - 1;
        for (int i = 0; i < (numEl -index); i++) {
            a[index + i] = a[index + (i+1)];//shift elements to the left
        }
        a[numEl] = null;
        return oldEl;
    }

    public String toString(){//return string of every element in the list
        String allEl = "";
        for(int i =0; i < numEl;i++){
            allEl = allEl + a[i] + "\n";
        }
        return allEl;
    }
}