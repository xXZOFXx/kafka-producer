package com.mycompany.kafka.app;


import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author e-zof
 */
public class SampleProducer {

    public SampleProducer() {
        //declaracion de variables
        String mensajeCaptura;
         int menu;
        Scanner DatoVacio = new Scanner(System.in);
        //propiedades de kafka
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

       //se pide al ussuari capturar un valor
       
            System.out.println("¿Desea un campo en la base");
            System.out.println("1. Si");
            System.out.println("2. no");

      
        
      
      menu = DatoVacio.nextInt();
      
             while (menu == 1) {

           
                //envio de info capturada a la base de datos 
               Scanner datoNuevo = new Scanner(System.in);  
                    System.out.println("Por favor ingresa texto para que se registre en la base:");
                    
                    mensajeCaptura = datoNuevo.nextLine();
                    ProducerRecord producerRecord = new ProducerRecord("channel", "name", mensajeCaptura);

                    KafkaProducer kafkaProducer = new KafkaProducer(properties);

                    kafkaProducer.send(producerRecord);
                   
                    
                    System.out.println("campos mandados correctamente");
                   
                    
             }
                
                   
        
    
        System.out.println("Buen día");

    }

}
