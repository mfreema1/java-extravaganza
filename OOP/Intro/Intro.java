//class is a blueprint for an object
public class Intro {

    private int num;

    //constructor, same look as C++
    //you should not call setters or other methods
    //from the constructorjkljk;l
    public Intro(int num) {
        this.num = num;
    }

    //some methods are added to an object automatically by Java
    @Override
    public String toString() {
        return "The value is " + this.num;
    }

    public void setNumber(int num) {
        //same as in C++, use the 'this' keyword to distinguish
        //the field of the class instead of the parameter
        this.num = num;
    }
}

//Classes allow for variables that are accessible by any member
//of the class.  These are known as member variables, or fields

//Access modifiers modify who can see or touch a member of the class
//public -- unrestricted access
//private -- nobody can access, primarily used for encapsulation,
    //as members of the class can work on these and expose them
    //via some API
//protected -- only package can access