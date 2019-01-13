public class Main {
    
    public static void main(String[] args) {
        String[] words = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "xenophobe",
            "asymptote",  // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage",
        };

        System.out.println(rotationPoint(words));
    }

    public static int rotationPoint(String[] words) {
        //grab the first and last indices and see if they are in order
        int front = 0;
        int back = words.length - 1;
        while(front < back) {
            
            int midpoint = (front + back) / 2;
            System.out.print("Front: " + front + ", " + "Back: " + back + ", ");
            System.out.print("Index: " + midpoint + ", ");
            System.out.println("Trying: " + words[midpoint]);
            if(words[midpoint].compareTo(words[midpoint - 1]) < 0) {
                //found it!
                return midpoint;
            }
            //do we need to go up or down
            else {
                //compare the midpoint against front, alter front or back
                if(words[midpoint].compareTo(words[front]) > 0 && words[midpoint].compareTo(words[back]) > 0) {
                    //midpoint is lexically after both front and back, means we must go down
                    front = midpoint + 1;
                }
                else {
                    //otherwise, go up
                    back = midpoint - 1;
                }
            }
        }
        return -1;
    }
}