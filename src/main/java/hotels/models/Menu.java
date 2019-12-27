package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Menu {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer idMenu;
    Integer idWydarzenia;
}
