package model;

public class Doctor {
    private int id;
    private String name;
    private String specialty;

    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }

    public void setName(String name) { this.name = name; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', specialty='" + specialty + "'}";
    }
}
