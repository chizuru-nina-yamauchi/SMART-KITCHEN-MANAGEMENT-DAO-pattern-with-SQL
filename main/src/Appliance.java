package src;

public class Appliance {
    // Attributes
    private Integer id;
    private String name;
    private String type;
    private String status;
    private Integer usageTime;

    // Constructor with all attributes
    public Appliance(Integer id, String name, String type, String status, Integer usageTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.usageTime = usageTime;
    }

    // Constructor without id
    public Appliance(String name, String type, String status, Integer usageTime) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.usageTime = usageTime;
    }

    // Default constructor
    public Appliance() {
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(Integer usageTime) {
        this.usageTime = usageTime;
    }

    // toString method

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", usageTime=" + usageTime +
                '}';
    }
}
