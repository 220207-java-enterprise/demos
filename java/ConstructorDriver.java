public class ConstructorDriver {

    public static void main(String[] args) {
    
        AppUser me = new AppUser("wsingleton", "password");
        System.out.println(me);
        
        AppUser myClone = new AppUser(me);
        System.out.println(myClone);
        System.out.println(myClone.originalToString());
        System.out.println(((Object) myClone)); // still uses AppUser#toString
        
        // == checks to see if two references point to the EXACT SAME object
        System.out.println(me == myClone);
        
        System.out.println(me.equals("hello"));
        System.out.println(me.equals(myClone)); 
        
    }
}
              /* implicit */
class AppUser extends Object {

    public String username;
    public String password;
    
    public AppUser(String username, String password) {
        super(); // technically always here, even if you don't explictly write it out
        this.username = username;
        this.password = password;
    }
    
    public AppUser(AppUser user) {
        this.username = user.username;
        this.password = user.password;
    }
    
    //@Override
    //public void wontWork() {
    //
    //}
    
    // I probably would never actually do this.
    public String originalToString() {
        return super.toString();
    }
   
    //@Override
    public String toString() {
        return "AppUser{\n\tusername=" + username + ",\n" + "\tpassword=" + password + "\n}";
    }
    
    @Override
    public boolean equals(Object o) {
    
        if (o == null) {
            return false;
        } 
        if (!(o instanceof AppUser)) {
            System.out.println("o was not an AppUser");
            return false;
        }
        
        AppUser otherUser = (AppUser) o;
        
        // if your if/else/while/for statement is only a single expression, curly braces are optional
        if (!this.username.equals(otherUser.username) || !this.password.equals(otherUser.password)) return false;
        
        return true;
    }
    
}
