class CircularList{
    static class Node{int item;int next;}
    static Node M[];
    static int free;
    static int N = 1000;

    CircularList(){
        M=new Node[N+1];
        for(int i=0; i<N; i++){
            M[i] = new Node(); M[i].next = i+1;
        }
        M[N] = new Node(); M[N].next = 0;free=0;
    }
    Node next(Node x){
       return M[x.next];
    }
    int item(Node x){
        return x.item;
    }

    Node insert(Node x,int v){
        int i = free; free =M[free].next;
        M[i].item = v;
        if (x==null){
            M[i].next = i;
        }else{
            M[i].next = x.next; x.next = i;
        }
        return M[i];
    }

    void remove(Node x){
        int i = x.next; x.next = M[i].next;
        M[i].next = free; free=i;
    }
}