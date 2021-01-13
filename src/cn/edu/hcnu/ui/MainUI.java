package cn.edu.hcnu.ui;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.IFlightService;
import cn.edu.hcnu.bll.impl.FlightServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUI {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);//接受键盘输入
        while (true) {
            System.out.println("按1，录入航班信息");
            System.out.println("按2，显示所有航班信息");
            System.out.println("按3，查询航班信息");
            System.out.println("按4，机票预订");
            System.out.println("按5，机票退订");
            System.out.println("按6，退出系统");

            int choice = sc.nextInt();

            if (choice == 1) {
                String id = UUID.randomUUID().toString().replace("-", "");


                //对象
                System.out.print("请输入航班编号：");
                String flightId = sc.next();
                System.out.print("请输入机型：");
                String planeType = sc.next();
                System.out.print("请输入座位数：");
                int currentSeatsNum = sc.nextInt();
                System.out.print("请输入起飞机场：");
                String departureAirport = sc.next();
                System.out.print("请输入目的机场：");
                String destinationAirport = sc.next();
                System.out.print("请输入起飞时间：");
                String departureTime = sc.next();

                Flight flight = new Flight(id, flightId, planeType, currentSeatsNum,
                        departureAirport, destinationAirport, departureTime);
                IFlightService iFlightService = new FlightServiceImpl();
                try {
                    iFlightService.insertFlight(flight);
                } catch (SQLException e) {
                    String errorMessage = e.getMessage();
                    if (errorMessage.startsWith("ORA-12899")) {
                        //ORA-12899: value too large for column "OPTS"."FLIGHT"."ID" (actual: 32, maximum: 30)
                        // 按指定模式在字符串查找
                        String pattern = "(\\w+-\\d{5}):(\\s\\w+)+\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                        /*
                        正则表达式（非打印字符相关含义可百度）：
                        若(\\w+-\\d{5}):(\\s\\w+)中有一个规则可用来表达这些，则不需要这串
                        String pattern = "(\\w+-\\d{5}):(\\s\\w+)+\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                        中为的“：”正则表达式中无含义，则直接用“：”。
                        \d表示数字，\s为空格，\w表示字母，\w+表示多个字母相加，即为一串字符，一个括号为一组
                        (\\w+-\\d{5}):    这个即可得到ORA-12899:
                        (\\s\\w+)         这个即可得value too large for column
                        \\s("\w+\")         这个即可得  "OPTS"
                        \\.(\"\\w+\")\\.("\\w+\")        这个即可得"FLIGHT"."ID"
                        */
                        // 创建 Pattern 对象
                        Pattern r = Pattern.compile(pattern);
                        // 现在创建 matcher 对象
                        Matcher m = r.matcher(errorMessage);
                        if (m.find()) {
                            String tableName = m.group(4);
                            String columnName = m.group(5);
                            System.out.println(tableName + "表的" + columnName + "这一列的值过大，请仔细检查，联系管理员");
                        } else {
                            System.out.println("NO MATCH");
                        }
                    }
                }
            }else if (choice == 2) {
                IFlightService iFlightService = new FlightServiceImpl();
                try {
                    Set<Flight> allFlights=iFlightService.getAllFlights();
                    /*
                    Set的遍历需要用到迭代器
                     */
                    for(Flight flight:allFlights){
                        System.out.println(flight);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}