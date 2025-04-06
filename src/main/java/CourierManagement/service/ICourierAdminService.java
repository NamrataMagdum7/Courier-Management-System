package CourierManagement.service;

import CourierManagement.entity.Employee;

public interface ICourierAdminService {

    /**
     * Add a new courier staff member to the system.
     * @param obj The employee object to be added.
     * @return The ID of the newly added courier staff member.
     */
    int addCourierStaff(Employee obj);
}