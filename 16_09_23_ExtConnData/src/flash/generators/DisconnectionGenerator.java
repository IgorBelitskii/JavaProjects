package flash.generators;
import flash.handler.EventHandler;

import java.util.Random;

public class DisconnectionGenerator extends Thread {
 EventHandler eventHandler;
 long nIterations;
 
 
 public DisconnectionGenerator(EventHandler eventHandler, long nIterations) {
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
     eventHandler.addEventEnd("sourceIp" + i + ":SourcePort" + i+" DestIp" + i + "DestPort" + i+" " + i);
 //    System.out.println("Added END event"+"sourceIp" + i + ":SourcePort" + i+" DestIp" + i + "DestPort" + i +" " + i);
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
