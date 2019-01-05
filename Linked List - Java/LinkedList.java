//Written by bello067
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> a;
    private boolean isSorted;
    private int numEl;

    public LinkedList(){
        a = new Node<T>(null);
        isSorted = true;
        numEl = 0;
    }

    public boolean add(T element){//adds element to list
        if(element == null){
            return false;
        }else if(a.getNext() == null) { //if the list is empty
            Node<T> b = new Node<T>(element, null);//make a new node
            a.setNext(b);//add it to the empty list
            numEl += 1;
            isSorted = true;
        }else{ //if list has at least one element
            Node<T> head = a;//setting head = a doesn't cause changes to a
            for(int i =0; i<numEl;i++){//iterates to the end of the list
                a = a.getNext();
            }
            Node<T> c = new Node<T>(element,null);//makes the element a node pointing to null
            a.setNext(c);//sets end of the list to the new element
            a = head;//a is set to the new modified list
            numEl += 1;
        }
        isSorted = false;
        return true;
    }

    public boolean add(int index, T element) {//add element at certain index
        if(element != null && numEl == 0 && index == 0){//if there are no elements in the list and the chosen index is 0
            Node<T> newEl = new Node<T>(element);
            a.setNext(newEl);
            numEl +=1;
            isSorted = true;
        }
        else if(element == null || index < 0 || index >= numEl){
            return false;
        }else{//if list is not empty
            Node<T> temp = a.getNext();
            for(int i = 0; i<index;i++){//makes temp equal to element located at given index
                temp = temp.getNext();
            }
            Node<T> b = new Node<T>(element, temp);//makes a node of the given element pointing to the temp
            Node<T> temp2 = a.getNext();
            for(int i = 0; i<(index - 1);i++){//makes temp2 equal to element located before given index
                temp2 = temp2.getNext();
            }
            temp2.setNext(b);//sets element before given index equal to given element which is pointing to temp
        }
        numEl += 1;
        isSorted = false;
        return true;
    }

    public void clear(){
        a = new Node<T>(null);
        numEl = 0;
    }

    public boolean contains(T element){//returns true if element is in list
        if(isSorted == false) {
            Node<T> temp = a.getNext();
            while (temp != null) {
                if (temp.getData().equals(element)) {
                    return true;
                }
                temp = temp.getNext();
            }
        }else{//if list is sorted
            Node<T> temp = a.getNext();
            while(temp != null) {
                if(temp.getData().compareTo(element) <= 0) {//stops checking to see if element is in list if temp is greater then or equal to element
                    if(temp.getData().equals(element)){
                        return true;
                    }
                }
                temp = temp.getNext();
            }
        }
        return false;
    }

    public T get(int index){//returns element at given index
        Node<T> temp;
        if(index < 0 || index >= numEl){
            return null;
        }else{
            temp = a.getNext();
            for(int i = 0; i < index;i++){
                temp = temp.getNext();
            }
        }
        return temp.getData();
    }

    public int indexOf(T element){//return index of first occurrence of element
        if(isSorted == false){
            Node<T> temp;
            if(element == null){
                return -1;
            }else{
                temp = a.getNext();
                for(int i =0;i<numEl;i++){
                    if(temp.getData().equals(element)){
                        return i;
                    }
                    temp = temp.getNext();
                }
            }
        }else{//if list is sorted
            Node<T> temp;
            if(element == null){
                return -1;
            }else{
                temp = a.getNext();
                if(temp.getData().compareTo(element) <= 0) {//stops checking to see if element is in list if temp is greater then or equal to element
                    for(int i =0;i<numEl;i++){
                        if(temp.getData().equals(element)){
                            return i;
                        }
                        temp = temp.getNext();
                    }
                }
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(numEl == 0){
            return true;
        }
        return false;
    }

    public int lastIndexOf(T element){//return index of last occurrence of element
        int lastIndexOf = -1;
        if(isSorted == false) {
            Node<T> temp;
            if (element == null) {
                return -1;
            } else {
                temp = a.getNext();
                for (int i = 0; i < numEl; i++) {
                    if (temp.getData().equals(element)) {
                        lastIndexOf = i;
                    }
                    temp = temp.getNext();
                }
            }
        }else{//if list is sorted
            Node<T> temp;
            if(element == null){
                return -1;
            }else {
                temp = a.getNext();
                if (temp.getData().compareTo(element) <= 0) {//stops checking to see if element is in list if temp is greater then or equal to element
                    for (int i = 0; i < numEl; i++) {
                        if (temp.getData().equals(element)) {
                            lastIndexOf = i;
                        }
                        temp = temp.getNext();
                    }
                }

            }
        }
        return lastIndexOf;
    }

    public T set(int index, T element){//sets element at given index to given element and returns old element at given index
        T old;
        if(element == null || index < 0 || index >= numEl){
            return null;
        }else{
            Node<T> temp = a.getNext();
            for(int i =0;i<index;i++){
                temp = temp.getNext();
            }
            old =  temp.getData();
            temp.setData(element);
        }
        return old;
    }

    public int size(){
        return numEl;
    }


    public void sort(boolean order) {//sorts list
        if (isSorted == true && order == true) {
            //sorting not needed
        }else if (order == true) {//sort in ascending order
            for(int i = 0; i < numEl;i++){
                Node<T> currentNode = a.getNext();
                Node<T> next = a.getNext().getNext();
                for(int j =0; j < numEl -1;j++){
                    if(currentNode.getData().compareTo(next.getData()) > 0){//if currentNode is greater than next
                        //element swap places
                        T temp = currentNode.getData();
                        currentNode.setData(next.getData());
                        next.setData(temp);
                    }
                    currentNode = next;
                    next = next.getNext();
                }
            }
            isSorted = true;
        }else{//sort in descending order
            for(int i = 0; i < numEl;i++){
                Node<T> currentNode = a.getNext();
                Node<T> next = a.getNext().getNext();
                for(int j =0; j < numEl -1;j++){
                    if(currentNode.getData().compareTo(next.getData()) < 0){//if currentNode is less than next
                        //element swap places
                        T temp = currentNode.getData();
                        currentNode.setData(next.getData());
                        next.setData(temp);
                    }
                    currentNode = next;
                    next = next.getNext();
                }

            }
        }

    }


    public boolean remove(T element) {//removes element from list
        int index = 0;
        Node<T> before;
        Node<T> after;
        index = this.indexOf(element);//gets index of element
        before = a.getNext();
        for(int i =0; i < (index -1);i++){//gets element located before given element
            before = before.getNext();
        }
        after =a.getNext();
        for(int i =0; i< (index+1);i++){//gets element located after given element
            after = after.getNext();
        }
        if(index == -1){//if element not in list
            return false;
        }
        before.setNext(after);//sets element before given element to element after given element
        numEl -= 1;
        return true;
    }

    public T remove(int index) {//removes element at given index
        Node<T> el;
        Node<T> after;
        Node<T> before;
        if(index < 0 || index >= numEl){
            return null;
        }
        el = a.getNext();
        for(int i =0;i<index;i++){//gets element at given index
            el = el.getNext();
        }
        before = a.getNext();
        for(int i =0;i <(index-1);i++){//gets element before given index
            before = before.getNext();
        }
        after = a.getNext();
        for(int i =0;i<(index +1);i++){//gets element after given index
            after = after.getNext();
        }
        before.setNext(after);//sets element before given element to element after given element
        numEl -= 1;
        return el.getData();
    }

    public String toString() {
        String allData = "";
        Node<T> el = a.getNext();
        for(int i =0; i < numEl;i++){
            allData += el.getData()+ "\n";
            el = el.getNext();
        }
        return allData;
    }
}
