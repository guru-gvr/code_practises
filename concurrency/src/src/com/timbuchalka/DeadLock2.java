package src.com.timbuchalka;

public class DeadLock2 {

    public static void main(String[] args) {
       final PolitePerson manoj = new PolitePerson("manoj");
       final PolitePerson babu = new PolitePerson("babu");

       new Thread(() ->{
           manoj.sayHello(babu);
       }).start();

       new Thread(() -> {
           babu.sayHello(babu);
       }).start();

    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }
        public String getName(){
            return this.name;
        }

        public synchronized void sayHello(PolitePerson politePerson){
            System.out.printf("%s : %s"+" has said hello to me %n",this.name,politePerson.getName());
            politePerson.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson politePerson){
            System.out.printf("%s : %s"+" has said hello back to me %n",this.name,politePerson.getName());
        }
    }
}
