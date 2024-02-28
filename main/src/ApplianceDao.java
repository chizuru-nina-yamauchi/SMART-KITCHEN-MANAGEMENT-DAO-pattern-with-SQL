package src;

import java.util.Set;

/*
*  Make an interface called ApplianceDao
*   - This interface should have no methods
*  This interface will be implemented by ApplianceDaoImpl because it will be used to interact with the database
*    - ApplianceDaoImpl will be used to interact with the database
* */
public interface ApplianceDao {
    Appliance getApplianceById(Integer id);
    Appliance getApplianceByName(String name);
    Set<Appliance> getAllAppliances();
    Appliance insertAppliance(Appliance appliance);
    boolean updateAppliance(Appliance appliance);
    boolean deleteAppliance(Integer id);
}
