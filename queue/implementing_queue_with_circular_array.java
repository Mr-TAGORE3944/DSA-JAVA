package queue;

public class implementing_queue_with_circular_array {
    

    public static class CirQueue {
        int r = -1;
        int f = -1;
        int[] arr = new int[5];
        int size = 0;

        public void add(int val){
            
            if(size == 0){
                f = r = 0;
                arr[0] = val;
            }
            else if(size == arr.length){
                System.out.println("Queue is full!");
                return;
            }
            else if(r == arr.length-1){
                r = 0;
                arr[0] =  val;
            }
            else if(r < arr.length){
                arr[++r] = val;
            }
            size++;
        }

        public int pop(){
            if(size == 0){
                System.out.println("Queue is Empty!");
                return -1;
            }
            else {
                if(f == arr.length-1){
                int x = arr[f];
                f = 0;
                size--;
                return x;
            }else{
                int x = arr[f];
                f++;
                size--;
                return x;
            }
        }
            
        }

        public int peek(){
            if(size == 0){
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[f];
        }

        public void display(){
            if(size == 0){
                System.out.println("Queue is Empty!");
                return;
            }
            if(f < r){
                for(int i = f; i <= r; i++){
                    System.out.print(arr[i] + " ");
                }
            }else if(r < f){
                for(int i = f ; i<= arr.length-1 ; i++){
                    System.out.print(arr[i] + " ");
                }
                for(int i = 0 ; i <= r ; i++){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        
    }


public static void main(String[] args) {
    

    CirQueue q = new CirQueue();
    q.display();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    q.display();
    q.pop();
    q.pop();
    q.pop();
    q.add(6);
    q.add(7);
    q.add(8);
    q.add(4);



    q.display();
}


}
