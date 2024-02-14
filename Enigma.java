public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String encrypt(String message){ 
        char[] newString = message.toCharArray();
        int num;
        char charVal;
        for(int i =0; i < message.length(); i++){
            num = rotors[0].indexOf(newString[i]);
            charVal = rotors[2].charAt(num);
            num = rotors[1].indexOf(charVal);
            newString[i] = rotors[2].charAt(num);
            this.rotate();
        }
        return new String(newString);
        
    }


    
    public String decrypt(String message){
        char[] newString = message.toCharArray();
        int num;
        char charVal;

        for(int i = 0; i < message.length();i++){
            num = rotors[2].indexOf(newString[i]);
            charVal = rotors[1].charAt(num);
            num = rotors[2].indexOf(charVal);
            newString[i] = rotors[0].charAt(num);
            rotate();

        }

        return new String(newString);
        
        
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
