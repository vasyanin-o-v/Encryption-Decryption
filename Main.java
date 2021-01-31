package encryptdecrypt;



public class Main {


    public static void main(String[] args) {
        AlgorithmMaker algorithmMaker = new AlgorithmMaker();
        algorithmMaker.parseArgs(args);
        algorithmMaker.doMagic();

    }
}
