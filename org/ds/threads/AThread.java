package org.ds.threads;

public class AThread implements Runnable {


  @Override
    public void run(){
      try {
          Thread.sleep(3000);
          System.out.println("Running Thread is : " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  }

}
