package src;

/*
* Make an enum class called SqlQuery that contains the following enum constants:
* */
public enum SqlQuery {
    // Enum constants
    GET_APPLIANCE_BY_ID("SELECT * FROM appliances WHERE id = ?"),
    GET_APPLIANCE_BY_NAME("SELECT * FROM appliances WHERE name = ?"),
    GET_ALL_APPLIANCES("SELECT * FROM appliances"),
    INSERT_APPLIANCE("INSERT INTO appliances (name, type, status, usage_time) VALUES (?, ?, ?, ?)"),
    UPDATE_APPLIANCE("UPDATE appliances SET name = ?, type = ?, status = ?, usage_time = ? WHERE id = ?"),
    DELETE_APPLIANCE("DELETE FROM appliances WHERE id = ?");

    // Attribute
    private final String query;

    // Constructor
    SqlQuery(String query) {
        this.query = query;
    }
    // Getter
    public String getQuery() {
        return query;
    }
}
