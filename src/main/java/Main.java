import dao.*;
import entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

//        Company company1 = new Company("Mango", BigDecimal.valueOf(1000000));
//        CompanyDAO.saveOrUpdateCompany(company1);
//
//        Company company2 = new Company("Ciela", BigDecimal.valueOf(90000));
//        CompanyDAO.saveOrUpdateCompany(company2);
//
//        Company company3 = new Company("Zoo market", BigDecimal.valueOf(70000));
//        CompanyDAO.saveOrUpdateCompany(company3);

//        Company company4 = new Company("", BigDecimal.valueOf(70000));
//        CompanyDAO.saveOrUpdateCompany(company4);

//        Company company = CompanyDAO.getCompany(5);
//        if (company != null) {
//            System.out.println(company);
//        }

//        CompanyDAO.deleteCompany(company);

        List<Company> companiesFilteredByName = CompanyDAO.filterByName("Pay Safe");
        System.out.println("---------  Companies filtered by name ----------");
        companiesFilteredByName.stream().forEach(System.out::println);

        List<Company> companiesFilteredByIncome = CompanyDAO.filterByIncome(BigDecimal.valueOf(10000));
        System.out.println("---------  Companies filtered by income ----------");
        companiesFilteredByIncome.stream().forEach(System.out::println);

        List<Company> companiesSortedByName = CompanyDAO.sortByName();
        System.out.println("---------  Companies sorted by name ----------");
        companiesSortedByName.stream().forEach(System.out::println);

        List<Company> companiesSortedByIncome = CompanyDAO.sortByIncome();
        System.out.println("---------  Companies sorted by income ----------");
        companiesSortedByIncome.stream().forEach(System.out::println);

//        Company company1 = CompanyDAO.getCompany(1);
//        Driver driver1 = new Driver("Ivan Ivanov", Driver.QualificationType.TRANSPORTATION_OF_MORE_THAN_12_PEOPLE, BigDecimal.valueOf(2000), company1);
//        DriverDAO.saveOrUpdateDriver(driver1);

//        Company company2 = CompanyDAO.getCompany(7);
//        Driver driver2 = new Driver("Petyr Petrov", Driver.QualificationType.LEGAL_CAPACITY_TO_TRANSPORT_SPECIAL_CARGO, BigDecimal.valueOf(4000), company2);
//        DriverDAO.saveOrUpdateDriver(driver2);

//        Company company3 = CompanyDAO.getCompany(8);
//        Driver driver3 = new Driver("Dimityr Dimitrov", Driver.QualificationType.LEGAL_CAPACITY_TO_TRANSPORT_SPECIAL_CARGO, BigDecimal.valueOf(6000), company3);
//        DriverDAO.saveOrUpdateDriver(driver3);
//
//        Driver driver4 = new Driver("Dimityr Dimitrov", Driver.QualificationType.TRANSPORTATION_OF_MORE_THAN_12_PEOPLE, BigDecimal.valueOf(4000), company3);
//        DriverDAO.saveOrUpdateDriver(driver4);
//
//        Driver driver5 = new Driver("Petyr Ivanov", Driver.QualificationType.LEGAL_CAPACITY_TO_TRANSPORT_SPECIAL_CARGO, BigDecimal.valueOf(6000), company3);
//        DriverDAO.saveOrUpdateDriver(driver5);
//
//        Company company4 = CompanyDAO.getCompany(11);
//        Driver driver6 = new Driver("Asen Ivanov", Driver.QualificationType.TRANSPORTATION_OF_MORE_THAN_12_PEOPLE, BigDecimal.valueOf(3000), company4);
//        DriverDAO.saveOrUpdateDriver(driver6);
//
//        Driver driver7 = new Driver("Ivaylo Petrov", Driver.QualificationType.LEGAL_CAPACITY_TO_TRANSPORT_SPECIAL_CARGO, BigDecimal.valueOf(4000), company4);
//        DriverDAO.saveOrUpdateDriver(driver7);

        List<Driver> driversFilteredByQualificationType = DriverDAO.filterByQualificationType(Driver.QualificationType.TRANSPORTATION_OF_MORE_THAN_12_PEOPLE);
        System.out.println("---------  Drivers filtered by qualification type ----------");
        driversFilteredByQualificationType.stream().forEach(System.out::println);

        List<Driver> driversFilteredBySalary = DriverDAO.filterBySalary(BigDecimal.valueOf(6000));
        System.out.println("---------  Drivers filtered by salary ----------");
        driversFilteredBySalary.stream().forEach(System.out::println);

        List<Driver> driversSortedByQualificationType = DriverDAO.sortByQualificationType();
        System.out.println("---------  Drivers sorted by qualification type ----------");
        driversSortedByQualificationType.stream().forEach(System.out::println);

        List<Driver> driversSortedBySalary = DriverDAO.sortBySalary();
        System.out.println("---------  Drivers filtered by salary ----------");
        driversSortedBySalary.stream().forEach(System.out::println);

//        Company company1 = CompanyDAO.getCompany(1);
//        Vehicle vehicle1 = new Vehicle(Vehicle.VehicleType.BUS, company1);
//        VehicleDAO.saveOrUpdateVehicle(vehicle1);

