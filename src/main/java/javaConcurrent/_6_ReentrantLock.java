package javaConcurrent;

/**
 * Reentrancy -> you do something, and while you are still doing it, you do it again:
 *
 *          synchronized (objLock) {
 *              doSomething(lock, ...)
 *          }
 *          public void doSomething(Object lock, ...) {
 *              synchronized (lock) {
 *              }
 *          }
 *
 * STATES TO UNDERSTAND DIFFERENCES BETWEEN SYNCHRONIZE AND LOCK
 * --------------------------------------------------------------------------------------------
 * WAITING -> thread calls wait()
 * BLOCKED -> thread is notified but has not object lock yet
 *
 * Synchronize code DRAWBACKS
 *---------------------------------------------------------------------------------------------
 * 1. Threads can be suspended while executing a single line:
 *    double a = 2.0; long b = 2L;
 *    ATOMIC obj1.equals(obj2) and read/write primitive except long/double
 *
 * 2. thread are blocked wait to execute sync can't be interrupted. Wait until obtain the intrinsic lock.
 *    SOL -> use Lock
 *
 * 3. We can't test if an object intrinsic lock is available
 *    SOL -> Lock has tryLock() and tryLock(time)
 *
 * 4. The sync block must be within the same method. we can't start a sync block in one method and end in another
 *    SOL -> Call Lock() in one method and unLock() in other method.
 *
 * 5. If multiple threads are waiting to get a lock it's not first come first served
 *    SOL -> ReentrantLock(true) FIFO

 */
public class _6_ReentrantLock {
    //https://stackoverflow.com/questions/18356795/static-versus-non-static-lock-object-in-synchronized-block
}
