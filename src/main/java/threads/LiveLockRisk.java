/* 
User: Urmi
Date: 1/27/2020 
Time: 4:59 PM
*/

package threads;

public class LiveLockRisk {
    public static void main(String[] args){
        //both workers active
        final Worker worker1 = new Worker("Worker 1 ", true);
        final Worker worker2 = new Worker("Worker 2", true);

        //one shared object
        final SharedResource1 s = new SharedResource1(worker1);
        new Thread(() -> {
            worker1.work(s, worker2);
        }).start();

        new Thread(() -> {
            worker2.work(s, worker1);
        }).start();
    }
}

class Worker{
    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource1 sharedResource, Worker other){
        while (active){
            // wait for the resource to become available.
            if(sharedResource.getOwner() != this){
                try {
                    wait(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                continue;
            }
            // If other worker is also active let it do it's work first
            if(other.isActive()){
                System.out.println(getName() + " : handover the resource to the worker " + other.getName());
                sharedResource.setOwner(other);
                continue;
            }
            //now use the commonResource
            System.out.println(getName() + ": working on the common resource");
            active = false;
            sharedResource.setOwner(other);
        }

    }
}

class SharedResource1{
    private Worker owner;

    public SharedResource1(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
