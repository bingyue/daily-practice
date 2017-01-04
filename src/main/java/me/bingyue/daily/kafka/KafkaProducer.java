package me.bingyue.daily.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

public class KafkaProducer extends Thread{
	
	private String topic;  
    
    public KafkaProducer(String topic){  
        super();  
        this.topic = topic;  
    }  
    
    public static void main(String[] args) {  
    	KafkaProducer kafkaProducer=  new KafkaProducer("distributedlog");// 使用kafka集群中创建好的主题   
    	kafkaProducer.start();
    }  
      
      
    @Override  
    public void run() {  
        Producer producer = createProducer();  
        System.out.println("*********send********"); 
        int i=0;  
        while(true){  
        	i++;
        	String message="第一条" +i+"日志";
            producer.send(new KeyedMessage<Integer, String>(topic, message));  
            System.out.println("发送"+message); 
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    private Producer createProducer() {  
        Properties properties = new Properties();  
        properties.put("zookeeper.connect", "192.168.109.58:2182,192.168.109.70:2182,192.168.109.91:2182");//声明zk  
        properties.put("serializer.class", StringEncoder.class.getName());  
        properties.put("metadata.broker.list", "192.168.109.58:9092,192.168.109.70:9092,192.168.109.91:9092");// 声明kafka broker  
        return new Producer<Integer, String>(new ProducerConfig(properties));  
     }  
      
      
    
}
