package hotels;

public class Hotel {
    private final long id;
    private final String nazwa;



    public Hotel(long id, String n)
    {
        this.id=id;
        this. nazwa=n;
    }

    public long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }
}