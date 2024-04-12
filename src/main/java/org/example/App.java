package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        UBAJson uba= new UBAJson();
        String filedta= "";
        String[] requests ;
        String[] respones ;
        File reader = new File("./uba.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(reader));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null){
            filedta=filedta+st;
        }
        requests= filedta.split("request-->");
        respones =new String[requests.length];
        for(int i=1;i<requests.length;i++){
            if(requests[i].contains("response-->")){
                respones[i] =requests[i].split("response-->")[1];

                requests[i]=requests[i].split("response-->")[0];
//                System.out.println("------REQUEST-------");
//                System.out.println(requests[i]);
//                System.out.println("------RESPONSE-------");
//                System.out.println(respones[i]);
                uba.jsonprepare(requests[i],respones[i]);
            }
        }


//        respones = filedta.split("response-->");





    }

}
