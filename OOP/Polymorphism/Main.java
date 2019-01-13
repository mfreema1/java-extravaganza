//Polymorphism is the ability of something to take on many different
//forms.  For example, let's show the bark() method of some dogs.

class Dog {

    public void bark() {
        System.out.println("Woof!");
    }
}

class Pitbull extends Dog {

    @Override
    public void bark() {
        System.out.println("Arf!");
    }
}

class Schnauzer extends Dog {

    //Not overriding the bark method 
}

class Main {

    public static void main(String[] args) {

        Schnauzer schnauzer = new Schnauzer();
        Pitbull pitbull = new Pitbull();

        //could put them into a collection and loop over
        //just call same method, observe different functionality
        schnauzer.bark();
        pitbull.bark();
    }
}