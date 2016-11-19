package flash.generators;
import flash.handler.EventHandler;

import java.util.Random;

public class ConnectionGenerator extends Thread {
 EventHandler eventHandler;
 long nIterations;
 
 
 public ConnectionGenerator(EventHandler eventHandler, long nIterations) {
  super();
  this.eventHandler = eventHandler;
  this.nIterations = nIterations;
 }

 

 @Override
 public void run() {
  for (int i = 0; i < nIterations; i++) {
   int probability = getProbability();
   if(probability == 1)
    continue;
   else {
    try {
     sleep(probability);
     eventHandler.addEventStart("sourceIp" + i + ":SourcePort" + i+" DestIp" + i + "DestPort" + i +" " + i);
 //    System.out.println("Added START event"+"sourceIp" + i + ":SourcePort" + i+" DestIp" + i + "DestPort" + i +" " + i);
    } catch (InterruptedException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   }
  }
  
 }
 
 
 private int getProbability() {
  Random random = new Random();
  return random.nextInt(3);

 }
 
}