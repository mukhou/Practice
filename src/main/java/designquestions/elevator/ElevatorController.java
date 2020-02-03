/* 
User: Urmi
Date: 2/3/2020 
Time: 11:04 AM
*/

package designquestions.elevator;

public interface ElevatorController {
    public void status ();
    public Elevator getElevator(int elevatorID);
    public void update(int elevatorId, int floor);
    public void pickup(int floor , boolean direction);
    public void reset(int elevatorId, int floor);
    public void step();
}
