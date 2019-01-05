//Written by bello067
public class ElephantHerd {

    int numEl;
    private List<Elephant> elephants;

    public ElephantHerd(){
        elephants = new LinkedList<>();
        numEl = 0;
    }

    public boolean add(Elephant ellie){//adds element to list
        elephants.add(ellie);
        numEl = numEl + 1;
        return true;
    }

    public Elephant find(String name){//returns elephant that has name in it's name
        for(int i = 0;i<numEl;i++){
            if(elephants.get(i).getName().contains(name)){
                return elephants.get(i);
            }
        }
        return null;
    }

    public Elephant remove(int index){//removes element at index
        if(0 <= index && index < elephants.size()){
            elephants.add(index,null);
            numEl = numEl -1;
        }
        return null;
    }

    public void clear(){//clears elements in list
        for(int i = 0; i < numEl;i++){
            elephants.set(i,null);
        }
        numEl = 0;
        List<Elephant> b = new LinkedList<>();
        elephants = b;
    }

    public void sort(){//sorts elephants by height
        for (int i = 1; i < numEl; i++) {
            Elephant temp = elephants.get(i);
            for (int j = i - 1; j >= 0 && temp.getHeight() > elephants.get(j).getHeight(); j--) {
                elephants.set(j+1,elephants.get(j));
                elephants.set(j,temp);
            }
        }
    }

    public Elephant[] getTopKLargestElephants(int k){
        Elephant[] b = new Elephant[k];
        if(numEl == 0){
            return null;
        }
        else if(numEl < k){//if number of elements are less then k return array of length numel
            for (int i = 1; i < numEl; i++) {
                Elephant temp = elephants.get(i);
                for (int j = i - 1; j >= 0 && temp.getHeight() > elephants.get(j).getHeight(); j--) {
                    elephants.set(j+1,elephants.get(j));
                    elephants.set(j,temp);
                }
            }
            Elephant[] c = new Elephant[numEl];
            for(int i = 0; i<numEl;i++){
                c[i] = elephants.get(i);
            }

            return c;
        }else{
            for (int i = 1; i < numEl; i++) {
                Elephant temp = elephants.get(i);
                for (int j = i - 1; j >= 0 && temp.getHeight() > elephants.get(j).getHeight(); j--) {
                    elephants.set(j+1,elephants.get(j));
                    elephants.set(j,temp);
                }
            }
            for(int i = 0; i<k;i++){
                b[i] = elephants.get(i);
            }
        }
        return b;
    }

    public Elephant getIndex(int index) {//returns elephant at index
        if (!(0 <= index && index < elephants.size())) {
            return null;
        } else {
            return elephants.get(index);
        }
    }

    public String toString() {//returns string of all elements in list
        String allEl = "";
        for (int i = 0; i < numEl; i++) {
            allEl = allEl + elephants.get(i) + "\n";
        }
        return allEl;
    }

}
