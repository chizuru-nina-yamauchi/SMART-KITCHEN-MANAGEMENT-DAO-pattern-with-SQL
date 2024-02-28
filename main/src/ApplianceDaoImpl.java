package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/*
*   ApplianceDaoImpl is a class that implements the ApplianceDao interface
*  - This class will be used to interact with the database
* */
public class ApplianceDaoImpl implements ApplianceDao {
    @Override
    public Appliance getApplianceById(Integer id) {
        // Try with resources to automatically close the connection
        try(
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement to be executed on the database
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_APPLIANCE_BY_ID.getQuery())
                ){
            // Set the id in the query to the id passed in
            ps.setInt(1, id);
            // Execute the query and store the result in a ResultSet
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                // Extract the appliance from the result set
                return extractApplianceFromResultSet(rs);
            }
        // Catch any exceptions and print the stack trace
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Appliance getApplianceByName(String name) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_APPLIANCE_BY_NAME.getQuery())
        ) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractApplianceFromResultSet(rs);
            }
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

    /*
    *  Use Set to store the appliances
    * Therefore, the return type of the method is Set<Appliance>
    * */
    @Override
    public Set<Appliance> getAllAppliances() {
        Set<Appliance> appliances = new HashSet<>();
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_ALL_APPLIANCES.getQuery())
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                appliances.add(extractApplianceFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appliances;
    }
    /*
    *  Insert an appliance into the database with using the INSERT_APPLIANCE query
    * - Return the appliance that was inserted
    *
    * */
    @Override
    public Appliance insertAppliance(Appliance appliance) {
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.INSERT_APPLIANCE.getQuery());
        ) {
            /*Set the values of the query
            * The first parameter is the name of the appliance
            *: parameter index means the index of the parameter in the query
            * */
            ps.setString(1, appliance.getName());
            ps.setString(2, appliance.getType());
            ps.setString(3, appliance.getStatus());
            ps.setInt(4, appliance.getUsageTime());
            // Execute the query and store the number of affected rows
            int affectedRows = ps.executeUpdate();
            // If the number of affected rows is greater than 0, return the appliance
            if (affectedRows > 0) {
                return getApplianceByName(appliance.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return null if the appliance was not inserted
        return null;
    }
    /*
    *  Update an appliance in the database with using the UPDATE_APPLIANCE query
    * Use the PreparedStatement to set the values of the query
    * Use boolean to return true if the appliance was updated
    *
    * */
    @Override
    public boolean updateAppliance(Appliance appliance) {
        // Try with resources to automatically close the connection
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.UPDATE_APPLIANCE.getQuery());
        ) {
            // Set the values of the query
            ps.setString(1, appliance.getName());
            ps.setString(2, appliance.getType());
            ps.setString(3, appliance.getStatus());
            ps.setInt(4, appliance.getUsageTime());
            ps.setInt(5, appliance.getId());
            // Execute the query and store the number of affected rows
            int affectedRows = ps.executeUpdate();
            // Return true if the number of affected rows is greater than 0
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return false if the appliance was not updated
        return false;
    }

    /*
    *  Delete an appliance from the database with using the DELETE_APPLIANCE query
    * Use boolean to return true if the appliance was deleted
    *
    *  */
    @Override
    public boolean deleteAppliance(Integer id) {
        // Try with resources to automatically close the connection
        try (
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement to be executed on the database
                PreparedStatement ps = conn.prepareStatement(SqlQuery.DELETE_APPLIANCE.getQuery());
        ) {
            // Set the id in the query to the id passed in
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            // Return true if the number of affected rows is greater than 0
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return false if the appliance was not deleted
        return false;
    }
    /*
    *  Extract the appliance from the result set and return it
    * */
    private Appliance extractApplianceFromResultSet(ResultSet rs) throws SQLException {
        // Create a new appliance to store the result
        Appliance appliance = new Appliance();
        // Set the attributes of the appliance
        appliance.setId(rs.getInt("id"));
        appliance.setName(rs.getString("name"));
        appliance.setType(rs.getString("type"));
        appliance.setStatus(rs.getString("status"));
        appliance.setUsageTime(rs.getInt("usage_time"));
        return appliance;
    }


}
