
package com.epam.composite;

/**
 * Created by Sergey_Stefoglo on 8/18/2016.
 */

public class EpamKazakhstanStruture {

   public static Epamer getEpamKazakhstanStructure(){
       Epamer  epamer=new Epamer("Alexey_Axyonov","Senior Software Engineering Manager");


       Epamer  teamC=new Epamer("Ivan_Minakov","Software Engineering Team Leader");
       teamC.getTeam().add(new Epamer("Alexand_Cheglov","Senior Software Engineer"));
       teamC.getTeam().add(new Epamer("Anatoliy_Goncharov","Software Engineer"));
       teamC.getTeam().add(new Epamer("Maxim_Fateyev","Lead Software Engineer"));
       teamC.getTeam().add(new Epamer("Maxim_Peters","Junior Software Engineer"));
       teamC.getTeam().add(new Epamer("Mikhail_Voloshin","Senior Software Engineer"));
       teamC.getTeam().add(new Epamer("Oleg_Motorin","Software Engineer"));
       teamC.getTeam().add(new Epamer("Ruslan_Nukeshtayev","Senior Software Engineer"));
       teamC.getTeam().add(new Epamer("Sergey_Stefoglo","Software Engineer"));
       teamC.getTeam().add(new Epamer("Serik_Idrisov","Senior Software Engineer"));

       epamer.getTeam().add(teamC);

       Epamer teamInt=new Epamer("Konstantin_Emshanov","Lead Software Engineer");
       teamInt.getTeam().add(new Epamer("Alexandr_Koryagin","Software Engineer"));
       teamInt.getTeam().add(new Epamer("Andrey_Bindyuk","Junior Software Engineer"));
       teamInt.getTeam().add(new Epamer("Sergey_Chernikov","Software Engineer"));
       teamInt.getTeam().add(new Epamer("Yelena_Zakharevich","Senior Software Engineer"));
       epamer.getTeam().add(teamInt);

       Epamer teamJedy=new Epamer("Anuar_Nurmakanov","Lead Software Engineer");
       teamJedy.getTeam().add(new Epamer("Andrey_Yun","Software Engineer"));
       teamJedy.getTeam().add(new Epamer("Igor_Polchshikov","Junior Software Engineer"));
       teamJedy.getTeam().add(new Epamer("Andrey_Kovalskiy","Software Engineer"));
       teamJedy.getTeam().add(new Epamer("Andrey_Gladyshev","Software Engineer"));
       teamJedy.getTeam().add(new Epamer("Luka_Giorgadze","Software Engineer"));
       teamJedy.getTeam().add(new Epamer("Pavel_Bobylev","Software Engineer"));
       teamJedy.getTeam().add(new Epamer("Tatyana_Gladysheva","Software Engineer"));
       teamJedy.getTeam().add(new Epamer("Almas_Doskozhin","Senior Software Engineer"));
       epamer.getTeam().add(teamJedy);

       Epamer teamAstana=new Epamer("Igor_Zhukov","Lead Software Engineer");
       teamAstana.getTeam().add(new Epamer("Alexander_Ketov","Software Engineer"));
       teamAstana.getTeam().add(new Epamer("Arman_Baikenzhin","Lead Software Engineer"));
       teamAstana.getTeam().add(new Epamer("Anatoliy_Poliyenko","Software Engineer"));
       teamAstana.getTeam().add(new Epamer("Askhat_Shagirov","Lead Software Engineer"));

       teamAstana.getTeam().add(new Epamer("Bakytzhan_Manaspayev","Software Engineer"));
       teamAstana.getTeam().add(new Epamer("Bekzat_Shymbolat","Software Engineer"));
       teamAstana.getTeam().add(new Epamer("Khamid_Sarmanov","Junior Software Engineer"));
       teamAstana.getTeam().add(new Epamer("Nikolay_Volik","Senior Software Engineer"));
       teamAstana.getTeam().add(new Epamer("Rashid_Kinzibayev","Software Engineer"));
       epamer.getTeam().add(teamAstana);


       return epamer;
   }

}
