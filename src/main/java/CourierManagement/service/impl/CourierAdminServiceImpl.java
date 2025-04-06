package CourierManagement.service.impl;

import CourierManagement.entity.Employee;
import CourierManagement.service.ICourierAdminService;

import java.util.ArrayList;
import java.util.List;

public class CourierAdminServiceImpl implements ICourierAdminService {

    private static final List<Employee> employeeList = new ArrayList<>();
    private static int currentId = 1001;

    @Override
    public int addCourierStaff(Employee obj) {
        obj.setEmployeeID(currentId);
        employeeList.add(obj);
        return currentId++;
    }
}