//        Company company2 = CompanyDAO.getCompany(7);
//        Vehicle vehicle2 = new Vehicle(Vehicle.VehicleType.BUS, company2);
//        VehicleDAO.saveOrUpdateVehicle(vehicle2);
//
//        Company company3 = CompanyDAO.getCompany(8);
//        Vehicle vehicle3 = new Vehicle(Vehicle.VehicleType.BUS, company3);
//        VehicleDAO.saveOrUpdateVehicle(vehicle3);
//
//        Vehicle vehicle4 = new Vehicle(Vehicle.VehicleType.TANK, company3);
//        VehicleDAO.saveOrUpdateVehicle(vehicle4);
//
//        Vehicle vehicle5 = new Vehicle(Vehicle.VehicleType.TRUCK, company3);
//        VehicleDAO.saveOrUpdateVehicle(vehicle5);
//
//        Company company4 = CompanyDAO.getCompany(11);
//        Vehicle vehicle6 = new Vehicle(Vehicle.VehicleType.BUS, company4);
//        VehicleDAO.saveOrUpdateVehicle(vehicle6);
//
//        Vehicle vehicle7 = new Vehicle(Vehicle.VehicleType.TRUCK, company4);
//        VehicleDAO.saveOrUpdateVehicle(vehicle7);
//
//        Client client1 = new Client("Ivana Ivanova");
//        ClientDAO.saveOrUpdateClient(client1);
//
//        Client client2 = new Client("Petyr Petrov");
//        ClientDAO.saveOrUpdateClient(client2);
//
//        Client client3 = new Client("Dimityr Petrov");
//        ClientDAO.saveOrUpdateClient(client3);
//
//        Client client4 = new Client("Vladimir Vladimirov");
//        ClientDAO.saveOrUpdateClient(client4);
//
//        Client client5 = new Client("Yoan Petrov");
//        ClientDAO.saveOrUpdateClient(client5);
//
//        Client client6 = new Client("Stoqn Dimitrov");
//        ClientDAO.saveOrUpdateClient(client6);
//
//        Company company1 = CompanyDAO.getCompany(1);
//        Driver driver1 = DriverDAO.getDriver(1);
//        Vehicle vehicle1 = VehicleDAO.getVehicle(1);
//
//        Transportation transportation1 =
//                new Transportation("Sandanski", "Sofiq",
//                        LocalDateTime.now(), LocalDateTime.now().plusHours(3),
//                        Transportation.TransportationType.PASSENGERS, BigDecimal.valueOf(0),
//                        BigDecimal.valueOf(60), company1, driver1, vehicle1);
//
//        transportation1.getClients().addAll(Arrays.asList(client1, client2));
//
//        TransportationDAO.saveOrUpdateTransportation(transportation1);

//        Company company2 = CompanyDAO.getCompany(8);
//        Driver driver2 = DriverDAO.getDriver(4);
//        Vehicle vehicle2 = VehicleDAO.getVehicle(4);
//        Client client3 = ClientDAO.getClient(5);
//
//        Transportation transportation2 =
//                new Transportation("Munich", "Paris",
//                        LocalDateTime.now(), LocalDateTime.now().plusDays(1),
//                        Transportation.TransportationType.STOCK, BigDecimal.valueOf(400),
//                        BigDecimal.valueOf(5000), company2, driver2, vehicle2);
//
//        transportation2.getClients().addAll(Arrays.asList(client3));
//
//        TransportationDAO.saveOrUpdateTransportation(transportation2);

        List<Transportation> transportationsFilteredByEndPoint = TransportationDAO.filterByEndPoint("London");
        System.out.println("---------  Transportations filtered by end point ----------");
        transportationsFilteredByEndPoint.stream().forEach(System.out::println);

        List<Transportation> transportationsSortedByEndPoint = TransportationDAO.sortByEndPoint();
        System.out.println("---------  Transportations sorted by end point ----------");
        transportationsSortedByEndPoint.stream().forEach(System.out::println);

        Company company = CompanyDAO.getCompany(8);
        List<Transportation> transportationsForCompany = TransportationDAO.getTransportationsForCompany(company);
        System.out.println("---------  Transportations for company " + company.getName() + " ----------");
        transportationsForCompany.stream().forEach(System.out::println);
        if (company!= null) {
            System.out.println("Number of transportations for company with id " + company.getId() + " : " + transportationsForCompany.size());
        }

        //Company company1 = CompanyDAO.getCompany(8);
        LocalDateTime fromDate = LocalDateTime.of(2022, 1,10,16,27,8);
        LocalDateTime toDate = LocalDateTime.of(2022, 1,10,17,0,8);
//
        List<Transportation> transportationsForCompanyFromDateToDate =
                TransportationDAO.getTransportationsForCompanyFromDateToDate(company,fromDate, toDate );
        System.out.println("---------  Transportations for company "+ company.getName() + " from " +fromDate +" to "+ toDate + " ----------");
        transportationsForCompanyFromDateToDate.stream().forEach(System.out::println);

        System.out.println("---------  Income from "+ fromDate +" to "+toDate +" for " + company.getName() + " ----------");
        System.out.println(CompanyDAO.getIncomeFromDateToDate(company, fromDate, toDate));

       // Company company = CompanyDAO.getCompany(8);
        System.out.println("---------  Income from transportations for " + company.getName() + " ----------");
        System.out.println(CompanyDAO.getIncomeFromTransportations(company));
    }
}
