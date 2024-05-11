import java.util.concurrent.Semaphore;

public class Pong implements  Runnable{

    private Semaphore s1, s2;
    private Controle contador;

    public Pong(Semaphore s1, Semaphore s2, Controle contador){
        this.s1 = s1;
        this.s2 = s2;
        this.contador = contador;
    }

    @Override
    public void run(){
        try{
            System.out.println("Thread B (PONG) iniciada!");
            while(contador.getControle() > 0){
                s2.acquire();
                System.out.println("0 <= PONG");
                s1.release();
                contador.decrementa();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread B (PONG) terminada!");
    }

}
