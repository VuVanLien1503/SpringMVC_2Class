package manager.service;

import manager.model.Employee;
import manager.my_interface.ICrud;
import manager.my_interface.ISearch;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements ICrud<Employee>, ISearch<Employee> {
    List<Employee> employeeList;
    RoomService roomService;

    public EmployeeService(RoomService roomService) {
        this.roomService = roomService;
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Lien", 23, "NamDinh", roomService.getListRoom().get(0)));
        employeeList.add(new Employee(2, "Hoang", 23, "ThaiBinh", roomService.getListRoom().get(1)));
        employeeList.add(new Employee(3, "Hoang1", 23, "ThaiBinh", roomService.getListRoom().get(1)));
        employeeList.add(new Employee(4, "Hoang2", 23, "ThaiBinh", roomService.getListRoom().get(1)));
        employeeList.add(new Employee(5, "Vu", 23, "HaNoi", roomService.getListRoom().get(2)));
        employeeList.add(new Employee(6, "Vu1", 23, "HaNoi", roomService.getListRoom().get(2)));
        employeeList.add(new Employee(7, "Vu2", 23, "HaNoi", roomService.getListRoom().get(2)));

    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void update(int index, Employee employee) {
        employeeList.set(index, employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeList.remove(employee);
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        for (Employee e :
                employeeList) {
            if (e.getId() == id) {
                employee = e;
                break;
            }
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String value) {
        List<Employee> list = null;
        for (Employee e :
                employeeList) {
            if (e.getName().toLowerCase().contains(value.toLowerCase())) {
                list.add(e);
            }
        }
        return list;
    }
}
