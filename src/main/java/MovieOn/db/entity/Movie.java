package MovieOn;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;


@Entity
@Table(name = "Movie")


public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String year;
    private String poster;
    private String description;


    public Movie(String Title, String Year, String Poster, String Description){
        this.title = Title;
        this.year = Year;
        this.poster = Poster;
        this.description = Description;
    }

    public Movie() {

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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


}
