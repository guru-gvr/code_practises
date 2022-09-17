package src.com.timbuchalka;

public class LiveLock {


    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker 1 ",true);
        Worker worker2 = new Worker("Worker 2 ",true);
        SharedResource sharedResource = new SharedResource(worker1);
        new Thread(() ->{
            worker1.work(sharedResource,worker2);
        }).start();

        new Thread(() ->{
            worker2.work(sharedResource,worker1);
        }).start();
    }



}

class SharedResource {
    private Worker owner;

    public Worker getOwner() {
        return owner;
    }

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }
}

class Worker {
    private String name;
    private boolean isActive;

    public Worker(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public synchronized void work(SharedResource sharedResource,Worker otherWorker) {
        while(isActive) {
            System.out.println("Shared resource owner name "+ sharedResource.getOwner().getName()+" Current worker name "+ this.getName());
            if(sharedResource.getOwner() != this) {
                try {
                    wait(10);
                }catch (InterruptedException exception){
                    System.out.println("Exceptiom");
                }
                continue;
            }

            if(otherWorker.isActive){
                System.out.println("Giving to other worker"+otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }
            this.isActive = false;
            System.out.println("Completed working on shared resource by "+this.getName());
            sharedResource.setOwner(otherWorker);
        }
    }
}
