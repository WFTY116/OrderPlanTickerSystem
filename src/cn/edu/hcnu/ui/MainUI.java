package cn.edu.hcnu.ui;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.IFlightService;
import cn.edu.hcnu.bll.impl.FlightServiceImpl;

import java.util.Scanner;
import java.util.UUID;

public class MainUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//接受键盘输
        while (true) {
            System.out.println("按1，录入航班信息");
            System.out.println("按2，显示所有航班信息");
            System.out.println("按3，查询航班信息");
            System.out.println("按4，机票预订");
            System.out.println("按5，机票退订");
            System.out.println("按6，退出系统");

            int choice=sc.nextInt();

            if(choice == 1){
                String  id = UUID.randomUUID().toString().replace("-","");


                //对象
                System.out.print("请输入航班编号：");
                String flightId=sc.next();
                System.out.print("请输入机型：");
                String planeType=sc.next();
                System.out.print("请输入座位数：");
                int currentSeatsNum=sc.nextInt();
                System.out.print("请输入起飞机场：");
                String departureAirport=sc.next();
                System.out.print("请输入目的机场：");
                String destinationAirport=sc.next();
                System.out.print("请输入起飞时间：");
                String departureTime=sc.next();

                Flight flight=new Flight(id,flightId,planeType,currentSeatsNum,
                        departureAirport,destinationAirport,departureTime);

                IFlightService iFlightService=new FlightServiceImpl();//用接口实现面向对象
                iFlightService.insertFlight(flight);
            }
        }
    }
}
