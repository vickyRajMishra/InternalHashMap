public class CustomHashMap<T, S> {
    private Node<T, S>[] nodes;
    private int size;

    CustomHashMap(){
        size = 16;
        nodes = new Node[size];
    }

    public boolean put(T key, S val){
        int index = key.hashCode() % size;

        Node<T, S> temp = new Node<>();
        temp.hash = key.hashCode();
        temp.key = key;
        temp.value = val;
        if(nodes[index]!=null){
            Node<T, S> tt = nodes[index];
            Node<T, S> prev = null;
            while(tt!=null){
                if(tt.hash == key.hashCode()){
                    tt.value = val;
                    return false;
                }
                prev = tt;
                tt = tt.next;
            }
            prev.next = temp;
        }
        else{
            nodes[index] = temp;
        }
        return true;
    }

    public S get(T key){
        int index = key.hashCode() % size;
        if(nodes[index] != null){
            Node<T, S> tt = nodes[index];
            while(tt!=null){
                if(tt.hash==key.hashCode())
                    return tt.value;
                tt = tt.next;
            }
        }
        return null;
    }

    public boolean remove(T key){
        int index = key.hashCode() % size;
        if(nodes[index] != null){
            Node<T, S> tt = nodes[index];
            Node<T, S> prev = null;
            while(tt!=null){
                if(tt.hash==key.hashCode()){
                    if(prev == null) {
                        nodes[index] = null;
                        return true;
                    }
                    prev.next = tt.next;
                }
                prev = tt;
                tt = tt.next;
            }
            return true;
        }
        return false;
    }
}

