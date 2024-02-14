public class Rotor {

    public static void main(String args[]){
        
        Rotor tester = new Rotor("helloWorld*",'h');
        tester.rotate();
        System.out.println(tester.toString());
        
    }
    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        String newString = "";
        newString += this.rotorValues.charAt(this.rotorValues.length()-1);
        for (int i = 0; i < this.rotorValues.length()-1; i++) {newString += this.rotorValues.charAt(i);}
        rotorValues = newString;
        if(rotorValues.charAt(0) == this.startChar) return true;
        else return false;
    }
    

    public int indexOf(char c){
        return this.rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        return  this.rotorValues.charAt(idx);
    }

    public String toString(){
        return this.rotorValues;
    }
}
    
