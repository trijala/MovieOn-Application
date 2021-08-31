package MovieOn.db.entity;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;


@Entity
@Table(name = "movie")


public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String year_created;
    private String poster;
    private String description;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "active")
    private Boolean active;



    public Movie(String Title, String Year, String Poster, String Description){
        this.title = Title;
        this.year_created = Year;
        this.poster = Poster;
        this.description = Description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear_created() {
        return year_created;
    }

    public void setYear_created(String year_created) {
        this.year_created = year_created;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie() {

    }
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



}
