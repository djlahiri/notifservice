package entities;

import jakarta.persistence.*;

@Entity
@Table(name="notifications")
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String receipent;
    private String message;

    private String subject;

    public String getReceipent() {
        return receipent;
    }

    public void setReceipent(String receipent) {
        this.receipent = receipent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
